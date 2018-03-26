package com.app.swing;

import javax.swing.SwingUtilities;

import com.app.swing.frame.AppFrame;
import com.app.swing.layout.impl.GridBackLayoutImpl;

public class InitApp {
	
	public static void startApp() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				AppFrame.createSampleFrame(new GridBackLayoutImpl());
			}
		});
	}

}
