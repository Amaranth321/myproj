package com.ncs.kaisquare.ids.utils;


import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    private static final Logger logger = LogManager.getLogger(Util.class);
    private static final SecureRandom RANDOM = new SecureRandom();
    private static Pattern pattern;
    private static Matcher matcher;

    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
              + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean validateEmail(String hex) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }
    public static char getCheckSumLetter(String str) {
        int len = str.length();
        long sum = 0;
        for (int i = 0; i < len; i++)
        {
            char x = str.charAt(i);
            sum += x * ((i % 7) + 2);
        }
        int sumChar = (int) (sum % 26);
        return (char) (sumChar + 'A');
    }

    public static String hexToString(byte[] data) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static String sha256hash(String text) {
        String hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(text.getBytes("iso-8859-1"), 0, text.length());
            hash = hexToString(md.digest());
        } catch (NoSuchAlgorithmException e) {
            logger.error("Unable to generate SHA-256 hash.", e);
        } catch (UnsupportedEncodingException e) {
            logger.error("Unable to generate SHA-256 hash.", e);
        }
        return hash;
    }

    public static String sha256InBase64(String text) {
        String hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(text.getBytes("iso-8859-1"), 0, text.length());
            Base64 base64 = new Base64(-1);
            hash = base64.encodeToString(md.digest());
        } catch (NoSuchAlgorithmException e) {
            logger.error("Unable to generate SHA-256 hash.", e);
        } catch (UnsupportedEncodingException e) {
            logger.error("Unable to generate SHA-256 hash.", e);
        }
        return hash;
    }

    public static String encryptPassword(String password)
    {
        return encryptPassword(password, "plain");
    }

    public static String encryptPassword(String password, String mechanism) {
        if (mechanism != null && mechanism.equals("sha")) {
            return password;
        } else {
            return sha256InBase64("ids:" + password);
        }
    }

    public static String encryptOldPassword(String username, String password) {
        return encryptOldPassword(username, password, "plain");
    }

    public static String encryptOldPassword(String username, String password, String mechanism) {
        if (mechanism != null && mechanism.equals("sha")) {
            return password;
        } else {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                md.update(password.getBytes("iso-8859-1"), 0, password.length());
                Base64 base64 = new Base64(-1);
                return base64.encodeToString(md.digest());
            } catch (NoSuchAlgorithmException e) {
                logger.error("Unable to generate SHA-1 hash.", e);
            } catch (UnsupportedEncodingException e) {
                logger.error("Unable to generate SHA-1 hash.", e);
            }
            return null;
        }
    }

    public static String encryptShapeShifterPassword(String username, String password) {
        return encryptShapeShifterPassword(username, password, "plain");
    }

    public static String encryptShapeShifterPassword(String username, String password, String mechanism) {
        String hash = null;
        if (mechanism != null && mechanism.equals("sha")) {
            return password;
        } else {
            hash = username + ":juzz4:" + password;
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(hash.getBytes("iso-8859-1"), 0, hash.length());
                return hexToString(md.digest());
            } catch (NoSuchAlgorithmException e) {
                logger.error("Unable to generate SHA-1 hash.", e);
            } catch (UnsupportedEncodingException e) {
                logger.error("Unable to generate SHA-1 hash.", e);
            }
            return null;
        }
    }

    public static String generatePassword(int length) {
        final char[] chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(chars.length);
            password[i] = chars[index];
        }
        return new String(password);
    }

    public static String generatePassword() {
        return generatePassword(8);
    }

    public static String escapeHibernateLikeString(String string) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            switch (c) {
                case '\\':
                    builder.append('\\').append('\\');
                    break;
                case '%':
                    builder.append('\\').append('%');
                    break;
                case '_':
                    builder.append('\\').append('_');
                    break;
                default:
                    builder.append(c);
                    break;
            }
        }
        return builder.toString();
    }

//    public static boolean isValidEmail(String email)
//    {
//        try
//        {
//            new InternetAddress(email, true);
//            return true;
//        }
//        catch (AddressException e)
//        {
//            return false;
//        }
//    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0 || s.equals("null");
    }

    public static boolean isNullOrEmpty(List l) {
        return l == null || l.isEmpty();
    }

    /**
     * return false if empty value is found for a particular key
     */
    public static boolean verifyJsonValues(String jsonStr) {

        Map<String, String> jsonObj = new LinkedHashMap<>();
        jsonObj = new Gson().fromJson(jsonStr, jsonObj.getClass());

        for (String key : jsonObj.keySet()) {
            try {
                String.format("%1$.0f", jsonObj.get(key));
            } catch (Exception e) {
                if (isNullOrEmpty(jsonObj.get(key))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * return false if empty value is found for a particular key
     */
    public static boolean verifyJsonListValues(String jsonListStr) {
        List<Map<String, String>> jsonObjList = new ArrayList<>();
        jsonObjList = new Gson().fromJson(jsonListStr, jsonObjList.getClass());

        for (Map<String, String> map : jsonObjList) {
            for (String key : map.keySet()) {
                try {
                    String.format("%1$.0f", map.get(key));
                } catch (Exception e) {
                    if (isNullOrEmpty(map.get(key))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }



    public static File createFileIfNotExists(String filename) throws IOException {
        File file = new File(filename);
        if (file.exists() == false) {
            file.createNewFile();
        }

        return file;
    }

    public static void deleteFileIfExists(String filename) {
        File fileTemp = new File(filename);
        if (fileTemp.exists()) {
            fileTemp.delete();
            logger.info("Deleted: " + filename);
        }
    }


    public static String getStackTraceString(Exception e) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);
        return baos.toString();
    }



    public static boolean isInteger(String intString) {
        if (isNullOrEmpty(intString)) {
            return false;
        }

        try {
            Integer.parseInt(intString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isLong(String longString) {
        if (isNullOrEmpty(longString)) {
            return false;
        }
        try {
            Long.parseLong(longString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isBoolean(String boolString) {
        if (isNullOrEmpty(boolString)) {
            return false;
        }
        try {
            Boolean.parseBoolean(boolString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDouble(String doubleString) {
        if (isNullOrEmpty(doubleString)) {
            return false;
        }

        try {
            Double.parseDouble(doubleString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String whichFn() {
        try {
            StackTraceElement[] steArray = Thread.currentThread().getStackTrace();
            String callerClass = steArray[2].getClassName();
            String callerMethod = steArray[2].getMethodName();

            String[] splitNames = callerClass.split("\\.");
            callerClass = splitNames[splitNames.length - 1];

            String errorOutput = String.format("In %s.%s() : ", callerClass, callerMethod);
            return errorOutput;
        } catch (Exception e) {
            return " [unknown] ";
        }
    }

    public static String getCallerFn() {
        try {
            StackTraceElement[] steArray = Thread.currentThread().getStackTrace();
            String callerClass = steArray[3].getClassName();
            String callerMethod = steArray[3].getMethodName();

            String[] splitNames = callerClass.split("\\.");
            callerClass = splitNames[splitNames.length - 1];

            String output = String.format("[Caller:%s.%s()] ", callerClass, callerMethod);
            return output;
        } catch (Exception e) {
            return "[Caller:unknown]:";
        }
    }

    public static String whichClass() {
        try {
            StackTraceElement[] steArray = Thread.currentThread().getStackTrace();
            String callerClass = steArray[2].getClassName();
            String[] splitNames = callerClass.split("\\.");
            callerClass = splitNames[splitNames.length - 1];
            String prefix = String.format("[%s] ", callerClass);
            return prefix;
        } catch (Exception e) {
            return "[Unknown] : ";
        }
    }

    public static String removeNonAlphanumeric(String input) {
        return input.replaceAll("[^A-Za-z0-9]", "");
    }

    //Use this only for critical logs that need to stand out
    public static void printImptLog(String textOrFormatter, Object... params) {
        try {
            String logText = textOrFormatter;
            if (params != null && params.length > 0) {
                logText = String.format(textOrFormatter, params);
            }

            logger.info("#");
            logger.info("#------------------------------------------");
            logger.info("#   " + logText);
            logger.info("#------------------------------------------");
            logger.info("#");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public static boolean isPingable(String ipAddress) {
        try {
            InetAddress inet = InetAddress.getByName(ipAddress);
            return inet.isReachable(2000);
        } catch (Exception e) {
            logger.error("Ping failed for " + ipAddress);
            return false;
        }
    }

    public static String getBrowserName(String userAgent) {
        String browsername = "";
        String browserversion = "";
        String browser = userAgent;
        if (isNullOrEmpty(browser)) {
            return "";
        }

        if (browser.toLowerCase().contains("msie")) {

            String subsString = browser.substring(browser.toLowerCase().indexOf("msie"));
            String Info[] = (subsString.split(";")[0]).split(" ");
            browsername = "Internet Explorer";
            browserversion = Info[1];
        } else if (browser.toLowerCase().contains("rv:11")) {

            browsername = "Internet Explorer";
            browserversion = "11";
        } else if (browser.toLowerCase().contains("firefox")) {

            String subsString = browser.substring(browser.toLowerCase().indexOf("firefox"));
            String Info[] = (subsString.split(" ")[0]).split("/");
            browsername = "Firefox";
            browserversion = Info[1].replace("]", "");
        } else if (browser.toLowerCase().contains("chrome")) {
            String subsString = browser.substring(browser.toLowerCase().indexOf("chrome"));
            String Info[] = (subsString.split(" ")[0]).split("/");
            browsername = "Chrome";
            browserversion = Info[1];
        } else if (browser.toLowerCase().contains("opera")) {
            String subsString = browser.substring(browser.toLowerCase().indexOf("opera"));
            String Info[] = (subsString.split(" ")[0]).split("/");
            browsername = "Opera";
            browserversion = Info[1].replace("]", "");
        } else if (browser.toLowerCase().contains("safari")) {
            String subsString = browser.substring(browser.toLowerCase().indexOf("safari"));
            String Info[] = (subsString.split(" ")[0]).split("/");
            browsername = "Safari";
            browserversion = Info[1].replace("]", "");
        }
        //access from mobile device
        if (browser.toLowerCase().contains("mobile")) {
            return "Mobile";
        }

        return browsername + "-" + browserversion;
    }



    public static int randInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static String sanitizeFilename(String filename) {
        return filename.replace(" ", "_")
                .replace(":", "-")
                .replace("/", "-")
                .replace("\\", "-");
    }

    public static boolean isValidImageUrl(String url) {
        try {
            BufferedImage image = ImageIO.read(new URL(url));
            return (image != null);
        } catch (Exception e) {
            return false;
        }
    }

    public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) {
            return bytes + " B";
        }
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

    public static String combine(String basePath, String relativePath) {
        char trailingChar = basePath.charAt(basePath.length() - 1);
        if (trailingChar == '/' || trailingChar == '\\') {
            return basePath + relativePath;
        } else {
            return basePath + "/" + relativePath;
        }
    }

    public static String replaceHost(String originalLink, String newHost) {
        try {
            URL parsedUrl = new URL(originalLink);
            String currentHost = parsedUrl.getHost();
            return originalLink.replace(currentHost, newHost);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return originalLink;
        }
    }

    public static byte[] imageUrlToBytes(String jpegUrl) {
        InputStream inputStream = null;
        try {
            //get the image byte array
            URL urlObj = new URL(jpegUrl);
            URLConnection connection = urlObj.openConnection();
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            connection.setUseCaches(false);
            connection.setAllowUserInteraction(false);

            inputStream = connection.getInputStream();
            BufferedImage frame = ImageIO.read(inputStream);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(frame, "jpeg", baos);
            byte[] out = baos.toByteArray();
            return out;
        } catch (Exception e) {
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

    public static String cutIfLong(String orig, int lengthLimit) {
        if (orig == null) {
            return "";
        }
        return (orig.length() <= lengthLimit ? orig : (orig.substring(0, lengthLimit) + " ..."));
    }
}
