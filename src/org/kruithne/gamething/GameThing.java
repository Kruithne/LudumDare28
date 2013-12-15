package org.kruithne.gamething;

import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoBuilder;

import java.util.Timer;

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
	public final static Timer scheduler = new Timer();
	public final static int windowWidth = 1024;
	public final static int windowHeight = 640;
}
