package com.example.rpg;

import com.example.jogodavelha.R;
import com.example.jogodavelha.R.id;
import com.example.jogodavelha.R.layout;
import com.example.jogodavelha.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class RpgActivity extends Activity implements OnClickListener{
	private final int SUBIR = 1;
	private final int DESCER = 2;
	private final int DIREITA = 3;
	private final int ESQUERDA = 4;
	
	int x, y;
	private int larguraTela;
	private int alturaTela;
	private int larguraImg;
	private int alturaImg;
	
	ImageView imageView; 
	AnimationDrawable animation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rpg);
		imageView = (ImageView) findViewById(R.id.animacao);
		imageView.setBackgroundResource(R.drawable.animacao);
		Button up = (Button) findViewById(R.id.up);
		up.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				capturaCoordenadas();
				movimenta(SUBIR);
			}
		});
		Button down = (Button) findViewById(R.id.down);
		down.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				capturaCoordenadas();
				movimenta(DESCER);
			}
		});
		Button right = (Button) findViewById(R.id.right);
		right.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				capturaCoordenadas();
				movimenta(DIREITA);
			}
		});
		Button left = (Button) findViewById(R.id.left);
		left.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				capturaCoordenadas();
				movimenta(ESQUERDA);
			}
		});
	}
	
	private void capturaCoordenadas()
	{
		x = imageView.getWidth();
		y = imageView.getHeight();
	}
	
	
	private void movimenta(int mov)
	{
		TranslateAnimation deslocamento;
		switch (mov)
		{
			case SUBIR:
				deslocamento = new TranslateAnimation(x, x, y, y-100);
				deslocamento.setDuration(1000);
//				deslocamento.setRepeatCount(5);
//				deslocamento.setRepeatMode(2);
// 			    deslocamento.setFillAfter(true);
				imageView.startAnimation(deslocamento);
				break;
			case DESCER:
				deslocamento = new TranslateAnimation(x, x, y, y+100);
				deslocamento.setDuration(1000);
				imageView.startAnimation(deslocamento);
				break;
			case DIREITA:
				deslocamento = new TranslateAnimation(x, x+100, y, y);
				deslocamento.setDuration(1000);
				imageView.startAnimation(deslocamento);
				break;
			case ESQUERDA:
				deslocamento = new TranslateAnimation(x, x-100, y, y);
				deslocamento.setDuration(1000);
				imageView.startAnimation(deslocamento);
				break;
		}
	}

	
	  public void onWindowFocusChanged(boolean hasFocus) {
		  animation = (AnimationDrawable)imageView.getBackground();
		  if (hasFocus) {
			  animation.start();

		  } else {
			  animation.stop();
		  }
	  }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rpg, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
