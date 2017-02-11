package de.tud.gdi1.dungeonkeeper.model.entity;

import java.util.ArrayList;

import de.tud.gdi1.dungeonkeeper.model.interfaces.IHighlightable;
import de.tud.gdi1.dungeonkeeper.ui.Trap;
import de.tud.gdi1.dungeonkeeper.ui.TrapEffect;
import eea.engine.entity.Entity;

public class TileEntity extends Entity implements IHighlightable {
	
	private boolean mined = false;
	private boolean highlighted = false;
	
	private Trap trap = null;

	private ArrayList<TrapEffect> activeEffects = new ArrayList<TrapEffect>();//Whenever someone steps on the tile look if this list is empty and if not go through it

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
	
	public void setTrap(Trap newTrap)
	{
		trap = newTrap;
	}
	
	public Trap getTrap()
	{
		return trap;
	}
	
	public ArrayList<TrapEffect> getActiveEffectsOnTile()
	{
		return this.activeEffects;
	}
}
