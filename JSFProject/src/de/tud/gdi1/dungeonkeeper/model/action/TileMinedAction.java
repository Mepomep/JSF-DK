package de.tud.gdi1.dungeonkeeper.model.action;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import de.tud.gdi1.dungeonkeeper.model.TrapEffect;
import de.tud.gdi1.dungeonkeeper.model.entity.ContextMenuButton;
import de.tud.gdi1.dungeonkeeper.model.entity.TileEntity;
import de.tud.gdi1.dungeonkeeper.model.factories.ButtonFactory;
import de.tud.gdi1.dungeonkeeper.model.trap.TrapType;
import eea.engine.action.Action;
import eea.engine.component.Component;
import eea.engine.entity.StateBasedEntityManager;

public class TileMinedAction implements Action
{
	
	boolean debug;
	
	public TileMinedAction(boolean debug)
	{
		this.debug = debug;
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta,
			Component event)
	{
		TileEntity entity = (TileEntity) event.getOwnerEntity();
		if (!entity.isMined())
		{
			entity.setMined(true);
			
		} else
		{
			TileEntity.IS_SELECTED = true;
			ContextMenuButton button1 = (ContextMenuButton) new ButtonFactory(
					(int) entity.getPosition().x + 80,
					(int) entity.getPosition().y, 0, entity, debug)
							.createEntity();
			ContextMenuButton button2 = (ContextMenuButton) new ButtonFactory(
					(int) entity.getPosition().x + 40,
					(int) entity.getPosition().y + 40, 1, entity, debug)
							.createEntity();
			ContextMenuButton button3 = (ContextMenuButton) new ButtonFactory(
					(int) entity.getPosition().x + 40,
					(int) entity.getPosition().y - 40, 2, entity, debug)
							.createEntity();
			ContextMenuButton button4 = (ContextMenuButton) new ButtonFactory(
					(int) entity.getPosition().x - 80,
					(int) entity.getPosition().y, 3, entity, debug)
							.createEntity();
			ContextMenuButton button5 = (ContextMenuButton) new ButtonFactory(
					(int) entity.getPosition().x - 40,
					(int) entity.getPosition().y - 40, 4, entity, debug)
							.createEntity();
			ContextMenuButton button6 = (ContextMenuButton) new ButtonFactory(
					(int) entity.getPosition().x - 40,
					(int) entity.getPosition().y + 40, 5, entity, debug)
							.createEntity();
			ContextMenuButton button7 = (ContextMenuButton) new ButtonFactory(
					(int) entity.getPosition().x,
					(int) entity.getPosition().y - 40, 6, entity, debug)
							.createEntity();
			ContextMenuButton button8 = (ContextMenuButton) new ButtonFactory(
					(int) entity.getPosition().x - 40,
					(int) entity.getPosition().y, 7, entity, debug)
							.createEntity();
			ContextMenuButton button9 = (ContextMenuButton) new ButtonFactory(
					(int) entity.getPosition().x + 40,
					(int) entity.getPosition().y, 8, entity, debug)
							.createEntity();
							
			StateBasedEntityManager.getInstance().addEntity(1, button1);
			StateBasedEntityManager.getInstance().addEntity(1, button2);
			StateBasedEntityManager.getInstance().addEntity(1, button3);
			StateBasedEntityManager.getInstance().addEntity(1, button4);
			StateBasedEntityManager.getInstance().addEntity(1, button5);
			StateBasedEntityManager.getInstance().addEntity(1, button6);
			StateBasedEntityManager.getInstance().addEntity(1, button7);
			StateBasedEntityManager.getInstance().addEntity(1, button8);
			StateBasedEntityManager.getInstance().addEntity(1, button9);
		}
	}
}
