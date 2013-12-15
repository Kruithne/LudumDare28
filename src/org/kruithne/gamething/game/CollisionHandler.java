package org.kruithne.gamething.game;

import org.kruithne.gamething.GameController;
import org.kruithne.gamething.entity.Entity;
import org.kruithne.gamething.maps.ITileObject;
import org.kruithne.gamething.maps.TileType;

import java.util.ArrayList;
import java.util.List;

public class CollisionHandler
{
	public void setMap(List<ITileObject> map)
	{
		this.map = map;
	}

	public boolean runCheck(float projectedX, float projectedY, float aX, float aY, float origX, float origY)
	{
		List<CollisionBound> bounds = new ArrayList<CollisionBound>(1);
		aX -= 1;
		aY -= 1;

		CollisionBound playerBound = new CollisionBound(aX, aY, aX + 63, aY + 63);
		bounds.add(playerBound);

		float diffX = origX - projectedX;
		float diffY = origY - projectedY;

		for (Entity entity : entityList)
		{
			if (entity.getType().isCollidable())
			{
				float entityX = (entity.getX() + projectedX) + 1;
				float entityY = (entity.getY() + projectedY) + 1;
				float entityEndX = entityX + 63;
				float entityEndY = entityY + 63;

				CollisionBound check = new CollisionBound(entityX, entityY, entityEndX, entityEndY);
				if (intersects(check, playerBound))
				{
					check.offsetX(diffX);
					check.offsetY(diffY);
					check.setEntity(entity);
					bounds.add(check);
				}
			}
		}

		for (ITileObject object : map)
		{
			TileType type = object.getTileType();

			float tileStartX = (object.getTileX() * 64) + projectedX;
			float tileStartY = (object.getTileY() * 64) + projectedY;

			float tileEndX = tileStartX + 64;
			float tileEndY = tileStartY + 64;

			CollisionBound check = new CollisionBound(tileStartX, tileStartY, tileEndX, tileEndY);

			if (type.isCollidable())
			{
				for (CollisionBound bound : bounds)
					if (intersects(check, bound))
						return false;
			}
			else if (type == TileType.END_HOLE)
			{
				for (CollisionBound bound : bounds)
				{
					if (bound.getEntity() != null && bound.getEntity().getType() == TileType.CRATE)
					{
						if (intersects(check, bound))
							GameController.endGame();
					}
				}
			}
		}

		for (CollisionBound bound : bounds)
			bound.updateEntity();

		return true;
	}

	private boolean intersects(CollisionBound check, CollisionBound bound)
	{
		if (intersects(check.aX, check.aY, check.bX, check.bY, bound.aX, bound.aY))
			return true;

		if (intersects(check.aX, check.aY, check.bX, check.bY, bound.bX, bound.bY))
			return true;

		if (intersects(check.aX, check.aY, check.bX, check.bY, bound.bX, bound.aY))
			return true;

		if (intersects(check.aX, check.aY, check.bX, check.bY, bound.aX, bound.bY))
			return true;

		return false;
	}

	private boolean intersects(float sX, float sY, float eX, float eY, float cX, float cY)
	{
		return ((cX > sX && cX < eX) && (cY > sY && cY < eY));
	}

	public void setEntityList(List<Entity> list)
	{
		entityList = list;
	}

	private List<ITileObject> map;
	private List<Entity> entityList;
}
