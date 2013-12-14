package org.kruithne.gamething.screens;

import org.kruithne.gamething.rendering.IRenderable;
import org.kruithne.gamething.rendering.RenderImage;
import org.newdawn.slick.Color;

import java.util.ArrayList;
import java.util.List;

public abstract class ScreenBase implements IScreen
{
	@Override
	public void addComponent(IRenderable object)
	{
		renderObjects.add(object);
	}

	@Override
	public List<IRenderable> getComponents()
	{
		return renderObjects;
	}

	@Override
	public Color getBackColor()
	{
		// Override if we want a back color.
		return null;
	}

	@Override
	public RenderImage getBackImage()
	{
		return null;
	}

	@Override
	public boolean tileBackground()
	{
		return true;
	}

	private List<IRenderable> renderObjects = new ArrayList<IRenderable>(0);
}
