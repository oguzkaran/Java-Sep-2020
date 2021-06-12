package org.csystem.app.samples.company;

public class ProjectWorker  extends Worker {
    private String m_projectName;
    private double m_ratio;
    //...

    public String getProjectName()
    {
        return m_projectName;
    }

    public void setProjectName(String projectName)
    {
        //...
        m_projectName = projectName;
    }

    public double getRatio()
    {
        return m_ratio;
    }

    public void setRatio(double ratio)
    {
        //...
        m_ratio = ratio;
    }

    public double calculateInsurancePayment()
    {
        double payment = super.calculateInsurancePayment();

        return payment + payment * m_ratio;
    }

    //...
}
