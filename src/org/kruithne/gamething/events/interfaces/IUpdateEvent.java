package org.kruithne.gamething.events.interfaces;

import org.newdawn.slick.GameContainer;

public interface IUpdateEvent extends IEvent
{
	void onUpdate(GameContainer window);
}
