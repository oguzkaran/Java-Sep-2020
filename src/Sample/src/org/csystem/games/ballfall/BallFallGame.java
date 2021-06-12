package org.csystem.games.ballfall;

import org.csystem.games.template.AbstractGame;

import java.util.Scanner;

public class BallFallGame extends AbstractGame {
    private BallFall m_ballFallGame;
    private Scanner m_kb;

    public BallFallGame()
    {
        super("Homework-002");
    }

    public void init()
    {
        m_ballFallGame = new BallFall();
        m_kb = new Scanner(System.in);
    }

    public void play()
    {
        for (;;) {
            System.out.print("Width?");
            int width = Integer.parseInt(m_kb.nextLine());

            if (width <= 0)
                break;

            System.out.print("Height?");
            int height = Integer.parseInt(m_kb.nextLine());

            m_ballFallGame.play(width, height);

            System.out.println(m_ballFallGame.getShape());
            System.out.println("//////////////////////");
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
        System.out.println("BallFallGame.destruct");
    }
}
