package org.kruithne.gamething.game;

public class Movement
{
	public boolean isMovingForward()
	{
		return movingForward;
	}

	public boolean isMovingBackward()
	{
		return movingBackward;
	}

	public boolean isMovingRight()
	{
		return movingRight;
	}

	public boolean isMovingLeft()
	{
		return movingLeft;
	}

	public void setMovingForward(boolean moving)
	{
		movingForward = moving;

		if (moving && isMovingBackward())
			setMovingBackward(false);
	}

	public void setMovingBackward(boolean moving)
	{
		movingBackward = moving;

		if (moving && isMovingForward())
			setMovingForward(false);
	}

	public void setMovingRight(boolean moving)
	{
		movingRight = moving;

		if (moving && isMovingLeft())
			setMovingLeft(false);
	}

	public void setMovingLeft(boolean moving)
	{
		movingLeft = moving;

		if (moving && isMovingRight())
			setMovingRight(false);
	}

	public float getMovementSpeed()
	{
		return movementSpeed;
	}

	public void setMovementSpeed(float speed)
	{
		movementSpeed = speed;
	}

	protected float movementSpeed = 0.3f;
	protected boolean movingForward;
	protected boolean movingBackward;
	protected boolean movingRight;
	protected boolean movingLeft;
}
