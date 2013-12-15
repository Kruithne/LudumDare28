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
			container.setDisplayMode(screenX, screenY, fullScreen);
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
	protected int screenX = 1024;
	protected int screenY = 640;
	protected boolean fullScreen = false;
}
