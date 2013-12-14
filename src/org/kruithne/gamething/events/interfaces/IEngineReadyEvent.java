package org.kruithne.gamething.events.interfaces;

import org.newdawn.slick.GameContainer;

public interface IEngineReadyEvent extends IEvent
{
	void onEngineReady(GameContainer window);
}
