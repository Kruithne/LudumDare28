package org.kruithne.gamething.entity;

import org.kruithne.gamething.maps.TileType;

public class BreakableEntity extends Entity
{
	public BreakableEntity(TileType type, float x, float y)
	{
		super(type, x, y);
	}

	public void breakEntity()
	{
		setTexture("broken_crate.png");
		isBroken = true;
	}

	@Override
	public void setX(float x)
	{
		if (!isBroken)
			super.setX(x) ;
	}

	@Override
	public void setY(float y)
	{
		if (!isBroken)
			super.setY(y);
	}

	private boolean isBroken;
}
