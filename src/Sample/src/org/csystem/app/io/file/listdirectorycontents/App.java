/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Komut satırından aşağıdaki gibi çalışan programı yazınız:
        java org.csystem.app.App <path>
    Program komut satırı argümanı verilmezse klavyeden yol ifadesini isteyecektir. Aldığı yol ifadesine ilişkin dizinin
    içerisindeki dosya ve dizinlerin isimlerini eğer directory ise yanına <DIR> yazarak ekrana basaktır. Eğer directory
    değilse ismini doğrudan ekrana basacaktır

    Uygulamayı dosyalar için byte cinsinden uzunlukları gösterecek şekilde yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.io.file.listdirectorycontents;

final class App {
    private App()
    {
    }
    public static void main(String[] args)
    {
        ListDirectoryContentsApp.run(args);
    }
}
