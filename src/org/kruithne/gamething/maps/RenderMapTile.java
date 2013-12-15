package org.kruithne.gamething.maps;

import org.kruithne.gamething.rendering.RenderImage;

public class RenderMapTile extends RenderImage implements ITileObject
{
	public RenderMapTile(TileType tileType, int tileX, int tileY)
	{
		super(tileType.getTexture());
		this.tileType = tileType;
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
		return tileType;
	}

	protected int tileX;
	protected int tileY;
	protected TileType tileType;
}
