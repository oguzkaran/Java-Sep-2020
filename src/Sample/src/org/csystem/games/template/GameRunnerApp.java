package org.csystem.games.template;

import org.csystem.games.ballfall.BallFallGame;
import org.csystem.games.craps.CrapsGame;
import org.csystem.games.zombie.WalkingDeadGame;

public class GameRunnerApp {
    private final GameController m_controller;

    private void initGames() // Bu metot oyunları da bilmeden yükleyebilir. Burada ele alınmayacaktır
    {
        m_controller.add(new WalkingDeadGame());
        m_controller.add(new BallFallGame());
        m_controller.add(new CrapsGame());
    }

    public GameRunnerApp()
    {
        m_controller = new GameController();
        this.initGames();
    }

    public void run()
    {
        m_controller.run();
    }
}
