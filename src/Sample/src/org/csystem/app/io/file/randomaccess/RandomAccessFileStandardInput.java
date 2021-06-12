package org.csystem.app.io.file.randomaccess;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public final class RandomAccessFileStandardInput implements Closeable {
    private final RandomAccessFile m_randomAccessFile;
    private final Scanner m_kb;
    private final String m_quitText;
    private final String m_prompt;            ;

    private void runForWrite() throws IOException
    {
        for (;;) {
            System.out.println(m_prompt);
            String text = m_kb.nextLine();

            if (m_quitText.equals(text))
                break;

            m_randomAccessFile.writeUTF(text);
        }
    }

    private void runForRead() throws IOException
    {
        m_randomAccessFile.seek(0); // Dosya göstericisini başa çektik
        try {
            for (;;) {
                String text = m_randomAccessFile.readUTF();

                System.out.println(text);
            }
        }
        catch (EOFException ignore) {
        }
    }

    public RandomAccessFileStandardInput(String path, String quitText, String prompt) throws IOException
    {
        this(path, quitText, prompt, new Scanner(System.in));
    }

    public RandomAccessFileStandardInput(String path, String quitText, String prompt, Scanner kb) throws IOException
    {
        m_randomAccessFile = new RandomAccessFile(path, "rw");
        m_randomAccessFile.seek(m_randomAccessFile.length()); // Dosyanın sonuna konumlandırdık
        m_quitText = quitText;
        m_prompt = prompt;
        m_kb = kb;
    }

    public void run() throws IOException
    {
        runForWrite();
        runForRead();
    }

    public void close() throws IOException
    {
         m_randomAccessFile.close();
    }
}
