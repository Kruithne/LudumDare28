package org.kruithne.gamething;

import org.kruithne.gamething.events.interfaces.IEngineReadyEvent;
import org.kruithne.gamething.screens.menus.MainScreen;
import org.newdawn.slick.GameContainer;

public class GameEngine implements IEngineReadyEvent
{
	@Override
	public void onEngineReady(GameContainer window)
	{
		GameController.setGameScreen(new MainScreen());
	}
}
