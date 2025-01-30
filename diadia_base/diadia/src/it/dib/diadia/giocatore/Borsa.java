package it.dib.diadia.giocatore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.dib.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	// private Attrezzo[] attrezzi;
	private List<Attrezzo> attrezzi; 
	private int numeroAttrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>();
		this.numeroAttrezzi = 0;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		// possiamo aggiungere un attrezzo
		this.attrezzi.add(attrezzo);
		this.numeroAttrezzi++;
		return true;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi.get(i).getNome().equalsIgnoreCase(nomeAttrezzo))
				a = attrezzi.get(i);
		return a;
	}
	
	public int getPeso() {
		int peso = 0;
		
		for (int i= 0; i<this.numeroAttrezzi; i++)
		peso += this.attrezzi.get(i).getPeso();
		return peso;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
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
					this.numeroAttrezzi--;
					return a;
				}
			}
		}
		return a;
	}
		
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi.get(i).toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
		}
	}