package org.kruithne.gamething;

import org.kruithne.gamething.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import org.picocontainer.Startable;

public class GameLoader implements Startable
{
	public GameLoader()	{}

	@Override
	public void start()
	{
		try
		{
			container = new AppGameContainer(new MainGame());
			container.setDisplayMode(GameThing.windowWidth, GameThing.windowHeight, fullScreen);
			container.setTargetFrameRate(60);
			container.start();
		}
		catch(SlickException exception)
		{
			Logger.logException(exception);
		}
	}

	@Override
	public void stop()
	{
		container.destroy();
	}

	protected AppGameContainer container;
	protected boolean fullScreen = false;
}
