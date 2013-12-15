package org.kruithne.gamething.screens.menus;

import org.kruithne.gamething.GameController;
import org.kruithne.gamething.input.MouseButton;
import org.kruithne.gamething.rendering.IReceiveMouseClickEvent;
import org.kruithne.gamething.rendering.RenderImage;
import org.kruithne.gamething.rendering.RenderPosition;
import org.kruithne.gamething.screens.ScreenBase;
import org.newdawn.slick.GameContainer;


public class LevelCompleteScreen extends ScreenBase implements IReceiveMouseClickEvent
{
	public LevelCompleteScreen()
	{
		backgroundImage = new RenderImage("brick.png");

		RenderImage text1 = new RenderImage("level_complete.png", 0, 200);
		RenderImage text2 = new RenderImage("no_more.png", 0, 300);

		text1.setRenderPositionX(RenderPosition.SCREEN_CENTRE);
		text2.setRenderPositionX(RenderPosition.SCREEN_CENTRE);

		addComponent(text1);
		addComponent(text2);
	}

	@Override
	public RenderImage getBackImage()
	{
		return backgroundImage;
	}

	@Override
	public void update(GameContainer window)
	{
	}

	@Override
	public void onMouseClick(MouseButton button, int x, int y)
	{
		GameController.setGameScreen(new MainScreen());
	}

	private RenderImage backgroundImage;
}
