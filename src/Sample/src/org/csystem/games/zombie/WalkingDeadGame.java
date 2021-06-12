package org.csystem.games.zombie;

import org.csystem.games.template.AbstractGame;

public class WalkingDeadGame extends AbstractGame {
    //...

    public WalkingDeadGame()
    {
        super("walking dead game");
    }

    public void init()
    {
        System.out.println("WalkingDeadGame.init");
    }

    public void play()
    {
        System.out.println("WalkingDeadGame.play");
    }

    public void pause()
    {
        System.out.println("WalkingDeadGame.pause");
    }

    public void load()
    {
        System.out.println("WalkingDeadGame.load");
    }

    public void save()
    {
        System.out.println("WalkingDeadGame.save");
    }
    public void destruct()
    {
        System.out.println("WalkingDeadGame.destruct");
    }
}
