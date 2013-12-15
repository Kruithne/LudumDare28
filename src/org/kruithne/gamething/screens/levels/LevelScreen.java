package org.kruithne.gamething.screens.levels;

import org.kruithne.gamething.GameThing;
import org.kruithne.gamething.logging.Logger;
import org.kruithne.gamething.maps.CharacterSpawn;
import org.kruithne.gamething.maps.ITileObject;
import org.kruithne.gamething.maps.MapLoader;
import org.kruithne.gamething.maps.RenderMapTile;
import org.kruithne.gamething.rendering.IRenderable;
import org.kruithne.gamething.rendering.RenderImage;
import org.kruithne.gamething.screens.ScreenBase;
import org.newdawn.slick.GameContainer;

import java.util.List;

public class LevelScreen extends ScreenBase
{
	public LevelScreen()
	{
		backgroundImage = new RenderImage("dirt.png");
		setupMap("start_map.png");

		charImage = new RenderImage("char.png");
		charImage.setDrawX((GameThing.windowWidth / 2) - (charImage.getWidth() / 2));
		charImage.setDrawY((GameThing.windowHeight / 2) - (charImage.getHeight() / 2));
		addComponent(charImage);
	}

	protected void setupMap(String map)
	{
		Logger.log("Loading map: " + map);
		List<ITileObject> tiles = MapLoader.loadMap(map);
		for (ITileObject tile : tiles)
		{
			if (tile instanceof RenderMapTile)
				addComponent((RenderMapTile) tile);
			else if (tile instanceof CharacterSpawn)
				setSpawn(tile.getTileX(), tile.getTileY());
		}
	}

	protected void setSpawn(int tileX, int tileY)
	{
		offsetX = (GameThing.windowWidth / 2) - (tileX * 64);
		offsetY = (GameThing.windowHeight / 2) - (tileY * 64);
	}

	@Override
	public void update(GameContainer window)
	{
		for (IRenderable object : getComponents())
		{
			if (object instanceof RenderMapTile)
			{
				RenderMapTile tile = (RenderMapTile) object;
				tile.setDrawX((tile.getTileX() * 64) + offsetX);
				tile.setDrawY((tile.getTileY() * 64) + offsetY);
			}
		}
	}

	@Override
	public RenderImage getBackImage()
	{
		return backgroundImage;
	}

	protected RenderImage backgroundImage;
	protected RenderImage charImage;
	protected int offsetX;
	protected int offsetY;
}
