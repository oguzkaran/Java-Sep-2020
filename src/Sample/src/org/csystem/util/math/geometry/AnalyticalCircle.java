/*----------------------------------------------------------------------------------------------------------------------
	AnalyticalCircle sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.math.geometry;

public class AnalyticalCircle extends Circle {
    private final Point m_center;

    public AnalyticalCircle()
    {
        this(0);
    }

    public AnalyticalCircle(Point center)
    {
        this(0, center);
    }

    public AnalyticalCircle(double r, Point center)
    {
        this(r, center.x, center.y);
    }

    public AnalyticalCircle(double r)
    {
        this(r, 0, 0);
    }

    public AnalyticalCircle(int x, int y)
    {
        this(0, x, y);
    }

    public AnalyticalCircle(double r, int x, int y) //primary ctor
    {
        super(r);
        m_center = new Point(x, y);
    }

    public int getX() {return m_center.x;}
    public int getY() {return m_center.y;}

    public Point getCenter()
    {
        return new Point(m_center.x, m_center.y);
    }

    public void setX(int x)
    {
        m_center.x = x;
    }

    public void setY(int y)
    {
        m_center.y = y;
    }

    public void set(int x, int y)
    {
        this.setX(x);
        this.setY(y);
    }

    public void set(Point center)
    {
        this.set(center.x, center.y);
    }

    public void offset(int dxy)
    {
        this.offset(dxy, dxy);
    }

    public void offset(int dx, int dy)
    {
        m_center.offset(dx, dy);
    }

    public double centerDistance(AnalyticalCircle analyticalCircle)
    {
        return m_center.distance(analyticalCircle.m_center);
    }
}
