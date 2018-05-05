package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ListTracker implements ActionListener
{
	JButton addT = new JButton();
	JButton removeT = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();
	
	int currentNum = 0;
	String formatted;
	
	
	JFrame frame = new JFrame();
	
	JPanel panel = new JPanel();
	
	String add;
	String remove;
	String printList;
	String loadList;
	
	FileWriter fw;
	JFileChooser fc;
	FileReader fr;
	
	ArrayList<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {
		ListTracker lt = new ListTracker();
		lt.startUpList();
		lt.createUI();
	}
	
	public void startUpList()
	{
			try {
				fr = new FileReader("src/intro_to_file_io/ToDoList");
				loadList = new String("");
				int c = fr.read();
				while(c != -1){
					loadList = loadList + ((char)c);
					c = fr.read();
				}
				JOptionPane.showMessageDialog(null, loadList);
				
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
	
	public void createUI()
	{
		
	frame.setVisible(true);
	panel.setVisible(true);
	
	addT.setText("Add Task");
	addT.addActionListener(this);
	addT.setVisible(true);
	
	removeT.setText("Remove Task");
	removeT.addActionListener(this);
	removeT.setVisible(true);
	
	save.setText("Save");
	save.addActionListener(this);
	save.setVisible(true);
	
	load.setText("Load");
	load.addActionListener(this);
	load.setVisible(true);
	
	frame.add(panel);
	panel.add(addT);
	panel.add(removeT);
	panel.add(save);
	panel.add(load);
	
	frame.pack();
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	}
	
	public String formatList(ArrayList<String> list)
	{
		String format = null;
		
		for(String i: list)
		{
			currentNum+=1;
			format = format + System.lineSeparator() + "Task #" + currentNum + ": " + i;
		}
		
		return format;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(addT))
		{
		add = JOptionPane.showInputDialog("Add Task:");
		list.add(add);
		}
		
		if(e.getSource().equals(removeT))
		{
			remove = JOptionPane.showInputDialog("Input the task you wish to remove: ");
			for(String s : list){
				if(s.equalsIgnoreCase(remove));
				{
					list.remove(remove);
					JOptionPane.showMessageDialog(null, "Your task has been deleted (if it exists)");
				}
			}
		}
		if(e.getSource().equals(save))
		{
			try {
				printList = formatList(list);
				fw = new FileWriter("src/intro_to_file_io/ToDolist");
				fw.write(printList);
				fw.close();
				
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
		if(e.getSource().equals(load))
		{
			fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String fileName = fc.getSelectedFile().getAbsolutePath();
				try {
					fr = new FileReader(fileName);
					loadList = new String("");
					int c = fr.read();
					while(c != -1){
						loadList = loadList + ((char)c);
						c = fr.read();
					}
					JOptionPane.showMessageDialog(null, loadList);
					
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		}
	}
}
