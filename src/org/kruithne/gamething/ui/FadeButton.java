package org.kruithne.gamething.ui;

import org.kruithne.gamething.helpers.InputHelper;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class FadeButton extends Button
{
	public FadeButton(Image image, Image overlay, int x, int y)
	{
		super(image, x, y);
		this.fadeOverlay = overlay;
	}

	@Override
	public void draw(GameContainer window, Graphics renderer)
	{
		super.draw(window, renderer);
		fadeOverlay.setAlpha(currentAlpha);
		renderer.drawImage(fadeOverlay, drawX, drawY);
	}

	@Override
	public void update(GameContainer window)
	{
		int endX = drawX + image.getWidth();
		int endY = drawY + image.getHeight();

		if (InputHelper.mouseWithinBounds(window.getInput(), drawX, drawY, endX, endY))
		{
			if (currentAlpha < 1F)
				currentAlpha += fadeSpeed;
		}
		else
		{
			if (currentAlpha > 0F)
				currentAlpha -= fadeSpeed;
		}
	}

	public void setFadeSpeed(float speed)
	{
		fadeSpeed = speed;
	}

	protected final Image fadeOverlay;
	protected float currentAlpha = 0F;
	protected float fadeSpeed = 0.005F;
}
