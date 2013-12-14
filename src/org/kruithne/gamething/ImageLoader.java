package org.kruithne.gamething;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.HashMap;
import java.util.Map;

public class ImageLoader
{
	public static Image getImage(String path)
	{
		if (loadedImages.containsKey(path))
			return loadedImages.get(path);

		try
		{
			Image newImage = new Image(path);
			loadedImages.put(path, newImage);
			return newImage;
		}
		catch (SlickException exception)
		{
			exception.printStackTrace();
		}
		return null;
	}

	private static final Map<String, Image> loadedImages = new HashMap<String, Image>(0);
}
