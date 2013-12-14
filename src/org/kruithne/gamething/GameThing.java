package org.kruithne.gamething;

import org.kruithne.gamething.logging.Logger;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoBuilder;

public class GameThing
{
	public static void main(String[] args)
	{
		Engine.addComponent(Logger.class);
		Engine.addComponent(BaseEngine.class);
		Engine.addComponent(RenderEngine.class);
		Engine.start();
	}

	public final static MutablePicoContainer Engine = new PicoBuilder().withCaching().withLifecycle().build();
}
