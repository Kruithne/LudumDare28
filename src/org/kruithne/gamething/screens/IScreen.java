package org.kruithne.gamething.screens;

import org.kruithne.gamething.rendering.IRenderObject;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;

import java.util.List;

public interface IScreen
{
	void update(GameContainer window);
	void addComponent(IRenderObject object);
	List<IRenderObject> getComponents();
	Color getBackColor();
}
