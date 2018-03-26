package com.app.swing.component.action;

import static com.app.swing.layout.impl.GridBackLayoutImpl.jpJSONContent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

import com.app.swing.component.render.ComponentRender;


public class JsonContentWriter implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouse clicked....");
		JTextArea textArea = (JTextArea) e.getComponent();
		int line;
		try {
			line = textArea.getLineOfOffset(textArea.getCaretPosition());
			int start = ((JTextArea) textArea).getLineStartOffset(line);
			int end = textArea.getLineEndOffset(line);
			String text = textArea.getDocument().getText(start, end - start);
			JOptionPane.showMessageDialog(null, text);
			ComponentRender.writeJsonIntoTextArea(jpJSONContent, text);
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
