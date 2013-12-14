package org.kruithne.gamething.screens.menus;

import org.kruithne.gamething.helpers.ImageLoader;
import org.kruithne.gamething.screens.IMenuScreen;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class MainScreen implements IMenuScreen
{
	@Override
	public void draw(GameContainer window, Graphics renderer)
	{
		renderer.setBackground(new Color(81, 65, 53));

		Image logo = ImageLoader.getImage("logo.png");
		renderer.drawImage(logo, (window.getWidth() / 2) - (logo.getWidth() / 2), 25);
	}
}
