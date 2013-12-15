package org.kruithne.gamething.maps;

import org.kruithne.gamething.rendering.RenderImage;

public class RenderMapTile extends RenderImage implements ITileObject
{
	public RenderMapTile(String imageString, int tileX, int tileY)
	{
		super(imageString);
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

	protected int tileX;
	protected int tileY;
}
