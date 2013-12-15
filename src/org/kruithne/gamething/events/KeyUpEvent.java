package org.kruithne.gamething.events;

import org.kruithne.gamething.events.interfaces.IEvent;
import org.kruithne.gamething.events.interfaces.IKeyUpEvent;

public class KeyUpEvent extends Event
{
	public KeyUpEvent(int key)
	{
		this.key = key;
	}

	@Override
	public Class<? extends IEvent> getInterface()
	{
		return IKeyUpEvent.class;
	}

	@Override
	public void triggerEvent(IEvent listener)
	{
		((IKeyUpEvent) listener).onKeyUp(key);
	}

	protected int key;
}
