// Assignment #: 7
//         Name: Rachel Ware
//    StudentID: 1213096974
//      Lecture: TTH 1:30
//  Description: Assignment 7 class runs the JApplet at a size of 400x400.

import javax.swing.*;

public class Assignment7 extends JApplet
{

 public void init()
  {
    // create a WholePanel object and add it to the applet
    WholePanel wholePanel = new WholePanel();
    getContentPane().add(wholePanel);

    //set applet size to 400 X 400
    setSize (400, 400);
  }

}