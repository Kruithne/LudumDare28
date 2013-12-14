package org.kruithne.gamething.events;

import org.kruithne.gamething.events.interfaces.IEvent;
import org.kruithne.gamething.events.interfaces.IMouseClickEvent;
import org.kruithne.gamething.input.MouseButton;

public class MouseClickEvent extends Event
{
	public MouseClickEvent(MouseButton button, int x, int y)
	{
		this.button = button;
		this.x = x;
		this.y = y;
	}

	@Override
	public Class<? extends IEvent> getInterface()
	{
		return IMouseClickEvent.class;
	}

	@Override
	public void triggerEvent(IEvent listener)
	{
		((IMouseClickEvent) listener).onMouseClick(button, x, y);
	}

	protected MouseButton button;
	protected int x;
	protected int y;
}
