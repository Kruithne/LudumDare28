package org.kruithne.gamething;

import org.kruithne.gamething.games.MainGame;
import org.newdawn.slick.*;

public class GameThing
{
	public static void main(String[] args)
	{
		try
		{
			AppGameContainer container;
			container = new AppGameContainer(new MainGame());
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
