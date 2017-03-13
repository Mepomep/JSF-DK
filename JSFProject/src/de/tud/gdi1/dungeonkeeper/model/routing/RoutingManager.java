package de.tud.gdi1.dungeonkeeper.model.routing;

import org.newdawn.slick.geom.Vector2f;

public class RoutingManager {

	Node[][] nodes;

	public RoutingManager(int maxAmountX, int maxAmountY) {
		nodes = new Node[maxAmountX][maxAmountY];
	}

	public void AddNode(int x, int y) {
		nodes[x][y] = new Node(x, y, nodes.length, nodes[0].length);
		if (nodes[x - 1][y] != null) {
			nodes[x][y].AddNeighbor(NeighborPositions.LEFT);
			nodes[x - 1][y].AddNeighbor(NeighborPositions.RIGHT);
		}
		if (nodes[x + 1][y] != null) {
			nodes[x][y].AddNeighbor(NeighborPositions.RIGHT);
			nodes[x + 1][y].AddNeighbor(NeighborPositions.LEFT);
		}
		if (nodes[x][y + 1] != null) {
			nodes[x][y].AddNeighbor(NeighborPositions.UP);
			nodes[x][y + 1].AddNeighbor(NeighborPositions.DOWN);
		}
		if (nodes[x][y - 1] != null) {
			nodes[x][y].AddNeighbor(NeighborPositions.DOWN);
			nodes[x][y - 1].AddNeighbor(NeighborPositions.UP);
		}

		UpdateNeighbors(nodes[x][y]);
	}

	private void UpdateNeighbors(Node node) {
		node.updateNode();
		if (node.newShortest) {
			node.ackUpdate();
			if (nodes[node.getX() + 1][node.getY()] != null) {
				nodes[node.getX() + 1][node.getY()].neighbors[0] = node.shortest;
				UpdateNeighbors(nodes[node.getX() + 1][node.getY()]);
			}
			if (nodes[node.getX() - 1][node.getY()] != null) {
				nodes[node.getX() - 1][node.getY()].neighbors[1] = node.shortest;
				UpdateNeighbors(nodes[node.getX() - 1][node.getY()]);
			}
			if (nodes[node.getX()][node.getY() - 1] != null) {
				nodes[node.getX()][node.getY() - 1].neighbors[2] = node.shortest;
				UpdateNeighbors(nodes[node.getX()][node.getY() - 1]);
			}
			if (nodes[node.getX()][node.getY() + 1] != null) {
				nodes[node.getX()][node.getY() + 1].neighbors[3] = node.shortest;
				UpdateNeighbors(nodes[node.getX()][node.getY() + 1]);
			}
		}
	}
	
	public Vector2f GetNextNode(int sourceX, int sourceY, int targetX, int targetY){
		NeighborPositions nextNode = nodes[sourceX][sourceY].GetNeighbor(targetX, targetY);
		if(nextNode == NeighborPositions.LEFT){
			return new Vector2f(sourceX - 1, sourceY);
		}
		else if(nextNode == NeighborPositions.RIGHT){
			return new Vector2f(sourceX + 1, sourceY);
		}
		else if(nextNode == NeighborPositions.UP){
			return new Vector2f(sourceX, sourceY + 1);
		}
		else {
			return new Vector2f(sourceX, sourceY - 1);
		}
	}
}
