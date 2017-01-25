package de.tud.gdi1.dungeonkeeper.ui;

public class Tile {

	private boolean mined = false;
	
	private Trap trap = null;
	
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
	
}
