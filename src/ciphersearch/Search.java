package ciphersearch;

import java.util.*;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class Search extends JFrame implements ActionListener{

	JButton add, launch, ad;
	JTextField write, path;
	JLabel lab;
	JComboBox list;
	String n;
	
	Search(){
		
		add= new JButton ("Add File");
		add.addActionListener(this);
		
		ad= new JButton ("Add File Path");
		ad.addActionListener(this);
		ad.setEnabled(false);
		ad.setVisible(false);
		
		launch= new JButton("Launch File");
		launch.addActionListener(this);
		
		write= new JTextField(50);
		lab= new JLabel ("File Searcher");
		
		path= new JTextField (80);
		path.setEnabled(false);
		path.setVisible(false);
		
		   //create file as String for JComboBox files
        String [] file= {"SaveFiles.txt", "triangle.txt", "sierpinskiTriangle.txt", "Patterns.txt"};
        
        //set the attributes of the JComboBox
        list= new JComboBox(file);
        list.setSelectedIndex(0);
        list.addActionListener(list);		
		
	     // 2... Create content pane, set layout
        JPanel content = new JPanel ();        // Create a content pane
        content.setLayout (new BorderLayout ()); // Use BorderLayout for panel
        JPanel north = new JPanel ();
        north.setLayout (new FlowLayout ()); // Use FlowLayout for input area
        JPanel south= new JPanel();
        south.setLayout (new FlowLayout());
        JPanel center= new JPanel();
        center.setLayout (new FlowLayout());
        
        north.add(write);
        center.add(list);
        center.add(add);
        center.add(launch);
        center.add(path);
        center.add(ad);
         
        
		content.add (north, "North"); // Input area
        content.add (center, "Center");
        content.add (south, "South"); // Input area
		
		// 4... Set this window's attributes.
        setContentPane (content);
        pack ();
        setTitle ("Heelix - FileSearch Engine");
        setSize (710, 120);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo (null);           // Center window.
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String text = write.getText();

		if (e.getActionCommand ().equals ("Add File"))//if Simulate is pressed
        {
            ad.setEnabled(true);
            ad.setVisible(true);
            path.setEnabled(true);
            path.setVisible(true);
            setSize (910, 200);            
        }
		if(e.getActionCommand().equals("Add File Path")) {

            DocSearch doc= new DocSearch(write.getText(), path.getText());
            doc.open();
		}
            
	}

}
