package org.kruithne.gamething.entity;

import org.kruithne.gamething.game.CollisionHandler;
import org.kruithne.gamething.maps.TileType;

import java.util.ArrayList;
import java.util.List;

public class EntityHandler
{
	public EntityHandler(CollisionHandler collision)
	{
		collision.setEntityList(entities);
	}

	public Entity createEntity(TileType type, float x, float y)
	{
		Entity entity = new Entity(type, x, y);
		entities.add(entity);
		return entity;
	}

	public BreakableEntity createBreakableEntity(TileType type, float x, float y)
	{
		BreakableEntity entity = new BreakableEntity(type, x, y);
		entities.add(entity);
		return entity;
	}

	public void processUpdate(float offsetX, float offsetY)
	{
		for (Entity entity : entities)
			entity.update(offsetX, offsetY);
	}

	private List<Entity> entities = new ArrayList<Entity>(0);
}
