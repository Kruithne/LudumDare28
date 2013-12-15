package org.kruithne.gamething.maps;

import org.kruithne.gamething.rendering.RenderImage;

public class RenderMapTile extends RenderImage
{
	public RenderMapTile(String imageString, int tileX, int tileY)
	{
		super(imageString);
		this.tileX = tileX;
		this.tileY = tileY;
	}

	public int getTileX()
	{
		return tileX;
	}

	public int getTileY()
	{
		return tileY;
	}

	protected int tileX;
	protected int tileY;
}
