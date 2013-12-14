package org.kruithne.gamething.ui;

import org.kruithne.gamething.rendering.RenderContainer;
import org.kruithne.gamething.rendering.RenderImage;
import org.newdawn.slick.Graphics;

public class RenderSimpleButton extends RenderButton
{
	public RenderSimpleButton(RenderImage image, RenderImage hoverImage)
	{
		super(image);
		this.hoverImage = hoverImage;

		buttonParts.addObject(image);
		buttonParts.addObject(hoverImage);
		this.hoverImage.setAlpha(0);
	}

	@Override
	public void handleMouseEnter()
	{
		hoverImage.setAlpha(1);
	}

	@Override
	public void handleMouseLeave()
	{
		hoverImage.setAlpha(0);
	}

	@Override
	public void render(Graphics renderer)
	{
		hoverImage.setDrawX(buttonImage.getDrawX()).setDrawY(buttonImage.getDrawY());
		buttonParts.render(renderer);
	}

	protected RenderImage hoverImage;
	protected RenderContainer buttonParts = new RenderContainer();
}
