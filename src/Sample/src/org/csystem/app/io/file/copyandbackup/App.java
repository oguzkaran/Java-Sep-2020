/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Komut satırından aşağıdaki gibi çalışan programı yazınız:
        java org.csystem.app.App <src> <dest>
    Program komut satırı argümanı verilmezse klavyeden yol ifadesini isteyecektir. src ile aldığı dosyayı dest ile
    aldığı dosya olarak kopyalayacaktır. Hedef dosya varsa hedef dosya ismi ve uzantısının sonuna "-bak" ekelenerek
    yedeklenecektir. Daha önce yedeklenmişse üzerine yazılacaktır. Bu işlemden sonra kopyalama yapılacaktır

    Not: Checked exception mantığının anlaşışlması için IOException fırlatılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.io.file.copyandbackup;

final class App {
    private App()
    {
    }
    public static void main(String[] args)
    {
        BackupAndCopyApp.run(args);
    }
}
