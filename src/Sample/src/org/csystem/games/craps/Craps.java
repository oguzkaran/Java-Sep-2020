/*--------------------------------------------------------------------------------------------------------------------
    Craps sınıfı
---------------------------------------------------------------------------------------------------------------------*/
package org.csystem.games.craps;

import java.util.Random;

public class Craps {
	private boolean m_win;
	private final Random m_random;
	
	public int total()
	{
		return m_random.nextInt(6) + 1 + m_random.nextInt(6) + 1;
	}
	
	public void doWorkForIndeterminite(int sum)
	{
		int newSum;
		
		while ((newSum = total()) != sum)
			if (newSum == 7)
				break;		
		
		m_win = newSum == sum;
	}
	
	public void doWorkForSum(int sum)
	{
		switch (sum) {
		case 7:
		case 11:
			m_win = true;
			break;
		case 2:
		case 3:
		case 12:
			m_win = false;
			break;
		default:
			doWorkForIndeterminite(sum);
		}		
	}
	
	public Craps()
	{
		m_random = new Random();
	}

	public boolean isWin()
	{
		return m_win;
	}

	public void play()
	{		
		doWorkForSum(total());
	}
}
