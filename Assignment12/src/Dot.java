import java.awt.Color;
import java.awt.Graphics;

// Assignment #: 12
//         Name: Rachel Ware
//    StudentID: 1213096974
//      Lecture: TTH 1:30
//  Description: Represents a dot to be drawn on a panel,
//               a collection of which form a wave

public class Dot 
{
	private Color color;
	private int x;		//x coordinate of center
	private int y;		//y coordinate of center
	private final int RADIUS = 3;	//constant radius of 3
	
	public Dot(int x1, int y1, Color color1)
	{
		color = color1;
		x = x1;
		y = y1;
	}
	
	//draws Dot
	public void draw(Graphics page)
	{
		page.setColor(color);
		page.fillOval(x, y, RADIUS, RADIUS);
	}
		
}
