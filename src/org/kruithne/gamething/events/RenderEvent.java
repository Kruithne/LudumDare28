package org.kruithne.gamething.events;

import org.kruithne.gamething.events.interfaces.IEvent;
import org.kruithne.gamething.events.interfaces.IRenderEvent;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class RenderEvent extends Event
{
	public RenderEvent(GameContainer window, Graphics renderer)
	{
		this.window = window;
		this.renderer = renderer;
	}

	@Override
	public Class<? extends IEvent> getInterface()
	{
		return IRenderEvent.class;
	}

	@Override
	public void triggerEvent(IEvent listener)
	{
		((IRenderEvent) listener).onRender(window, renderer);
	}

	private GameContainer window;
	private Graphics renderer;
}
