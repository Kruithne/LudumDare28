package org.kruithne.gamething;

import org.kruithne.gamething.events.interfaces.IMouseClickEvent;
import org.kruithne.gamething.events.interfaces.IMouseMoveEvent;
import org.kruithne.gamething.events.interfaces.IRenderEvent;
import org.kruithne.gamething.events.interfaces.IUpdateEvent;
import org.kruithne.gamething.input.MouseButton;
import org.kruithne.gamething.rendering.IReceiveMouseClickEvent;
import org.kruithne.gamething.rendering.IReceiveMouseMoveEvent;
import org.kruithne.gamething.rendering.IRenderable;
import org.kruithne.gamething.screens.IScreen;
import org.kruithne.gamething.screens.menus.BlackScreen;
import org.kruithne.gamething.screens.menus.MainScreen;
import org.kruithne.gamething.rendering.RenderImage;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class RenderEngine implements IRenderEvent, IUpdateEvent, IMouseMoveEvent, IMouseClickEvent
{
	public RenderEngine()
	{
		currentScreen = new MainScreen();
		overlayScreen = new BlackScreen();
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

		renderScreen(renderer, currentScreen);
		renderScreen(renderer, overlayScreen);
	}

	protected void renderScreen(Graphics renderer, IScreen screen)
	{
		for (IRenderable renderable : screen.getComponents())
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

	@Override
	public void onMouseClick(MouseButton button, int x, int y)
	{
		for (IRenderable renderable : currentScreen.getComponents())
			if (renderable instanceof IReceiveMouseClickEvent)
				((IReceiveMouseClickEvent) renderable).onMouseClick(button, x, y);
	}

	protected IScreen currentScreen;
	protected IScreen overlayScreen;
}
