package de.tud.gdi1.dungeonkeeper.model.event;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import eea.engine.event.Event;

public class MouseLeftEvent extends Event{

	public MouseLeftEvent() {
		super("MouseLeftEvent");
	}
	@Override
	protected boolean performAction(GameContainer gc, StateBasedGame sb, int delta) {
		
		 Shape shape = getOwnerEntity().getShape();

		    // determine the current mouse (x, y) position
		    Vector2f mousePosition = new Vector2f(gc.getInput().getMouseX(), gc
		        .getInput().getMouseY());

		    // return if the current mouse position and the area covered by the shape
		    // overlap
		    return !(shape.contains(mousePosition.x, mousePosition.y));
	}

}
