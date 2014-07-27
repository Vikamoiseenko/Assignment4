package com.vmoiseenko.Assignment4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
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
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FirstSwing {
	private JFrame frame;
	private JList<String> list;
	private JScrollPane scrollPane;
	private JPanel mainPanel;
	private JPanel centerPanel;
	private JPanel buttonPanel;
	private JLabel lblName;
	private JTextField txtName;
	
	private JLabel lblDirections;
	private JTextField txtDirections;
	
	private JLabel lblIngredients;
	private JTextField txtIngredients;
	
	private JLabel lblCalories;
	private JTextField txtCalories;
	private JLabel lblFat;
	private JTextField txtFat;
	private JLabel lblProtein;
	private JTextField txtProtein;
	
	private JButton btnNewForm;
	private JButton btnAdd;
	private JButton btnExit;

	private Recipes recipes;
	private ArrayList<Item> ingridients;
	
	public FirstSwing(){
		createJFrame();
		recipes = new Recipes();
		ingridients = new ArrayList<Item>();
		
	}

	private void createJFrame(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200,200,550,400);
		frame.setTitle("Recipe");
		frame.add(createMainPanel());
		frame.setVisible(true);
	}

	private JPanel createMainPanel(){
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(createScrollPane(),BorderLayout.WEST);
		mainPanel.add(createCenterPanel(),BorderLayout.CENTER);
		mainPanel.add(createButtonPanel(), BorderLayout.SOUTH);
		return mainPanel;
	}
	
	private JScrollPane createScrollPane(){
		list = new JList<String>();
		//add the selection listener to the list
		list.addListSelectionListener(new SelectionListener());
		scrollPane = new JScrollPane(list);
		return scrollPane;
	}

	private JPanel createCenterPanel(){
		centerPanel=new JPanel();
		centerPanel.setLayout(new GridLayout(7,2,5,5));

		lblName=new JLabel("Enter Recipe Name");
		txtName=new JTextField();
		
		lblDirections = new JLabel("Directions");
		txtDirections=new JTextField();
		
		lblIngredients = new JLabel("Enter Ingredients Name");
		txtIngredients = new JTextField();
		
				
		lblCalories = new JLabel("Calories");
		txtCalories = new JTextField();
		
		lblFat = new JLabel("Fat");
		txtFat = new JTextField();
		
		lblProtein = new JLabel("Protein");
		txtProtein = new JTextField();
		
		centerPanel.add(lblName);
		centerPanel.add(txtName);
		centerPanel.add(lblDirections);
		centerPanel.add(txtDirections);
		centerPanel.add(lblIngredients);
		centerPanel.add(txtIngredients);
		centerPanel.add(lblCalories);
		centerPanel.add(txtCalories);
		centerPanel.add(lblFat);
		centerPanel.add(txtFat);
		centerPanel.add(lblProtein);
		centerPanel.add(txtProtein);
				
		return centerPanel;
	}

	private JPanel createButtonPanel(){
		buttonPanel=new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		btnNewForm =new  JButton("Add Recipes");
		btnNewForm.addActionListener(new AddRecipeListener());
		btnAdd = new JButton("Get Recipes");
		btnAdd.addActionListener(new FillListListener());
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ExitListener());

		buttonPanel.add(btnNewForm);
		buttonPanel.add(btnAdd);
		buttonPanel.add(btnExit);

		return buttonPanel;
	}

	

	private class ExitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);

		}

	}
	
	private class FillListListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		ArrayList<Item>items=recipes.getItems();
		//set the default model for the list object
		//our list will contain Strings
		DefaultListModel<String> model = new DefaultListModel<String>();
		//loop through the arrayList
		for(Item i : items){
		//add the item names to the list
		model.addElement(i.getName());
		}
		list.setModel(model);
		}

		}
		private class AddRecipeListener implements ActionListener{

		
		@Override
		public void actionPerformed(ActionEvent e) {
		Recipe r = new Recipe();
		r.setName(txtName.getText());
		r.setDirections(txtDirections.getText());

		for(Item i: ingridients){
		Ingredient ingredient = (Ingredient)i;
		r.addItem(ingredient);
		}

		recipes.addItem(r);
		txtName.setText("");
		txtDirections.setText("");
		ingridients.clear(); //I need to clear the ingredients
		//for the next recipe

		}


		}

		private class IngredientListener implements ActionListener{

		
		@Override
		public void actionPerformed(ActionEvent e) {

		Ingredient i=new Ingredient();
		i.setName(txtIngredients.getText());
		i.setCalories(Integer.parseInt(txtCalories.getText()));
		i.setFat(Integer.parseInt(txtFat.getText()));
		i.setProtein(Integer.parseInt(txtProtein.getText()));
		ingridients.add(i);
		txtIngredients.setText("");
		txtCalories.setText("");
		txtFat.setText("");
		txtProtein.setText("");


		}

		}
		private class SelectionListener implements ListSelectionListener{
		
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
		if (list.getSelectedIndex() != -1) {
		//No selection, disable fire button.
		String name=list.getSelectedValue();
		Recipe r = (Recipe)recipes.getItem(name);
		SecondForm sec =new SecondForm(r);
		


		}

		}

		}	

}
