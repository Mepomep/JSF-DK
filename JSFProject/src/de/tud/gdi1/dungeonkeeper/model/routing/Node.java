package de.tud.gdi1.dungeonkeeper.model.routing;

public class Node {

	protected boolean newShortest;
	private int x;
	private int y;
	protected int[][][] neighbors;
	public int[][] shortest;
	int[][] suggestedNeighbor;

	public Node(int xPosition, int yPosition, int maxAmountX, int maxAmountY) {
		x = xPosition;
		y = yPosition;
		neighbors = new int[4][maxAmountX][maxAmountY];
		shortest = new int[maxAmountX][maxAmountY];
		for(int n = 0; n < neighbors.length; n++){
			for(int i = 0; i < neighbors[n].length; i++){
				for(int j = 0; j < neighbors[n][i].length; j++){
					neighbors[n][i][j] = Integer.MAX_VALUE - 1;
					shortest[i][j] = Integer.MAX_VALUE - 1;
					shortest[x][y] = 0;
				}
			}
		}
	}

	protected void updateNode() {
		for(int n = 0; n < neighbors.length; n++){
			for(int i = 0; i < neighbors[n].length; i++){
				for(int j = 0; j < neighbors[n][i].length; j++){
					if(neighbors[n][i][j] + 1 < shortest[i][j]){
						newShortest = true;
						suggestedNeighbor[i][j] = n;
						shortest[i][j] = neighbors[n][i][j] + 1;
					}
				}
			}
		}
	}

	protected void addNeighbor(NeighborPositions position) {
		
		int xOffset = x;
		int yOffset = y;
		int neighbor = 0;
		if (position == NeighborPositions.LEFT) {
			neighbor = 0;
			xOffset = x - 1;
		} else if (position == NeighborPositions.RIGHT) {
			neighbor = 1;
			xOffset = x + 1;
		} else if (position == NeighborPositions.UP) {
			neighbor = 2;
			yOffset = y + 1;
		} else {
			neighbor = 3;
			yOffset = y - 1;
		}

		for (int i = 0; i < neighbors[neighbor].length; i++) {
			for (int j = 0; j < neighbors[neighbor][i].length; j++) {
				if (j == yOffset && i == xOffset) {
					neighbors[neighbor][i][j] = 0;
				} else
					neighbors[neighbor][i][j] = Integer.MAX_VALUE - 1;
			}
		}
	}
	
	protected void ackUpdate(){
		newShortest = false;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public NeighborPositions getNeighbor(int destinationX, int destinationY){
		
		int neighbor = suggestedNeighbor[destinationX][destinationY];
		
		if(neighbor == 0){
			return NeighborPositions.LEFT;
		}
		else if(neighbor == 1){
			return NeighborPositions.RIGHT;
		}
		else if(neighbor == 2){
			return NeighborPositions.UP;
		}
		else {
			return NeighborPositions.DOWN;
		}
	}
}
