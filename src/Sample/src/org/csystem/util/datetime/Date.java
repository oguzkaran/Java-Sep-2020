/*----------------------------------------------------------------------------------------------------------------------
	Date sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public class Date {
    private static final String [] MONTHS_TR;
    private static final String [] MONTHS_EN;
    private static final String [] DAYS_OF_WEEK_TR;
    private static final String [] DAYS_OF_WEEK_EN;
    private static final Month [] MONTHS;

    static {
        MONTHS_TR = new String[] {"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
                "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
        MONTHS_EN = new String[] {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        DAYS_OF_WEEK_TR = new String[] {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
        DAYS_OF_WEEK_EN = new String[] {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        MONTHS = Month.values();
    }

    private int m_day;
    private int m_month;
    private int m_year;
    private int m_dayOfWeek;

    private static boolean isValidDate(int day, int month, int year)
    {
        if (day < 1 || day > 31 || month < 1 || month > 12)
            return false;

        return day <= MONTHS[month - 1].getDays(year);
    }

    private static int getTotalDaysByMonth(int month, int year)
    {
        int totalDays = 0;

        for (int m  = month - 1; m >= 1; --m)
            totalDays += MONTHS[m - 1].getDays(year);

        return month > 2 && Month.isLeapYear(year) ? totalDays + 1 : totalDays;
    }

    private static int getDayOfYear(int day, int month, int year)
    {
        return day + getTotalDaysByMonth(month, year);
    }

    private static int getDayOfWeek(int day, int month, int year)
    {
        int totalDays = getDayOfYear(day, month, year);

        for (int y = 1900; y < year; ++y)
            totalDays += Month.isLeapYear(y) ? 366 : 365;

        return totalDays % 7;
    }

    private static String getDaySuffix(int day)
    {
        String suffix = "th";

        switch (day) {
            case 1:
            case 21:
            case 31:
                suffix = "st";
                break;
            case 2:
            case 22:
                suffix = "nd";
                break;
            case 3:
            case 23:
                suffix = "rd";
                break;
        }

        return suffix;
    }

    private static void doWorkForException(String message)
    {
        throw new DateTimeException(message);
    }

    private static void checkForDate(int day, int month, int year, String errMessage)
    {
        if (!isValidDate(day, month, year))
            doWorkForException(errMessage);
    }

    private void checkForDay(int val)
    {
        checkForDate(val, m_month, m_year, "Invalid day value:" + val);
    }

    private void checkForMonth(int val)
    {
        checkForDate(m_day, val, m_year, "Invalid month value:" + val);
    }

    private void checkForYear(int val)
    {
        checkForDate(m_day, m_month, val, "Invalid year value:" + val);
    }

    private void set(int day, int month, int year)
    {
        m_day = day;
        m_month = month;
        m_year = year;
        m_dayOfWeek = getDayOfWeek(m_day, m_month, m_year);
    }

    public static Date of()
    {
        return of(new Random());
    }

    public static Date of(Random r)
    {
        return of(r, new Date().m_year);
    }

    public static Date of(int year)
    {
        return of(new Random(), year);
    }

    public static Date of(Random r, int year)
    {
        return of(r, year, year);
    }

    public static Date of(int minYear, int maxYear)
    {
        return of(new Random(), minYear, maxYear);
    }

    public static Date of(Random r, int minYear, int maxYear)
    {
        int year = r.nextInt(maxYear - minYear + 1) + minYear;
        int month = r.nextInt(12) + 1;
        int day = r.nextInt(MONTHS[month - 1].getDays(year)) + 1;

        return new Date(day, month, year);
    }

    public Date() //Burada yazılanların bilinmesi gerekmez. Sadece default ctor'un anlamı olarak yazılmıştır
    {
        Calendar now = Calendar.getInstance();

        m_day = now.get(Calendar.DAY_OF_MONTH);
        m_month = now.get(Calendar.MONTH) + 1;
        m_year = now.get(Calendar.YEAR);
        m_dayOfWeek = getDayOfWeek(m_day, m_month, m_year);
    }

    public Date(int day, Month month, int year)
    {
        this(day, month.ordinal() + 1, year);
    }

    public Date(int day, int month, int year)
    {
        checkForDate(day, month, year, String.format("Invalid date values: all values -> %d, %d, %d", day, month, year));
        set(day, month, year);
    }

    public int getDay()
    {
        return m_day;
    }

    public void setDay(int day)
    {
        if (day == m_day)
            return;

        checkForDay(day);
        set(day, m_month, m_year);
    }

    public Month getMonth()
    {
        return MONTHS[m_month - 1];
    }

    public void setMonth(Month month)
    {
        setMonthValue(month.ordinal() + 1);
    }
    public int getMonthValue()
    {
        return m_month;
    }

    public void setMonthValue(int month)
    {
        if (month == m_month)
            return;

        checkForMonth(month);
        set(m_day, month, m_year);
    }

    public int getYear()
    {
        return m_year;
    }

    public void setYear(int year)
    {
        if (year == m_year)
            return;

        checkForYear(year);
        set(m_day, m_month, year);
    }

    public DayOfWeek getDayOfWeek()
    {
        return DayOfWeek.values()[m_dayOfWeek];
    }

    public String getDayOfWeekTR()
    {
        return DAYS_OF_WEEK_TR[m_dayOfWeek];
    }

    public String getDayOfWeekEN()
    {
        return DAYS_OF_WEEK_EN[m_dayOfWeek];
    }

    public boolean isLeapYear()
    {
        return Month.isLeapYear(m_year);
    }

    public boolean isWeekend()
    {
        return m_dayOfWeek == 0 || m_dayOfWeek == 6;
    }

    public boolean isWeekday()
    {
        return !isWeekend();
    }

    public String toString()
    {
        return toString('/');
    }

    public String toString(char delimiter)
    {
        return String.format("%02d%c%02d%c%04d", m_day, delimiter, m_month, delimiter, m_year);
    }

    public String toStringTR()
    {
        return String.format("%d %s %d", m_day, MONTHS_TR[m_month], m_year);
    }

    public String toStringEN()
    {
        return String.format("%d%s %s %d", m_day, getDaySuffix(m_day), MONTHS_EN[m_month], m_year);
    }

    public String toLongDateStringTR()
    {
        return String.format("%s %s", toStringTR(), DAYS_OF_WEEK_TR[m_dayOfWeek]);
    }

    public String toLongDateStringEN()
    {
        return String.format("%s %s", toStringEN(), DAYS_OF_WEEK_EN[m_dayOfWeek]);
    }
}
