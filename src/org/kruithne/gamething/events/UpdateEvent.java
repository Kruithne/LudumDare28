package org.kruithne.gamething.events;

import org.kruithne.gamething.events.interfaces.IEvent;
import org.kruithne.gamething.events.interfaces.IUpdateEvent;
import org.newdawn.slick.GameContainer;

public class UpdateEvent extends Event
{
	public UpdateEvent(GameContainer window)
	{
		this.window = window;
	}

	@Override
	public Class<? extends IEvent> getInterface()
	{
		return IUpdateEvent.class;
	}

	@Override
	public void triggerEvent(IEvent listener)
	{
		((IUpdateEvent) listener).onUpdate(window);
	}

	private GameContainer window;
}
