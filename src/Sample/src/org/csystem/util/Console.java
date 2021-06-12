package org.csystem.util;

import java.util.Scanner;

public final class Console {
    private static final Scanner ms_kb;

    static {
        ms_kb = new Scanner(System.in);
    }

    private Console()
    {
    }

    /////////////////////readInt methods/////////////////////
    public static int readInt()
    {
        return readInt("");
    }

    public static int readInt(String message)
    {
        return readInt(message, "");
    }

    public static int readInt(String message, String errMessage)
    {
        for (;;) {
            try {
                System.out.print(message);
                return Integer.parseInt(ms_kb.nextLine());
            }
            catch (NumberFormatException ignore) {
                System.out.print(errMessage);
            }
        }
    }

    public static int readIntLine(String message)
    {
        return readIntLine(message, "");
    }

    public static int readIntLine(String message, String errMessage)
    {
        return readInt(message + '\n', errMessage + '\n');
    }

    /////////////////////readDouble methods/////////////////////
    public static double readDouble()
    {
        return readDouble("");
    }

    public static double readDouble(String message)
    {
        return readDouble(message, "");
    }

    public static double readDouble(String message, String errMessage)
    {
        for (;;) {
            try {
                System.out.print(message);
                return Double.parseDouble(ms_kb.nextLine());
            }
            catch (NumberFormatException ignore) {
                System.out.print(errMessage);
            }
        }
    }

    public static double readDoubleLine(String message)
    {
        return readDoubleLine(message, "");
    }

    public static double readDoubleLine(String message, String errMessage)
    {
        return readDouble(message + '\n', errMessage + '\n');
    }

    /////////////////////readString methods/////////////////////
    public static String read()
    {
        return read("");
    }

    public static String read(String message)
    {
        System.out.print(message);
        return ms_kb.nextLine();
    }

    public static String readLine(String message)
    {
        return read(message + '\n');
    }

    /////////////////////readChar methods/////////////////////
    public static char readChar()
    {
        return readChar("");
    }

    public static char readChar(String message)
    {
        return readChar(message, "");
    }

    public static char readChar(String message, String errMessage)
    {
        for (;;) {
            System.out.print(message);
            String s = ms_kb.nextLine();

            if (s.length() <= 1)
                return s.isEmpty() ? '\n': s.charAt(0);

            System.out.print(errMessage);
        }
    }

    public static char readCharLine(String message)
    {
        return readCharLine(message + '\n', "");
    }

    public static char readCharLine(String message, String errMessage)
    {
        return readChar(message + '\n', errMessage + '\n');
    }
}
