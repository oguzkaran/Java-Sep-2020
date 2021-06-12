package org.csystem.app.samples.randomgenerator;

import org.csystem.util.ArrayUtil;
import org.csystem.util.StringUtil;
import org.csystem.util.datetime.Date;
import org.csystem.util.datetime.Time;

import java.util.Random;

public class RandomObjectArrayGenerator {
    private final Random m_random;
    private final Object [] m_objects;

    private Object getRandomObject()
    {
        int n = m_random.nextInt(6);

        Object object;

        switch (n) {
            case 0:
                object = StringUtil.getRandomTextTR(m_random, m_random.nextInt(20) + 1);
                break;
            case 1:
                object = Date.of(m_random);
                break;
            case 2:
                object = Time.of(m_random);
                break;
            case 3:
                object = m_random.nextInt(255) - 128;
                break;
            case 4:
                object = (char)(m_random.nextInt(26) + 'A');
                break;
            default:
                object = ArrayUtil.generateRandomArray(m_random, 10, 0, 100);

        }
        return object;
    }

    public RandomObjectArrayGenerator(int n)
    {
        m_random = new Random();
        m_objects = new Object[n];
    }

    public Object [] getObjects()
    {
        return m_objects;
    }

    public void run()
    {
        for (int i = 0; i < m_objects.length; ++i)
            m_objects[i] = getRandomObject();
    }
}

