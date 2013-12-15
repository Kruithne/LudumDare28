package org.kruithne.gamething.game;

import org.kruithne.gamething.logging.Logger;
import org.kruithne.gamething.maps.ITileObject;

import java.util.List;

public class CollisionHandler
{
	public void setMap(List<ITileObject> map)
	{
		this.map = map;
	}

	public boolean runCheck(float projectedX, float projectedY, float startX, float startY)
	{
		startX = startX - 4;
		startY = startY - 4;
		float endX = startX + 60;
		float endY = startY + 60;

		for (ITileObject object : map)
		{
			if (object.getTileType().isCollidable())
			{
				float tileStartX = (object.getTileX() * 64) + projectedX;
				float tileStartY = (object.getTileY() * 64) + projectedY;

				float tileEndX = tileStartX + 64;
				float tileEndY = tileStartY + 64;

				if (intersects(tileStartX, tileStartY, tileEndX, tileEndY, startX, startY))
					return false;

				if (intersects(tileStartX, tileStartY, tileEndX, tileEndY, endX, endY))
					return false;
			}
		}
		return true;
	}

	private boolean intersects(float sX, float sY, float eX, float eY, float cX, float cY)
	{
		return ((cX > sX && cX < eX) && (cY > sY && cY < eY));
	}

	protected List<ITileObject> map;
}
