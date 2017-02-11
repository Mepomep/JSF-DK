package de.tud.gdi1.dungeonkeeper.model;

import de.tud.gdi1.dungeonkeeper.model.Factories.TileFactory;
import de.tud.gdi1.dungeonkeeper.model.entity.TileEntity;
import eea.engine.entity.Entity;
import eea.engine.entity.StateBasedEntityManager;

public class Map {

	TileEntity[][] tiles;
	
	public Map(boolean debug){
		
		tiles = new TileEntity[10][10];
		for(int i = 0; i < tiles.length; i++){
			for(int j = 0; j < tiles[0].length; j++){
				tiles[i][j] = (TileEntity) new TileFactory(30 + (int) (40 * i), 30 + (int) (40 * j), debug).createEntity();
				StateBasedEntityManager.getInstance().addEntity(1, tiles[i][j]);
			}
		}
	}
}
