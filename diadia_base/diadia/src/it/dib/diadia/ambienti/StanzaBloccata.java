package it.dib.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	private String direzioneBloccata;
	private String attrezzoSbloccante;
	
	public StanzaBloccata(String nome, String direzione, String attrezzo) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.attrezzoSbloccante = attrezzo;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzioneBloccata) {
		if(this.hasAttrezzo(attrezzoSbloccante) == false) {
			// stanza bloccata
			return this;
		}else {
			return super.getStanzaAdiacente(direzioneBloccata);
		}
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoSbloccante) == false) {
			return "Stanza bloccata in direzione: " + direzioneBloccata;
		}else {
			return super.getDescrizione();
		}
	}
}
