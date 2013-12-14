package org.kruithne.gamething.games;

import org.kruithne.gamething.screens.IScreen;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public abstract class GameBase extends BasicGame implements IGame
{
	public GameBase()
	{
		super("Game Thing!");
	}

	@Override
	public void init(GameContainer window) throws SlickException
	{
		window.setShowFPS(false);
	}

	@Override
	public void update(GameContainer window, int i) throws SlickException
	{
		// Override if needed.
	}

	@Override
	public void render(GameContainer window, Graphics renderer) throws SlickException
	{
		currentScreen.draw(window, renderer);
	}

	protected IScreen currentScreen;
}
