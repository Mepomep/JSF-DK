package de.tud.gdi1.dungeonkeeper.model.factories;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import de.tud.gdi1.dungeonkeeper.model.action.BuildAction;
import de.tud.gdi1.dungeonkeeper.model.entity.ContextMenuButton;
import de.tud.gdi1.dungeonkeeper.model.entity.TileEntity;
import eea.engine.component.RenderComponent;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import eea.engine.event.ANDEvent;
import eea.engine.event.Event;
import eea.engine.event.basicevents.MouseClickedEvent;
import eea.engine.event.basicevents.MouseEnteredEvent;
import eea.engine.interfaces.IEntityFactory;

public class ButtonFactory implements IEntityFactory
{
	int		x;
	int		y;
	int		type;
	boolean	debug;
	TileEntity tile;
			
	public ButtonFactory(int x, int y, int type, TileEntity tile, boolean debug)
	{
		this.x = x;
		this.y = y;
		this.type = type;
		this.tile = tile;
		this.debug = debug;
	}
	
	@Override
	public Entity createEntity()
	{
		ContextMenuButton button = new ContextMenuButton(type);
		button.setPosition(new Vector2f(x, y));
		
		if (!debug)
		{
			try
			{
				RenderComponent image;
				image = new ImageRenderComponent(
						new Image("Assets/earth_unhighlighted.png"));
				button.addComponent(image);
			} catch (SlickException e)
			{
				e.printStackTrace();
			}
		} else
			button.setSize(new Vector2f(10, 10));
			
		Event event = new ANDEvent(new MouseEnteredEvent(),
				new MouseClickedEvent());
		event.addAction(new BuildAction(type, tile, debug));
		button.addComponent(event);
		
		return button;
	}
	
}
