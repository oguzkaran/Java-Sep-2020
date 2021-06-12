package org.csystem.app.io.file.copyandbackup;

import java.io.IOException;

public final class BackupAndCopyApp {
    private BackupAndCopyApp()
    {
    }

    public static void run(String [] args)
    {
        try {
            BackupAndCopy backupAndCopy = new BackupAndCopy(args);

            backupAndCopy.run();
        }
        catch (IOException ex) {
            System.err.println("Dosya işlemi hatası");
        }
        catch (Throwable ex) {
            System.err.println("Beklenmeyen bir durum oluştu");
        }
    }
}
