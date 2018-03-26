package com.app.swing.component.action;

import static com.app.swing.layout.impl.GridBackLayoutImpl.jpFileBrowser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.app.swing.component.render.ComponentRender;;

public class DirectoryChooser implements ActionListener {

	JFileChooser jfc = new JFileChooser();
	@Override
	public void actionPerformed(ActionEvent e) {
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int action = jfc.showOpenDialog(null);
		System.out.println(action);
		if(action==JFileChooser.APPROVE_OPTION)
		{
			//remember last directory
			jfc.setCurrentDirectory(jfc.getSelectedFile());
			System.out.println(jfc.getSelectedFile().canRead());
			if(!jfc.getSelectedFile().canRead())
			{
				JOptionPane.showMessageDialog(null, "Cannot open the Path "+jfc.getSelectedFile().getPath());
			}
			ComponentRender.generateFileListIntoJComboBox(jpFileBrowser, jfc.getSelectedFile().getPath());			
		}
		
	}

}
