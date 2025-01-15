package it.dib.diadia.ambienti;

import it.dib.diadia.IO;

/**
 * Stanza Buia: se in questa stanza non è presente un attrezzo con
 * nome particolare il metodo getDescrizione() ritorna la stringa
 * "qui c'è buio pesto"
 */

public class StanzaBuia extends Stanza {
	private String attrezzoLuminoso;	// nome dell'attrezzo che consente di vedere
	
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzoLuminoso = attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoLuminoso) == true) {
			return super.getDescrizione();
		}else {
			return "Qui c'è buio pesto";
		}
	}
	
}
