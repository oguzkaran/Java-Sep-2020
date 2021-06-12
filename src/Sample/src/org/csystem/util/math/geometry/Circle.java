/*----------------------------------------------------------------------------------------------------------------------
	Circle sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.math.geometry;

import static java.lang.Math.PI;

public class Circle {
    private double m_r;

    public Circle()
    {
    }

    public Circle(double r)
    {
        this.setRadius(r);
    }

    public double getRadius()
    {
        return m_r;
    }

    public void setRadius(double r)
    {
        m_r = Math.abs(r);
    }

    public double getArea()
    {
        return PI * m_r * m_r;
    }

    public double getCircumference()
    {
        return 2 * PI * m_r;
    }
}
