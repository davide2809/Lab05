package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model=new Model();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnagrammi"
    private Button btnAnagrammi; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorretti"
    private TextArea txtCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrati"
    private TextArea txtErrati; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doAnagrammi(ActionEvent event) {
    	String parola=txtParola.getText();
    	if(parola.length()==0) {
    		txtCorretti.appendText("Inserisci una parola");
    		return;
    	}
    	List<String> corrette=new ArrayList<String>(model.getAnagrammiCorretti(parola));
    	List<String> errate=new ArrayList<String>(model.getAnagrammiErrati(parola));
    	for(String s:corrette)
    		txtCorretti.appendText(s+"\n");
    	for(String s:errate)
    		txtErrati.appendText(s+"\n");
    	txtParola.clear();

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	txtParola.clear();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Untitled'.";
        assert btnAnagrammi != null : "fx:id=\"btnAnagrammi\" was not injected: check your FXML file 'Untitled'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Untitled'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Untitled'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Untitled'.";

    }

	public void setModel(Model model) {
		this.model=model;
		
	}
}
