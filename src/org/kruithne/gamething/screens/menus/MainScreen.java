package org.kruithne.gamething.screens.menus;

import org.kruithne.gamething.GameController;
import org.kruithne.gamething.GameThing;
import org.kruithne.gamething.rendering.RenderPosition;
import org.kruithne.gamething.screens.ScreenBase;
import org.kruithne.gamething.rendering.RenderImage;
import org.kruithne.gamething.screens.levels.LevelScreen;
import org.kruithne.gamething.ui.RenderSimpleButton;
import org.newdawn.slick.GameContainer;

public class MainScreen extends ScreenBase
{
	public MainScreen()
	{
		background = new RenderImage("brick.png");

		logo = new RenderImage("logo.png", 0, 35);
		logoFlash = new RenderImage("logo_flash.png", 0, 35);

		playButtonImage = new RenderImage("play_button.png", 0, 300);
		playButton = new RenderSimpleButton(playButtonImage, new RenderImage("play_button_flash.png"));

		playButton.addClickHandler(new Runnable() {
			@Override
			public void run() {
				GameController.setGameScreen(new LevelScreen());
			}
		});

		logo.setRenderPositionX(RenderPosition.SCREEN_CENTRE);
		logoFlash.setRenderPositionX(RenderPosition.SCREEN_CENTRE);
		playButtonImage.setRenderPositionX(RenderPosition.SCREEN_CENTRE);

		RenderImage brazier1 = new RenderImage("brazier.png", 0, 0);
		RenderImage brazier2 = new RenderImage("brazier.png", 0, 0);

		brazier1.setDrawY(GameThing.windowHeight - brazier1.getHeight());
		brazier2.setDrawY(GameThing.windowHeight - brazier2.getHeight());
		brazier1.setDrawX(50);
		brazier2.setDrawX(GameThing.windowWidth - brazier2.getWidth() - 50);

		addComponent(brazier1);
		addComponent(brazier2);

		addComponent(logo);
		addComponent(logoFlash);
		addComponent(playButton);
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
	}

	@Override
	public RenderImage getBackImage()
	{
		return background;
	}

	private RenderImage logo;
	private RenderImage logoFlash;
	private RenderImage background;
	private float logoFlashAlpha = 0F;
	private boolean logoIsUpdating = true;
	private RenderSimpleButton playButton;
	private RenderImage playButtonImage;
}
