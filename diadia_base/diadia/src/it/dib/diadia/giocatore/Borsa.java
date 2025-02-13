package it.dib.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.dib.diadia.attrezzi.AttrezziComparator;
import it.dib.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi; 
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>();
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.add(attrezzo);
		return true;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i < attrezzi.size(); i++)
			if (this.attrezzi.get(i).getNome().equalsIgnoreCase(nomeAttrezzo))
				a = attrezzi.get(i);
		return a;
	}
	
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i < attrezzi.size(); i++)
			peso += this.attrezzi.get(i).getPeso();
		return peso;
	}
	
	public boolean borsaIsEmpty() {
		return attrezzi.isEmpty();
	}
		
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
		
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(hasAttrezzo(nomeAttrezzo) == true) {
			Iterator<Attrezzo> it = attrezzi.iterator();
			while(it.hasNext()) {
				a = it.next();
				if(a.getNome().equalsIgnoreCase(nomeAttrezzo) == true) {
					it.remove();
					return a;
				}
			}
		}
		return a;
	}
		
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.borsaIsEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i < attrezzi.size(); i++)
				s.append(attrezzi.get(i).toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
		}
	
	/**
	 * 
	 * @return lista degli attrezzi nella borsa ordinati per peso, a parità di peso, per nome
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> attrOrd = attrezzi;
		Collections.sort(attrOrd, new AttrezziComparator());
		return attrOrd;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> insieme = new TreeSet<>(new AttrezziComparator());
		insieme.addAll(attrezzi);
		return insieme;
		
	}
	
	/**
	 * 
	 * @return insieme di attrezzi nella borsa ordinati per nome
	 */
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> attrOrd = new TreeSet<Attrezzo>(attrezzi);
		return attrOrd;
	}
	
	/**
	 * 
	 * @return mappa che associa un intero (peso) con l'insieme degli attrezzi di tale peso
	 */
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
	    Map<Integer, Set<Attrezzo>> insieme = new HashMap<>();
	    
	    for (Attrezzo a : attrezzi) {
	        int peso = a.getPeso();
	        
	        // Ottieni il set esistente o creane uno nuovo
	        insieme.putIfAbsent(peso, new HashSet<>());
	        
	        // Aggiungi l'attrezzo al set corrispondente
	        insieme.get(peso).add(a);
	    }
	    
	    return insieme;
	}

	
	// metodo main per i test
	public static void main(String[] args) {
		Borsa b = new Borsa(50);
		Attrezzo piuma = new Attrezzo("Piuma", 1);
		Attrezzo libro = new Attrezzo("Libro", 5);
		Attrezzo piombo = new Attrezzo("Piombo", 10);
		Attrezzo martello = new Attrezzo("Martello", 10);
		Attrezzo ps = new Attrezzo("Ps", 5);
		b.addAttrezzo(piuma);
		b.addAttrezzo(libro);
		b.addAttrezzo(piombo);
		b.addAttrezzo(ps);
		b.addAttrezzo(martello);
		
		// List<Attrezzo> l = b.getContenutoOrdinatoPerPeso();
		SortedSet<Attrezzo> l = b.getSortedSetOrdinatoPerPeso();
		// Map<Integer, Set<Attrezzo>> l = b.getContenutoRaggruppatoPerPeso();
		System.out.println(l);	
		
	}
	
}



