/*--------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Bir okulda Fizik sınavı ortak olarak yapılıyor. Kaç şube olduğu ve herbir şubede kaç öğrenci
    olduğu bilgisi klavyeden alınsın. Bu işlem sonrasında öğrencilerin notları rasgele belirlensin. Tüm bu işlemlerden
    sonra Fizik sınavı için herbir şubenin ayrı ayrı not ortalamaları ile okulun ortalamasını bulan basit bir simülasyon
    programını yazınız. Programı mümkün olduğunda genel yazmaya çalışınız
---------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.simulation.centralexam;

public final class ExamSimulationApp {
    private ExamSimulationApp()
    {
    }

    public static void run()
    {
        ExamSimulation physSimulation = new ExamSimulation("Fizik");
        ExamSimulation mathSimulation = new ExamSimulation("Matematik");

        physSimulation.run();
        mathSimulation.run();
        physSimulation.displayReport();
        mathSimulation.displayReport();
    }
}
