package org.kruithne.gamething.maps;

import org.kruithne.gamething.misc.RGB;

public enum TileType
{
	CHAR_START(255, 0, 0, "char.png"),
	BRICK(112, 89, 73, "brick.png", true);

	private TileType(int r, int g, int b, String file, boolean causesCollision)
	{
		rgb = new RGB(r, g, b);
		texture = file;
		collidable = causesCollision;
	}

	private TileType(int r, int g, int b, String file)
	{
		this(r, g, b, file, false);
	}

	public static TileType getFromRGB(RGB check)
	{
		for (TileType tileType : values())
			if (check.equals(tileType.rgb))
				return tileType;

		return null;
	}

	public String getTexture()
	{
		return texture;
	}

	public boolean isCollidable()
	{
		return collidable;
	}

	public RGB rgb;
	private String texture;
	private boolean collidable;
}
