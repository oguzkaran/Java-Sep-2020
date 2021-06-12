package org.csystem.util.system;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class SystemUtil {
    private SystemUtil()
    {
    }

    public static String getEndianText()
    {
        return isLittleEndian() ? "LITTLE ENDIAN" : "BIG ENDIAN";
    }

    public static ByteOrder getEndian(ByteBuffer byteBuffer)
    {
        return byteBuffer.order();
    }

    public static void toLittleEndian(ByteBuffer byteBuffer)
    {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static void toBigEndian(ByteBuffer byteBuffer)
    {
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    public static boolean isLittleEndian()
    {
        return ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
    }
}
