package com.vmoiseenko.Assignment4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SecondForm {
	private JFrame frame;
	private JPanel panel;
	private JLabel label;
	private JScrollPane scrollPane;
	private JList<String> list;
	private JTextArea txtDirections;
	private JButton button;

	public SecondForm(Recipe r){
		recipe = r;
		createFrame();
	}

	private void createFrame(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setBounds(200,200,250,500);
		frame.add(createPanel());
		frame.setVisible(true);
	}

	private JPanel createPanel(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,1));
		
		label = new JLabel(recipe.getName());
		list=new JList<String>();
		
		scrollPane = new JScrollPane(list);
		fillScrollPane();
		txtDirections = new JTextArea();
		txtDirections.setLineWrap(true);
		txtDirections.setText(recipe.getDirections());
		
		button = new JButton("close");
		button.addActionListener(new CloseListener());

		panel.add(label);
		panel.add(scrollPane);
		panel.add(txtDirections);
		panel.add(button);
		return panel;
	}

		private void fillScrollPane(){
		ArrayList<Item>items=recipe.getItems();
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		//loop through the arrayList
		for(Item i : items){
		//add the item names to the list
		model.addElement(i.getName());
		}
		list.setModel(model);
	}
	
	private class CloseListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			frame.dispose();

		}

	}
}
