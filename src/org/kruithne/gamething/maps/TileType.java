package org.kruithne.gamething.maps;

import org.kruithne.gamething.misc.RGB;

public enum TileType
{
	CHAR_START(255, 0, 0, "char.png"),
	BRICK(112, 89, 73, "brick.png", true),
	DARK_BRICK(33, 26, 22, "dark_brick.png"),
	CRATE(99, 68, 51, "crate.png", true, true),
	END_HOLE(255, 0, 110, "end_hole.png");

	private TileType(int r, int g, int b, String file, boolean causesCollision, boolean isPushable)
	{
		rgb = new RGB(r, g, b);
		texture = file;
		collidable = causesCollision;
		pushable = isPushable;
	}

	private TileType(int r, int g, int b, String file, boolean causesCollision)
	{
		this(r, g, b, file, causesCollision, false);
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

	public boolean isPushable()
	{
		return pushable;
	}

	public RGB rgb;
	private String texture;
	private boolean collidable;
	private boolean pushable;
}
