/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Komut satırından aşağıdaki gibi çalışan programı yazınız
        java org.csystem.app.App file1 file2 ... fileN dest

    - Program file1, file2, file3, ..., fileN ile belirtilen dosyaları birleştirerek dest ile belirtilen dosyaya
    ekleyecektir
    - Files sınıfı ve Path arayüzünü kullanabilirsiniz
    - Program kaynak dosyalardan biri bile yoksa mesaj vererek programı sonlandırmalı ve kopyaladığı bilgi varsa bile
    hedef dosyayı silmelidir
    - TODO: Bir önceki maddeyi öncden dosyaların var olup olmadığına bakarak uygulayınız
    - Hedef dosya varsa üzerine yazılacaktır

    Not: Örnek özellike ArrayList kullanılarak yapılmıştır. İstenirse dizi ile de yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.io.file.concatfiles;

final class App {
    private App()
    {
    }
    public static void main(String[] args)
    {
        ConcatFilesApp.run(args);
    }
}
