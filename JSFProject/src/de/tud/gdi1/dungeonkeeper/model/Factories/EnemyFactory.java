package de.tud.gdi1.dungeonkeeper.model.factories;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import de.tud.gdi1.dungeonkeeper.model.entity.EnemyEntity;
import eea.engine.component.RenderComponent;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import eea.engine.interfaces.IEntityFactory;

public class EnemyFactory implements IEntityFactory{

	private boolean debug;
	
	private int	hp,
				x,
				y;
	
	public EnemyFactory(int x, int y, int maxHP, boolean debug)
	{
		this.x = x;
		this.y = y;
		this.hp = maxHP;
		this.debug = debug;
	}
	
	@Override
	public Entity createEntity() {
		Entity enemy = new EnemyEntity(hp);
		enemy.setPosition(new Vector2f(x, y));
		
		if(!debug){
			try {				
				RenderComponent image = new ImageRenderComponent(new Image("Assets/earth_unhighlighted.png"));
				enemy.addComponent(image);
			}catch (SlickException e) {
				e.printStackTrace();
			}
		} else enemy.setSize(new Vector2f(10,10));
		
		
		return enemy;
	}
}
