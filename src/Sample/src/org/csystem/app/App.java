/*----------------------------------------------------------------------------------------------------------------------
    RandomAccessFile sınıfı ile basit bir örnek. Örnekte hem dosyaya yazma hem de dosyadan okuma yapılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class App {
    public static void main(String[] args) throws IOException
    {
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        for (;;) {
            System.out.print("Bir yazı giriniz:");
            String str = kb.readLine();

            if ("elma".equals(str))
                break;
            byte [] data = str.getBytes();

            System.out.printf("Length:%d%n", data.length);
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

