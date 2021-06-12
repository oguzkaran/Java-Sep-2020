/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örnek Files sınıfının newBufferedWriter metodu ile de yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.io.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

final class WriterApp {
    private WriterApp()
    {
    }
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.err.println("Geçersiz sayıda argümanlar");
            System.exit(-1);
        }

        Scanner kb = new Scanner(System.in);

        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(args[0]), StandardCharsets.UTF_8,
                StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            for (;;) {
                System.out.print("Bir yazı giriniz:");
                String text = kb.nextLine();

                if ("elma".equals(text))
                    break;

                bw.write(text);
                bw.newLine();
                bw.flush();
            }
        }
        catch (NumberFormatException ignore) {
            System.err.println("Geçersiz sayı formatı");
        }
        catch (Throwable ex) {
            System.err.printf("Exception:%s", ex.getMessage());
        }
    }
}
