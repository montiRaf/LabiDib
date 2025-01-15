package it.dib.diadia.comandi;

import it.dib.diadia.Partita;
import it.dib.diadia.ambienti.Stanza;

/**
 * Comando che permette di cambiare stanza
 */
public class ComandoVai implements Comando {

	private String direzione;
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(direzione == null) {
			System.out.println("Dove vuoi andare? Devi specificare una direzione");
			return;
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		if(prossimaStanza == null) {
			System.out.println("Direzione inesistente");
			return;
		}
		
		partita.setStanzaCorrente(prossimaStanza);
		System.out.println(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
}
