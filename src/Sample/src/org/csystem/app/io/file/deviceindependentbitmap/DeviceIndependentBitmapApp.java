package org.csystem.app.io.file.deviceindependentbitmap;

import java.io.IOException;

public final class DeviceIndependentBitmapApp {
    private DeviceIndependentBitmapApp()
    {
    }

    public static void run(String  [] args)
    {
        if (args.length != 1) {
            System.err.println("Geçersiz sayıda argüman");
            System.exit(1);
        }

        try (DeviceIndependentBitmap dib = new DeviceIndependentBitmap(args[0])) {
            System.out.printf("%d x %d%n", dib.getWidth(), dib.getHeight());
            //...
        }
        catch (IOException ignore) {
            System.out.println("Bir problem oluştu");
        }
    }
}
