package org.kruithne.gamething.entity;

import org.kruithne.gamething.maps.TileType;
import org.kruithne.gamething.rendering.RenderImage;

public class Entity extends RenderImage
{
	public Entity(TileType type, float x, float y)
	{
		super(type.getTexture());
		this.x = x;
		this.y = y;
		this.type = type;
	}

	public void update(float offsetX, float offsetY)
	{
		setDrawX(getX() + offsetX);
		setDrawY(getY() + offsetY);
	}

	public float getX()
	{
		return x;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public float getY()
	{
		return y;
	}

	public void setY(float y)
	{
		this.y = y;
	}

	public TileType getType()
	{
		return type;
	}

	private float x;
	private float y;
	private TileType type;
}
