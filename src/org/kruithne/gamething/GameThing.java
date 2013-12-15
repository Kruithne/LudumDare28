package org.kruithne.gamething;

import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoBuilder;

public class GameThing
{
	public static void main(String[] args)
	{
		Engine.addComponent(RenderEngine.class);
		Engine.addComponent(GameEngine.class);
		Engine.addComponent(GameLoader.class);
		Engine.start();
	}

	public final static MutablePicoContainer Engine = new PicoBuilder().withCaching().withLifecycle().build();
}
