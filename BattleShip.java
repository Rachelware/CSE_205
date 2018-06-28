//Honors Contract
//Name: Rachel Ware
//ASU ID: 1213096974
//class: TTH 1:30
//Description:	The Battleship class defines a battleship, containing its length, 
//				location, and whether it has sunk.

public class BattleShip 
{
	//ship attributes
	private int length;			//number of grid squares long
	private int pixelLength;	//long side measurement for Graphics
	private int orientation; 	//1 is vertical, 0 is horizontal
	private int xPos;			//top left point x coordinate
	private int yPos;			//top right point y coordinate
	private boolean sunk;		//if ship is sunk
	private Coordinate[] coordinates;	//holds a Coordinate for each grid square of ship
			
	//Constructor
	public BattleShip(int length, int orientation)
	{
		this.length = length;
		this.orientation = orientation;
		pixelLength = setPixelLength(length);
		sunk = false;								//all ships start afloat
		coordinates = new Coordinate[length];		//initialize with number of grid squares
	}
	
	//setters
	
	//Returns pixel length found using predetermined values
	public int setPixelLength(int length)
	{
		if (length == 5)
			return 304;
		if (length == 4)
			return 244;
		if (length == 3)
			return 184;
		if (length == 2)
			return 124;
		else
			return 0;
	}
	
	//Sets position in x and y and grid coordinates
	public void setPosition(int x, int y)
	{
		xPos = x;
		yPos = y;
		changeCoordinates();	//to set grid coordinates
	}
	
	//Sets coordinates and grid position of ship
	public void setCoordinates(String coor)
	{
		coordinates[0] = new Coordinate(coor, 0, orientation, 0);
		setPosition(coordinates[0].getX(), coordinates[0].getY());
		int value = coordinates[0].getFirstCoorValue();
		setCoordinates(coor, value);
		
	}
	
	//helper method to other setCoordinates
	//Sets second through last coordinate
	public void setCoordinates(String coor, int firstCoorValue)
	{
		for (int i = 1; i < length; i++)
		{
			coordinates[i] = new Coordinate(coor, i, orientation, firstCoorValue);
		}
		
	}
	
	//Calls Coordinate class to set coordinate grid values using x and y positions
	public void changeCoordinates()
	{
		coordinates[0].setCoorByXY(xPos, yPos);
	}
	
	//Sinks ship or part of ship
	public void setSunk(int place)
	{
		coordinates[place].setSunk();	//sinks given segment of ship
		boolean allSunk = true;
		for (int i = 0; i < coordinates.length; i++)	//check how much of ship has sunk
		{
			if (coordinates[i].getSunk() == false)
			{
				allSunk = false;
			}
		}
		if (allSunk)
			sinkShip();	//if all coordinates(segments) have sunk, whole ships has sunk
	}
	
	//Sets whole ship to sunk
	public void sinkShip()
	{
		sunk = true;
	}
	
	//getters
	
	//Returns ship length in grid spaces
	public int getLength()
	{
		return length;
	}
	
	//Return ship length in pixels
	public int getPixelLength()
	{
		return pixelLength;
	}
	
	//Returns orientation, 0 for horizontal and 1 for vertical
	public int getOrientation()
	{
		return orientation;
	}
	
	//Returns x position
	public int getXPosition()
	{
		return xPos;
	}
	
	//Returns y position
	public int getYPosition()
	{
		return yPos;
	}
	
	//Returns coordinate for given segment of ship as a String
	public String getCoordinate(int index)
	{
		return coordinates[index].toString();
	}

	//returns whether ship has sunk
	public boolean getSunk()
	{
		return sunk;
	}
	
}

