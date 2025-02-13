package it.dib.diadia.ambienti;

import it.dib.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza {
	private String direzioneBloccata;
	private Attrezzo attrezzoSbloccante;		// attrezzo che permette di sbloccare la direzione
	
	public StanzaBloccata(String nome, String direzione, Attrezzo attrezzo) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.attrezzoSbloccante = attrezzo;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.direzioneBloccata.equalsIgnoreCase(direzione) && this.hasAttrezzo(attrezzoSbloccante.getNome()) == false) {
			// stanza bloccata, restituisce la stanza corrente
			return this;
		}else {
			// la stanza contiene l'attrezzo sboccante
			return super.getStanzaAdiacente(direzione);
		}
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoSbloccante.getNome()) == false) {
			return "Stanza bloccata in direzione: " + direzioneBloccata;
		}else {
			return super.getDescrizione();
		}
	}
}
