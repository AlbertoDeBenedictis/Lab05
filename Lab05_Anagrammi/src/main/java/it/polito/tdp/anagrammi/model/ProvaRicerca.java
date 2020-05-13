package it.polito.tdp.anagrammi.model;

import java.util.List;

public class ProvaRicerca {

	public static void main(String[] args) {
	
		Ricerca r = new Ricerca();
		
		String prova1 = "pesca";
		
		List<Parola> anagrammi_pesca = r.anagrammi(prova1);
		
		System.out.println(anagrammi_pesca);
	}

}
