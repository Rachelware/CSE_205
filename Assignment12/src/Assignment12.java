// Assignment #: 12
//         Name: Rachel Ware
//    StudentID: 1213096974
//      Lecture: TTH 1:30
//  Description: The Assignment 12 class creates a controlpanel and
//               adds it as its Applet content and also sets its size.

import javax.swing.*;

public class Assignment12 extends JApplet
 {
  private final int WIDTH = 800;
  private final int HEIGHT = 340;

  public void init()
   {
       ControlPanel panel = new ControlPanel(WIDTH,HEIGHT);
       getContentPane().add(panel);
       setSize(WIDTH,HEIGHT);
   }
 }
