package org.csystem.app.samples.randomgenerator;

import org.csystem.util.ArrayUtil;
import org.csystem.util.datetime.Date;
import org.csystem.util.datetime.Time;

public final class RandomObjectArrayGeneratorApp {
    private RandomObjectArrayGeneratorApp()
    {
    }

    public static void run()
    {
        RandomObjectArrayGenerator rag = new RandomObjectArrayGenerator(5);

        rag.run();

        for (Object object : rag.getObjects()) {
            String typeName = object.getClass().getName();
            System.out.printf("Dinamik tür ismi:%s%n", typeName);

            if (object instanceof String) {
                String s = (String)object;

                System.out.printf("Yazı:%s%n", s);
                System.out.printf("Yazı:%s%n", s.toUpperCase());
            }
            else if (object instanceof Date) {
                Date date = (Date)object;

                System.out.println(date.toLongDateStringTR());
            }
            else if (object instanceof Time) {
                Time time = (Time) object;

                System.out.println(time.toLongTimeString());
            }
            else if (object instanceof Integer) {
                int val = (int)object;

                System.out.printf("result = %d%n", val * val);
            }
            else if (object instanceof Character) {
                char ch = (char)object;

                System.out.printf("ch = %c%n", ch);
            }
            else if (object instanceof int[]){
                int [] a = (int[])object;

                ArrayUtil.display(2, a);
            }
        }
    }
}
