package org.kruithne.gamething;

import org.kruithne.gamething.events.EngineReadyEvent;
import org.kruithne.gamething.events.RenderEvent;
import org.kruithne.gamething.events.UpdateEvent;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class MainGame extends BasicGame
{
	public MainGame()
	{
		super("Game Thing!");
	}

	@Override
	public void init(GameContainer gameContainer) throws SlickException
	{
		new EngineReadyEvent(gameContainer).fireEvent();
	}

	@Override
	public void update(GameContainer gameContainer, int i) throws SlickException
	{
		new UpdateEvent(gameContainer).fireEvent();
	}

	@Override
	public void render(GameContainer gameContainer, Graphics graphics) throws SlickException
	{
		new RenderEvent(gameContainer, graphics).fireEvent();
	}
}
