package org.kruithne.gamething.screens.menus;

import org.kruithne.gamething.rendering.RenderPosition;
import org.kruithne.gamething.screens.ScreenBase;
import org.kruithne.gamething.rendering.RenderImage;
import org.newdawn.slick.GameContainer;

public class MainScreen extends ScreenBase
{
	public MainScreen()
	{
		/*playButtonImage = ImageLoader.getImage("play_button.png");
		playButton = new FadeButton(
				playButtonImage,
				ImageLoader.getImage("play_button_flash.png"),
				0, 300
		);*/

		background = new RenderImage("brick.png");

		logo = new RenderImage("logo.png", 0, 35);
		logoFlash = new RenderImage("logo_flash.png", 0, 35);

		addComponent(logo);
		addComponent(logoFlash);
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

			logoFlash.setAlpha(logoFlashAlpha);
		}

		logo.setRenderPositionX(RenderPosition.SCREEN_CENTRE, window);
		logoFlash.setRenderPositionX(RenderPosition.SCREEN_CENTRE, window);
	}

	@Override
	public RenderImage getBackImage()
	{
		return background;
	}

	/*@Override
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
	}*/

	private RenderImage logo;
	private RenderImage logoFlash;
	private RenderImage background;
	private float logoFlashAlpha = 0F;
	private boolean logoIsUpdating = true;
	/*private FadeButton playButton;
	private Image playButtonImage;
	private Image playButton;*/
}
