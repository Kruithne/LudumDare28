package org.kruithne.gamething.screens;

import org.kruithne.gamething.rendering.IRenderObject;
import org.kruithne.gamething.rendering.RenderImage;
import org.newdawn.slick.Color;

import java.util.ArrayList;
import java.util.List;

public abstract class ScreenBase implements IScreen
{
	@Override
	public void addComponent(IRenderObject object)
	{
		renderObjects.add(object);
	}

	@Override
	public List<IRenderObject> getComponents()
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

	private List<IRenderObject> renderObjects = new ArrayList<IRenderObject>(0);
}
