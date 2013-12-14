package org.kruithne.gamething.events;

import org.kruithne.gamething.events.interfaces.IEvent;
import org.kruithne.gamething.events.interfaces.IMouseMoveEvent;

public class MouseMoveEvent extends Event
{
	public MouseMoveEvent(int sourceX, int sourceY, int x, int y)
	{
		this.sourceX = sourceX;
		this.sourceY = sourceY;
		this.x = x;
		this.y = y;
	}

	@Override
	public Class<? extends IEvent> getInterface()
	{
		return IMouseMoveEvent.class;
	}

	@Override
	public void triggerEvent(IEvent listener)
	{
		((IMouseMoveEvent) listener).onMouseMove(sourceX, sourceY, x, y);
	}

	private int sourceX;
	private int sourceY;
	private int x;
	private int y;
}
