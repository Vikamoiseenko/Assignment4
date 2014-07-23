package com.vmoiseenko.Assignment4;

import java.util.ArrayList;

public interface Manage {
	void addItem (Item i);
	void editItem(Item i);
	void deleteItem(Item i);
	Item getItem(String name);
	ArrayList<Item> getItems();
}
