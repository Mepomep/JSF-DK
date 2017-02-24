package de.tud.gdi1.dungeonkeeper.ui;

public abstract class Room {
	private RoomType roomType = null;
	
	public RoomType getRoomType()
	{
		return this.roomType;
	}
}
