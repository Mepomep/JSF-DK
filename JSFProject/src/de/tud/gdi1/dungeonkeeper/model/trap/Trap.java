package de.tud.gdi1.dungeonkeeper.model.trap;

public abstract class Trap 
{
	protected TrapType trapType = null;
	protected String name = null;
	
	public abstract void trigger();
	
	public Trap(String name, TrapType type)
	{
		this.name = name;
		this.trapType = type;
	}
	
	public TrapType getTrapEffect()
	{
		return this.trapType;
	}
	
	public String getName()
	{
		return this.name;
	}
	
}
