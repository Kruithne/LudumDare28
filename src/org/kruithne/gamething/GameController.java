package org.kruithne.gamething;

import org.kruithne.gamething.screens.IScreen;
import org.kruithne.gamething.screens.menus.LevelCompleteScreen;

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

	public static void endGame()
	{
		getRenderEngine().setCurrentScreen(new LevelCompleteScreen());
	}
}
