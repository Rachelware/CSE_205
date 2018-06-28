//Honors Contract
//Name: Rachel Ware
//ASU ID: 1213096974
//class: TTH 1:30
//Description: 	The ShipArray class creates an array of BattleShips and places them on the game board.
//				It also contains methods to attack other ShipArrays and determine if all ships
//				in the array have sunk.

import java.util.ArrayList;

public class ShipArray
{
	private final int LENGTH = 5;	//always have 5 ships
	private BattleShip[] array;		//array of ships
	private ArrayList<String> gridVals;		//array of all game grid values
	//several possible ship arrangement arrays
	private String[] arr1 = {"A,1", "C,3", "F,6", "H,1", "C,9"};
	private String[] arr2 = {"E,5", "B,2", "H,1", "A,7", "G,7"};
	private String[] arr3 = {"B,4", "D,6", "H,2", "H,8", "A,1"};
	
	
	public ShipArray()
	{
		array = new BattleShip[LENGTH];
		
		//get random ship arrangement
		int arrNum = (int)(Math.random()*3);
		if (arrNum == 0)
			randomShipArrangement(arr1);
		else if (arrNum == 1)
			randomShipArrangement(arr2);
		else
			randomShipArrangement(arr3);
		
		//create ArrayList of all game grid values
		Coordinate getArray = new Coordinate("A,1", 0, 0, 0);
		String[] arr = getArray.getGridValues();
		gridVals = new ArrayList<String>();
		for (int i = 0; i < 100; i++)
		{
			gridVals.add(arr[i]);
		}
	}
	
	//Creates a random arrangement of ships in an array
	public BattleShip[] randomShipArrangement(String[] coorArray)
	{
		int orientationNumber = (int)(Math.random()* 2);
		array[0] = new BattleShip(5, orientationNumber);
		array[0].setCoordinates(coorArray[0]);	
		
		orientationNumber = (int)(Math.random()* 2);
		array[1]  = new BattleShip(4, orientationNumber);
		array[1].setCoordinates(coorArray[1]);
		
		orientationNumber = (int)(Math.random()* 2);
		array[2] = new BattleShip(3, orientationNumber);
		array[2].setCoordinates(coorArray[2]);
		
		orientationNumber = (int)(Math.random()* 2);
		array[3] = new BattleShip(3, orientationNumber);
		array[3].setCoordinates(coorArray[3]);
		
		orientationNumber = (int)(Math.random()* 2);
		array[4] = new BattleShip(2, orientationNumber);
		array[4].setCoordinates(coorArray[4]);

		return array;
	}
		
	//Returns BattleShip stored at given index
	public BattleShip getVal(int index)
	{
		return array[index];
	}
	
	//Attacks given coordinates (for player)
	public boolean attack(String coordinates)
	{
		boolean success = false;
		for (int i = 0; i < 5; i++)
		{	
			//if there is a ship there 
			for (int j = 0; j <array[i].getLength(); j++)
			{
				if (coordinates.equals(array[i].getCoordinate(j)))
				{
					array[i].setSunk(j);	//sinks one grid square	
					success = true;
				}
			}
		}
		return success;
	}
	
	//Attacks a random grid square (for computer)
	public boolean compAttack()
	{
		boolean success = false;
		int number = (int)(Math.random()*gridVals.size());
		String gridSpace = gridVals.get(number);	//place to attack
		gridVals.remove(number);
		
		//System.out.println("attacked: " + gridSpace);
		for (int i = 0; i < 5; i++)	//check all ships
		{	
			//if there is a ship there 
			for (int j = 0; j <array[i].getLength(); j++)	//check all spaces of ship
			{
				if (gridSpace.equals(array[i].getCoordinate(j)))	//if matches
				{
					array[i].setSunk(j);	//hit that space
					success = true;
				}
			}
		}
		return success;
		
	}
	
	//Returns if all ships in array are sunk
	public boolean allShipsSunk()
	{
		boolean allSunk = true;
		for (int i = 0; i < 5; i++)
		{
			if (array[i].getSunk() == false)
			{
				allSunk = false;
			}
		}
		return allSunk;
	}
}









