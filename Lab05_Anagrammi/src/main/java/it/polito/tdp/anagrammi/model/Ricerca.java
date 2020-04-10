package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ricerca {
	
	private Set<String> soluzione;
	int n;
	
	public Set<String> anagrammi(String parola) {
		soluzione=new HashSet<String>();
		
		parola=parola.toLowerCase();
		
		List<Character> disponibili =new ArrayList<Character>();
		for(int i=0;i<parola.length();i++) {
			disponibili.add(parola.charAt(i));
		}
		n=parola.length();
		ricorsione("",0,disponibili);
		return this.soluzione;
	}

	private void ricorsione(String parziale, int livello, List<Character> disponibili) {
		if(parziale.length()==this.n) {
			this.soluzione.add(parziale);
		}
		for(Character ch:disponibili) {
			String possibile=parziale+ch;
			
			List<Character> rimanenti=new ArrayList<Character>();
			rimanenti.addAll(disponibili);
			rimanenti.remove(ch);
			
			ricorsione(possibile, livello+1, rimanenti);
		}
		
	}

}
