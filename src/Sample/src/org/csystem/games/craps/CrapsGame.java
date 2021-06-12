package org.csystem.games.craps;

import org.csystem.games.ballfall.BallFall;
import org.csystem.games.template.AbstractGame;

import java.util.Scanner;

public class CrapsGame extends AbstractGame {
    private Craps m_craps;
    private Scanner m_kb;
    public CrapsGame()
    {
        super("Craps simulation");
    }

    public void init()
    {
        System.out.println("Designed and implemented by Mert Çelik");
        m_craps = new Craps();
        m_kb = new Scanner(System.in);
    }

    public void play()
    {
        for (;;) {
            System.out.print("Kaç kez oynamak istersiniz?");
            int n = Integer.parseInt(m_kb.nextLine());

            if (n <= 0)
                break;

            int count = 0;

            for (int i = 0; i < n; ++i) {
                m_craps.play();
                if (m_craps.isWin())
                    ++count;
            }

            System.out.printf("p = %f%n", (double)count / n);
        }
    }

    public void pause()
    {
        System.out.println("BallFallGame.pause");
    }

    public void load()
    {
        System.out.println("BallFallGame.load");
    }

    public void save()
    {
        System.out.println("BallFallGame.save");
    }
    public void destruct()
    {
        System.out.println("Designed and implemented by Mert Çelik");
    }
}
