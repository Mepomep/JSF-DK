package de.tud.gdi1.dungeonkeeper.model.room;

public abstract class Room {
	
	
	private RoomType roomType = null;
	
	private String name = null;
	
	public Room (String name, RoomType type)
	{
		this.name = name;
		this.roomType = type;
	}
	
	public RoomType getRoomType()
	{
		return this.roomType;
	}
	
	public String getName()
	{
		return this.name;
	}
}
