package de.tud.gdi1.dungeonkeeper.model.event;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import de.tud.gdi1.dungeonkeeper.model.interfaces.IBuildable;
import eea.engine.entity.Entity;
import eea.engine.event.Event;

public class IsBuiltEvent extends Event {

	public IsBuiltEvent() {
		super("IsBuiltEvent");
	}

	@Override
	protected boolean performAction(GameContainer gc, StateBasedGame sb, int delta) {
		Entity entity = getOwnerEntity();
		if(IBuildable.class.isInstance(entity)){
			return !((IBuildable)entity).isBuilt();
		}
		else return false;
	}

}
