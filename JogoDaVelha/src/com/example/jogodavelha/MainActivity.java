package com.example.jogodavelha;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	Button but1, but2, but3, but4, but5, but6, but7, but8, but9;
	Jogador jogadorA, jogadorB;
	private static final int ARQUIVO = 0;
    private static final int EDITAR = 1;
    private static final int FORMATAR = 2;
 
    private static final int ARQ_NOVO = 3;
    private static final int ARQ_SALVAR = 4;
 
    private static final int EDITAR_RECORTAR = 5;
    private static final int EDITAR_COPIAR = 6;
     
    private static final int FORMATAR_FONTE = 7;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		but1 = (Button) findViewById(R.id.imgButton1);
	//	but1.setOnClickListener(this);
		but2 = (Button) findViewById(R.id.imgButton2);
//		but2.setOnClickListener(this);
		but3 = (Button) findViewById(R.id.imgButton3);
//		but3.setOnClickListener(this);
		but4 = (Button) findViewById(R.id.imgButton4);
//		but4.setOnClickListener(this);
		but5 = (Button) findViewById(R.id.imgButton5);
//		but5.setOnClickListener(this);
		but6 = (Button) findViewById(R.id.imgButton6);
//		but6.setOnClickListener(this);
		but7 = (Button) findViewById(R.id.imgButton7);
//		but7.setOnClickListener(this);
		but8 = (Button) findViewById(R.id.imgButton8);
	//	but8.setOnClickListener(this);
		but9 = (Button) findViewById(R.id.imgButton9);
		//but9.setOnClickListener(this);
		jogadorA = new Jogador("sol"); 
		jogadorA.setMinhaVez(true);
		jogadorB = new Jogador("lua");
		jogadorB.setMinhaVez(false);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
		try
        {
            //cria o menu e submenus
            SubMenu menuArquivo = menu.addSubMenu(ARQUIVO, 0, 0, "Arquivo");
            SubMenu menuEditar = menu.addSubMenu(EDITAR, 1, 0, "Editar");
            MenuItem menuFormatar = menu.add(FORMATAR, FORMATAR_FONTE, 0, "Formatar");        
             
            //define uma tecla de atalho para o menu, nesse caso a 
            //tecla de atalho é a letra "F"
            menuFormatar.setShortcut('0', 'F');
             
            //adiciona um ícone ao menu
            //menuFormatar.setIcon(R.drawable.icon);
            menuFormatar.setIcon(android.R.drawable.ic_menu_edit);
             
            //caso seja necessário desabilitar o menu Arquivo
            //abaixo segue exemplo
            //menu.findItem(ARQUIVO).setEnabled(false);
     
            menuArquivo.add(ARQUIVO, ARQ_NOVO, 0, "Novo");
            menuArquivo.add(ARQUIVO, ARQ_SALVAR, 1, "Salvar");
            menuArquivo.setIcon(android.R.drawable.ic_menu_more);
             
            //caso seja necessário desabilitar um subitem do menu Arquivo
            //abaixo segue exemplo
            //menuArquivo.findItem(ARQ_NOVO).setEnabled(false);
             
            menuEditar.add(EDITAR, EDITAR_RECORTAR, 0, "Recortar");
            menuEditar.add(EDITAR, EDITAR_COPIAR, 1, "Copiar");
     
            //caso seja necessário desabilitar um subitem do menu Editar
            //abaixo segue exemplo
            //menuEditar.findItem(EDITAR_COPIAR).setEnabled(false);
        }
        catch (Exception e) {
            trace("Erro : " + e.getMessage());
        }            
        return super.onCreateOptionsMenu(menu);       
	}
	
	 public boolean onOptionsItemSelected(MenuItem item) {
	        //de acordo com o item selecionado você executará
	        //a função desejada
	        switch (item.getItemId()) {
	            case ARQ_NOVO:     
	                trace("Você selecionou o menu Novo");
	                break;
	            case ARQ_SALVAR:     
	                trace("Você selecionou o menu Salvar");
	                break;
	            case EDITAR_COPIAR: 
	                trace("Você selecionou o menu Copiar");
	                break;
	            case EDITAR_RECORTAR: 
	                trace("Você selecionou o menu Recortar");
	                break;
	            case FORMATAR_FONTE: 
	                trace("Você selecionou o menu Formatar");
	                break;
	        }
	        return true;
	    }    
	     
	    private void trace (String msg) 
	    {
	        Toast.makeText (getApplicationContext(), msg, Toast.LENGTH_SHORT).show ();
	    }
	
	private void verificaVencedor(View arg, String codigo)
	{
		if ( this.verificaDiagonal(codigo) || this.verificaHorizontal(codigo) || this.verificaVertical(codigo))
		{
//			//parabens vc venceu!
//			Toast.makeText(this, "Parabens você venceu!!!!", Toast.LENGTH_SHORT).show();
			Intent it = new Intent(this, Activity02.class);
			it.putExtra("vencedor", jogadorA.getNome());
			startActivity(it);
		}
	}
	
	/*
	 * Metodo q verifica se há um vencedor na horizontal
	 * se os tres botoes da horizontal forem iguais 
	 */
	private boolean verificaHorizontal(String codigo)
	{
		if (   (but1.getText().equals(codigo) && but2.getText().equals(codigo) && but3.getText().equals(codigo)) 	
			|| (but4.getText().equals(codigo) && but5.getText().equals(codigo) && but6.getText().equals(codigo))
			|| (but7.getText().equals(codigo) && but8.getText().equals(codigo) && but9.getText().equals(codigo)) )
			return true;
		return false;
	}
	
	/*
	 * Metodo q verifica se há um vencedor na vertical
	 * se os tres botoes da vertical forem iguais 
	 */
	private boolean verificaVertical(String codigo)
	{
		if (   (but1.getText().equals(codigo) && but4.getText().equals(codigo) && but7.getText().equals(codigo)) 	
			|| (but2.getText().equals(codigo) && but5.getText().equals(codigo) && but8.getText().equals(codigo))
			|| (but3.getText().equals(codigo) && but6.getText().equals(codigo) && but9.getText().equals(codigo)) )
			return true;
		return false;
	}
	
	/*
	 * Metodo q verifica se há um vencedor na diagonal
	 * se os tres botoes da diagonal forem iguais 
	 */
	private boolean verificaDiagonal(String codigo)
	{
		if (   (but1.getText().equals(codigo) && but5.getText().equals(codigo) && but9.getText().equals(codigo)) 	
			|| (but3.getText().equals(codigo) && but5.getText().equals(codigo) && but7.getText().equals(codigo)) )
			return true;
		return false;
	}
	
	/*
	 * Metodo que inverte a vez do jogador, ao fim da rodada
	 */
	private void inverteVez()
	{
		jogadorA.setMinhaVez(jogadorB.getMinhaVez());
		jogadorB.setMinhaVez(!jogadorB.getMinhaVez());
	}
	
	/*
	 * Metodo que retorna o jogador q esta jogando, segundo a vez do jogador
	 */
	private boolean getJogadorDaVez()
	{
		return jogadorA.getMinhaVez() ? jogadorA.getMinhaVez() : jogadorB.getMinhaVez() ? jogadorB.getMinhaVez() : null; 
	}

	@Override
	public void onClick(View arg0) {
		Button but = (Button) arg0;
		if (jogadorA.getMinhaVez())
		{
			but.setText("p");
		}
		else
		{		
			but.setText("o");
		}
		but.setClickable(false);
		verificaVencedor(arg0, jogadorA.getMinhaVez() ? "p" : "o");
		this.inverteVez();
		//verificar se o jogo terminou se alguem ja ganhou, se empatou
	}
	
}