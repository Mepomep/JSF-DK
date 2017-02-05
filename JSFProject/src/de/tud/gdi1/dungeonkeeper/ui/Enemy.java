package de.tud.gdi1.dungeonkeeper.ui;

import java.util.ArrayList;

public class Enemy {
	
	private int life, 
				maxLife;
	
	private ArrayList<TrapEffect> damageOverTime;
	
	public Enemy(int life)
	{
		this.maxLife = life;
		this.life = maxLife;
		damageOverTime = new ArrayList<TrapEffect>();
	}
	
	public int getMaxLife()
	{
		return this.maxLife;
	}
	
	public void setMaxLife(int newMaxLife)
	{
		this.maxLife = newMaxLife;
	}
	
	public int getLife()
	{
		return this.life;
	}
	
	public void setLife(int newLife)
	{
		life = newLife;
	}
	
	public void decreaseLife(int value)
	{
		life -= value;
	}
	
	public boolean isAlive()
	{
		return life > 0;
	}
	
	public void processDamageOverTime()//Is called every second
	{
		for (int i = 0; i < damageOverTime.size(); i++)
		{
			switch (damageOverTime.get(i)) 
			{
			case GAS_EFFECT:
			case FIRE_EFFECT:
				decreaseLife(maxLife/10);
				break;

			default:
				break;
			}
			
			
		}
	}
}
