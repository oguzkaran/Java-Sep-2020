/*--------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden aşağıdaki formatta girilen bilgiyi ayrıştırarak ekrana sonuçları yazdıran programı yazınız.
    Not: Format geçerlilik kontrolü yapılmayacaktır
    <isim>:<gg/aa/yyyy>:<ders adı>:<vize>:<final>
    Oğuz Karan:10/09/1976:Programlamaya Giriş:76:89
    Oğuz Karan:10/09/1976:Elektronik:55:40
    Bu formatta kişimin vize ve final notlarına göre vize * 0.4 + final * 0.6 formülüne göre geçme notunu hesaplayan ve
    doğum tarihinin hangi güne geldiğini de ekrana yazdıran programı yazınız
---------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.studentinfoparser;

import java.util.Scanner;

public final class StudentInfoParserConsoleApp {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Formatlı yazıyı giriniz:");
            String str = kb.nextLine();

            if ("quit".equals(str))
                break;
            StudentInfoParser parser = new StudentInfoParser(str);
            StudentInfo studentInfo = parser.getStudentInfo();

            System.out.println(studentInfo.toString());
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}
