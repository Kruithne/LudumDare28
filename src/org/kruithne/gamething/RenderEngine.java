package org.kruithne.gamething;

import org.kruithne.gamething.events.interfaces.*;
import org.kruithne.gamething.input.MouseButton;
import org.kruithne.gamething.logging.Logger;
import org.kruithne.gamething.rendering.IReceiveMouseClickEvent;
import org.kruithne.gamething.rendering.IReceiveMouseMoveEvent;
import org.kruithne.gamething.rendering.IRenderable;
import org.kruithne.gamething.screens.IScreen;
import org.kruithne.gamething.screens.IScreenOverlay;
import org.kruithne.gamething.screens.menus.BlackScreen;
import org.kruithne.gamething.rendering.RenderImage;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class RenderEngine implements IRenderEvent, IUpdateEvent, IMouseMoveEvent, IMouseClickEvent
{
	public RenderEngine()
	{
		overlayScreen = new BlackScreen();
	}

	@Override
	public void onRender(GameContainer window, Graphics renderer)
	{
		if (currentScreen != null)
			renderScreen(renderer, currentScreen, window);

		renderScreen(renderer, overlayScreen, window);
	}

	public void setCurrentScreen(IScreen screen)
	{
		if (!isLoading())
		{
			IScreenOverlay overlay = getOverlayScreen();
			pendingScreen = screen;
			overlay.fadeIn();
		}
	}

	public IScreenOverlay getOverlayScreen()
	{
		return (IScreenOverlay) overlayScreen;
	}

	public boolean isLoading()
	{
		return pendingScreen != null;
	}

	protected void renderScreen(Graphics renderer, IScreen screen, GameContainer window)
	{
		if (screen.getBackColor() != null)
			renderer.setBackground(screen.getBackColor());

		RenderImage backImage = screen.getBackImage();
		if (backImage != null)
		{
			if (screen.tileBackground())
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

		for (IRenderable renderable : screen.getComponents())
			renderable.render(renderer);
	}

	@Override
	public void onUpdate(GameContainer window)
	{
		if (currentScreen != null)
			currentScreen.update(window);

		if (overlayScreen != null)
			overlayScreen.update(window);

		if (isLoading())
		{
			IScreenOverlay overlay = getOverlayScreen();
			if (!overlay.isAnimating())
			{
				currentScreen = pendingScreen;
				pendingScreen = null;
				overlay.fadeOut();
			}
		}
	}

	@Override
	public void onMouseMove(int sourceX, int sourceY, int x, int y)
	{
		if (currentScreen == null)
			return;

		for (IRenderable renderable : currentScreen.getComponents())
			if (renderable instanceof IReceiveMouseMoveEvent)
				((IReceiveMouseMoveEvent) renderable).onMouseMove(sourceX, sourceY, x, y);
	}

	@Override
	public void onMouseClick(MouseButton button, int x, int y)
	{
		if (currentScreen == null)
			return;

		for (IRenderable renderable : currentScreen.getComponents())
			if (renderable instanceof IReceiveMouseClickEvent)
				((IReceiveMouseClickEvent) renderable).onMouseClick(button, x, y);
	}

	protected IScreen currentScreen;
	protected IScreen overlayScreen;
	protected IScreen pendingScreen;
}
