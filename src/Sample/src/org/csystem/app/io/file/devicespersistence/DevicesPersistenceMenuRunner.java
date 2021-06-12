package org.csystem.app.io.file.devicespersistence;

import java.io.IOException;

public final class DevicesPersistenceMenuRunner {
    private DevicesPersistenceMenuRunner()
    {
    }

    public static void run()
    {
        try (DevicesPersistenceMenuApp devicesPersistenceMenuApp = new DevicesPersistenceMenuApp("devices.dat")) {
            devicesPersistenceMenuApp.run();
        }
        catch (IOException ignore) {
            System.out.println("Bir problem oluştu");
        }
    }
}
