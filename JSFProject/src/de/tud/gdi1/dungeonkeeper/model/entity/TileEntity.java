package de.tud.gdi1.dungeonkeeper.model.entity;

import de.tud.gdi1.dungeonkeeper.model.interfaces.IHighlightable;
import eea.engine.entity.Entity;

public class TileEntity extends Entity implements IHighlightable {
	
	private boolean mined = false;
	private boolean highlighted = false;


	public TileEntity() {
		super("Tile");
	}

	@Override
	public boolean isHighlightable() {
		return !(mined || highlighted);
	}
	
	@Override
	public boolean isHighlighted(){
		return highlighted && !mined;
	}
	
	public void setHighlighted(boolean highlighted){
		this.highlighted = highlighted;
	}
}
