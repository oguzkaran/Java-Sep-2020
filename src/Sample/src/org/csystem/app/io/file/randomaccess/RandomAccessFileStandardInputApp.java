package org.csystem.app.io.file.randomaccess;

import java.io.IOException;

public final class RandomAccessFileStandardInputApp {
    private RandomAccessFileStandardInputApp()
    {
    }

    public static void run(String  [] args)
    {
        if (args.length != 1) {
            System.err.println("Geçersiz sayıda argüman");
            System.exit(1);
        }

        try (RandomAccessFileStandardInput ra = new RandomAccessFileStandardInput(args[0], "elma", "Bir yazı giriniz:")) {
            ra.run();
        }
        catch (IOException ignore) {
            System.out.println("Bir problem oluştu");
        }
    }
}
