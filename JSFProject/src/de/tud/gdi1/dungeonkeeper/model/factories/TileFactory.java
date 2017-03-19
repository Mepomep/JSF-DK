package de.tud.gdi1.dungeonkeeper.model.factories;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import de.tud.gdi1.dungeonkeeper.model.action.TileHighlightedAction;
import de.tud.gdi1.dungeonkeeper.model.action.TileMinedAction;
import de.tud.gdi1.dungeonkeeper.model.entity.TileEntity;
import de.tud.gdi1.dungeonkeeper.model.event.IsBuiltEvent;
import de.tud.gdi1.dungeonkeeper.model.event.IsHighlightableEvent;
import de.tud.gdi1.dungeonkeeper.model.event.IsHighlightedEvent;
import de.tud.gdi1.dungeonkeeper.model.event.MouseLeftEvent;
import eea.engine.component.RenderComponent;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import eea.engine.event.ANDEvent;
import eea.engine.event.Event;
import eea.engine.event.basicevents.MouseClickedEvent;
import eea.engine.event.basicevents.MouseEnteredEvent;
import eea.engine.interfaces.IEntityFactory;

public class TileFactory implements IEntityFactory
{
	
	int		x;
	int		y;
	boolean	debug;
	boolean	mined;
			
	public TileFactory(int x, int y, boolean mined, boolean debug)
	{
		this.x = x;
		this.y = y;
		this.debug = debug;
		this.mined = mined;
	}
	
	@Override
	public Entity createEntity()
	{
		Entity tile = new TileEntity();
		tile.setPosition(new Vector2f(x, y));
		
		if (!debug)
		{
			try
			{
				RenderComponent image;
				if (!mined)
				{
					image = new ImageRenderComponent(
							new Image("Assets/earth_unhighlighted.png"));
				} else
				{
					image = new ImageRenderComponent(
							new Image("Assets/earth_mined_unhighlighted.png"));
				}
				tile.addComponent(image);
			} catch (SlickException e)
			{
				e.printStackTrace();
			}
		} else
			tile.setSize(new Vector2f(10, 10));
			
		Event event = new ANDEvent(new MouseEnteredEvent(),
				new IsHighlightableEvent());
		event.addAction(new TileHighlightedAction(debug));
		tile.addComponent(event);
		
		event = new ANDEvent(new MouseLeftEvent(), new IsHighlightedEvent());
		event.addAction(new TileHighlightedAction(debug));
		tile.addComponent(event);
		
		/*
		 * event = new ANDEvent(new MouseEnteredEvent(), new
		 * MouseClickedEvent(), new IsMinedEvent()); event.addAction(new
		 * TileMinedAction(debug)); tile.addComponent(event);
		 */
		event = new ANDEvent(new MouseEnteredEvent(), new MouseClickedEvent(),
				new IsBuiltEvent());
		event.addAction(new TileMinedAction(debug));
		tile.addComponent(event);
		
		return tile;
	}
}
