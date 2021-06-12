package org.csystem.app.samples.devices;

import java.util.ArrayList;
import java.util.Scanner;

public final class StoreDevicesToArrayApp {
    private StoreDevicesToArrayApp()
    {
    }

    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Başlangıç capacity değerini giriniz:");

        ArrayList<Device> devices = new ArrayList<>(Integer.parseInt(kb.nextLine()));

        for (;;) {
            System.out.print("Cihaz adını giriniz:");
            String name = kb.nextLine();

            if ("elma".equals(name))
                break;

            System.out.print("Cihaz Ip adresini giriniz:");
            String host = kb.nextLine();

            System.out.print("Cihaz port numarasını giriniz:");
            int port = Integer.parseInt(kb.nextLine());

            devices.add(new Device(name, host, port));
            System.out.printf("Size:%d%n", devices.size());
        }

        System.out.println("------------------------");
        for (Device dev : devices)
            System.out.println(dev);

        System.out.println("Tekrar yapıyor musunuz?");
    }
}