package org.csystem.games.template;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController {
    private final ArrayList<AbstractGame> m_games = new ArrayList<>();

    private AbstractGame getGameByOption(int option)
    {
        return (AbstractGame)m_games.get(option);
    }

    private void displayMenu()
    {
        int size = m_games.size();

        System.out.println("Oyunlar:");
        for (int i = 0; i < size; ++i) {
            AbstractGame game = m_games.get(i);
            System.out.printf("%d.%s%n", i + 1, game.name);
        }

        System.out.printf("%d.Çıkış%n", size + 1);
        System.out.print("Oyun numarasını giriniz:");
    }

    public void add(AbstractGame game)
    {
        m_games.add(game);
    }

    public void run()
    {
        Scanner kb = new Scanner(System.in);

        int sizep1 = m_games.size() + 1;

        for (;;) {
            if (m_games.isEmpty()) {
                System.out.print("Lütfen oyun yükleyiniz:");
                break;
            }
            this.displayMenu();
            int option = Integer.parseInt(kb.nextLine());

            if (option < 0 || option > sizep1) {
                System.out.println("Geçersiz seçenek");
                continue;
            }

            if (option == sizep1)
                break;

            AbstractGame curGame = getGameByOption(option - 1);

            curGame.run();
        }
        System.out.println("C ve Sistem Programcıları Derneği");
        System.out.print("Tekrar yapıyor musunuz?");
    }
}
