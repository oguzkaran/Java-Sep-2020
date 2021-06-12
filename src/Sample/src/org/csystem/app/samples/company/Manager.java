package org.csystem.app.samples.company;

public class Manager extends Employee {
    private double m_salary;
    private String m_department;

    //...

    public double getSalary()
    {
        return m_salary;
    }

    public void setSalary(double salary)
    {
        //...
        m_salary = salary;
    }

    public String getDepartment()
    {
        return m_department;
    }

    public void setDepartment(String department)
    {
        //...
        m_department = department;
    }

    public double calculateInsurancePayment()
    {
        return m_salary * 1.5;
    }

    //...
}
