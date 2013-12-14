package org.kruithne.gamething.screens;

import org.kruithne.gamething.rendering.IRenderObject;

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

	private List<IRenderObject> renderObjects = new ArrayList<IRenderObject>(0);
}
