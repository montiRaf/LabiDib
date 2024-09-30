package it.dib.diadia.giocatore;

import it.dib.diadia.attrezzi.Attrezzo;

public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	Borsa borsa;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		borsa = new Borsa();
	}
	
	public Giocatore(int cfu) {
		this.cfu = cfu;
		borsa = new Borsa();
	}
	
	public Giocatore(int cfu, int pesoMax) {
		this.cfu = cfu;
		borsa = new Borsa(pesoMax);
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public boolean prendiAttrezzo(Attrezzo attrezzo) {
		return borsa.addAttrezzo(attrezzo);
	}
	
	public Attrezzo posaAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		a = borsa.removeAttrezzo(nomeAttrezzo);
		return a;
	}

	public Borsa getBorsa() {
		return borsa;
	}

	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
	

}
