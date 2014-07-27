package com.vmoiseenko.Assignment4;
import java.util.ArrayList;

public class Recipe extends Item implements Manage{
	private String directions;
private ArrayList<Item> ingredients;
	
	public Recipe() {
		ingredients = new ArrayList<Item>();
	}
	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}
	
	@Override
	public void addItem(Item i) {
		ingredients.add(i);

	}

	@Override
	public void editItem(Item i) {
		for(Item item: ingredients){
			if (item.getName().equals(i.getName())){
				ingredients.remove(item);
				ingredients.add(i);
			}
		}

	}

	
	@Override
	public Item getItem(String name) {
		Item it = null;
		for(Item b: ingredients){
			if (b.getName().equals(name)){
				it=b;
			}
		}
		return it;
	}

	@Override
	public ArrayList<Item> getItems() {

		return ingredients;
	}

	
}
