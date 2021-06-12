package org.csystem.app.samples.findtextincurly;

import java.util.Scanner;

public final class FindTextInCurlyApp {
    private FindTextInCurlyApp()
    {
    }

    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        FindTextInCurly findTextInCurly = new FindTextInCurly();

        for (;;) {
            System.out.print("Bir yazı giriniz:");
            String str = kb.nextLine();

            if ("elma".equals(str))
                break;

            findTextInCurly.setText(str);

            findTextInCurly.findText();

            System.out.println(findTextInCurly.isValid()?  findTextInCurly.getResult() : "Geçersiz");
        }
    }
}
