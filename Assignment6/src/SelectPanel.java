// Assignment #: 6
//         Name: Rachel Ware
//    StudentID: 1213096974
//      Lecture: TTH 1:30
//  Description: The SelectPanel class handles adding and removing projects on the Project selection tab.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class SelectPanel extends JPanel
 {
   private Vector projectList, selectedList; 
   private JPanel formatPanel;	
   private JPanel buttonPanel;	//panel for buttons
   private JButton addButton;
   private JButton removeButton;
   private JList availProj;		//list of available projects
   private JList selectProj;	//list of selected projects
   private JLabel projSelectedLabel;	//display of number of selected projects
   private DefaultListModel listModel;	//Using list model because I don't know how to use the Vector

   //Constructor initialize each component and arrange them using
   //certain layouts
   public SelectPanel(Vector projectList)
     {
	   //instantiate components
      this.projectList = projectList;
      formatPanel = new JPanel();
      buttonPanel = new JPanel();
      addButton = new JButton("add");
      addButton.addActionListener(new ButtonListener());	//action listener on "add" button
      removeButton = new JButton("remove");
      removeButton.addActionListener(new ButtonListener());		//action listener on "remove" button
      availProj = new JList(projectList);
      listModel = new DefaultListModel();
      selectProj = new JList(listModel);
      projSelectedLabel = new JLabel("The total number of selected projects: 0"); //sets label to 0 initially
      
      //set up panels
      buttonPanel.setLayout(new GridLayout(1,2));
      buttonPanel.add(addButton);
      buttonPanel.add(removeButton);
      
      JPanel availPanel = new JPanel();
      availPanel.setLayout(new BorderLayout());
      availPanel.add(new JLabel("Available project(s)"), BorderLayout.PAGE_START);
      availPanel.add(availProj, BorderLayout.CENTER);
      
      JPanel selectPanel = new JPanel();
      selectPanel.setLayout(new BorderLayout());
      selectPanel.add(selectProj, BorderLayout.CENTER);
      selectPanel.add(new JLabel("Selected project(s)"), BorderLayout.PAGE_START);
      
      formatPanel.setLayout(new GridLayout(3,1));
      formatPanel.add(availPanel);
      formatPanel.add(buttonPanel);
      formatPanel.add(selectPanel);
      
      setLayout(new BorderLayout());
      add(formatPanel, BorderLayout.CENTER);
      add(projSelectedLabel, BorderLayout.PAGE_END);
      
      updateProjectList();	//initial update to project list
         
       // organize components for the select panel
  }

 //This method updates refresh the JList of projects with
 //updated vector information
 public void updateProjectList()
  {
    // call updateUI() for the JList
	 availProj.updateUI();
  }

 //ButtonListener class listens to see if any of
 //buttons is pushed, and perform their corresponding action.
 private class ButtonListener implements ActionListener
  {
       public void actionPerformed(ActionEvent event)
        {
          if (event.getSource() == addButton)	//if add button pressed
          {
        	  //add selection to selected projects
        	  int index = listModel.getSize();
        	  listModel.add(index, availProj.getSelectedValue());
        	  selectProj.getModel();
        	  projSelectedLabel.setText("The total number of selected projects: " + listModel.getSize());
          }
          if (event.getSource() == removeButton)	//if remove button pressed
          {
        	 //remove selection from selected projects
        	  int index = selectProj.getSelectedIndex();
        	 listModel.removeElementAt(index);
        	 selectProj.getModel();
        	  projSelectedLabel.setText("The total number of selected projects: " + listModel.getSize());
          }
          updateProjectList();	//update the ProjectList
        }
  } //end of ButtonListener class

} //end of SelectPanel class
