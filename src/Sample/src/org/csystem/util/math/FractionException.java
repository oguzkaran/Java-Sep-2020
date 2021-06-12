package org.csystem.util.math;

public class FractionException extends NumberFormatException {
    private final FractionExceptionStatus m_status;
    private final int m_a;
    private final int m_b;

    public FractionException(String s, FractionExceptionStatus status, int a, int b)
    {
        super(s);
        m_status = status;
        m_a = a;
        m_b = b;
    }

    public FractionExceptionStatus getStatus()
    {
        return m_status;
    }

    public int getNumerator()
    {
        return m_a;
    }

    public int getDenominator()
    {
        return m_b;
    }

    public String getMessage()
    {
        return String.format("Message: %s, Error Status: %s, Numerator: %d, Denominator: %d", super.getMessage(), m_status, m_a, m_b);
    }
}
