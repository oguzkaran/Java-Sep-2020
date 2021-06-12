/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması:Komut satırından aşağıdaki gibi çalışan programı yazınız:
        java org.csystem.app.io.file.copyfile.App <src> <dest> <block size>
    Örnek aşağıdaki gibi Files sınıfının copy metodu ile yapılmıştır. Bu metot bir InputStream'den bir dosyaya
    kopyalama yapar. Benzer şekilde bir dosyadan da OutputStream'e kopyalama yapan bir copy metodu da vardır. Burada
    örnek olarak InputStream bir FileInputStream olarak alınmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.io.file.copyfile;

final class App {
    private App()
    {
    }
    public static void main(String[] args)
    {
        CopyFileApp.run(args);
    }
}
