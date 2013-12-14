package org.kruithne.gamething.screens.menus;

import org.kruithne.gamething.helpers.ImageLoader;
import org.kruithne.gamething.helpers.RenderHelper;
import org.kruithne.gamething.screens.IMenuScreen;
import org.kruithne.gamething.ui.FadeButton;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class MainScreen implements IMenuScreen
{
	public MainScreen()
	{
		playButtonImage = ImageLoader.getImage("play_button.png");
		playButton = new FadeButton(
				playButtonImage,
				ImageLoader.getImage("play_button_flash.png"),
				0, 300
		);
	}

	@Override
	public void draw(GameContainer window, Graphics renderer)
	{
		renderer.setBackground(new Color(81, 65, 53));

		Image logo = ImageLoader.getImage("logo.png");
		Image logoFlash = ImageLoader.getImage("logo_flash.png");
		logoFlash.setAlpha(logoFlashAlpha);

		int logoX = RenderHelper.getCenterX(window, logo);
		int logoY = 35;

		renderer.drawImage(logo, logoX, logoY);
		renderer.drawImage(logoFlash, logoX, logoY);

		playButton.setX(RenderHelper.getCenterX(window, playButtonImage));
		playButton.draw(window, renderer);
	}

	@Override
	public void update(GameContainer window)
	{
		if (logoIsUpdating)
		{
			if (logoFlashAlpha >= 1F)
				logoIsUpdating = false;
			else
				logoFlashAlpha += 1F / 10000;
		}

		playButton.update(window);
	}

	private float logoFlashAlpha = 0F;
	private boolean logoIsUpdating = true;
	private FadeButton playButton;
	private Image playButtonImage;
}
