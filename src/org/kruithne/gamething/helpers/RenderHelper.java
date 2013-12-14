package org.kruithne.gamething.helpers;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class RenderHelper
{
	public static void renderBackground(GameContainer window, Graphics renderer, Image image)
	{
		for (int x = 0; x < window.getWidth(); x = x + image.getWidth())
			for (int y = 0; y < window.getHeight(); y = y + image.getHeight())
				renderer.drawImage(image, x, y);
	}

	public static int getCenterX(GameContainer window, Image image)
	{
		return (window.getWidth() / 2) - (image.getWidth() / 2);
	}
}
