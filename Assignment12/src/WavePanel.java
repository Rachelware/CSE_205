// Assignment #: 12
//         Name: Rachel Ware
//    StudentID: 1213096974
//      Lecture: TTH 1:30
//  Description: Defines a panel where waves are moving

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


public class WavePanel extends JPanel
{
	private Color color;
	private Timer timer;	//controls movement of the wave
	private int delay;		//delay of timer
	private int waveWidth;
	private int waveHeight;
	private int time;		//time after a wave started to be drawn, starts at 0
	private int step;		//each step that time changes for each timer tick
	private ArrayList ptList;	//stores dots to draw a wave
	
	public WavePanel(Color color)
	{
		this.color = color;
		ptList = new ArrayList();
		waveHeight = 72;
		waveWidth = 50;
		delay = 20;
		step = 1;
		time = 0;
		this.setBackground(Color.WHITE);	
		timer = new Timer(delay, new WaveListener());	//set timer to delay
		timer.start();
	}
	
	//restarts wave by restarting timer
	public void resume()
	{
		time = 0;
		timer.restart();
	}
	
	//Clears wave panel and resets time
	public void clearPanel()
	{
		ptList.clear();
		repaint();
		time = 0;
	}
	
	//Changes wave color
	public void changeColor(Color anotherColor)
	{
		color = anotherColor;
	}
	
	//Changes wave width
	public void setWaveWidth(int newWidth)
	{
		waveWidth = newWidth;
	}
	
	//Changes delay
	public void setDelay(int delayNum)
	{
		delay = delayNum;
		timer.setInitialDelay(delay);
	}
	
	//paints changes
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		for (int i = 0; i < ptList.size(); i++)
		{
			((Dot)ptList.get(i)).draw(page);
		}
	}
	
	//Changes waves as user indicates
	private class WaveListener implements ActionListener
	{

		public void actionPerformed(ActionEvent event) 
		{
			time += step;
			int x =  (waveWidth*time)/50;
			int y = (int) (waveHeight* Math.sin((0.0174533)*time)+85);
			ptList.add(new Dot(x, y, color));
			repaint();
			
			//if x or y touches edge
			if (x >= 800 || y >= 340)
			{
				timer.stop();
			}
			
		}
		
	}
	
}












