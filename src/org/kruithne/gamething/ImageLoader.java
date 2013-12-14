package org.kruithne.gamething;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageLoader
{
	public static Image getImage(String path)
	{
		return getImage(path, 1F);
	}

	public static Image getImage(String path, float scale)
	{
		try
		{
			return new Image(path).getScaledCopy(scale);
		}
		catch (SlickException exception)
		{
			exception.printStackTrace();
		}
		return null;
	}
}
