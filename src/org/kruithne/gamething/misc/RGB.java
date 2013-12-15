package org.kruithne.gamething.misc;

public class RGB
{
	public RGB(int r, int g, int b)
	{
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public boolean equals(RGB check)
	{
		return check.r == r && check.g == g && check.b == b;
	}

	@Override
	public String toString()
	{
		return "R: " + r + " G: " + g + " B: " + b;
	}

	public int r;
	public int g;
	public int b;
}
