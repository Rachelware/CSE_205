//Honors Contract
//Name: Rachel Ware
//ASU ID: 1213096974
//class: TTH 1:30
//Description: The Coordinate class creates a coordinate that has a position in pixels and 
//				in the game grid and evaluates it in relationship to the BattleShip it is part of
//				and the game board.

public class Coordinate
{
	private int xPoint;		//x-coordinate of top left of ship coordinate belongs to
	private int yPoint;		//y-coordinate of top left of ship coordinate belongs to
	private final int LENGTH = 61;		//length of square in pixels
	private String coordinateGrid;		//square name in game grid
	private int[] xValues = new int[10];			//possible x-values in pixels
	private int[] yValues = new int[10];			//possible y values on grid
	private String[] gridValues = new String[100];		//possible grid values
	//gridValues stored a different way
	private String[][] fastGridValues = { {"A","B","C","D","E","F","G","H","I","J"}, {"1","2","3","4","5","6","7","8","9","10"} };
	private int place;						//place order in ship
	private int firstCoorInGridValues;		//save first coordinate position in game grid
	private boolean sunk;					//whether coordinate has been hit
	
	public Coordinate(String pos, int place, int orientation, int firstCoorinGridValues)
	{
		sunk = false;	//start afloat
		coordinateGrid = pos;	//uses position of first coordinate of ship
		this.place = place;
		firstCoorInGridValues = firstCoorinGridValues;
		
		//set up xValues and yValues with pixel values for each square of game grid
		int index = 0;
		for (int i = 65; i < 616; i = i + LENGTH)
		{
			xValues[index] = i;
			yValues[index] = i;
			index++;
		}
		
		//set up array of possible game grid values
		String alpha = "ABCDEFGHIJo";
		String num = "12345678910o";
		index = 0;
		for (int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				gridValues[index] = alpha.substring(i, i+1) + "," + num.substring(j, j+1);
				if (j == 9)
				{
					gridValues[index] = alpha.substring(i, i+1) + "," + num.substring(j, j+2);
				}
				index++;
				
			}
		}
		setXandY();							//set x and y pixel values
		changeCoorByPlace(orientation);		//set grid position of this coordinate
	}
	
	//setters
	
	//Set x and y coordinates using game grid position
	public void setXandY()
	{
		int countX = 0;
		int countY = 0;
		for (int j = 0; j < 100; j++)	//travel through all grid values
	    {
			//when given position and array value match
			if (coordinateGrid.equals(gridValues[j]))
			{
				xPoint = xValues[countX];
				yPoint = yValues[countY];
				if (place == 0)
				{
					firstCoorInGridValues = j;	//save grid value of first part of ship
				}	
				
			}
			//to match values to grid
			countX++;
			if (j == 9 || (j -9) % 10 == 0)
			{
				countX = 0;
				countY++;
			}
		}
		
	}
	
	//set game grid values for segments of ship
	public void changeCoorByPlace(int orientation)
	{
		if (orientation == 1)	//vertical
		{
			if (place == 1)
			{
				coordinateGrid = gridValues[firstCoorInGridValues +1];
			}
			else if (place == 2)
			{
				coordinateGrid = gridValues[firstCoorInGridValues +2];
			}
			else if (place == 3)
			{
				coordinateGrid = gridValues[firstCoorInGridValues +3];
			}
			else if (place == 4)
			{
				coordinateGrid = gridValues[firstCoorInGridValues +4];
			}
			else	//if place == 0
			{
				//nothing
			}
		}
		else	//if horizontal
		{
			if (place == 0)
			{
				coordinateGrid = gridValues[firstCoorInGridValues +10];
			}
			else if (place == 2)
			{
				coordinateGrid = gridValues[firstCoorInGridValues +20];
			}
			else if (place == 3)
			{
				coordinateGrid = gridValues[firstCoorInGridValues +30];
			}
			else if (place == 4)
			{
				coordinateGrid = gridValues[firstCoorInGridValues +40];
			}
			else	//if place == 0
			{
				//nothing
			}
		}
	}
	
	//Sets game grid position using x and y positions
	public void setCoorByXY(int x, int y)
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				//find a certain square and change the game grid value to it
				if (x > xValues[i] && x < xValues[i + 1] && y > yValues[j] && y < yValues[j+1])
				{
					coordinateGrid = fastGridValues[0][j] + "," + fastGridValues[1][i];
				}
			}
		}
	}
	
	//if coordinate is hit
	public void setSunk()
	{
		sunk = true;
	}
	
	//getters
	
	//Returns x coordinate pixel value
	public int getX()
	{
		return xPoint;
	}
	
	//Returns y coordinate pixel value
	public int getY()
	{
		return yPoint;
	}
	
	//Returns if coordinate has been hit
	public boolean getSunk()
	{
		return sunk;
	}
	
	//get gridValue position of first coordinate
	public int getFirstCoorValue()
	{
		return firstCoorInGridValues;
	}
	
	//Return coordinate game grid position as a string
	public String toString()
	{
		return coordinateGrid;
	}
	
	//Returns array gridValues
	public String[] getGridValues()
	{
		return gridValues;
	}
	
}
