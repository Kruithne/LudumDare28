package org.kruithne.gamething.events;

import org.kruithne.gamething.events.interfaces.IEngineReadyEvent;
import org.kruithne.gamething.events.interfaces.IEvent;
import org.newdawn.slick.GameContainer;

public class EngineReadyEvent extends Event
{
	public EngineReadyEvent(GameContainer window)
	{
		this.window = window;
	}

	@Override
	public Class<? extends IEvent> getInterface()
	{
		return IEngineReadyEvent.class;
	}

	@Override
	public void triggerEvent(IEvent listener)
	{
		((IEngineReadyEvent) listener).onEngineReady(window);
	}

	private GameContainer window;
}
