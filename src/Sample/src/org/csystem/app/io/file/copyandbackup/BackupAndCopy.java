package org.csystem.app.io.file.copyandbackup;

import static org.csystem.util.CommandLineUtil.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class BackupAndCopy {
    private Path m_sourcePath;
    private Path m_destinationPath;

    private void parseCommandLineArgs(String [] args) throws IOException
    {
        if (args.length != 2 && args.length != 0) {
            System.err.println("Kullanım: java CopyAndBackupAopp <kaynak dosya> <hedef dosya>");
            System.exit(-1);
        }

        args = getArguments(args, "Kaynak dosya ve hedef dosya yol ifadelerini giriniz:", new Scanner(System.in));

        if (args.length == 2) {
            m_sourcePath = Path.of(args[0]);
            m_destinationPath = Path.of(args[1]);
        }
        else {
            String [] cmdInfo = args[0].split("[ \t]+");

            m_sourcePath = Path.of(cmdInfo[0]);
            m_destinationPath = Path.of(cmdInfo[1]);
        }
    }

    private void copy(String message) throws IOException
    {
        Files.copy(m_sourcePath, m_destinationPath);
        System.out.println(message);
    }

    private void backupAndCopy() throws IOException
    {
        Files.move(m_destinationPath, Path.of(m_destinationPath.toString() + "-bak"), StandardCopyOption.REPLACE_EXISTING);
        this.copy("Kopyalama başarıyla yapıldı ve yedeklendi");
    }

    private void copy() throws IOException
    {
        try {
            copy("Kopyalama başarıyla yapıldı");
        }
        catch (FileAlreadyExistsException ignore) {
            this.backupAndCopy();
        }
    }

    public BackupAndCopy(String [] args) throws IOException
    {
        this.parseCommandLineArgs(args);
    }

    public void run() throws IOException
    {
        try {
            this.copy();
        }
        catch (NoSuchFileException ignore) {
            System.err.println("Kaynak dosya bulunamadı");
        }
    }
}
