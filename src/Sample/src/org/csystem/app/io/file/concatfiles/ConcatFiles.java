package org.csystem.app.io.file.concatfiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;

public class ConcatFiles {
    private final ArrayList<Path> m_sourcePaths = new ArrayList<>();
    private File m_destinationFile;

    private void parseCommandLineArgs(String [] args)
    {
        if (args.length < 2) {
            System.err.println("Geçersiz sayıda argüman");
            System.exit(1);
        }

        for (int i = 0; i < args.length - 1; ++i)
            m_sourcePaths.add(Path.of(args[i]));

        m_destinationFile = new File(args[args.length - 1]);
        m_destinationFile.delete();
    }

    private void concat() throws IOException
    {
        try (FileOutputStream fos = new FileOutputStream(m_destinationFile, true)) {
            for (Path path : m_sourcePaths)
                Files.copy(path, fos);
        }
        catch (NoSuchFileException ignore) {
            System.err.println("Kaynak dosya bulunamadı");
            m_destinationFile.delete();
        }
    }

    public ConcatFiles(String [] args)
    {
        this.parseCommandLineArgs(args);
    }

    public void run() throws IOException
    {
        this.concat();
    }
}
