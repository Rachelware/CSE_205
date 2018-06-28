//Honors Contract
//Name: Rachel Ware
//ASU ID: 1213096974
//class: TTH 1:30
//Description:	Runs the GUI of the battleship game and uses Graphics and action listeners.

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class BattleGrid extends JPanel
{
	//instance variables
	private ShipArray playerArray;		//storage of player ships
	private ShipArray computerArray;	//storage of computer ships
	private JPanel topMenuPanel;
	private CanvasPanel gridPanel;
	private JPanel inputPanel;			//bottom panel
	private JLabel guessedCoordinatesLabel;
	private JTextArea coordinatesText;			//shows guessed coordinates
	private JScrollPane scrollCoordinates;		//scrollpane for guessed coordinates
	private JLabel attackInstructions;			//says how to attack
	private JTextField input;					//textbox for input
	private JButton attackButton;	
	private JCheckBox lockShips;	
	private boolean gridLocked;		//if ship position is locked
	private int pressedShip; 		//which ship mouse presses
	
	public BattleGrid()
	{
		//set defaults
		playerArray = new ShipArray();
		computerArray = new ShipArray();
		pressedShip = -1;	//no ship starts pressed
		gridLocked = false;
		
		//initialize instance variables and add listeners
		topMenuPanel = new JPanel();
		gridPanel = new CanvasPanel();
		gridPanel.addMouseListener(new PointListener());	//grid panel tracks mouse actions
		gridPanel.addMouseMotionListener(new PointListener());
		inputPanel = new JPanel();
		guessedCoordinatesLabel = new JLabel("Guessed Coordinates: ");
		coordinatesText = new JTextArea();
		coordinatesText.setEditable(false);
		scrollCoordinates = new JScrollPane(coordinatesText);
		attackInstructions = new JLabel("Input: letter,number   ");
		input = new JTextField();
		attackButton = new JButton("Attack");
		attackButton.addActionListener(new ButtonListener());
		lockShips = new JCheckBox("Lock Ships");
		lockShips.addActionListener(new ButtonListener());
		
		//set layouts and add components to panels
		topMenuPanel.setPreferredSize(new Dimension(800, 100));
		topMenuPanel.setLayout(new BoxLayout(topMenuPanel, BoxLayout.X_AXIS));
		topMenuPanel.add(guessedCoordinatesLabel);
		topMenuPanel.add(scrollCoordinates);	//adds scrolling text field
		
		gridPanel.setPreferredSize(new Dimension(600,600));
		gridPanel.setLayout(new GridLayout(11,11));	
		gridPanel.setBorder(new MatteBorder(1,1,1,1, Color.BLACK));
		//make grid appearance
		JLabel label1 = new JLabel("");
		label1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		gridPanel.add(label1);
		for (int i = 1; i < 11; i ++)
		{
			String number = i + "";
			JLabel label = new JLabel(number);	//TEMPORARY
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			gridPanel.add(label);
		}
		//add text to grid edges
		int alphabetInt = 0;
		String letter = "ABCDEFGHIJ";
		for (int i = 11; i < 111; i++)
		{
			if (i == 11 || i == 21 || i==31 || i==41||i==51||i==61||i==71||i==81||i==91||i==101)
			{
				JLabel label = new JLabel(letter.substring(alphabetInt, alphabetInt + 1));	//TEMPORARY
				label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				gridPanel.add(label);
				alphabetInt++;
			}
			JLabel label = new JLabel("");	//TEMPORARY
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			gridPanel.add(label);
		}
		gridPanel.setBackground(Color.BLUE);
		
		inputPanel.setPreferredSize(new Dimension(800, 50));
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
		inputPanel.add(attackInstructions);
		inputPanel.add(input);
		inputPanel.add(attackButton);
		inputPanel.add(lockShips);
		
		//add all panels to main panel
		setLayout(new BorderLayout());
		add(topMenuPanel, BorderLayout.NORTH);
		add(gridPanel, BorderLayout.CENTER);
		add(inputPanel, BorderLayout.SOUTH);
		setBorder(new EmptyBorder(10,10,10,10));
		
	}
	
	
 	 //class for grid panel and graphics
	 private class CanvasPanel extends JPanel
	  {
	     //Constructor to initialize the canvas panel
	     public CanvasPanel( )
	      {
	        // make this canvas panel listen to mouse
	        addMouseListener(new PointListener());
	        addMouseMotionListener(new PointListener());
	      }


	     //this method draws all characters pressed by a user so far
	     public void paintComponent(Graphics page)
	      {
	       super.paintComponent(page);   
	       page.setColor(Color.GRAY);
	       
	       //length 5 ship drawn
	       if (playerArray.getVal(0).getSunk())	//if it has sunk it appears red
	    	   page.setColor(Color.RED);
	       if (playerArray.getVal(0).getOrientation() == 0)		//draw according to orientation
	    	   page.fillRect(playerArray.getVal(0).getXPosition(), playerArray.getVal(0).getYPosition(), 60, playerArray.getVal(0).getPixelLength());
	       else
	    	   page.fillRect(playerArray.getVal(0).getXPosition(), playerArray.getVal(0).getYPosition(), playerArray.getVal(0).getPixelLength(), 60);
	       page.setColor(Color.GRAY); 
	       
	       //length 4
	       if (playerArray.getVal(1).getSunk())
	    	   page.setColor(Color.RED);
	       if (playerArray.getVal(1).getOrientation() == 0)
	    	   page.fillRect(playerArray.getVal(1).getXPosition(), playerArray.getVal(1).getYPosition(), 60, playerArray.getVal(1).getPixelLength());
	       else
	    	   page.fillRect(playerArray.getVal(1).getXPosition(), playerArray.getVal(1).getYPosition(), playerArray.getVal(1).getPixelLength(), 60);
	       page.setColor(Color.GRAY);
	       
	       //length 3
	       if (playerArray.getVal(2).getSunk())
	    	   page.setColor(Color.RED);
	       if (playerArray.getVal(2).getOrientation() == 0)
	    	   page.fillRect(playerArray.getVal(2).getXPosition(), playerArray.getVal(2).getYPosition(), 60, playerArray.getVal(2).getPixelLength());
	       else
	    	   page.fillRect(playerArray.getVal(2).getXPosition(), playerArray.getVal(2).getYPosition(), playerArray.getVal(2).getPixelLength(), 60);
	       page.setColor(Color.GRAY);
	       
	       if (playerArray.getVal(3).getSunk())
	    	   page.setColor(Color.RED);
	       if (playerArray.getVal(3).getOrientation() == 0)
	    	   page.fillRect(playerArray.getVal(3).getXPosition(), playerArray.getVal(3).getYPosition(), 60, playerArray.getVal(3).getPixelLength());
	       else
	    	   page.fillRect(playerArray.getVal(3).getXPosition(), playerArray.getVal(3).getYPosition(), playerArray.getVal(3).getPixelLength(), 60);
	       page.setColor(Color.GRAY);
	       
	       //length 2
	       if (playerArray.getVal(4).getSunk())
	    	   page.setColor(Color.RED);
	       if (playerArray.getVal(4).getOrientation() == 0)
	    	   page.fillRect(playerArray.getVal(4).getXPosition(), playerArray.getVal(4).getYPosition(), 60, playerArray.getVal(4).getPixelLength());
	       else
	    	   page.fillRect(playerArray.getVal(4).getXPosition(), playerArray.getVal(4).getYPosition(), playerArray.getVal(4).getPixelLength(), 60);
	       
	      }
	  }
	
	
	//listener classes
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == lockShips)
			{
				if (lockShips.isSelected())
				{
					lockShips.setEnabled(false);	//box can only be checked once
					gridLocked = true;
				}
			}
			if (e.getSource() == attackButton)
			{
				if (gridLocked == false)	//if ships not locked
				{
					JOptionPane.showMessageDialog(gridPanel, "lock ships before starting");
				}
				else
				{
					String inputCoordinates = input.getText();	//get input
					input.setText("");
					boolean success = computerArray.attack(inputCoordinates);	//attack
					//put to guessed coordinates list
					String stuff = coordinatesText.getText();	
					String results = " MISS\n";
					if (success == true)
					{
						results = " HIT\n";
					}
					coordinatesText.setText(stuff + inputCoordinates + results);	//add to list
					
					//win state
					if (computerArray.allShipsSunk())
					{
						repaint();
						stuff = coordinatesText.getText();	
						coordinatesText.setText(stuff + "YOU WON!!!");
						JOptionPane.showMessageDialog(gridPanel, "YOU WON!!!");
					}
					else	//computer takes turn
					{
						//no ability to tell what place computer hit (no visual or text)
						success = playerArray.compAttack();
						stuff = coordinatesText.getText();
						results = "computer: MISS\n";
						if (success == true)
						{
							results = "computer: HIT\n";
						}
						coordinatesText.setText(stuff + results);	//add to list
						
						//lose state
						if (playerArray.allShipsSunk())
						{
							repaint();
							stuff = coordinatesText.getText();	
							coordinatesText.setText(stuff + "YOU LOST!!!");
							JOptionPane.showMessageDialog(gridPanel, "YOU LOST!!!");
						}
					repaint();
					}
				}
			}
		}

	}

	
	public class PointListener implements MouseListener, MouseMotionListener
    {
		public void mouseDragged(MouseEvent arg0) {}
		public void mouseMoved(MouseEvent arg0) {}
		public void mouseClicked(MouseEvent arg0) {}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}

		public void mousePressed(MouseEvent e) 
		{
			//go through all ships and see which one is pressed
			for (int i = 0; i < 5; i++)
			{	
				//within x range and y range
				int startX = playerArray.getVal(i).getXPosition();
				int startY = playerArray.getVal(i).getYPosition();
				if (playerArray.getVal(i).getOrientation() == 0)
				{
					if (e.getX() >= startX && e.getX() <= (startX +playerArray.getVal(i).getPixelLength()))
					{
						if (e.getY() >= startY && e.getY() <= (startY + 60))
						{
							 pressedShip = i;	//save which ship
						}
					}
				}
				else
				{
					if (e.getX() >= startX && e.getX() <= (startX + 60))
					{
						if (e.getY() >= startY && e.getY() <= (startY +playerArray.getVal(i).getPixelLength()))
						{
							 pressedShip = i;	//save which ship
						}
					}
				 }
			}
			
			
		}

		public void mouseReleased(MouseEvent e) 
		{
			if (gridLocked == false)	//if ships are allowed to move
			{
				//find which ship to move
				if (pressedShip == 0)
				{
					if (playerArray.getVal(0).getOrientation() == 0) //if not too close to edge
					{
						if (e.getY() < 431)
						{
							//move ship
							playerArray.getVal(0).setPosition(e.getX(), e.getY());
							repaint();
						}
					}
					else
					{
						if (e.getX() < 431)
						{
							playerArray.getVal(0).setPosition(e.getX(), e.getY());
							repaint();
						}
					}
				}
				else if (pressedShip == 1)
				{
					if (playerArray.getVal(1).getOrientation() == 0)
					{
						if (e.getY() < 492)
						{
							playerArray.getVal(1).setPosition(e.getX(), e.getY());
							repaint();
						}
					}
					else
					{
						if (e.getX() < 492)
						{
							playerArray.getVal(1).setPosition(e.getX(), e.getY());
							repaint();
						}
					}
				}
				else if (pressedShip == 2)
				{
					if (playerArray.getVal(2).getOrientation() == 0)	
					{
						if (e.getY() < 553)
						{
							playerArray.getVal(2).setPosition(e.getX(), e.getY());
							repaint();
						}
					}
					else
					{
						if (e.getX() < 553)
						{
							playerArray.getVal(2).setPosition(e.getX(), e.getY());
							repaint();
						}
					}
				}
				else if (pressedShip == 3) 
				{
					if (playerArray.getVal(3).getOrientation() == 0)	
					{
						if (e.getY() < 553)
						{
							playerArray.getVal(3).setPosition(e.getX(), e.getY());
							repaint();
						}
					}
					else
					{
						if (e.getX() < 553)
						{
							playerArray.getVal(3).setPosition(e.getX(), e.getY());
							repaint();
						}
					}
				}
				else if (pressedShip == 4)	
				{
					if (playerArray.getVal(4).getOrientation() == 0)	
					{
						if (e.getY() < 614)
						{
							playerArray.getVal(4).setPosition(e.getX(), e.getY());
							repaint();
						}
					}
					else
					{
						if (e.getX() < 614)
						{
							playerArray.getVal(4).setPosition(e.getX(), e.getY());
							repaint();
						}
					}
				}
				else
				{
					repaint();
				}
			}
			
		}
		
    }
}











