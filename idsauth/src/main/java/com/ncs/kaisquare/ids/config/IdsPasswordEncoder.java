package com.ncs.kaisquare.ids.config;

import com.ncs.kaisquare.ids.utils.Util;
import org.springframework.security.crypto.password.PasswordEncoder;

public class IdsPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return Util.encryptPassword(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return Util.encryptPassword(rawPassword.toString()).equals(encodedPassword);
    }
}
