package org.kruithne.gamething.rendering;

public abstract class RenderObject implements IRenderObject
{
	public RenderObject(int x, int y)
	{
		drawX = x;
		drawY = y;
	}

	@Override
	public int getDrawX()
	{
		return drawX;
	}

	@Override
	public int getDrawY()
	{
		return drawY;
	}

	@Override
	public void setDrawX(int x)
	{
		drawX = x;
	}

	@Override
	public void setDrawY(int y)
	{
		drawY = y;
	}

	protected int drawX;
	protected int drawY;
}
