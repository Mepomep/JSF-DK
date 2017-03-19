package de.tud.gdi1.dungeonkeeper.model.event;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import de.tud.gdi1.dungeonkeeper.model.entity.TileEntity;
import de.tud.gdi1.dungeonkeeper.model.interfaces.IBuildable;
import de.tud.gdi1.dungeonkeeper.model.interfaces.IMinable;
import eea.engine.entity.Entity;
import eea.engine.event.Event;

public class IsBuiltEvent extends Event
{
	
	public static int trapCounter = 0;
	
	public IsBuiltEvent()
	{
		super("IsBuiltEvent");
	}
	
	@Override
	protected boolean performAction(GameContainer gc, StateBasedGame sb,
			int delta)
	{
		Entity entity = getOwnerEntity();
		if ((IBuildable.class.isInstance(entity)
				&& !((IBuildable) entity).isBuilt())
				|| (IMinable.class.isInstance(entity)
						&& !((IMinable) entity).isMined())
						&& !TileEntity.IS_SELECTED)
		{
			trapCounter++;
			return true;
		}
		return false;
	}
}
