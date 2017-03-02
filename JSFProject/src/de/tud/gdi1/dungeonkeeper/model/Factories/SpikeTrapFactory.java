package de.tud.gdi1.dungeonkeeper.model.Factories;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import de.tud.gdi1.dungeonkeeper.model.action.TileBuiltAction;
import de.tud.gdi1.dungeonkeeper.model.action.TileHighlightedAction;
import de.tud.gdi1.dungeonkeeper.model.action.TileMinedAction;
import de.tud.gdi1.dungeonkeeper.model.entity.SpikeTrapEntity;
import de.tud.gdi1.dungeonkeeper.model.entity.TileEntity;
import de.tud.gdi1.dungeonkeeper.model.event.IsBuiltEvent;
import de.tud.gdi1.dungeonkeeper.model.event.IsHighlightableEvent;
import de.tud.gdi1.dungeonkeeper.model.event.IsHighlightedEvent;
import de.tud.gdi1.dungeonkeeper.model.event.IsMinedEvent;
import de.tud.gdi1.dungeonkeeper.model.event.MouseLeftEvent;
import eea.engine.component.RenderComponent;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import eea.engine.event.ANDEvent;
import eea.engine.event.Event;
import eea.engine.event.basicevents.MouseClickedEvent;
import eea.engine.event.basicevents.MouseEnteredEvent;
import eea.engine.interfaces.IEntityFactory;

public class SpikeTrapFactory implements IEntityFactory {
	
	
	boolean debug;
	Entity tile;
	int id;
	public SpikeTrapFactory(Entity e, int id, boolean debug){
		tile = e;
		this.id = id;
		this.debug = debug;
	}
	
	
	@Override
	public Entity createEntity() {
		Entity trap = new SpikeTrapEntity(String.valueOf(id));
		trap.setPosition(tile.getPosition());
		
		if(!debug){
			try {				
				RenderComponent image;
				image = new ImageRenderComponent(new Image("Assets/entry.png"));
				trap.addComponent(image);
			}catch (SlickException e) {
				e.printStackTrace();
			}
		} else trap.setSize(new Vector2f(10,10));
		
		Event event = new ANDEvent(new MouseEnteredEvent(), new IsHighlightableEvent());
		event.addAction(new TileHighlightedAction(debug));
		trap.addComponent(event);
		
		return trap;
	}

}
