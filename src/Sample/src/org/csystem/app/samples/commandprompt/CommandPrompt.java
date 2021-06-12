/*----------------------------------------------------------------------------------------------------------------------
	CommandPrompt sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.commandprompt;

import org.csystem.util.StringUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandPrompt {
    private static final String [] COMMANDS = {"length", "reverse", "upper", "lower", "change", "gett", "join", "cleart", "elma"};
    private final Scanner m_kb = new Scanner(System.in);
    private final ArrayList<String> m_textList = new ArrayList<>();
    private String m_prompt;

    private static String getCommandByText(String text)
    {
        if (text.length() < 3)
            return "";

        for (String cmdStr : COMMANDS)
            if (cmdStr.startsWith(text))
                return cmdStr;

        return "";
    }

    private static void lengthProc(String [] commandInfo)
    {
        if (commandInfo.length != 2) {
            System.out.println("length bir tane argüman almalıdır");
            return;
        }

        System.out.println(commandInfo[1].length());
    }

    private static void reverseProc(String [] commandInfo)
    {
        if (commandInfo.length != 2) {
            System.out.println("reverse bir tane argüman almalıdır");
            return;
        }

        System.out.println(StringUtil.reverse(commandInfo[1]));
    }

    private static void upperProc(String [] commandInfo)
    {
        if (commandInfo.length != 2) {
            System.out.println("upper bir tane argüman almalıdır");
            return;
        }

        System.out.println(commandInfo[1].toUpperCase());

    }

    private static void lowerProc(String [] commandInfo)
    {
        if (commandInfo.length != 2) {
            System.out.println("lower bir tane argüman almalıdır");
            return;
        }

        System.out.println(commandInfo[1].toLowerCase());
    }

    private void getTextsProc(String [] commandInfo)
    {
        if (commandInfo.length != 1) {
            System.out.println("gett argümansız yazılmalıdır");
            return;
        }

        for (;;) {
            System.out.println("İşlemi sonlandırmak için elma giriniz");
            System.out.print("Yazıyı giriniz:");
            String text = m_kb.nextLine();

            if ("elma".equals(text))
                break;

            m_textList.add(text);
        }
    }

    private void clearTextsProc(String [] commandInfo)
    {
        m_textList.clear();
    }

    private void joinProc(String [] commandInfo)
    {
        String sep = " ";

        if (commandInfo.length != 1)
            sep = StringUtil.join(commandInfo, 1, ' ');

        if (m_textList.isEmpty()) {
            System.out.println("Listede hiç yazı yok");
            return;
        }

        String str = StringUtil.join(m_textList, sep);

        System.out.println(str);
    }

    private void changeProc(String [] commandInfo)
    {
        m_prompt = StringUtil.join(commandInfo, 1, ' ');
    }

    private static void quitProc(String [] commandInfo)
    {
        System.out.println("C ve Sistem Programcıları Derneği");
        System.out.println("Tekrar yapıyor musunuz?");
        System.exit(0);
    }
    private void doWorkForCommand(String [] commandInfo)
    {
        switch (commandInfo[0]) {
            case "length":
                lengthProc(commandInfo);
                break;
            case "reverse":
                reverseProc(commandInfo);
                break;
            case "upper":
                upperProc(commandInfo);
                break;
            case "lower":
                lowerProc(commandInfo);
                break;
            case "change":
                changeProc(commandInfo);
                break;
            case "gett":
                getTextsProc(commandInfo);
                break;
            case "cleart":
                clearTextsProc(commandInfo);
                break;
            case "join":
                joinProc(commandInfo);
                break;
            default:
                quitProc(commandInfo);
                break;
        }
    }

    private void parseCommand(String [] commandsInfo)
    {
        String cmdStr = getCommandByText(commandsInfo[0]);

        if (!cmdStr.isEmpty()) {
            commandsInfo[0] = cmdStr;
            doWorkForCommand(commandsInfo);
        }
        else {
            System.out.println("Geçersiz komut");
        }
    }

    public CommandPrompt(String prompt)
    {
        m_prompt = prompt;
    }

    public void run()
    {
        System.out.println("C ve Sistem Programcıları Derneği");
        System.out.println("Homework-013 çalışma sorusuna ilişkin bir iskelet");
        System.out.println("Geri kalanları lütfen yapınız");

        for (;;) {
            System.out.print(m_prompt + ">");
            String cmd = m_kb.nextLine().trim();
            parseCommand(cmd.split("[ \t]"));
        }
    }
}
