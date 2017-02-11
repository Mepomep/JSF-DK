package de.tud.gdi1.dungeonkeeper.model.action;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import de.tud.gdi1.dungeonkeeper.model.entity.TileEntity;
import eea.engine.action.Action;
import eea.engine.component.Component;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.StateBasedEntityManager;

public class TileHighlightedAction implements Action {
	
	boolean debug;
	public TileHighlightedAction(boolean debug){
		this.debug = debug;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta, Component event) {
		TileEntity entity = (TileEntity) event.getOwnerEntity();
		if(!debug){
			if(entity.isHighlighted()&&entity.isMined()){
				entity.setHighlighted(false);
				try {
					entity.addComponent(new ImageRenderComponent(new Image("assets/earth_unhighlighted.png")));
				} catch (SlickException e) {
					e.printStackTrace();
				}
			}
			else if(entity.isHighlighted()&&!entity.isMined()){
				entity.setHighlighted(false);
				try {
					entity.addComponent(new ImageRenderComponent(new Image("assets/earth_mined_unhighlighted.png")));
				} catch (SlickException e) {
					e.printStackTrace();
				}
			}
			else if(!entity.isHighlighted()&&!entity.isMined()){
				entity.setHighlighted(true);
				try {
					entity.addComponent(new ImageRenderComponent(new Image("assets/earth_mined_highlighted.png")));
				} catch (SlickException e) {
					e.printStackTrace();
				}
			}
			else{
				entity.setHighlighted(true);
				try {
					entity.addComponent(new ImageRenderComponent(new Image("assets/earth_highlighted.png")));
				} catch (SlickException e) {
					e.printStackTrace();
				}
			}	
		}
	}
}
