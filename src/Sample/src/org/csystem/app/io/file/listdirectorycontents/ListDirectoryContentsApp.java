package org.csystem.app.io.file.listdirectorycontents;

import org.csystem.util.CommandLineUtil;

import java.io.File;
import java.util.Scanner;

public final class ListDirectoryContentsApp {
    private ListDirectoryContentsApp()
    {
    }

    private static void listFiles(File path)
    {
        String postfix = "";
        for (File file : path.listFiles()) {
            if (file.isDirectory())
                postfix = " <DIR>";
            else if (file.isFile())
                postfix = String.format(" %d bytes", file.length());

            System.out.printf("%s%s%n", file.getName(), postfix);
        }
    }

    public static void run(String [] args)
    {
        args = CommandLineUtil.getArguments(args, "Dizin yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Geçersiz argümanlar");
            System.exit(-1);
        }

        File path = new File(args[0]);

        if (path.exists())
            if (path.isDirectory())
                listFiles(path);
            else
                System.out.println("Belirtilen yol ifadesi dizin değil");
        else
            System.out.println("Belirtilen yol ifadesi bulunamadı");
    }
}
