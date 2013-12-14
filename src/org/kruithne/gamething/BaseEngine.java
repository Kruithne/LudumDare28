package org.kruithne.gamething;

import org.kruithne.gamething.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import org.picocontainer.Startable;

public class BaseEngine implements Startable
{
	public BaseEngine(Logger output)
	{
		this.output = output;
	}

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
			output.logException(exception);
		}
	}

	@Override
	public void stop()
	{
		container.destroy();
	}

	protected final Logger output;
	protected AppGameContainer container;
	protected int screenX = 1024;
	protected int screenY = 512;
	protected boolean fullScreen = false;
}
