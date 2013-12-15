package org.kruithne.gamething.events;

import org.kruithne.gamething.events.interfaces.IEvent;
import org.kruithne.gamething.events.interfaces.IKeyDownEvent;
import org.kruithne.gamething.logging.Logger;

public class KeyDownEvent extends Event
{
	public KeyDownEvent(int key)
	{
		Logger.log("Key press: " + key);
		this.key = key;
	}

	@Override
	public Class<? extends IEvent> getInterface()
	{
		return IKeyDownEvent.class;
	}

	@Override
	public void triggerEvent(IEvent listener)
	{
		((IKeyDownEvent) listener).onKeyDown(key);
	}

	protected int key;
}
