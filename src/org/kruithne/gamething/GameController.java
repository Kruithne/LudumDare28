package org.kruithne.gamething;

import org.kruithne.gamething.screens.IScreen;

public final class GameController
{
	private static RenderEngine getRenderEngine()
	{
		return GameThing.Engine.getComponent(RenderEngine.class);
	}

	public static void setGameScreen(IScreen screen)
	{
		getRenderEngine().setCurrentScreen(screen);
	}
}
