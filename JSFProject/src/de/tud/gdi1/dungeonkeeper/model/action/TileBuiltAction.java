package de.tud.gdi1.dungeonkeeper.model.action;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import de.tud.gdi1.dungeonkeeper.model.Factories.SpikeTrapFactory;
import de.tud.gdi1.dungeonkeeper.model.entity.TileEntity;
import de.tud.gdi1.dungeonkeeper.model.event.IsBuiltEvent;
import eea.engine.action.Action;
import eea.engine.component.Component;
import eea.engine.entity.Entity;
import eea.engine.entity.StateBasedEntityManager;

public class TileBuiltAction implements Action {

	boolean debug;

	public TileBuiltAction(boolean debug){
		this.debug = debug;
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta, Component event) {
		TileEntity entity = (TileEntity) event.getOwnerEntity();
		
		if(entity.isMined()){		
			Entity newTrap = new SpikeTrapFactory(entity, IsBuiltEvent.trapCounter, debug).createEntity();
			StateBasedEntityManager.getInstance().addEntity(1, newTrap);
		}
	}
}
