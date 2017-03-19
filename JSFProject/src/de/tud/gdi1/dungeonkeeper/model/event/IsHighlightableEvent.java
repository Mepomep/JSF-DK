package de.tud.gdi1.dungeonkeeper.model.event;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import de.tud.gdi1.dungeonkeeper.model.interfaces.IHighlightable;
import eea.engine.entity.Entity;
import eea.engine.event.Event;

public class IsHighlightableEvent extends Event
{
	
	public IsHighlightableEvent()
	{
		super("IsHighlightableEvent");
	}
	
	@Override
	protected boolean performAction(GameContainer gc, StateBasedGame sb,
			int delta)
	{
		Entity entity = getOwnerEntity();
		if (IHighlightable.class.isInstance(entity))
		{
			return !((IHighlightable) entity).isHighlighted();
		} else
			return false;
	}
	
}
