package org.csystem.app.io.file.copyfilewithblock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    private static boolean isValidBlockSize(String str)
    {
        boolean result;

        try {
            result = Integer.parseInt(str) > 0;
        }
        catch (NumberFormatException ignore) {
            result = false;
        }

        return result;
    }

    private static void doCopy(FileInputStream fis, FileOutputStream fos, int blockSize) throws IOException
    {
        byte [] buffer = new byte[blockSize];
        int result;

        while ((result = fis.read(buffer)) > 0)
            fos.write(buffer, 0, result);

        System.out.println("Dosya başarıyla kopyalandı");
    }

    private String m_sourcePath;
    private String m_destinationPath;
    private int m_blockSize;

    private void parseCommandLineArgs(String [] args)
    {
        if (args.length != 3) {
            System.err.println("Geçersiz sayıda argüman");
            System.exit(-1);
        }

        m_sourcePath = args[0];
        m_destinationPath = args[1];
        if (!isValidBlockSize(args[2])) {
            System.err.println("Geçersiz blok sayısı");
            System.exit(-1);
        }
        m_blockSize = Integer.parseInt(args[2]);
    }

    private void copy() throws IOException
    {
        try (FileOutputStream fos = new FileOutputStream(m_destinationPath);
             FileInputStream fis = new FileInputStream(m_sourcePath)) {
            doCopy(fis, fos, m_blockSize);
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
