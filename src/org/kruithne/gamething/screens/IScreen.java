package org.kruithne.gamething.screens;

import org.kruithne.gamething.rendering.IRenderable;
import org.kruithne.gamething.rendering.RenderImage;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;

import java.util.List;

public interface IScreen
{
	void update(GameContainer window);
	void addComponent(IRenderable object);
	List<IRenderable> getComponents();
	Color getBackColor();
	RenderImage getBackImage();
	boolean tileBackground();
}
