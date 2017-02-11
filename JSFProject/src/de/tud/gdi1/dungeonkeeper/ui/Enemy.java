package de.tud.gdi1.dungeonkeeper.ui;

import java.util.ArrayList;

import de.tud.gdi1.dungeonkeeper.model.TrapEffect;

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
			switch (damageOverTime.get(i).getType()) 
			{
			case GAS_EFFECT:
				decreaseLife(life/10);
				break;
			case FIRE_EFFECT:
				decreaseLife(maxLife/20);
				break;
			case SPIKE_EFFECT:
				decreaseLife(5);
				break;
			default:
				break;
			}
			damageOverTime.get(i).decreaseTicks();
			if (damageOverTime.get(i).getRemainingTicks() == 0)
			{
				damageOverTime.remove(i);
				i--;
			}
			
		}
	}
	
	public void updateEffects(ArrayList<TrapEffect> newEffects)
	{
		for (int i = 0; i < newEffects.size(); i++)
		{
			int effectIndex = damageOverTime.indexOf(newEffects.get(i));
			if (effectIndex != -1)
				damageOverTime.get(effectIndex).increaseTicks();
			else
			{
				int ticks = 1;//If the trap has no Damage Over Time effect it will only be applied once
				switch (newEffects.get(i).getType()) 
				{
				case GAS_EFFECT:
				case FIRE_EFFECT:
					ticks = 5;
					break;
				default:
					break;
				}
				damageOverTime.add(new TrapEffect(newEffects.get(i).getType(), ticks, newEffects.get(i).getTrapID()));
			}
			
		}
	}
}
