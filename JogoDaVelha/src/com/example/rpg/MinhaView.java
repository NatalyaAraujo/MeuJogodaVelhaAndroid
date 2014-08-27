package com.example.rpg;

import com.example.jogodavelha.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MinhaView extends View
{
	private Button up, down, right, left;
	private Person person;
	//private Drawable img;
	
//	private int larguraImg;
//	private int alturaImg;
	
	public MinhaView(Context context, AttributeSet attrs) {
		// TODO Auto-generated constructor stub
		super(context, null);
		init(context);
	}
	
	private void init(Context context)
	{
		person = new Person(context);
//		img = context.getResources().getDrawable(R.drawable.penelope_charmosa_pqna);
//		larguraImg = img.getIntrinsicWidth();
//		alturaImg  = img.getIntrinsicHeight();
//		up = (Button) this.findViewById(R.id.button1);
//		up.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//		down = (Button) findViewById(R.id.button2);
//		right = (Button) findViewById(R.id.button3);
//		left = (Button) findViewById(R.id.button4);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
//		Paint pincel = new Paint();
//		pincel.setColor(Color.WHITE);
		//canvas.drawRect(0, 0, larguraTela, alturaTela, pincel);
		person.getImg().setBounds(person.getX(), person.getY(), person.getX() + person.getLarguraImg(), person.getY() + person.getAlturaImg());
		person.getImg().draw(canvas);
	}
	
	protected void subir(){
		person.setY(person.getY() + 20);
	}
	
	protected void descer(){
		person.setY(person.getY() - 20);
	}
	
	protected void direita(){
		person.setX(person.getX() + 20);
	}
	
	protected void esquerda(){
		person.setX(person.getX() - 20);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		float x = event.getX();
		float y = event.getY();
		//Log.i(CATEGORIA, "onTouchEvent x/y > " + x + "/" + y);
		switch (event.getAction()) 
		{
			case MotionEvent.ACTION_DOWN:
				descer();
				//selecionou = img.copyBounds().contains((int) x, (int) y);
				break;
			case MotionEvent.ACTION_MOVE:
				direita();
//				if(selecionou)
//				{
//					this.x = (int) x - (larguraImg / 2);
//					this.y = (int) y - (alturaImg / 2);
//				}
				break;
			case MotionEvent.ACTION_UP:
				subir();
				//selecionou = false;
				break;
		}
		invalidate();
		//return super.onTouchEvent(event);
		return true;
	}

	
}
