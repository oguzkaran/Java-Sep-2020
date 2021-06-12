/*--------------------------------------------------------------------------------------------------------------------
    SpecialLotto sınıfı
---------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.simulation.lotto;

import org.csystem.util.NumberUtil;

import java.util.Random;

public class SpecialLotto {
    private final Random m_random;
    private boolean m_firstWin;
    private boolean m_secondWin;
    private boolean m_thirdWin;
    private int first;
    private int second;
    private int third;

    private int getNumber()
    {
        return m_random.nextInt(99) + 1;
    }

    private void setNumbers()
    {
        setFirst();
        setSecond();
        setThird();
    }

    private void setFirst()
    {
        first = getNumber();
    }

    private void setSecond()
    {

        while ((second = getNumber()) == first)
            ;
    }

    private void setThird()
    {
        while ((third = getNumber()) == first || third == second)
            ;
    }

    private void playFirstGame(int first, int second, int third)
    {
        m_firstWin = first + second + third < 150;
    }

    private void playSecondGame(int first, int second, int third)
    {
        m_secondWin = NumberUtil.isPrime(first + second + third);
    }

    private void playThirdGame(int first, int second, int third)
    {
        int max = Math.max(Math.max(first, second), third);
        int min = Math.min(Math.min(first, second), third);
        int mid = first + second + third - max - min;

        m_thirdWin = max - min > mid;
    }

    public SpecialLotto()
    {
        m_random = new Random();
    }

    public SpecialLotto(Random rand)
    {
        m_random = rand;
    }

    public boolean isFirstWin()
    {
        return m_firstWin;
    }

    public boolean isSecondWin()
    {
        return m_secondWin;
    }

    public boolean isThirdWin()
    {
        return m_thirdWin;
    }

    public void playFirstGame()
    {
        setNumbers();
        playFirstGame(first, second, third);
    }

    public void playSecondGame()
    {
        setNumbers();
        playSecondGame(first, second, third);
    }

    public void playThirdGame()
    {
        setNumbers();
        playThirdGame(first, second, third);
    }

    public void play()
    {
        setNumbers();
        playFirstGame(first, second, third);
        playSecondGame(first, second, third);
        playThirdGame(first, second, third);
    }
}
