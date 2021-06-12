package org.csystem.app.io.file.deviceindependentbitmap;

import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class DeviceIndependentBitmap implements Closeable {
    private final RandomAccessFile m_bitmapFile;

    public DeviceIndependentBitmap(String path) throws IOException
    {
        m_bitmapFile = new RandomAccessFile(path, "r");
    }

    public int getWidth() throws IOException
    {
        m_bitmapFile.seek(18);
        byte [] data = new byte[4];
        m_bitmapFile.read(data);
        //...

        return ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    public int getHeight() throws IOException
    {
        m_bitmapFile.seek(22);
        byte [] data = new byte[4];
        m_bitmapFile.read(data);
        //...

        return ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    //...

    public void close() throws IOException
    {
         m_bitmapFile.close();
    }
}
