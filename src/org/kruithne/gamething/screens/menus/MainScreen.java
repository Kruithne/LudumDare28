package org.kruithne.gamething.screens.menus;

import org.kruithne.gamething.helpers.ImageLoader;
import org.kruithne.gamething.helpers.RenderHelper;
import org.kruithne.gamething.screens.IMenuScreen;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class MainScreen implements IMenuScreen
{
	@Override
	public void draw(GameContainer window, Graphics renderer)
	{
		RenderHelper.renderBackground(window, renderer, ImageLoader.getImage("dirt_background.png"));
	}
}
