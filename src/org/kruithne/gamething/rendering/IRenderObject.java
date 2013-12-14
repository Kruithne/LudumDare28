package org.kruithne.gamething.rendering;

public interface IRenderObject
{
	int getDrawX();
	int getDrawY();
	void setDrawX(int x);
	void setDrawY(int y);
	RenderType getRenderType();
	Object getRenderObject();
}
