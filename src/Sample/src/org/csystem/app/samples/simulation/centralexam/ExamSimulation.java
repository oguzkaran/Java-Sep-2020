/*--------------------------------------------------------------------------------------------------------------------
    ExamSimulation sınıfı
---------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.simulation.centralexam;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class ExamSimulation {
    private final String m_lectureName;
    private int [][] m_grades;
    private double [] m_averages;
    private double m_average;

    private void findAverages()
    {
        int totalNumberOfStudents = 0;
        int totalGrades = 0;

        for (int i = 0; i < m_grades.length; ++i) {
            int total = ArrayUtil.sum(m_grades[i]);

            m_averages[i] = (double)total / m_grades[i].length;
            totalGrades += total;
            totalNumberOfStudents += m_grades[i].length;
        }

        m_average = (double)totalGrades / totalNumberOfStudents;
    }

    private void fillGrades()
    {
        Random r = new Random();
        Scanner kb = new Scanner(System.in);
        System.out.printf("%s sınavı şube sayısını giriniz:", m_lectureName);
        m_grades = new int[Integer.parseInt(kb.nextLine())][];
        m_averages = new double[m_grades.length];

        for (int i = 0; i < m_grades.length; ++i) {
            System.out.printf("%d. şube öğrenci sayısı?", i + 1);
            int count = Integer.parseInt(kb.nextLine());

            m_grades[i] = ArrayUtil.generateRandomArray(r, count, 0, 101);
        }
    }

    public ExamSimulation(String name)
    {
        m_lectureName = name;
    }

    public int getNumberOfClasses()
    {
        return m_grades.length;
    }

    public int getNumberOfStudents(int i)
    {
        return m_grades[i].length;
    }

    public int getGrade(int i, int k)
    {
        return m_grades[i][k];
    }

    public double getAverage(int i)
    {
        return m_averages[i];
    }

    public double getAverage()
    {
        return m_average;
    }

    public String getLectureName()
    {
        return m_lectureName;
    }

    public void run()
    {
        fillGrades();
        findAverages();
    }

    public void displayGrades()
    {
        System.out.printf("%s dersi sınav notları:%n", m_lectureName);
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < m_grades.length; ++i) {
            System.out.printf("%d. şube notları:", i + 1);
            ArrayUtil.display(3, m_grades[i]);
        }

        System.out.println("-------------------------------------------------------");
    }

    public void displayReport()
    {
        System.out.println("*******************************************************");
        displayGrades();
        System.out.printf("%s dersi için not ortalamaları:%n", m_lectureName);
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < m_averages.length; ++i)
            System.out.printf("%d.şube not ortalaması:%f%n", i + 1, m_averages[i]);
        System.out.printf("Okul Ortalaması:%f%n", m_average);
        System.out.println("-------------------------------------------------------");
        System.out.println("*******************************************************");
    }
}
