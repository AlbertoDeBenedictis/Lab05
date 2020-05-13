package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DizionarioDAO {

	/**
	 * Data una stringa, controlla se è contenuta nel vocabolario
	 * 
	 * @param parola Stringa da cercare
	 * @return true se trovata, false se non trovata
	 */
	public boolean isCorrect(String parola) {
		
		// 0. Creo il boolean da restituire
		
		boolean trovato = false;

		// 1. Preparo la query generica
		String sql = "SELECT * FROM parola WHERE nome = ?";

		try {
			
			// 1.1 Prendo la connessione e preparo lo statement
			
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			// 1.2 Aggiungo la parola da cercare al posto di "?"
			
			st.setString(1, parola);
			
			// 1.3 Eseguo la query e scorro il puntatore del risultato
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {  // se entro nel for vuol dire che ho trovato un risultato
				
				trovato = true;
			}
			
			conn.close();
			
			return trovato;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

}
