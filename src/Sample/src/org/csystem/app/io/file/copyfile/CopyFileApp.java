package org.csystem.app.io.file.copyfile;

import org.csystem.app.io.file.copyfilewithblock.CopyFile;

import java.io.IOException;

public final class CopyFileApp {
    private CopyFileApp()
    {
    }

    public static void run(String [] args)
    {
        try {
            CopyFile copyFile = new CopyFile(args);

            copyFile.run();
        }
        catch (IOException ex) {
            System.err.println("Dosya işlemi hatası");
        }
        catch (Throwable ex) {
            System.err.println("Beklenmeyen bir durum oluştu");
        }
    }
}
