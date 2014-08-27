package com.example.jogodavelha;

public class Jogador 
{
	private String nome;
	private String figura;
	private boolean minhaVez;
	
	public Jogador() {}
	
	public Jogador(String nome)
	{
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getFigura() {
		return figura;
	}
	
	public boolean getMinhaVez() {
		return minhaVez;
	}
	
	public void setMinhaVez(boolean minhaVez) {
		this.minhaVez = minhaVez;
	}
	
	public void setFigura(String figura) {
		this.figura = figura;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
