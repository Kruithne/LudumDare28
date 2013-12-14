package org.kruithne.gamething.events.interfaces;

public interface IMouseMoveEvent extends IEvent
{
	void onMouseMove(int sourceX, int sourceY, int x, int y);
}
