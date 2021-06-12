package org.csystem.app.io.file.devicespersistence;

import org.csystem.app.io.file.devicespersistence.entity.DeviceInfo;
import org.csystem.util.Console;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public final class DevicesPersistenceMenuApp implements Closeable {
    private final RandomAccessFile m_devicesFile;
    private final  Scanner m_kb = new Scanner(System.in);

    private void displayMenu()
    {
        System.out.println("1.Ekle");
        System.out.println("2.Listele");
        System.out.println("3.Çıkış");
        System.out.print("Seçenek:");
    }

    private DeviceInfo getDeviceByStandardInput()
    {
        int id = Console.readInt("Id değerini giriniz:", "Hatalı Giriş yaptınız:");

        String name = Console.read("Adını giriniz:");

        String host = Console.read("Host bilgisini giriniz:");
        //...

        return new DeviceInfo(id, name, host);
    }

    private DeviceInfo getDeviceByFile() throws IOException
    {
        int id = m_devicesFile.readInt();
        String name = m_devicesFile.readUTF();
        String host = m_devicesFile.readUTF();

        //Format kontrolü yapılmalı. Burada ele alınmayacak

        return new DeviceInfo(id, name, host);
    }

    private void insertProc() throws IOException
    {
        m_devicesFile.seek(m_devicesFile.length());
        DeviceInfo deviceInfo = this.getDeviceByStandardInput();

        m_devicesFile.seek(m_devicesFile.length());
        m_devicesFile.writeInt(deviceInfo.getId());
        m_devicesFile.writeUTF(deviceInfo.getName());
        m_devicesFile.writeUTF(deviceInfo.getHost());
    }

    private void listProc() throws IOException
    {
        try {
            m_devicesFile.seek(0);
            for (;;) {
                DeviceInfo deviceInfo = this.getDeviceByFile();
                System.out.println(deviceInfo);
            }
        }
        catch (EOFException ignore) {

        }
    }

    private void quitProc()
    {
        System.out.println("C ve Sistem Programcıları Derneği");
        System.out.println("Tekrar yapıyor musunuz?");
        System.exit(0);
    }

    private void doWorkForOption(int option) throws IOException
    {
        switch (option) {
            case 1:
                this.insertProc();
                break;
            case 2:
                this.listProc();
                break;
            case 3:
                this.quitProc();
                break;
            default:
                System.out.println("Geçersiz seçenek");
        }
    }

    public DevicesPersistenceMenuApp(String path) throws IOException
    {
        m_devicesFile = new RandomAccessFile(path, "rw");
    }

    public void run()
    {
        for (;;) {
            try {
                this.displayMenu();
                this.doWorkForOption(Integer.parseInt(m_kb.nextLine()));
            }
            catch (NumberFormatException ignore) {
                System.out.println("Seçenekler [1, 3] arasındaki tamsayılardan olmalıdır");
            }
            catch (Throwable ignore) {
                System.out.println("Beklenmedik bir durum oluştu");
            }
        }
    }

    public void close() throws IOException
    {
         m_devicesFile.close();
    }
}
