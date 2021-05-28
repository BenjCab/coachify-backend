package com.switchfully.youcoach.util;

import java.util.Random;

public class EmailGenerator {

    public static String createRandomEmail() {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        while (stringBuilder.length() < 10) {
            int index = (int) (random.nextFloat() * chars.length());
            stringBuilder.append(chars.charAt(index));
        }
        return stringBuilder.append("@gmail.com").toString();
    }
}
