package org.kruithne.gamething.rendering;

import org.kruithne.gamething.input.MouseButton;

public interface IReceiveMouseClickEvent
{
	void onMouseClick(MouseButton button, int x, int y);
}
