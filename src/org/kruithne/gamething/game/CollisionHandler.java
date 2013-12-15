package org.kruithne.gamething.game;

import org.kruithne.gamething.maps.ITileObject;
import org.kruithne.gamething.rendering.RenderPositionalObject;

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
		//float bX = aX + 63;
		//float bY = aY + 63;

		bounds.add(new CollisionBound(aX, aY, aX + 63, aY + 63));

		float diffX = origX - projectedX;
		float diffY = origY - projectedY;

		for (RenderPositionalObject object : moveObjects)
		{
			float sX = object.getDrawX() + diffX;
			float sY = object.getDrawY() + diffY;
			CollisionBound bound = new CollisionBound(sX, sY, sX + 64, sY + 64);
			bound.setObject(object);

			bounds.add(bound);
		}

		for (ITileObject object : map)
		{
			if (object.getTileType().isCollidable())
			{
				float tileStartX = (object.getTileX() * 64) + projectedX;
				float tileStartY = (object.getTileY() * 64) + projectedY;

				float tileEndX = tileStartX + 64;
				float tileEndY = tileStartY + 64;

				for (CollisionBound bound : bounds)
				{
					CollisionBound check = new CollisionBound(tileStartX, tileStartY, tileEndX, tileEndY);
					if (intersects(check, bound))
						return false;
				}
			}
		}

		for (CollisionBound bound : bounds)
			bound.updateObject();

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

	public void addEffectedByCollisionObject(RenderPositionalObject object)
	{
		moveObjects.add(object);
	}

	protected List<ITileObject> map;
	protected List<RenderPositionalObject> moveObjects = new ArrayList<RenderPositionalObject>(0);
}
