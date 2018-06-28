//Honors Contract
//Name: Rachel Ware
//ASU ID: 1213096974
//class: TTH 1:30
//Description: Class to run program as a JApplet.

import javax.swing.*;

public class GameRunner extends JApplet
{
	public void init()
	{
		//create game board and put in applet
		BattleGrid gameBoard = new BattleGrid();
		getContentPane().add(gameBoard);
		
		//set applet size
		setSize(700, 850);
	}
}
