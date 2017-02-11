package de.tud.gdi1.dungeonkeeper.model;

import de.tud.gdi1.dungeonkeeper.ui.TrapType;

public class TrapEffect {
	

	private TrapType type;
	private int ticksRemaining,
				trapID;
	
	
	public TrapEffect (TrapType type, int ticks, int trapID)
	{
		this.type = type;
		this.ticksRemaining = ticks;
		this.trapID = trapID;
	}
	
	public int getTrapID()
	{
		return this.trapID;
	}
	
	public int getRemainingTicks()
	{
		return this.ticksRemaining;
	}
	
	public void setRemainingTicks(int newTicks)
	{
		this.ticksRemaining = newTicks;
	}
	
	public void decreaseTicks()
	{
		this.ticksRemaining--;
	}
	
	public void increaseTicks()
	{
		this.ticksRemaining++;
	}
	
	public TrapType getType()
	{
		return this.type;
	}
	
	public boolean equals(Object o)
	{
		if (!o.getClass().equals(this.getClass()))
			return false;
		return ((TrapEffect) o).trapID == this.trapID;
	}

}
