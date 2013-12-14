package org.kruithne.gamething.rendering;

import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;

public class RenderContainer implements IRenderable
{
	public List<IRenderable> getContents()
	{
		return objects;
	}

	public void addObject(IRenderable object)
	{
		objects.add(object);
	}

	@Override
	public void render(Graphics renderer)
	{
		for (IRenderable object : objects)
			object.render(renderer);
	}

	private List<IRenderable> objects = new ArrayList<IRenderable>(0);
}
