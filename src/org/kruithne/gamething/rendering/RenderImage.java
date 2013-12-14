package org.kruithne.gamething.rendering;

import org.kruithne.gamething.helpers.ImageLoader;
import org.kruithne.gamething.rendering.RenderObject;
import org.kruithne.gamething.rendering.RenderPosition;
import org.kruithne.gamething.rendering.RenderType;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

public class RenderImage extends RenderObject
{
	public RenderImage(String imageString)
	{
		this(imageString, 0, 0);
	}

	public RenderImage(String imageString, int x, int y)
	{
		super(x, y);
		this.image = ImageLoader.getImage(imageString);
	}

	public void setAlpha(float alpha)
	{
		image.setAlpha(alpha);
	}

	public void setRenderPositionX(RenderPosition posX, GameContainer window)
	{
		if (posX == RenderPosition.SCREEN_CENTRE)
			setDrawX((window.getWidth() / 2) - (image.getWidth() / 2));
	}

	public void setRenderPositionY(RenderPosition posY, GameContainer window)
	{
		if (posY == RenderPosition.SCREEN_CENTRE)
			setDrawY((window.getHeight() / 2) - (image.getHeight() / 2));
	}

	@Override
	public int getWidth()
	{
		return image.getWidth();
	}

	@Override
	public int getHeight()
	{
		return image.getHeight();
	}

	@Override
	public RenderType getRenderType()
	{
		return RenderType.IMAGE;
	}

	@Override
	public Object getRenderObject()
	{
		return image;
	}

	protected Image image;
}
