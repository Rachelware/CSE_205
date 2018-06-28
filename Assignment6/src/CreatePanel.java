// Assignment #: 6
//         title: Rachel Ware
//    StudentID: 1213096974
//      Lecture: TTH 1:30
//  Description: The CreatePanel class handles creating projects on the Project creation tab.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CreatePanel extends JPanel
 {
   private Vector projectList;
   private JButton button1;
   private SelectPanel sPanel;
   private JLabel label1;		//label for errors or success messages when adding projects
   private JTextField titleField;
   private JTextField numberField;
   private JTextField locationField;
   private JPanel organizePanel;	//panel to segment left side of tab
   private JPanel inputPanel;		//panel to format input boxes
   private JScrollPane scrollPane;
   private JTextArea textArea;

 //Constructor initializes components and organize them using certain layouts
 public CreatePanel(Vector projectList, SelectPanel sPanel)
  {
    //instantiate components
	 this.projectList = projectList;
    this.sPanel = sPanel;
    button1 = new JButton("Create a project");
    button1.addActionListener(new ButtonListener());	//add actionListener to button
    label1 = new JLabel();
    label1.setForeground(Color.RED);	//sets words to red
    titleField = new JTextField();
    numberField = new JTextField();
    locationField = new JTextField();
    organizePanel = new JPanel();
    inputPanel = new JPanel();
    textArea = new JTextArea("No Project");	//set original text
    textArea.setEditable(false);	//created projects not editable
    scrollPane = new JScrollPane(textArea);		//scrolling possible
    
    //set panel layouts
    organizePanel.setLayout(new GridLayout(3,2));
    organizePanel.add(new JLabel("Project Title"));
    organizePanel.add(titleField);
    organizePanel.add(new JLabel("Project Number"));
    organizePanel.add(numberField);
    organizePanel.add(new JLabel("Project Location"));
    organizePanel.add(locationField);
      
    inputPanel.setLayout(new GridLayout(3,1));
    inputPanel.add(label1);
    inputPanel.add(organizePanel);
    inputPanel.add(button1);
      
    setLayout(new GridLayout(1,1));
    add(inputPanel);
    add(scrollPane);
  }


  //ButtonListener is a listener class that listens to
  //see if the button "Create a project" is pushed.
  //When the event occurs, it add the project information
  //in the text fields to the text area
  //and the list of project information,
  //and it also does error checking.
  private class ButtonListener implements ActionListener
   {
    public void actionPerformed(ActionEvent event)
     {
         //set initial variable values
    	boolean error = false;		//track error
    	 String title = "-1";
    	 String location = "-1";
    	 int number = -1;
    	 
    	 //get input from text fields
    	 title = titleField.getText();
         try
         {
        	 number = Integer.parseInt(numberField.getText());
         }
         catch(NumberFormatException e)		//catch if number input is not an integer
         {
        	 error = true;
         }
         location = locationField.getText();
         
         //process input or report errors
         if (error == true && numberField.getText().isEmpty() == false)
         {
        	//error message for number input not being an integer
        	 label1.setText("Please enter an integer for the project number");
         }
         else 
         {
        	//error message for a field being empty
	         if (titleField.getText().isEmpty() == true || locationField.getText().isEmpty() == true || numberField.getText().isEmpty() == true)
	         {
	        	 label1.setText("Please enter all fields");
	        	 
	         }
	         else	//if no errors
	         {
			     Project proj = new Project();	//create a project
			     proj.setProjTitle(title);
			     proj.setProjNumber(number);
			     proj.setProjLocation(location);
			     if (projectList.size() == 0)	//clear initial text when first project is created
			     {
			    	 textArea.setText("");
			     }
		         projectList.add(proj);		//project added to project list
		         label1.setText("Project added.");	//success message
		         titleField.setText("");		//clear text fields
		         numberField.setText("");
		         locationField.setText("");
		         textArea.append(proj.toString());	//add project to text area on right
	         }
         }
    	// if there is no error, add a project to project list
         // otherwise, show an error message

     } //end of actionPerformed method
  } //end of ButtonListener class

} //end of CreatePanel class
