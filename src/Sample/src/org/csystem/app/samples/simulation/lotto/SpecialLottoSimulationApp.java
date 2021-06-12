/*--------------------------------------------------------------------------------------------------------------------
    SpecialLottoSimulationApp sınıfı
---------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.simulation.lotto;

import java.util.Scanner;

public final class SpecialLottoSimulationApp {
    private SpecialLottoSimulationApp()
    {
    }

    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Kaç kez oynatmak istiyorsunuz?");
        int n = Integer.parseInt(kb.nextLine());
        SpecialLottoSimulation simulation = new SpecialLottoSimulation();

        simulation.run(n);
        System.out.printf("p1 = %f%n", simulation.getFirstGameWinProbability());
        System.out.printf("p2 = %f%n", simulation.getSecondGameWinProbability());
        System.out.printf("p3 = %f%n", simulation.getThirdGameWinProbability());
    }
}
