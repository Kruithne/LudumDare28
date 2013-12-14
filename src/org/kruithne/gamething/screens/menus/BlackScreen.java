package org.kruithne.gamething.screens.menus;

import org.kruithne.gamething.rendering.RenderImage;
import org.kruithne.gamething.screens.IScreenOverlay;
import org.kruithne.gamething.screens.ScreenBase;
import org.newdawn.slick.GameContainer;

public class BlackScreen extends ScreenBase implements IScreenOverlay
{
	public BlackScreen()
	{
		tile = new RenderImage("black_tile.png");
	}

	@Override
	public void update(GameContainer window)
	{
		if (isAnimating())
		{
			float currentAlpha = tile.getAlpha();

			if (fadingIn)
			{
				if (currentAlpha < 1F)
					tile.setAlpha(currentAlpha += 0.005F);
				else
					animating = false;
			}
			else
			{
				if (currentAlpha > 0F)
					tile.setAlpha(currentAlpha -= 0.005F);
				else
					animating = false;
			}
		}
	}

	@Override
	public RenderImage getBackImage()
	{
		return tile;
	}

	@Override
	public void fadeIn()
	{
		fadingIn = true;
		animating = true;
	}

	@Override
	public void fadeOut()
	{
		fadingIn = false;
		animating = true;
	}

	@Override
	public boolean isAnimating()
	{
		return animating;
	}

	protected boolean animating = false;
	protected boolean fadingIn = false;
	protected RenderImage tile;
}
