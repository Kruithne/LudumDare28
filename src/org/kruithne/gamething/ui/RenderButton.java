package org.kruithne.gamething.ui;

import org.kruithne.gamething.rendering.IReceiveMouseMoveEvent;
import org.kruithne.gamething.rendering.IRenderable;
import org.kruithne.gamething.rendering.RenderImage;
import org.kruithne.gamething.ui.interfaces.IButtonUI;
import org.newdawn.slick.Graphics;

public abstract class RenderButton implements IRenderable, IReceiveMouseMoveEvent, IButtonUI
{
	public RenderButton(RenderImage image)
	{
		buttonImage = image;
	}

	@Override
	public void onMouseMove(int sourceX, int sourceY, int x, int y)
	{
		int drawX = buttonImage.getDrawX();
		int drawY = buttonImage.getDrawY();

		if ((x > drawX && x < (drawX + buttonImage.getWidth())) && (y > drawY && y < (drawY + buttonImage.getHeight())))
		{
			handleMouseOver();
			if (!mouseIsOver)
			{
				mouseIsOver = true;
				handleMouseEnter();
			}
		}
		else
		{
			if (mouseIsOver)
			{
				mouseIsOver = false;
				handleMouseLeave();
			}
		}
	}

	@Override
	public void handleMouseEnter()
	{
		// Override if needed!
	}

	@Override
	public void handleMouseLeave()
	{
		// Override if needed!
	}

	@Override
	public void handleMouseOver()
	{
		// Override if needed!
	}

	@Override
	public void render(Graphics renderer)
	{
		buttonImage.render(renderer);
	}

	protected boolean mouseIsOver = false;
	protected RenderImage buttonImage;
}
