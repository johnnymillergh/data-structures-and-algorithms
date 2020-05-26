package com.jmsoftware.datastructuresandalgorithms.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <h1>KeyInputUtil</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 5/25/20 4:07 PM
 **/
public class KeyInputUtil {
    private static final String TRUE_STRING = "TRUE";
    private static final InputStreamReader INPUT_STREAM_READER = new InputStreamReader(System.in);
    private static final BufferedReader BUFFERED_READER = new BufferedReader(INPUT_STREAM_READER);

    public static int readInt() {
        int integerValue = 0;
        try {
            integerValue = Integer.parseInt(readString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return integerValue;
    }

    public static float readFloat() {
        float floatValue = 0.0f;
        try {
            floatValue = Float.parseFloat(readString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return floatValue;
    }

    public static double readDouble() {
        double doubleValue = 0.0;
        try {
            doubleValue = Double.parseDouble(readString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doubleValue;
    }

    public static String readString() {
        String stringValue = "";
        try {
            stringValue = BUFFERED_READER.readLine();
            if (stringValue.length() == 0) {
                stringValue = BUFFERED_READER.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringValue;
    }

    public static boolean readBoolean() {
        return TRUE_STRING.equals(readString().toUpperCase());
    }

    public static char readChar() {
        try {
            return readString().charAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return '\0';
    }

    public static void main(String[] args) {
        System.out.print("Please input an integer number:");
        System.out.println("Your input is " + KeyInputUtil.readInt());
        System.out.print("Please input a float number:");
        System.out.println("Your input is " + KeyInputUtil.readFloat());
        System.out.print("Please input a double number:");
        System.out.println("Your input is " + KeyInputUtil.readDouble());
        System.out.print("Please input a string:");
        System.out.println("Your input is " + KeyInputUtil.readString());
        System.out.print("Please input a boolean value:");
        System.out.println("Your input is " + KeyInputUtil.readBoolean());
        System.out.print("Please input a char:");
        System.out.println("Your input is " + KeyInputUtil.readChar());
    }
}
