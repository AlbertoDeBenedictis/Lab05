/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Parola;
import it.polito.tdp.anagrammi.model.Ricerca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Ricerca ricerca = new Ricerca();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnagrammi"
    private Button btnAnagrammi; // Value injected by FXMLLoader

    @FXML // fx:id="txtGiusti"
    private TextArea txtGiusti; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrati"
    private TextArea txtErrati; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doAnagrammi(ActionEvent event) {
    	
    	txtGiusti.clear();
    	txtErrati.clear();
    	
    	// Se ancora non ho scritto la parola stampo un errore
    	
    	if(txtParola.getText().equals("")) {
    		txtGiusti.setText("ERRORE: Digitare una parola per ottenere gli anagrammi");
    		return;
    	}
    	
    	// Altrimenti procedo con l'algoritmo
    	
    	String parola = txtParola.getText();
    	List<Parola> anagrammi = this.ricerca.anagrammi(parola);
    	
    	// Dalla lista di parola, suddivido le giuste e le sbagliate e le stampo
    	
    	for(Parola p: anagrammi) {
    		if(p.isCorretta()) {
    			txtGiusti.appendText(p.getContenuto()+"\n");
    		}
    		else {
    			txtErrati.appendText(p.getContenuto()+"\n");
    		}
    	}
    	
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	// Semplicemente pulisco tutto
    	
    	txtParola.clear();
    	txtGiusti.clear();
    	txtErrati.clear();
    

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnagrammi != null : "fx:id=\"btnAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtGiusti != null : "fx:id=\"txtGiusti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
