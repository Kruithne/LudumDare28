package org.kruithne.gamething;

import org.kruithne.gamething.events.interfaces.IMouseMoveEvent;
import org.kruithne.gamething.events.interfaces.IRenderEvent;
import org.kruithne.gamething.events.interfaces.IUpdateEvent;
import org.kruithne.gamething.rendering.IReceiveMouseMoveEvent;
import org.kruithne.gamething.rendering.IRenderable;
import org.kruithne.gamething.screens.IScreen;
import org.kruithne.gamething.screens.menus.MainScreen;
import org.kruithne.gamething.rendering.RenderImage;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class RenderEngine implements IRenderEvent, IUpdateEvent, IMouseMoveEvent
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
						backImage.setDrawX(x).setDrawY(y).render(renderer);
			}
			else
			{
				backImage.render(renderer);
			}
		}

		for (IRenderable renderable : currentScreen.getComponents())
			renderable.render(renderer);
	}

	@Override
	public void onUpdate(GameContainer window)
	{
		currentScreen.update(window);
	}

	@Override
	public void onMouseMove(int sourceX, int sourceY, int x, int y)
	{
		for (IRenderable renderable : currentScreen.getComponents())
			if (renderable instanceof IReceiveMouseMoveEvent)
				((IReceiveMouseMoveEvent) renderable).onMouseMove(sourceX, sourceY, x, y);
	}

	protected IScreen currentScreen;
}
