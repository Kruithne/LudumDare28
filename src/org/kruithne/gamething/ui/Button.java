package org.kruithne.gamething.ui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class Button implements IButton
{
	public Button(Image image, int x, int y)
	{
		this.image = image;
		this.drawX = x;
		this.drawY = y;
	}

	@Override
	public void draw(GameContainer window, Graphics renderer)
	{
		renderer.drawImage(image, drawX, drawY);
	}

	@Override
	public void update(GameContainer window)
	{
		// Override if needed.
	}

	@Override
	public void setX(int x)
	{
		drawX = x;
	}

	@Override
	public void setY(int y)
	{
		drawY = y;
	}

	protected final Image image;
	protected int drawX;
	protected int drawY;
}
