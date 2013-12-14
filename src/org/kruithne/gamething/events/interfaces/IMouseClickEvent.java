package org.kruithne.gamething.events.interfaces;

import org.kruithne.gamething.input.MouseButton;

public interface IMouseClickEvent extends IEvent
{
	void onMouseClick(MouseButton button, int x, int y);
}
