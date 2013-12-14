package org.kruithne.gamething;

import org.kruithne.gamething.events.interfaces.IRenderEvent;
import org.kruithne.gamething.events.interfaces.IUpdateEvent;
import org.kruithne.gamething.rendering.IRenderObject;
import org.kruithne.gamething.screens.IScreen;
import org.kruithne.gamething.screens.menus.MainScreen;
import org.kruithne.gamething.rendering.RenderImage;
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
		if (currentScreen.getBackColor() != null)
			renderer.setBackground(currentScreen.getBackColor());

		RenderImage backImage = currentScreen.getBackImage();
		if (backImage != null)
		{
			if (currentScreen.tileBackground())
			{
				for (int x = 0; x < window.getWidth(); x += backImage.getWidth())
					for (int y = 0; y < window.getHeight(); y += backImage.getHeight())
						renderer.drawImage((Image) backImage.getRenderObject(), x, y);
			}
			else
			{
				renderer.drawImage((Image) backImage.getRenderObject(), backImage.getDrawX(), backImage.getDrawY());
			}
		}

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
