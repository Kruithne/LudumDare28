package org.kruithne.gamething.screens.levels;

import org.kruithne.gamething.GameThing;
import org.kruithne.gamething.game.CollisionHandler;
import org.kruithne.gamething.game.Movement;
import org.kruithne.gamething.input.KeyBinding;
import org.kruithne.gamething.logging.Logger;
import org.kruithne.gamething.maps.CharacterSpawn;
import org.kruithne.gamething.maps.ITileObject;
import org.kruithne.gamething.maps.MapLoader;
import org.kruithne.gamething.maps.RenderMapTile;
import org.kruithne.gamething.rendering.IReceiveKeyDownEvent;
import org.kruithne.gamething.rendering.IReceiveKeyUpEvent;
import org.kruithne.gamething.rendering.IRenderable;
import org.kruithne.gamething.rendering.RenderImage;
import org.kruithne.gamething.screens.ScreenBase;
import org.newdawn.slick.GameContainer;

import java.util.List;

public class LevelScreen extends ScreenBase implements IReceiveKeyDownEvent, IReceiveKeyUpEvent
{
	public LevelScreen()
	{
		backgroundImage = new RenderImage("dirt.png");
		setupMap("start_map.png");

		charImage = new RenderImage("char.png");
		charImage.setDrawX((GameThing.windowWidth / 2) - (charImage.getWidth() / 2));
		charImage.setDrawY((GameThing.windowHeight / 2) - (charImage.getHeight() / 2));
		addComponent(charImage);
	}

	protected void setupMap(String mapName)
	{
		Logger.log("Loading map: " + mapName);
		map = MapLoader.loadMap(mapName);
		for (ITileObject tile : map)
		{
			if (tile instanceof RenderMapTile)
				addComponent((RenderMapTile) tile);
			else if (tile instanceof CharacterSpawn)
				setSpawn(tile.getTileX(), tile.getTileY());
		}
		collisionHandler.setMap(map);
	}

	protected void setSpawn(int tileX, int tileY)
	{
		offsetX = (GameThing.windowWidth / 2) - (tileX * 64);
		offsetY = (GameThing.windowHeight / 2) - (tileY * 64);
	}

	@Override
	public void update(GameContainer window)
	{
		for (IRenderable object : getComponents())
		{
			if (object instanceof RenderMapTile)
			{
				RenderMapTile tile = (RenderMapTile) object;
				tile.setDrawX((tile.getTileX() * 64) + offsetX);
				tile.setDrawY((tile.getTileY() * 64) + offsetY);
			}
		}

		float charX = charImage.getDrawX();
		float charY = charImage.getDrawY();

		float speed = movement.getMovementSpeed();

		if (movement.isMovingRight())
		{
			float projectedX = offsetX - speed;
			if (collisionHandler.runCheck(projectedX, offsetY, charX, charY))
				offsetX = projectedX;
		}

		if (movement.isMovingLeft())
		{
			float projectedX = offsetX + speed;
			if (collisionHandler.runCheck(projectedX, offsetY, charX, charY))
				offsetX = projectedX;
		}

		if (movement.isMovingBackward())
		{
			float projectedY = offsetY - speed;
			if (collisionHandler.runCheck(offsetX, projectedY, charX, charY))
				offsetY = projectedY;
		}

		if (movement.isMovingForward())
		{
			float projectedY = offsetY + speed;
			if (collisionHandler.runCheck(offsetX, projectedY, charX, charY))
				offsetY = projectedY;
		}
	}

	@Override
	public RenderImage getBackImage()
	{
		return backgroundImage;
	}

	@Override
	public void onKeyDown(int key)
	{
		handleInput(key, true);
	}

	@Override
	public void onKeyUp(int key)
	{
		handleInput(key, false);
	}

	protected void handleInput(int key, boolean down)
	{
		KeyBinding binding = KeyBinding.getBinding(key);

		switch (binding)
		{
			case FORWARD: movement.setMovingForward(down); break;
			case BACKWARD: movement.setMovingBackward(down); break;
			case LEFT: movement.setMovingLeft(down); break;
			case RIGHT: movement.setMovingRight(down); break;
		}
	}

	protected List<ITileObject> map;
	protected Movement movement = new Movement();
	protected CollisionHandler collisionHandler = new CollisionHandler();
	protected RenderImage backgroundImage;
	protected RenderImage charImage;
	protected float offsetX;
	protected float offsetY;
}
