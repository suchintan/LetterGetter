package com.awesome.lettergetter;

import android.graphics.Bitmap;

public class Item {
	Bitmap image;
	String quantity;
	
	public Item(Bitmap image, String title) {
		super();
		this.image = image;
		this.quantity = title;
	}
	
	
	public Item(Bitmap image, int i, int j ) {
		super();
		this.image = image;
		this.quantity = Integer.toString(i);
		
	}
	public Bitmap getImage() {
		return image;
	}
	public void setImage(Bitmap image) {
		this.image = image;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String title) {
		this.quantity = title;
	}
	

}
