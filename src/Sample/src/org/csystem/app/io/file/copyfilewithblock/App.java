/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması:Komut satırından aşağıdaki gibi çalışan programı yazınız:
        java org.csystem.app.io.file.copyfile.App <src> <dest> <block size>
    - Programda Files sınıfı kullanılmayacaktır
    - Program src ile belirtilen yol ifadesi ilişkin dosyayı dest ile belirtilen yol ifadesine ilişkin dosyaya kopyalayacaktır
    - Dosya varsa "trucate" edilecektir
    - Dosya bloklar halinde kopayalanack blok uzunluğu da komut satırı argümanından alınacaktır

    Anahtar Notlar: Files kullanılarak yapılanın daha iyi olduğu söylenebilir. Çünkü işletim sistemine özgü bazı özel
    fonksiyolar da Files sınıfının metotları içerisinde kullanılabilir. Tabii ki bu uygulamada da blok miktarı
    ayarlanarak çok büyük dosyalar için de hızlı olması sağlanabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.io.file.copyfilewithblock;

final class App {
    private App()
    {
    }
    public static void main(String[] args)
    {
        CopyFileApp.run(args);
    }
}
