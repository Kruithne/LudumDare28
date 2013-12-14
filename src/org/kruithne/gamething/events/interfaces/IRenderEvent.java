package org.kruithne.gamething.events.interfaces;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface IRenderEvent extends IEvent
{
	void onRender(GameContainer window, Graphics renderer);
}
