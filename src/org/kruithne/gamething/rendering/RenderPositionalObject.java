package org.kruithne.gamething.rendering;

public abstract class RenderPositionalObject implements IRenderable
{
	public RenderPositionalObject(float x, float y)
	{
		drawX = x;
		drawY = y;
	}

	public RenderPositionalObject setDrawX(float x)
	{
		drawX = x;
		return this;
	}

	public RenderPositionalObject setDrawY(float y)
	{
		drawY = y;
		return this;
	}

	public float getDrawX()
	{
		return drawX;
	}

	public float getDrawY()
	{
		return drawY;
	}

	protected float drawX;
	protected float drawY;
}
