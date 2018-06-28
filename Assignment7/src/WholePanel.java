// Assignment #: 7
//         Name: Rachel Ware
//    StudentID: 1213096974
//      Lecture: TTH 1:30
//  Description: The WholePanel class creates the layout and allows a square to be modified
//					in size with the mouse and in color and filled/not filled using buttons
//					and a checkbox.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // to use listener interfaces

public class WholePanel extends JPanel
{
   private Color currentColor;		//tracks current color
   private int currentWidth, currentHeight;		//tracks current width and height
   private CanvasPanel canvas;
   private JPanel menuPanel;
   private JCheckBox fillCheck;
   private boolean filled;		//track if checkbox is filled
   private FillListener listen;		//listener for fillCheck
   private JRadioButton white;		//color buttons
   private JRadioButton red;
   private JRadioButton blue;
   private JRadioButton green;
   private JRadioButton orange;
   private ColorListener listener;	//listener for buttons
   private int x1, y1;				//tracks x and y point of rectangle
   private int startX, startY, endX, endY;		//variables for tracking x and y for mouse events
   

   public WholePanel()
   {
     //white is the default color
     currentColor = Color.WHITE;

     //default x-y coordinate, width, and height of a rectangle
     currentWidth = currentHeight = 100;
     x1 = 100; y1 = 100;
     startX = x1; startY = y1;
     endX = x1; endY = y1;
     
     //initialize listeners
     listen = new FillListener();
     listener = new ColorListener();
     
     //initialize and add listeners to checkbox and buttons
     fillCheck = new JCheckBox("Filled");
     fillCheck.addItemListener(listen);
     fillCheck.setSelected(false);		//checkbox starts unselected
     white = new JRadioButton("white");
     white.addActionListener(listener);
     red = new JRadioButton("red");
     red.addActionListener(listener);
     blue = new JRadioButton("blue");
     blue.addActionListener(listener);
     green = new JRadioButton("green");
     green.addActionListener(listener);
     orange = new JRadioButton("orange");
     orange.addActionListener(listener);
     
     //add buttons to button group
     ButtonGroup colors = new ButtonGroup();
     colors.add(white);
     colors.add(red);
     colors.add(blue);
     colors.add(green);
     colors.add(orange);
     white.setSelected(true);	//start with white button selected
     
     //add components to menu
     menuPanel = new JPanel();
     menuPanel.add(fillCheck);
     menuPanel.add(white);
     menuPanel.add(red);
     menuPanel.add(blue);
     menuPanel.add(green);
     menuPanel.add(orange);

     canvas = new CanvasPanel();
     filled = false;	//set filled to fale initially

     JSplitPane sPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menuPanel, canvas);

     setLayout(new BorderLayout());
     add(sPane, BorderLayout.CENTER);

    }


private class ColorListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)	//when color button changed
	{
		//set color to color of button selected
		if (white.isSelected())
		{
			currentColor = Color.WHITE;
		}
		else if (red.isSelected())
		{
			currentColor = Color.RED;
		}
		else if (blue.isSelected())
		{
			currentColor = Color.BLUE;
		}
		else if (green.isSelected())
		{
			currentColor = Color.GREEN;
		}
		else //if (orange.isSelected())
		{
			currentColor = Color.ORANGE;
		}
		repaint();	//apply changes
	}
}

private class FillListener implements ItemListener
{
	public void itemStateChanged(ItemEvent g)	//checkbox checked or unchecked
	{
		if (fillCheck.isSelected())
		{
			filled = true;		//change filled according to changes
		}
		else
		{
			filled = false;
		}
		repaint();		//apply changes

	}
}

 //CanvasPanel is the panel where pressed keys will be drawn
 private class CanvasPanel extends JPanel
  {
     //Constructor to initialize the canvas panel
     public CanvasPanel( )
      {
        // make this canvas panel listen to mouse
        addMouseListener(new PointListener());
        addMouseMotionListener(new PointListener());

        setBackground(Color.BLACK);
      }


     //this method draws all characters pressed by a user so far
     public void paintComponent(Graphics page)
      {
       super.paintComponent(page);

       //set color, then draw a rectangle
       page.setColor(currentColor);
    	   
       page.drawRect(x1, y1, currentWidth, currentHeight);
       
       if (filled == true)
       {
    	   page.fillRect(x1, y1, currentWidth, currentHeight);	//fill Rectangle if needed
       }
      }

    // listener class that listens to the mouse
    public class PointListener implements MouseListener, MouseMotionListener
         {
         //in case that a user presses using a mouse,
         //record the point where it was pressed.
         public void mousePressed (MouseEvent event) 
         {
        	 startX = event.getX();
        	 startY = event.getY();
         }
         public void mouseClicked (MouseEvent event) {}
         public void mouseReleased (MouseEvent event) 
         {
        	 endX = event.getX();
        	 endY = event.getY();
        	 repaint();
         }
         public void mouseEntered (MouseEvent event) {}
         public void mouseExited (MouseEvent event) {}
         public void mouseMoved(MouseEvent event) {}
         public void mouseDragged(MouseEvent event)	//control how rectangle changes when mouse is dragged
          {
        	 //right side, does not overlap with top or bottom
        	if (startX > (x1 + currentWidth/2) && startY > (y1 + currentHeight/4) && startY < (y1 + currentHeight - currentHeight/4))
        	{
        		if ((event.getX()-x1) > 100) //if rectangle width will be larger than 100
        		{
        			currentWidth = event.getX()-x1; //change width
        		}
        		else	//if rectangle width would be 100 or smaller
        		{
        			currentWidth = 100;	//set width to 100
        		}	
        	    repaint();
        	}
        	//bottom
        	else if (startX > (x1 + currentWidth/4) && startX < (x1 + currentWidth - currentWidth/4) && startY > (y1 + currentHeight/2))
        	{
        		if ((event.getY()-y1) > 100)	//if rectangle height will be larger than 100
        		{
        			currentHeight = event.getY()-y1;
        		}
        		else	//if rectangle height would be 100 or smaller
        		{
        			currentHeight = 100;
        		}
        	    repaint();
        	}
        	
        	//left
        	else if (startX < (x1 + currentWidth/2) && startY > (y1 + currentHeight/4) && startY < (y1 + currentHeight - currentHeight/4))
        	{
        		if (event.getX() <= x1)	//if mouse is left of x1
        		{
        			currentWidth += x1 - event.getX();
        			x1 = event.getX();	//x1 moves left
        		}
        		else	//mouse right of x1
        		{
        			if ((currentWidth+x1-event.getX()) < 100)	//if width would be less than 100
            		{
        				x1 += currentWidth-100;
            			currentWidth = 100;
        		    }
            		else
            		{
        				int farRightSide = x1 + currentWidth; //marks right side point
            			x1 = event.getX();					  //move x1
        				currentWidth = farRightSide-x1; 	  //switches width with rights side stationary
            		}
        		}
        	    repaint();
        	}
        	//top
        	else if (startX > (x1 + currentWidth/4) && startX < (x1 + currentWidth - currentWidth/4) && startY < (y1 + currentHeight/2))
        	{
        		if (event.getY()<= y1)	//if mouse point is above y1
        		{
        			currentHeight += y1 - event.getY();
        			y1 = event.getY();	//move top edge to mouse point
        		}
        		else 
        		{
        			if ((currentHeight+y1-event.getY()) > 100)
        			{
        				int bottomSide = y1 + currentHeight;	//marks bottom point
        				y1 = event.getY();						//move y1
        				currentHeight = bottomSide-y1;			//switch height with bottom side stationary
        			}
        			else	//if width would be less than 100
        			{
        				y1 +=currentHeight-100;
        				currentHeight=100;
        			}
        		}
        	    repaint();
        	}
        	

          }

    } // end of PointListener

  } // end of Canvas Panel Class

} // end of Whole Panel Class
