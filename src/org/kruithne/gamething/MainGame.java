package org.kruithne.gamething;

import org.kruithne.gamething.events.*;
import org.kruithne.gamething.input.MouseButton;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class MainGame extends BasicGame
{
	public MainGame()
	{
		super("The Depths of Kargron - Ludum Dare #28 Entry by Kruithne");
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy)
	{
		new MouseMoveEvent(oldx, oldy, newx, newy).fireEvent();
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount)
	{
		new MouseClickEvent(MouseButton.getMouseButton(button), x, y).fireEvent();
	}

	@Override
	public void keyPressed(int key, char c)
	{
		new KeyDownEvent(key).fireEvent();
	}

	@Override
	public void keyReleased(int key, char c)
	{
		new KeyUpEvent(key).fireEvent();
	}

	@Override
	public void init(GameContainer gameContainer) throws SlickException
	{
		gameContainer.setShowFPS(false);
		new EngineReadyEvent(gameContainer).fireEvent();
	}

	@Override
	public void update(GameContainer gameContainer, int i) throws SlickException
	{
		new UpdateEvent(gameContainer).fireEvent();
	}

	@Override
	public void render(GameContainer gameContainer, Graphics graphics) throws SlickException
	{
		new RenderEvent(gameContainer, graphics).fireEvent();
	}
}
