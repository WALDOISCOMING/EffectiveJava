package Chap4.�׸�13;

public class Complex {

	private final float re;
	private final float im;
	public Complex(float re,float im){
		this.re=re;this.im=im;
	}
	public Complex add (Complex c)
	{
		return new Complex(re+c.re, im+c.im);
	}
}
