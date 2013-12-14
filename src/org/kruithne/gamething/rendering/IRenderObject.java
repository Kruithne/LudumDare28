package org.kruithne.gamething.rendering;

public interface IRenderObject
{
	int getDrawX();
	int getDrawY();
	void setDrawX(int x);
	void setDrawY(int y);
	int getWidth();
	int getHeight();
	RenderType getRenderType();
	Object getRenderObject();
}
