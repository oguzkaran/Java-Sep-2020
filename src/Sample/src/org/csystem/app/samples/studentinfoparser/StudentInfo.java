package org.csystem.app.samples.studentinfoparser;

import org.csystem.util.datetime.Date;

public class StudentInfo {
    private String m_name;
    private Date m_birthDate;
    private String m_lectureName;
    private int m_midtermGrade;
    private int m_finalGrade;

    public StudentInfo(String name, String birthDateStr, String lectureName, int midtermGrade, int finalGrade)
    {
        m_name = name;
        m_lectureName = lectureName;
        m_midtermGrade = midtermGrade;
        m_finalGrade = finalGrade;
        setBirthDate(birthDateStr);
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public String getLectureName()
    {
        return m_lectureName;
    }

    public void setLectureName(String lectureName)
    {
        m_lectureName = lectureName;
    }

    public int getMidtermGrade()
    {
        return m_midtermGrade;
    }

    public void setMidtermGrade(int midtermGrade)
    {
        m_midtermGrade = midtermGrade;
    }

    public int getFinalGrade()
    {
        return m_finalGrade;
    }

    public void setFinalGrade(int finalGrade)
    {
        m_finalGrade = finalGrade;
    }

    public double getGrade()
    {
        return m_midtermGrade * 0.3 + m_finalGrade * 0.6;
    }

    public void setBirthDate(String birthDateStr)
    {
        String [] birthDateInfo = birthDateStr.split("[/]");
        int day = Integer.parseInt(birthDateInfo[0]);
        int month = Integer.parseInt(birthDateInfo[1]);
        int year = Integer.parseInt(birthDateInfo[2]);

        m_birthDate = new Date(day, month, year);
    }

    public String toString()
    {
        double grade = getGrade();
        String fmt = "{name: %s, birthDate: %s, lectureName: %s, midtermGrade: %d, finalGrade: %d, grade: %f, status:%s}";

        return String.format(fmt, m_name, m_birthDate.toLongDateStringEN(), m_lectureName, m_midtermGrade, m_finalGrade, grade,  grade >= 50 ? "Geçti" : "Kaldı");
    }
}
