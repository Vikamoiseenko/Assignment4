package com.vmoiseenko.Assignment4;

public class Ingredient extends Item{
private String unitSize;
private double calories;
private double fat;
private double protein;
private double carbs;
public String getUnitSize() {
	return unitSize;
}
public void setUnitSize(String unitSize) {
	this.unitSize = unitSize;
}
public double getCalories() {
	return calories;
}
public void setCalories(double calories) {
	this.calories = calories;
}
public double getFat() {
	return fat;
}
public void setFat(double fat) {
	this.fat = fat;
}
public double getProtein() {
	return protein;
}
public void setProtein(double protein) {
	this.protein = protein;
}
public double getCarbs() {
	return carbs;
}
public void setCarbs(double carbs) {
	this.carbs = carbs;
}
}
