package org.kruithne.gamething.game;

import org.kruithne.gamething.rendering.RenderPositionalObject;

public class CollisionBound
{
	public CollisionBound(float aX, float aY, float bX, float bY)
	{
		this.aX = aX;
		this.aY = aY;
		this.bX = bX;
		this.bY = bY;
	}

	public void setObject(RenderPositionalObject object)
	{
		this.object = object;
	}

	public void updateObject()
	{
		if (object != null)
		{
			object.setDrawX(aX);
			object.setDrawY(aY);
		}
	}

	protected float aX;
	protected float aY;
	protected float bX;
	protected float bY;
	private RenderPositionalObject object;
}
