/*--------------------------------------------------------------------------------------------------------------------
	Homework-002-4. sorunun bir çözümü	
	(İleride daha iyisi yazılacaktır)
---------------------------------------------------------------------------------------------------------------------*/
package org.csystem.games.ballfall;

public final class BallFallGameApp {
	private BallFallGameApp()
	{
	}

	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		BallFall ballFallGame = new BallFall();
		
		for (;;) {		
			System.out.print("Width?");
			int width = Integer.parseInt(kb.nextLine());
			
			if (width <= 0)
				break;
			
			System.out.print("Height?");
			int height = Integer.parseInt(kb.nextLine());			
			
			ballFallGame.play(width, height);
			
			System.out.println(ballFallGame.getShape());
			System.out.println("//////////////////////");
		}	
	}
}