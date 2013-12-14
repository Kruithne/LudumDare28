package org.kruithne.gamething.events.interfaces;

public interface IEventBase
{
	void fireEvent();
	Class<? extends IEvent> getInterface();
	void triggerEvent(IEvent listener);
}
