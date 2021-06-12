/*--------------------------------------------------------------------------------------------------------------------
    SpecialLottoSimulation sınıfı
---------------------------------------------------------------------------------------------------------------------*/

package org.csystem.app.samples.simulation.lotto;

import java.util.Random;

public class SpecialLottoSimulation {
    private double m_firstGameWinProbability;
    private double m_secondGameWinProbability;
    private double m_thirdGameWinProbability;

    private void runSimulation(int n)
    {
        SpecialLotto lotto = new SpecialLotto(new Random());

        int firstGameWinCount = 0;
        int secondGameWinCount = 0;
        int thirdGameWinCount = 0;

        for (int i = 0; i < n; ++i) {
            lotto.play();
            if (lotto.isFirstWin())
                ++firstGameWinCount;

            if (lotto.isSecondWin())
                ++secondGameWinCount;

            if (lotto.isThirdWin())
                ++thirdGameWinCount;
        }

        m_firstGameWinProbability = (double)firstGameWinCount / n;
        m_secondGameWinProbability = (double)secondGameWinCount / n;
        m_thirdGameWinProbability = (double)thirdGameWinCount / n;
    }

    public double getFirstGameWinProbability()
    {
        return m_firstGameWinProbability;
    }

    public double getSecondGameWinProbability()
    {
        return m_secondGameWinProbability;
    }

    public double getThirdGameWinProbability()
    {
        return m_thirdGameWinProbability;
    }

    public void run(int n)
    {
        runSimulation(n);
    }
}
