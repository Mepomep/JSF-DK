package de.tud.gdi1.dungeonkeeper.model;

import de.tud.gdi1.dungeonkeeper.model.Factories.TileFactory;
import de.tud.gdi1.dungeonkeeper.ui.Tile;
import eea.engine.entity.Entity;
import eea.engine.entity.StateBasedEntityManager;

public class Map {

	Tile[][] tiles;
	
	public Map(boolean debug){
		Entity testTile = new TileFactory(400, 300, debug).createEntity();
		StateBasedEntityManager.getInstance().addEntity(1, testTile);
		tiles = new Tile[10][10];
		for(int i = 0; i < tiles.length; i++){
			for(int j = 0; j < tiles[0].length; j++){
				tiles[i][j] = new Tile();
			}
		}
	}
}
