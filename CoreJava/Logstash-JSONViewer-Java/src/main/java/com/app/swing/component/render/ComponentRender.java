package com.app.swing.component.render;

import java.awt.Dimension;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import org.json.JSONObject;

import com.app.swing.component.action.FileChooser;
import com.app.swing.component.action.JsonContentWriter;

public class ComponentRender {
	
	private static int RAW_CONTENT_INTIAL_HEIGHT= 0;
	private static int RAW_CONTENT_INTIAL_WINDTH= 0;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void generateFileListIntoJComboBox(JPanel jp, String path) {
		jp.removeAll();
		jp.repaint();

		List<String> files = extractAllFilesByDir(path);
		System.out.println(files);

		if (null == files || files.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No files found in selected directory " + path);
		} else {
			String[] s = files.toArray(new String[files.size()]);
			JComboBox jComboBox = new JComboBox(s);
			jComboBox.addItemListener(new FileChooser());
			jp.add(jComboBox);

			jp.revalidate();
		}

	}

	public static void generateRawContentinToTextArea(JPanel jp, String path) {
		System.out.println("e.getItem();" + path);
		List<String> contents = readFile(path);
		if (null == contents || contents.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Unable to read file/file empty :: " + path);
		} else {
			Dimension d = jp.getPreferredSize();
			jp.removeAll();
			//jp.repaint();

			JTextArea jta = new JTextArea();
			jta.addMouseListener(new JsonContentWriter());
			contents.forEach(content -> {
				jta.append(content + "\n");
			});

			//jta.setLineWrap(true);
			//jta.setWrapStyleWord(true);
			JScrollPane scrolltxt = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrolltxt.setViewportView(jta);
			scrolltxt.setWheelScrollingEnabled(true);
			//scrolltxt.setPreferredSize(d);
			if(RAW_CONTENT_INTIAL_HEIGHT == 0 && RAW_CONTENT_INTIAL_WINDTH ==0) {
				RAW_CONTENT_INTIAL_WINDTH = jp.getWidth(); 
				RAW_CONTENT_INTIAL_HEIGHT = jp.getHeight();
			}
			scrolltxt.setPreferredSize(new Dimension(RAW_CONTENT_INTIAL_HEIGHT, RAW_CONTENT_INTIAL_WINDTH));
			System.out.println("jp.getWidth()+\"::\" +jp.getHeight()"+jp.getWidth()+"::" +jp.getHeight());
			jp.add(scrolltxt);
			jp.revalidate();
			jp.repaint();

			System.out.println("Content Written Successfully...");
		}

	}


	public static void writeJsonIntoTextArea(JPanel jp, String contents) {
		if (null == contents || contents.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Line empty :: ");
		} else {
			Dimension d = jp.getPreferredSize();
			jp.removeAll();
			// jp.repaint();

			JTextArea jta = new JTextArea();
			try {
				JSONObject sourceJSON = new JSONObject(contents);
				// JSONObject targetJSON = extractNestedJSON(contents);
				String prettyJson = sourceJSON.toString(8);
				jta.append(prettyJson);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jta.setLineWrap(true);
			jta.setWrapStyleWord(true);
			JScrollPane scrolltxt = new JScrollPane();
			scrolltxt.setViewportView(jta);
			scrolltxt.setWheelScrollingEnabled(true);
			jp.setPreferredSize(d);
			jp.add(scrolltxt);
			jp.revalidate();
			 jp.repaint();
			System.out.println("Content Written as JSON Successfully...");
		}
	}

	private static List<String> extractAllFilesByDir(String path) {
		try {
			System.out.println("Extract File info");
			return Files.list(Paths.get(path)).filter(e -> e.toString().endsWith(".log")).map(file -> {
				System.out.println(file.toString());
				return file.toString();
			}).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	private static List<String> readFile(String path) {
		try {
			return Files.lines(Paths.get(path)).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
}
