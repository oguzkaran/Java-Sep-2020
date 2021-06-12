/*--------------------------------------------------------------------------------------------------------------------
    IntValue sınıfı
---------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public final class IntValue {
    private static final IntValue [] CACHE;
    private final int m_val;

    private IntValue(int val)
    {
        m_val = val;
    }

    public static final IntValue ONE;
    public static final IntValue ZERO;
    public static final IntValue TEN;

    static {
        CACHE = new IntValue[256];
        ONE = of(1);
        ZERO = of(0);
        TEN = of(10);
    }

    public static IntValue of(int val)
    {
        if (val < -128 || val > 127)
            return new IntValue(val);

        if (CACHE[val + 128] == null)
            CACHE[val + 128] = new IntValue(val);

        return CACHE[val + 128];
    }

    public int getVal()
    {
        return m_val;
    }

    public int compareTo(IntValue other)
    {
        return m_val - other.m_val;
    }

    public IntValue add(int val)
    {
        return of(m_val + val);
    }

    public IntValue add(IntValue other)
    {
        return add(other.m_val);
    }

    public IntValue subtract(int val)
    {
        return add(-val);
    }

    public IntValue subtract(IntValue other)
    {
        return subtract(other.m_val);
    }

    public IntValue multiply(int val)
    {
        return of(m_val * val);
    }

    public IntValue multiply(IntValue other)
    {
        return multiply(other.m_val);
    }

    public IntValue increment()
    {
        return add(1);
    }

    public IntValue decrement()
    {
        return subtract(1);
    }

    public String toString()
    {
        return m_val + "";
    }
}
