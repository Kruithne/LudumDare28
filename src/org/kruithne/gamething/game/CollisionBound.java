package org.kruithne.gamething.game;

import org.kruithne.gamething.entity.Entity;
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

	public void setEntity(Entity entity)
	{
		this.entity = entity;
	}

	public void offsetX(float offset)
	{
		aX += offset;
		bX += offset;
		offsetX += offset;
	}

	public void offsetY(float offset)
	{
		aY += offset;
		bY += offset;
		offsetY += offset;
	}

	public void updateEntity()
	{
		if (entity != null)
		{
			entity.setX(entity.getX() + offsetX);
			entity.setY(entity.getY() + offsetY);
		}
	}

	public Entity getEntity()
	{
		return entity;
	}

	protected float offsetX;
	protected float offsetY;
	protected float aX;
	protected float aY;
	protected float bX;
	protected float bY;
	private Entity entity;
}
