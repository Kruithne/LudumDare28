package org.kruithne.gamething;

import org.kruithne.gamething.events.interfaces.IRenderEvent;
import org.kruithne.gamething.events.interfaces.IUpdateEvent;
import org.kruithne.gamething.rendering.IRenderObject;
import org.kruithne.gamething.screens.IScreen;
import org.kruithne.gamething.screens.menus.MainScreen;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class RenderEngine implements IRenderEvent, IUpdateEvent
{
	public RenderEngine()
	{
		currentScreen = new MainScreen();
	}

	@Override
	public void onRender(GameContainer window, Graphics renderer)
	{
		for (IRenderObject object : currentScreen.getComponents())
		{
			switch (object.getRenderType())
			{
				case IMAGE:
					renderer.drawImage((Image) object.getRenderObject(), object.getDrawX(), object.getDrawY());
				break;

				case TEXT:
					renderer.drawString(object.getRenderObject().toString(), object.getDrawX(), object.getDrawY());
				break;
			}
		}
	}

	@Override
	public void onUpdate(GameContainer window)
	{
		currentScreen.update(window);
	}

	protected IScreen currentScreen;
}
