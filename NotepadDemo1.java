import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NotepadDemo1 {
	static JFrame frame = new JFrame("Untitled.txt *");
	static JTextArea area = new JTextArea();

	public static void main(String[] args) {

		frame.setSize(900, 700);
		JMenuBar bar = new JMenuBar();
		JMenu File, Edit, Help, helpSub;
		JMenuItem New, Save, cut, copy, paste, changeColor, fontsize, selectall, naahImGoodThanks;

		area.setBounds(5, 5, frame.getWidth(), frame.getHeight());
		Font font = new Font(null, Font.BOLD, 20);
		area.setFont(font);
		File = new JMenu("File");
		Edit = new JMenu("Edit");
		Help = new JMenu("Help");
		helpSub = new JMenu("Want help ?");

		New = new JMenuItem("New File");
		Save = new JMenuItem("Save");

		cut = new JMenuItem("Cut");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		changeColor = new JMenuItem("Change Text Color");
		fontsize = new JMenuItem("Set Font Size");
		selectall = new JMenuItem("Select All");

		naahImGoodThanks = new JMenuItem("Naah bro, I'm Good Thanks for Asking though");
		JMenuItem[] menuItems = new JMenuItem[] { New, Save, cut, copy, paste, changeColor, fontsize, selectall };
		File.add(New);
		File.add(Save);

		Edit.add(cut);
		Edit.add(copy);
		Edit.add(paste);
		Edit.add(changeColor);
		Edit.add(fontsize);
		Edit.add(selectall);

		helpSub.add(naahImGoodThanks);
		Help.add(helpSub);

		bar.add(File);
		bar.add(Edit);
		bar.add(Help);
		JScrollPane pane = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		frame.setJMenuBar(bar);
		frame.add(pane);
		for (int i = 0; i < menuItems.length; i++) {
			final int j = i;
			menuItems[j].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (j == 0) {
						New();
					} else if (j == 1) {
						save();
					} else if (j == 2) {
						area.cut();
					} else if (j == 3) {
						area.copy();
					} else if (j == 4) {
						area.paste();
					} else if (j == 5) {
						Color color = JColorChooser.showDialog(frame, "Select a color", null);
						area.setForeground(color);
					} else if (j == 6) {
						String size = JOptionPane.showInputDialog(frame, "Set Font Size");
						int s = Integer.parseInt(size);
						Font font = new Font(null, Font.BOLD, s);
						area.setFont(font);
					} else if (j == 7) {
						area.selectAll();
					}
				}
			});
		}
		frame.setVisible(true);

	}

	public static void New() {
		int selection = JOptionPane.showConfirmDialog(frame, "Do you want to save the file");
		if (selection == 0) {
			save();
			String filename = "Untitled.txt *";
			frame.setTitle(filename);
			area.setText("");
		} else if (selection == 1) {
			String filename = "Untitled.txt *";
			frame.setTitle(filename);
			area.setText("");
		}

	}

	public static void save() {
		String filename;

		filename = JOptionPane.showInputDialog(frame, "Enter File Name");

		frame.setTitle(filename + ".txt");
		File file = new File("C:\\Users\\Dell\\eclipse-workspace\\SwingPrac\\src\\" + filename + ".txt");
		try {
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(area.getText());

			fileWriter.flush();
			fileWriter.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
