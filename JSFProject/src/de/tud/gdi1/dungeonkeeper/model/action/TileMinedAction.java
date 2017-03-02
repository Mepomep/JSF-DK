package de.tud.gdi1.dungeonkeeper.model.action;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import de.tud.gdi1.dungeonkeeper.model.entity.TileEntity;
import eea.engine.action.Action;
import eea.engine.component.Component;

public class TileMinedAction implements Action{

	boolean debug;

	public TileMinedAction(boolean debug){
		this.debug = debug;
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta, Component event) {
		TileEntity entity = (TileEntity) event.getOwnerEntity();
		if(!entity.isMined()){
			entity.setMined(true);		

		}
	}
}
