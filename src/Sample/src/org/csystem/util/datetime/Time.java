/*----------------------------------------------------------------------------------------------------------------------
	Time sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public class Time {
    private int m_hour;
    private int m_minute;
    private int m_second;
    private int m_millisecond;

    private static void doWorkForException(String message)
    {
        throw new DateTimeException(message);
    }

    private static boolean isValidForBound(int val, int max)
    {
        return 0 <= val && val <= max;
    }

    private static boolean isValidForHour(int val)
    {
        return isValidForBound(val, 23);
    }

    private static boolean isValidForMinute(int val)
    {
        return isValidForBound(val, 59);
    }

    private static boolean isValidForSecond(int val)
    {
        return isValidForBound(val, 59);
    }

    private static boolean isValidForMillisecond(int val)
    {
        return isValidForBound(val, 999);
    }

    private static boolean isValidForTime(int hour, int minute, int second, int millisecond)
    {
        return isValidForHour(hour) && isValidForMinute(minute) &&
                isValidForSecond(second) && isValidForMillisecond(millisecond);
    }

    private static void checkForHour(int val)
    {
        if (!isValidForHour(val))
            doWorkForException("Invalid hour value:" + val);
    }

    private static void checkForMinute(int val)
    {
        if (!isValidForMinute(val))
            doWorkForException("Invalid minute value:" + val);
    }

    private static void checkForSecond(int val)
    {
        if (!isValidForSecond(val))
            doWorkForException("Invalid second value:" + val);
    }

    private static void checkForMillisecond(int val)
    {
        if (!isValidForMillisecond(val))
            doWorkForException("Invalid millisecond value value:" + val);
    }

    private static void checkForTime(int hour, int minute, int second, int millisecond)
    {
        if (!isValidForTime(hour, minute, second, millisecond))
            doWorkForException(String.format("Invalid time values:all values -> %d, %d, %d, %d", hour, minute, second, millisecond));
    }

    public static Time of()
    {
        return of(new Random());
    }

    public static Time of(Random r)
    {
        return new Time(r.nextInt(24), r.nextInt(60), r.nextInt(60), r.nextInt(1000));
    }

    public Time() //Burada yazılanların bilinmesi gerekmez. Sadece default ctor'un anlamı olarak yazılmıştır
    {
        Calendar now = Calendar.getInstance();

        m_hour = now.get(Calendar.HOUR_OF_DAY);
        m_minute = now.get(Calendar.MINUTE);
        m_second = now.get(Calendar.SECOND);
        m_millisecond = now.get(Calendar.MILLISECOND);
    }

    public Time(int hour, int minute)
    {
        this(hour, minute, 0);
    }

    public Time(int hour, int minute, int second)
    {
        this(hour, minute, second, 0);
    }

    public Time(int hour, int minute, int second, int millisecond)
    {
        checkForTime(hour, minute, second, millisecond);
        m_hour = hour;
        m_minute = minute;
        m_second = second;
        m_millisecond = millisecond;
    }

    public int getHour()
    {
        return m_hour;
    }

    public void setHour(int hour)
    {
        if (hour == m_hour)
            return;

        checkForHour(hour);
        m_hour = hour;
    }

    public int getMinute()
    {
        return m_minute;
    }

    public void setMinute(int minute)
    {
        if (minute == m_minute)
            return;

        checkForMinute(minute);
        m_minute = minute;
    }

    public int getSecond()
    {
        return m_second;
    }

    public void setSecond(int second)
    {
        if (second == m_second)
            return;

        checkForSecond(second);
        m_second = second;
    }

    public int getMillisecond()
    {
        return m_millisecond;
    }

    public void setMillisecond(int millisecond)
    {
        if (millisecond == m_millisecond)
            return;

        checkForMillisecond(millisecond);
        m_millisecond = millisecond;
    }

    public String toLongTimeString()
    {
        return String.format("%s.%03d", toString(), m_millisecond);
    }

    public String toString()
    {
        return String.format("%s:%02d", toShortTimeString(), m_second);
    }

    public String toShortTimeString()
    {
        return String.format("%02d:%02d", m_hour, m_minute);
    }
}
