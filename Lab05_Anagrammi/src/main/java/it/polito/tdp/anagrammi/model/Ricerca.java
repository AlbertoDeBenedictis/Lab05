package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.DizionarioDAO;

public class Ricerca {

	DizionarioDAO dizionario = new DizionarioDAO();

	private List<Parola> soluzione;

	public boolean isCorrect(String parola) {
		return dizionario.isCorrect(parola);
	}

	public List<Parola> anagrammi(String parola) {

		// 1. Sistemo il parametro
		parola = parola.toUpperCase();

		// 2. Inizializzo l'elenco di anagrammi
		this.soluzione = new ArrayList<Parola>();

		// 3. Itero sulla parola per avere una lista di caratteri

		List<Character> disponibili = new ArrayList<>();

		for (int i = 0; i < parola.length(); i++) {
			disponibili.add(parola.charAt(i));
		}

		// 4. Inizio la ricorsione!!!
		cerca("", 0, disponibili);

		return this.soluzione;
	}

	/**
	 * Data una soluzione parziale e dei caratteri disponibili, prova tutti le
	 * combinazioni possibili e, una volta soddisfatta la condizione terminale, le
	 * aggiunge alla soluzione
	 * 
	 * @param parziale    Soluzione parziale (parte dell'anagramma)
	 * @param livello     Numero di caratteri contenuti nella sol. parziale
	 * @param disponibili Caratteri rimasti da iterare
	 */
	private void cerca(String parziale, int livello, List<Character> disponibili) {

		// 1. CASO TERMINALE (non ho più caratteri da provare)

		if (disponibili.size() == 0) {

			// Aggiungo la nuova parola alla soluzione, controllando nel dizionario
				this.soluzione.add(new Parola(parziale, this.dizionario.isCorrect(parziale)));
			}
		

		// 2. CASO NORMALE (aggiungo a giro un carattere tra quelli disponibili e
		// richiamo la funzione)

		for (Character ch : disponibili) {

			// 2.1 Attacco alla soluzione parziale il primo dei caratteri disponibili

			String tentativo = parziale + ch;

			// 2.2 Creo una nuova lista di disponibili per rimuovere il carattere che ho
			// appena aggiunto nella soluzione parziale

			List<Character> rimanenti = new ArrayList<>(disponibili); // costruttore a partire da una altra lista
			rimanenti.remove(ch);

			// 2.3 RICHIAMO LA FUNZIONE STESSA, facendola passare al livello successivo
			// (parziale----> tentativo, livello + 1, rimanenti)

			cerca(tentativo, livello + 1, rimanenti);

		}

	}

}
