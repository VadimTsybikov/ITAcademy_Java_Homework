package core;

import java.util.Random;

public class RandomString {
    private static final String pattern = "ABCDEFGHIJKLMONPQRSTUVWXYZabcdefghijklmonpqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя ";

    public static String random(int stringLength) {
        Random randomGen = new Random();
        String result = "";
        for (int i = 0; i < stringLength; i++) {
            result += pattern.charAt(randomGen.nextInt(pattern.length()));
        }
        return result;
    }
}