package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	private AnagrammaDAO dao;
	private Ricerca ric;

	public Model() {
		dao=new AnagrammaDAO();
		ric=new Ricerca();
	}
	/**
	 * Data una parola calcola i possibili anagrammi e li confronta con il dizionario restituendo quelli present
	 * @param parola
	 * @return List<String>
	 */
	public List<String> getAnagrammiCorretti(String parola) {
		List<String> corretti=new ArrayList<String>();
		Set<String> anagrammi=new HashSet<String>(ric.anagrammi(parola));
		for(String s:anagrammi) {
			if(dao.isCorrect(s))
				corretti.add(s);
		}
		return corretti;
	}
	/**
	 * Data una parola calcola i possibili anagrammi e li confronta con il dizionario restituendo quelli non presenti
	 * @param parola
	 * @return List<String>
	 */
	public List<String> getAnagrammiErrati(String parola) {
		List<String> corretti=new ArrayList<String>();
		Set<String> anagrammi=new HashSet<String>(ric.anagrammi(parola));
		for(String s:anagrammi) {
			if(!dao.isCorrect(s))
				corretti.add(s);
		}
		return corretti;
	}
	
	
	
	

}
