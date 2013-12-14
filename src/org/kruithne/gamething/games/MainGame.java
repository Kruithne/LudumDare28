package org.kruithne.gamething.games;

import org.kruithne.gamething.screens.menus.MainScreen;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class MainGame extends GameBase
{
	@Override
	public void init(GameContainer window) throws SlickException
	{
		super.init(window);
		currentScreen = new MainScreen();
	}
}
