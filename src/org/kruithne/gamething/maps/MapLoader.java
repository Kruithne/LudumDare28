package org.kruithne.gamething.maps;

import org.kruithne.gamething.logging.Logger;
import org.kruithne.gamething.misc.RGB;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapLoader
{
	public static List<ITileObject> loadMap(String file)
	{
		try
		{
			InputStream stream = MapLoader.class.getClassLoader().getResourceAsStream("res/maps/" + file);
			BufferedImage bufferedImage = ImageIO.read(stream);
			final byte[] pixels = ((DataBufferByte) bufferedImage.getRaster().getDataBuffer()).getData();

			final int width = bufferedImage.getWidth();
			List<ITileObject> tiles = new ArrayList<ITileObject>(0);

			final int pixelLength = 3;
			for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength)
			{
				TileType tile = TileType.getFromRGB(new RGB(
						(int) pixels[pixel + 2] & 0xff,
						(int) pixels[pixel + 1] & 0xff,
						(int) pixels[pixel] & 0xff
				));

				if (tile != null)
				{
					if (tile == TileType.CHAR_START)
					{
						CharacterSpawn spawn = new CharacterSpawn(col, row);
						tiles.add(spawn);
						tiles.add(new RenderMapTile(spawn.getTileType(), col, row));
					}
					else if (tile == TileType.CRATE)
					{
						PushableCrate crate = new PushableCrate(col, row);
						tiles.add(crate);
						tiles.add(new RenderMapTile(crate.getTileType(), col, row));
					}
					else
					{
						tiles.add(new RenderMapTile(tile, col, row));
					}
				}

				col++;

				if (col == width)
				{
					col = 0;
					row++;
				}
			}
			return tiles;
		}
		catch (Exception exception)
		{
			Logger.logException(exception);
		}
		return null;
	}
}
