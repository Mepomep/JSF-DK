package de.tud.gdi1.dungeonkeeper.model;

import de.tud.gdi1.dungeonkeeper.model.Factories.TileFactory;
import de.tud.gdi1.dungeonkeeper.model.entity.TileEntity;
import eea.engine.entity.Entity;
import eea.engine.entity.StateBasedEntityManager;

public class Map {

	TileEntity[][] tiles;
	
	public Map(boolean debug){
		Entity testTile = new TileFactory(400, 300, debug).createEntity();
		StateBasedEntityManager.getInstance().addEntity(1, testTile);
		tiles = new TileEntity[10][10];
		for(int i = 0; i < tiles.length; i++){
			for(int j = 0; j < tiles[0].length; j++){
				tiles[i][j] = new TileEntity();
			}
		}
	}
}
