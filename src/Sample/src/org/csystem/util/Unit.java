/*----------------------------------------------------------------------------------------------------------------------
    Unit sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public final class Unit<T> {
    private final T m_t;

    public static <T> Unit<T> of(T t)
    {
        return new Unit<>(t);
    }

    public Unit(T t)
    {
        m_t = t;
    }

    public T get()
    {
        return m_t;
    }

    //...
    public String toString()
    {
        return String.format("{value: %s}", m_t);
    }
}
