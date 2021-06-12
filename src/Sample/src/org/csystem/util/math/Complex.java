/*----------------------------------------------------------------------------------------------------------------------
	Complex sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.math;

public class Complex {
	private static Complex add(double a1, double b1, double a2, double b2)
	{		
		return new Complex(a1 + a2, b1 + b2);
	}
	
	private static Complex subtract(double a1, double b1, double a2, double b2)
	{
		return add(a1, b1, -a2, -b2);
	}
	
	public double re;
	public double im;
	
	public Complex()
	{		
	}	
	
	public Complex(double re)
	{
		this.re = re;
	}
	
	public Complex(double re, double im)
	{
		this.re = re;
		this.im = im;
	}
	
	public double getNorm()
	{
		return Math.sqrt(re * re + im * im);
	}
	
	public Complex getConjugate()
	{
		return new Complex(re, -im);		
	}
	
	//add methods
	public Complex add(Complex other)
	{
		return add(re, im, other.re, other.im);						
	}
	
	public Complex add(double val)
	{
		return add(re, im, val, 0);
	}
	
	public static Complex add(double val, Complex z)
	{
		return add(val, 0, z.re, z.im);
	}
	
	//subtract methods
	public Complex subtract(Complex other)
	{
		return subtract(re, im, other.re, other.im);						
	}
	
	public Complex subtract(double val)
	{
		return subtract(re, im, val, 0);
	}
	
	public static Complex subtract(double val, Complex z)
	{
		return subtract(val, 0, z.re, z.im);
	}
	
	public String toString()
	{
		return String.format("|%.2f + %.2f * i| = %f", re, im, getNorm());
	}
}

