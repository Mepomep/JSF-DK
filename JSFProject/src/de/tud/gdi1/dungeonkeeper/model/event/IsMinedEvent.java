package de.tud.gdi1.dungeonkeeper.model.event;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import de.tud.gdi1.dungeonkeeper.model.interfaces.IMinable;
import eea.engine.entity.Entity;
import eea.engine.event.Event;

public class IsMinedEvent extends Event
{
	
	public IsMinedEvent()
	{
		super("IsMinedEvent");
	}
	
	@Override
	protected boolean performAction(GameContainer gc, StateBasedGame sb,
			int delta)
	{
		Entity entity = getOwnerEntity();
		
		if (IMinable.class.isInstance(entity))
		{
			return !((IMinable) entity).isMined();
		} else
			return false;
	}
	
}
