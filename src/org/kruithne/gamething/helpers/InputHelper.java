package org.kruithne.gamething.helpers;

import org.newdawn.slick.Input;

public class InputHelper
{
	public static boolean mouseWithinBounds(Input input, int lowX, int lowY, int highX, int highY)
	{
		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();

		return (mouseX > lowX && mouseX < highX) && (mouseY > lowY && mouseY < highY);
	}
}
