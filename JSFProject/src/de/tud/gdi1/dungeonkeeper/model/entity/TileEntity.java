package de.tud.gdi1.dungeonkeeper.model.entity;

import java.util.ArrayList;

import de.tud.gdi1.dungeonkeeper.model.TrapEffect;
import de.tud.gdi1.dungeonkeeper.model.interfaces.IBuildable;
import de.tud.gdi1.dungeonkeeper.model.interfaces.IHighlightable;
import de.tud.gdi1.dungeonkeeper.model.interfaces.IMinable;
import de.tud.gdi1.dungeonkeeper.ui.Room;
import de.tud.gdi1.dungeonkeeper.ui.Trap;
import eea.engine.entity.Entity;

public class TileEntity extends Entity implements IHighlightable, IMinable, IBuildable {
	
	private boolean mined = false;
	private boolean highlighted = false;
	
	private Trap trap = null;
	private Room room = null;

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
		return mined;
	}
	

	@Override
	public boolean isBuilt() {
		return room != null || trap != null || !mined;
	}
	
	public void setHighlighted(boolean highlighted){
		this.highlighted = highlighted;
	}
	
	public void setMined(boolean isMined){
		mined = isMined;
	}
	
	/**
	 * @param newTrap
	 * @return true if the new trap could be set, ideally money will only be removed from the account if the trap could be build
	 */
	public boolean setTrap(Trap newTrap)
	{
		if (this.room != null)//You can't place a trap in a room or rooms over traps
			return false;
		trap = newTrap;
		return true;
	}
	
	public Trap getTrap()
	{
		return trap;
	}
	
	public boolean setRoom(Room newRoom)
	{
		if (this.trap != null)
			return false;
		room = newRoom;
		return true;
	}
	
	public Room getRoom()
	{
		return room;
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
