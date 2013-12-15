package org.kruithne.gamething.screens.levels;

import org.kruithne.gamething.logging.Logger;
import org.kruithne.gamething.maps.MapLoader;
import org.kruithne.gamething.maps.RenderMapTile;
import org.kruithne.gamething.maps.TileType;
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

	}

	protected void setupMap(String map)
	{
		Logger.log("Loading map: " + map);
		List<RenderMapTile> tiles = MapLoader.loadMap(map);
		for (RenderMapTile tile : tiles)
			addComponent(tile);
	}

	@Override
	public void update(GameContainer window)
	{
		for (IRenderable object : getComponents())
		{
			if (object instanceof RenderMapTile)
			{
				RenderMapTile tile = (RenderMapTile) object;
				tile.setDrawX(tile.getTileX() * 64);
				tile.setDrawY(tile.getTileY() * 64);
			}
		}
	}

	@Override
	public RenderImage getBackImage()
	{
		return backgroundImage;
	}

	protected RenderImage backgroundImage;
}
