package org.kruithne.gamething;

import org.newdawn.slick.*;

public class GameThing extends BasicGame
{
	public GameThing(String name)
	{
		super(name);
	}

	@Override
	public void init(GameContainer gameContainer) throws SlickException
	{
		// Dance like it's 1972.
	}

	@Override
	public void update(GameContainer gameContainer, int i) throws SlickException
	{
		// Update stuff!
	}

	@Override
	public void render(GameContainer gameContainer, Graphics graphics) throws SlickException
	{
		graphics.drawString("Hello, world!", 20, 20);
		graphics.drawImage(ImageLoader.getImage("/res/images/dirt.png"), 50, 50);
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer container;
			container = new AppGameContainer(new GameThing("Game Thing!"));
			container.setDisplayMode(1024, 512, false);
			container.start();
		}
		catch(SlickException exception)
		{
			// ToDo: Better logging.
			exception.printStackTrace();
		}
	}
}
