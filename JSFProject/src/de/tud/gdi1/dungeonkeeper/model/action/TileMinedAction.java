package de.tud.gdi1.dungeonkeeper.model.action;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import de.tud.gdi1.dungeonkeeper.model.TrapEffect;
import de.tud.gdi1.dungeonkeeper.model.entity.TileEntity;
import de.tud.gdi1.dungeonkeeper.ui.TrapType;
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
		else 
		{
			//Give some way to build trap or room
			
		}
	}
}
