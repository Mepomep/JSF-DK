package de.tud.gdi1.dungeonkeeper.model;

import de.tud.gdi1.dungeonkeeper.model.entity.TileEntity;
import de.tud.gdi1.dungeonkeeper.model.factories.TileFactory;
import eea.engine.entity.StateBasedEntityManager;

public class Map
{
	
	TileEntity[][] tiles;
	
	public Map(boolean debug, int[] posEntry, int[] posCore)
	{
		
		tiles = new TileEntity[41][25];
		for (int i = 0; i < tiles.length; i++)
		{
			for (int j = 0; j < tiles[0].length; j++)
			{
				if (i == posEntry[0] && j == posEntry[1]
						|| i == posCore[0] && j == posCore[1])
				{
					tiles[i][j] = (TileEntity) new TileFactory(
							30 + (int) (40 * i), 30 + (int) (40 * j), true,
							debug).createEntity();
				} else
				{
					tiles[i][j] = (TileEntity) new TileFactory(
							30 + (int) (40 * i), 30 + (int) (40 * j), false,
							debug).createEntity();
				}
				StateBasedEntityManager.getInstance().addEntity(1, tiles[i][j]);
			}
		}
		tiles[posEntry[0]][posEntry[1]].setMined(true);
		tiles[posCore[0]][posCore[1]].setMined(true);
	}
}