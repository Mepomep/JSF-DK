package de.tud.gdi1.dungeonkeeper.model.routing;

import org.newdawn.slick.geom.Vector2f;

public class RoutingManager
{
	
	Node[][] nodes;
	
	public RoutingManager(int maxAmountX, int maxAmountY)
	{
		nodes = new Node[maxAmountX][maxAmountY];
	}
	
	public void addNode(int x, int y)
	{
		nodes[x][y] = new Node(x, y, nodes.length, nodes[0].length);
		if (nodes[x - 1][y] != null)
		{
			nodes[x][y].addNeighbor(NeighborPositions.LEFT);
			nodes[x - 1][y].addNeighbor(NeighborPositions.RIGHT);
		}
		if (nodes[x + 1][y] != null)
		{
			nodes[x][y].addNeighbor(NeighborPositions.RIGHT);
			nodes[x + 1][y].addNeighbor(NeighborPositions.LEFT);
		}
		if (nodes[x][y + 1] != null)
		{
			nodes[x][y].addNeighbor(NeighborPositions.UP);
			nodes[x][y + 1].addNeighbor(NeighborPositions.DOWN);
		}
		if (nodes[x][y - 1] != null)
		{
			nodes[x][y].addNeighbor(NeighborPositions.DOWN);
			nodes[x][y - 1].addNeighbor(NeighborPositions.UP);
		}
		
		updateNeighbors(nodes[x][y]);
	}
	
	private void updateNeighbors(Node node)
	{
		node.updateNode();
		if (node.newShortest)
		{
			node.ackUpdate();
			if (nodes[node.getX() + 1][node.getY()] != null)
			{
				nodes[node.getX() + 1][node
						.getY()].neighbors[0] = node.shortest;
				updateNeighbors(nodes[node.getX() + 1][node.getY()]);
			}
			if (nodes[node.getX() - 1][node.getY()] != null)
			{
				nodes[node.getX() - 1][node
						.getY()].neighbors[1] = node.shortest;
				updateNeighbors(nodes[node.getX() - 1][node.getY()]);
			}
			if (nodes[node.getX()][node.getY() - 1] != null)
			{
				nodes[node.getX()][node.getY()
						- 1].neighbors[2] = node.shortest;
				updateNeighbors(nodes[node.getX()][node.getY() - 1]);
			}
			if (nodes[node.getX()][node.getY() + 1] != null)
			{
				nodes[node.getX()][node.getY()
						+ 1].neighbors[3] = node.shortest;
				updateNeighbors(nodes[node.getX()][node.getY() + 1]);
			}
		}
	}
	
	public Vector2f getNextNode(int sourceX, int sourceY, int targetX,
			int targetY)
	{
		NeighborPositions nextNode = nodes[sourceX][sourceY]
				.getNeighbor(targetX, targetY);
		if (nextNode == NeighborPositions.LEFT)
		{
			return new Vector2f(sourceX - 1, sourceY);
		} else if (nextNode == NeighborPositions.RIGHT)
		{
			return new Vector2f(sourceX + 1, sourceY);
		} else if (nextNode == NeighborPositions.UP)
		{
			return new Vector2f(sourceX, sourceY + 1);
		} else
		{
			return new Vector2f(sourceX, sourceY - 1);
		}
	}
	
}
