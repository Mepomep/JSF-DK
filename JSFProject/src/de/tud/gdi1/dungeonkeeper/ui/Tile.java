package de.tud.gdi1.dungeonkeeper.ui;

import java.util.ArrayList;

public class Tile {

	private boolean mined = false;
	
	private Trap trap = null;
	
	private ArrayList<TrapEffect> activeEffects = new ArrayList<TrapEffect>();//Whenever someone steps on the tile look if this list is empty and if not go through it
	
	public void setTrap(Trap newTrap)
	{
		trap = newTrap;
	}
	
	public Trap getTrap()
	{
		return trap;
	}
	
	public boolean isMined()
	{
		return mined;
	}
	
	public void setMined(boolean newMined)
	{
		mined = newMined;
	}
	
	public ArrayList<TrapEffect> getActiveEffectsOnTile()
	{
		return this.activeEffects;
	}
	
}
