package org.kruithne.gamething.maps;

public class PushableCrate implements ITileObject
{
	public PushableCrate(int tileX, int tileY)
	{
		this.tileX = tileX;
		this.tileY = tileY;
	}

	@Override
	public int getTileX()
	{
		return tileX;
	}

	@Override
	public int getTileY()
	{
		return tileY;
	}

	@Override
	public TileType getTileType()
	{
		return TileType.DARK_BRICK;
	}

	protected int tileX;
	protected int tileY;
}
