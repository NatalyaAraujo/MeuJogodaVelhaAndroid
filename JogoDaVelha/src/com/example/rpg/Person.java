package com.example.rpg;

import com.example.jogodavelha.R;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class Person 
{
	private Drawable img;
	
	private int larguraImg;
	private int alturaImg;
	private int x, y;
	
	public Person() {
		// TODO Auto-generated constructor stub
		x=0;
		y=10;
		larguraImg=50;
		alturaImg=50;
	}
	
	public Person(int x, int y, Context context) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		img = context.getResources().getDrawable(R.drawable.penelope_charmosa_pqna);
		larguraImg = img.getIntrinsicWidth();
		alturaImg  = img.getIntrinsicHeight();
	}
	public Person(Context context) {
		// TODO Auto-generated constructor stub
		img = context.getResources().getDrawable(R.drawable.penelope_charmosa_pqna);
		larguraImg = img.getIntrinsicWidth();
		alturaImg  = img.getIntrinsicHeight();
	}
	
	public Person(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}

	public Drawable getImg() {
		return img;
	}

	public void setImg(Drawable img) {
		this.img = img;
	}

	public int getLarguraImg() {
		return larguraImg;
	}

	public void setLarguraImg(int larguraImg) {
		this.larguraImg = larguraImg;
	}

	public int getAlturaImg() {
		return alturaImg;
	}

	public void setAlturaImg(int alturaImg) {
		this.alturaImg = alturaImg;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	

}
