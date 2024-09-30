package it.dib.diadia;

import it.dib.diadia.ambienti.Labirinto;
import it.dib.diadia.ambienti.Stanza;
import it.dib.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  Raffaele Monti
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto labirinto;
	private boolean finita;
	private Giocatore giocatore;
	
	public Partita(){
		this.labirinto = new Labirinto();
		this.finita = false;
		giocatore = new Giocatore();
	}
	
	public Partita(int cfu, int pesoMax){
		this.labirinto = new Labirinto();
		this.finita = false;
		giocatore = new Giocatore(cfu, pesoMax);
	}
	
	public Stanza getStanzaVincente() {
		return labirinto.getStanzaVincente();
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		labirinto.setStanzaCorrente(stanzaCorrente);
	}

	public Stanza getStanzaCorrente() {
		return labirinto.getStanzaCorrente();
	}

	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return labirinto.getStanzaCorrente().getNome() == labirinto.getStanzaVincente().getNome();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
	

}
