package com.app.swing.frame;

import javax.swing.JFrame;
import javax.swing.ScrollPaneLayout;

import com.app.swing.layout.LayoutSchema;

public class AppFrame {

	public static void createSampleFrame(LayoutSchema ls) {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

		// JLabel jl = new JLabel("Hello Swing");

		// jf.getContentPane().add(jl);
		jf.setLayout(new ScrollPaneLayout());
		ls.addComponentsToPane(jf.getContentPane());
		jf.setLocationByPlatform(true);
		jf.pack();
		jf.setVisible(true);

	}
}
