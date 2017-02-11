package de.tud.gdi1.dungeonkeeper.model.entity;

import java.util.ArrayList;

import de.tud.gdi1.dungeonkeeper.model.TrapEffect;
import de.tud.gdi1.dungeonkeeper.model.interfaces.IHighlightable;
import de.tud.gdi1.dungeonkeeper.model.interfaces.IMinable;
import de.tud.gdi1.dungeonkeeper.ui.Trap;
import eea.engine.entity.Entity;

public class TileEntity extends Entity implements IHighlightable, IMinable {
	
	private boolean mined = false;
	private boolean highlighted = false;
	
	private Trap trap = null;

	private ArrayList<TrapEffect> activeEffects = new ArrayList<TrapEffect>();//Whenever someone steps on the tile look if this list is empty and if not go through it

	public TileEntity() {
		super("Tile");
	}
	
	@Override
	public boolean isHighlighted(){
		return highlighted;
	}
	
	@Override
	public boolean isMined() {
		return !mined;
	}
	
	public void setHighlighted(boolean highlighted){
		this.highlighted = highlighted;
	}
	
	public void setMined(boolean isMined){
		mined = isMined;
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
	
	public void updateEffects()
	{
		for (int i = 0; i < activeEffects.size(); i++)
		{
			activeEffects.get(i).decreaseTicks();
			if (activeEffects.get(i).getRemainingTicks() == 0)
			{
				activeEffects.remove(i);
				i--;
			}
			
		}
	}
}
