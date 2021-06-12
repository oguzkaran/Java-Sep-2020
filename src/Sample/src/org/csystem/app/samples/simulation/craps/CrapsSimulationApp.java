/*--------------------------------------------------------------------------------------------------------------------
    CrapsSimulationApp sınıfı
---------------------------------------------------------------------------------------------------------------------*/

package org.csystem.app.samples.simulation.craps;

import org.csystem.games.craps.Craps;

public final class CrapsSimulationApp {
	private CrapsSimulationApp()
	{
	}

	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		Craps craps = new Craps();
		
		System.out.print("Kaç kez oynamak istersiniz?");
		int n = Integer.parseInt(kb.nextLine());
		
		int count = 0;
		
		for (int i = 0; i < n; ++i) {
			craps.play();
			if (craps.isWin())
				++count;			
		}
		
		System.out.printf("p = %f%n", (double)count / n);
	}
}