package org.kruithne.gamething.events;

import org.kruithne.gamething.GameThing;
import org.kruithne.gamething.events.interfaces.IEvent;
import org.kruithne.gamething.events.interfaces.IEventBase;

public abstract class Event implements IEventBase
{
	public void fireEvent()
	{
		for (IEvent listener : GameThing.Engine.getComponents(getInterface()))
			triggerEvent(listener);
	}
}
