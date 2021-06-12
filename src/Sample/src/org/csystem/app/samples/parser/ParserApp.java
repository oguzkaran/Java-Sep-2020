package org.csystem.app.samples.parser;

import java.util.Scanner;

public final class ParserApp {
    private ParserApp()
    {
    }
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Parser parser = new Parser();

        for (;;) {
            System.out.print("Bir yazı giriniz:");
            String s = kb.nextLine();

            if ("elma".equals(s))
                break;

            StringISource ss = new StringISource(s);
            CharArrayISource cs = new CharArrayISource(s.trim());

            parser.setSource(ss);

            int digitsCount = parser.doParseForDigits();
            int whitespacesCount = parser.doParseForWhitespaces();

            System.out.printf("Rakam sayısı:%d%n", digitsCount);
            System.out.printf("Boşluk sayısı:%d%n", whitespacesCount);
            System.out.println("--------------------------------------");

            parser.setSource(cs);

            digitsCount = parser.doParseForDigits();
            whitespacesCount = parser.doParseForWhitespaces();

            System.out.printf("Rakam sayısı:%d%n", digitsCount);
            System.out.printf("Boşluk sayısı:%d%n", whitespacesCount);
            System.out.println("--------------------------------------");
        }
    }
}
