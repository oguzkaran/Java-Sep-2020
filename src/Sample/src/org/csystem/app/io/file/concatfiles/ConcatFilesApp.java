package org.csystem.app.io.file.concatfiles;

import java.io.IOException;

public final class ConcatFilesApp {
    private ConcatFilesApp()
    {
    }

    public static void run(String [] args)
    {
        try {
            ConcatFiles concatFiles = new ConcatFiles(args);

            concatFiles.run();
        }
        catch (IOException ex) {
            System.err.println("Dosya işlemi hatası");
        }
        catch (Throwable ex) {
            System.err.println("Beklenmeyen bir durum oluştu");
        }
    }
}
