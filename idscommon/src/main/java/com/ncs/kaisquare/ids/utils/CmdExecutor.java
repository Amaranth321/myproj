package com.ncs.kaisquare.ids.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Aye Maung
 * @since v4.3
 */
public class CmdExecutor {

    private static Logger logger = LogManager.getLogger(CmdExecutor.class);

    public static int readErrorCode(List<String> commandList) {
        String command = StringUtils.join(commandList, " ");
        try {
            Process process = Runtime.getRuntime().exec(command);
            int exitCode = process.waitFor();
            return exitCode;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return -1;
        }
    }

    public static List<String> readTillProcessEnds(List<String> commandList, boolean printOutputs)
    {
        ProcessBuilder processBuilder = new ProcessBuilder(commandList);
        return read(processBuilder, printOutputs);
    }

    public static List<String> readTillProcessEnds(String commandString, boolean printOutputs)
    {
        List<String> commandList = Arrays.asList(
                "sh",
                "-c",
                commandString
        );
        return readTillProcessEnds(commandList, printOutputs);
    }

    private static List<String> read(ProcessBuilder processBuilder, boolean printOutputs)
    {
        List<String> outputLines = new ArrayList<>();
        Process process = null;
        Scanner scanner = null;
        try
        {
            if (printOutputs)
            {
                logger.info("[CmdExecutor] Running: %s", StringUtils.join(processBuilder.command(), " "));
            }

            processBuilder.redirectErrorStream(true);
            process = processBuilder.start();
            scanner = new Scanner(process.getInputStream());
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                if (!line.isEmpty())
                {
                    outputLines.add(line);
                    if (printOutputs)
                    {
                        logger.info("[CmdExecutor] %s", line);
                    }
                }
            }
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            outputLines = new ArrayList<>();

            if (scanner != null)
            {
                scanner.close();
            }

            if (process != null)
            {
                process.destroy();
            }
        }

        return outputLines;
    }

}
