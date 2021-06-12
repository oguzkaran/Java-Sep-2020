package org.csystem.app.io.file.filelist;

import java.io.File;

public final class FileListApp {
    private FileListApp()
    {
    }

    private static void listFiles(File path)
    {
        for (File file : path.listFiles())
            System.out.println(file.getAbsolutePath());
    }

    public static void run(String [] args)
    {
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
