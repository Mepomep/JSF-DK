package de.tud.gdi1.dungeonkeeper.model.action;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import de.tud.gdi1.dungeonkeeper.model.Factories.SpikeTrapFactory;
import de.tud.gdi1.dungeonkeeper.model.entity.TileEntity;
import eea.engine.action.Action;
import eea.engine.component.Component;
import eea.engine.entity.Entity;

public class TileBuiltAction implements Action {

	boolean debug;

	public TileBuiltAction(boolean debug){
		this.debug = debug;
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta, Component event) {
		TileEntity entity = (TileEntity) event.getOwnerEntity();
		
		Entity newTrap = new SpikeTrapFactory().createEntity();
	}
}
