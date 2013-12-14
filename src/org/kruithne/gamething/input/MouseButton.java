package org.kruithne.gamething.input;

public enum MouseButton
{
	LEFT_CLICK,
	RIGHT_CLICK,
	MIDDLE_CLICK,
	MOUSE_4,
	MOUSE_5;

	public static MouseButton getMouseButton(int buttonID)
	{
		for (MouseButton button : values())
			if (button.ordinal() == buttonID)
				return button;

		return null;
	}
}
