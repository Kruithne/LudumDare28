package org.kruithne.gamething.screens.levels;

import org.kruithne.gamething.screens.ScreenBase;
import org.newdawn.slick.Color;

public abstract class LevelBase extends ScreenBase
{
	@Override
	public Color getBackColor()
	{
		return new Color(0, 0, 0);
	}
}
