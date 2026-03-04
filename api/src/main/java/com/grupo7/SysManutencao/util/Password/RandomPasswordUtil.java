package com.grupo7.SysManutencao.util.Password;

import java.security.SecureRandom;

public class RandomPasswordUtil {

    private static final SecureRandom random = new SecureRandom();

    public static String generate4DigitPassword() {
        int number = random.nextInt(10000);
        return String.format("%04d", number);
    }
}