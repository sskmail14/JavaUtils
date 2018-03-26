package com.app.swing.component.action;

import static com.app.swing.layout.impl.GridBackLayoutImpl.jpRawContent;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.app.swing.component.render.ComponentRender;

public class FileChooser implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		ComponentRender.generateRawContentinToTextArea(jpRawContent, e.getItem().toString());
	}
	
	

}
