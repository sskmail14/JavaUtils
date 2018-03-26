package com.app.swing.layout.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.app.swing.component.action.DirectoryChooser;
import com.app.swing.layout.LayoutSchema;

public class GridBackLayoutImpl implements LayoutSchema	{

	public static JPanel jpRawContent;
	public static JPanel jpDirBrowser;
	public static JPanel jpFileBrowser;
	public static JPanel jpJSONContent;
	
	
	@Override
	public void addComponentsToPane(Container contentPane) {
		

		JButton button = new JButton("Choose Directory...");
		button.addActionListener(new DirectoryChooser());
		
		
		JLabel defaultLabel = new JLabel("Nothing to Show...");
		
		contentPane.setLayout(new GridBagLayout());
		
        // creates some panels with some default values for now
        jpDirBrowser = new JPanel(new BorderLayout());
        jpDirBrowser.setBackground(Color.BLUE);
        jpDirBrowser.add(button);
		
        jpFileBrowser = new JPanel();
        jpFileBrowser.setBackground(Color.GREEN);	    
	    
        jpRawContent = new JPanel(new GridBagLayout());
        jpRawContent.setBackground(Color.RED);
        jpRawContent.add(defaultLabel);
        // grab some info to make the JTextPane and make it scroll
       
        // adding the quantities to the chat panel
        jpJSONContent = new JPanel();
        jpJSONContent.setLayout(new BorderLayout());
        jpJSONContent.add(defaultLabel);
        
        // a new GridBagConstraints used to set the properties/location of the panels
        GridBagConstraints c = new GridBagConstraints();

        // adding some panels to the content pane
        // set it to start from the top left of the quadrant if it's too small
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.BOTH; // set it to fill both vertically and horizontally
        c.gridx = 0; // set it to quadrant x=0 and
        c.gridy = 0; // set it to quadrant y=0
        c.weightx = 0.3;
        c.weighty = 0.1;
        contentPane.add(jpDirBrowser, c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.7;
        c.weighty = 0.1;
        contentPane.add(jpFileBrowser, c);

        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.5;
        c.weighty = 0.7;
        contentPane.add(jpRawContent, c);

        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0.5;
        c.weighty = 0.7;
        contentPane.add(jpJSONContent, c);

	}

	
}
