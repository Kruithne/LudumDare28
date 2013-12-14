package org.kruithne.gamething.ui.interfaces;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface IButton
{
	void draw(GameContainer window, Graphics renderer);
	void update(GameContainer window);
	void setX(int x);
	void setY(int y);
}
