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
					ITileObject object;

					if (tile == TileType.CHAR_START)
						object = new CharacterSpawn(col, row);
					else
						object = new RenderMapTile(tile, col, row);

					tiles.add(object);
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
