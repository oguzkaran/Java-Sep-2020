package org.csystem.app.io.file.copyfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyFile {
    private String m_sourcePath;
    private Path m_destinationPath;

    private void parseCommandLineArgs(String [] args)
    {
        if (args.length != 2) {
            System.err.println("Geçersiz sayıda argüman");
            System.exit(-1);
        }

        m_sourcePath = args[0];
        m_destinationPath = Path.of(args[1]);
    }

    private void copy() throws IOException
    {
        try (FileInputStream fis = new FileInputStream(m_sourcePath)) {
            Files.copy(fis, m_destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Dosya başarıyla kopyalandı");
        }
        catch (FileNotFoundException ignore) {
            System.err.println("Kaynak dosya bulunamadı");
        }
    }

    public CopyFile(String [] args)
    {
        this.parseCommandLineArgs(args);
    }

    public void run() throws IOException
    {
        this.copy();
    }
}
