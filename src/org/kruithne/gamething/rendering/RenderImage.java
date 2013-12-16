package org.kruithne.gamething.rendering;

import org.kruithne.gamething.GameThing;
import org.kruithne.gamething.helpers.ImageLoader;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class RenderImage extends RenderPositionalObject implements IRenderable
{
	public RenderImage(String imageString)
	{
		this(imageString, 0, 0);
	}

	public RenderImage(String imageString, int x, int y)
	{
		super(x, y);
		setTexture(imageString);
	}

	public void setTexture(String imageString)
	{
		this.image = ImageLoader.getImage(imageString);
	}

	public void setAlpha(float alpha)
	{
		image.setAlpha(alpha);
	}

	public float getAlpha()
	{
		return image.getAlpha();
	}

	public void setRenderPositionX(RenderPosition posX)
	{
		if (posX == RenderPosition.SCREEN_CENTRE)
			setDrawX((GameThing.windowWidth / 2) - (image.getWidth() / 2));
	}

	public void setRenderPositionY(RenderPosition posY)
	{
		if (posY == RenderPosition.SCREEN_CENTRE)
			setDrawY((GameThing.windowHeight / 2) - (image.getHeight() / 2));
	}

	public int getWidth()
	{
		return image.getWidth();
	}

	public int getHeight()
	{
		return image.getHeight();
	}

	@Override
	public void render(Graphics renderer)
	{
		renderer.drawImage(image, drawX, drawY);
	}

	protected Image image;
}
