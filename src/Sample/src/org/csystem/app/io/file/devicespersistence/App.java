/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Aşağıdaki açıklanan programı yazınız:
    - Program içerisinde bir menü olacaktır
    - Menüler sırasıyla "Ekle", "Listele" ve "Çıkış" şeklindedir
    - Cihazlara ilişkin bilgiler (id, name, host) devices.dat isimli bir dosyada saklanacaktır
    - Dosya programın sonuna kadar açık kalacaktır
    - Örnek basit olması açısından dosya formatı kontrolü yapılmayacaktır
    - Fonksiyonel programlama kullanılarak daha iyi şekilde yazılabilir (Uygulama kursunda ele alınacaktır)
    - Bazı detaylar gözardı edilmiştir
    - TODO: Dosyanın sürekli açık kalmayan versiyonunu yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.io.file.devicespersistence;

final class App {
    private App()
    {
    }
    public static void main(String[] args)
    {
        DevicesPersistenceMenuRunner.run();
    }
}
