package it.polito.tdp.anagrammi.model;

public class Parola {

	private String contenuto;
	private boolean corretta;

	
	
	
	
	
	@Override
	public String toString() {
		return contenuto +" "+corretta;
	}

	public Parola() {
		super();
	}

	public Parola(String contenuto, boolean corretta) {
		super();
		this.contenuto = contenuto;
		this.corretta = corretta;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}

	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}

	public String getContenuto() {
		return contenuto;
	}

	public boolean isCorretta() {
		return corretta;
	}

}
