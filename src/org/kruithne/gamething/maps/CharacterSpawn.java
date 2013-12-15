package org.kruithne.gamething.maps;

public class CharacterSpawn implements ITileObject
{
	public CharacterSpawn(int x, int y)
	{
		tileX = x;
		tileY = y;
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
		return TileType.CHAR_START;
	}

	protected int tileX;
	protected int tileY;
}
