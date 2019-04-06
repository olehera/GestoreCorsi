package it.polito.tdp.corsi;

import java.net.URL;
import java.util.*;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.GestoreCorsi;
import it.polito.tdp.corsi.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GestoreCorsiController {
	
	private GestoreCorsi model;
	
	public void setModel(GestoreCorsi m) {
		model = m;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtPeriodo;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnStatCorsi;
    
    @FXML
    private TextField txtCorso;

    @FXML
    private Button btnElencaStudenti;

    @FXML
    private Button btnStatCDS;

    @FXML
    private TextArea txtResult;
    
    @FXML
    void doCalcolaStatCDS(ActionEvent event) {

    }

    @FXML
    void doCalcolaStatCorsi(ActionEvent event) {
    	txtResult.clear();
    	int periodo;
    	
    	try {
    		periodo = Integer.parseInt(txtPeriodo.getText().trim());
    	} catch (NumberFormatException e) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	if(periodo != 1 && periodo != 2) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	
    	Map<Corso,Integer> res = model.getIscrittiCorsi(periodo);
		
		for(Entry<Corso, Integer> entry : res.entrySet()) 
			txtResult.appendText(((Corso)entry.getKey()).getNome() + "=" + entry.getValue() + "\n");

    }

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	txtResult.clear();
    	int periodo;
    	
    	try {
    		periodo = Integer.parseInt(txtPeriodo.getText().trim());
    	} catch(NumberFormatException nfe) {
    		txtResult.appendText("Devi inserire un periodo (1 0 2)");
    		return;
    	}
    	if (periodo != 1 && periodo != 2) {
    		txtResult.appendText("Devi inserire un periodo (1 0 2)");
    		return;
    	}
    	
    	List<Corso> corsi = this.model.getCorsiByPeriodo(periodo);
    	
    	for (Corso c : corsi) 
    		txtResult.appendText(c.toString()+"\n");
    	
    }
    
    @FXML
    void doElencaStudenti(ActionEvent event) {
    	txtResult.clear();
    	String codins = txtCorso.getText().trim();
    	List<Studente> studenti = this.model.elencaStudenti(codins);
    	
    	for (Studente s : studenti)
    		txtResult.appendText(s.toString()+"\n");

    }

    @FXML
    void initialize() {
        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnStatCorsi != null : "fx:id=\"btnStatCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnElencaStudenti != null : "fx:id=\"btnElencaStudenti\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnStatCDS != null : "fx:id=\"btnStatCDS\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
    }
}

