/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örnek Files sınıfının newBufferedReader metodu ile de yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.io.file;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

final class ReaderApp {
    private ReaderApp()
    {
    }
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.err.println("Geçersiz sayıda argümanlar");
            System.exit(-1);
        }

        try (BufferedReader br = Files.newBufferedReader(Path.of(args[0]), StandardCharsets.UTF_8)) {
           String line;

           while ((line = br.readLine()) != null)
               System.out.println(line);
        }
        catch (EOFException ignore) {
            System.out.println("\nOkuma tamalandı");
        }
        catch (FileNotFoundException ignore) {
            System.err.println("Dosya bulunamadı");
        }
        catch (Throwable ex) {
            System.err.printf("Exception:%s", ex.getMessage());
        }
    }
}