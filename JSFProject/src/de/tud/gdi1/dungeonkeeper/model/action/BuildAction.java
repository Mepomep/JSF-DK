package de.tud.gdi1.dungeonkeeper.model.action;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import de.tud.gdi1.dungeonkeeper.model.entity.TileEntity;
import de.tud.gdi1.dungeonkeeper.model.room.Room;
import de.tud.gdi1.dungeonkeeper.model.room.RoomType;
import de.tud.gdi1.dungeonkeeper.model.trap.TrapFire;
import de.tud.gdi1.dungeonkeeper.model.trap.TrapGas;
import de.tud.gdi1.dungeonkeeper.model.trap.TrapSpike;
import eea.engine.action.Action;
import eea.engine.component.Component;
import eea.engine.entity.Entity;
import eea.engine.entity.StateBasedEntityManager;

public class BuildAction implements Action
{
	boolean		debug;
	int			type;
	TileEntity	tile;
				
	public BuildAction(int type, TileEntity tile, boolean debug)
	{
		this.debug = debug;
		this.type = type;
		this.tile = tile;
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta,
			Component event)
	{
		switch (type)
		{
			case (0):
				tile.setTrap(new TrapSpike());
				cleanUp();
				break;
				
			case (1):
				tile.setTrap(new TrapGas());
				cleanUp();
				break;
			case (2):
				tile.setTrap(new TrapFire());
				cleanUp();
				break;
			case (3):
				//tile.setRoom(new Room("PLACEHOLDER", RoomType.LIBRARY));
				cleanUp();
				break;
			case (4):
				//tile.setRoom(new Room("PLACEHOLDER", RoomType.PRISON));
				cleanUp();
				break;
			case (5):
				//tile.setRoom(new Room("PLACEHOLDER", RoomType.TREASURE));
				cleanUp();
				break;
			case (6):
				cleanUp();
				break;
			default:
				cleanUp();
				break;
		}
	}
	
	private void cleanUp()
	{
		for (int i = 0; i < 9; i++)
		{
			Entity entity = StateBasedEntityManager.getInstance().getEntity(1,
					"button" + i);
			StateBasedEntityManager.getInstance().removeEntity(1, entity);
		}
		TileEntity.IS_SELECTED = false;
	}
}
