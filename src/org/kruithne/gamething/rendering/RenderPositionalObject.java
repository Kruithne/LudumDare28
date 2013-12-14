package org.kruithne.gamething.rendering;

public abstract class RenderPositionalObject implements IRenderable
{
	public RenderPositionalObject(int x, int y)
	{
		drawX = x;
		drawY = y;
	}

	public RenderPositionalObject setDrawX(int x)
	{
		drawX = x;
		return this;
	}

	public RenderPositionalObject setDrawY(int y)
	{
		drawY = y;
		return this;
	}

	public int getDrawX()
	{
		return drawX;
	}

	public int getDrawY()
	{
		return drawY;
	}

	protected int drawX;
	protected int drawY;
}
