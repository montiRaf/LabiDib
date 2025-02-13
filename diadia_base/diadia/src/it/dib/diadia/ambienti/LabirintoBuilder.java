package it.dib.diadia.ambienti;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import it.dib.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder{

	private Labirinto labirinto;
	private Stanza ultimaStanza;
	
	public LabirintoBuilder() {
		labirinto = new Labirinto();
	}
	
	public LabirintoBuilder addStanzaIniziale(String nome) {
		Stanza stanza = new Stanza(nome);
		labirinto.setStanzaCorrente(stanza);
		labirinto.addStanza(stanza);
		ultimaStanza = stanza;
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String nome) {
		Stanza stanza = new Stanza(nome);
		labirinto.setStanzaVincente(stanza);
		labirinto.addStanza(stanza);
		ultimaStanza = stanza;
		return this;
	}
	
	public LabirintoBuilder addStanza(String nome) {
		Stanza stanza = new Stanza(nome);
		labirinto.addStanza(stanza);
		ultimaStanza = stanza;
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String nomeStanza1, String nomeStanza2, String direzione) {
		Stanza stanza1 = labirinto.getStanza(nomeStanza1);
		Stanza stanza2 = labirinto.getStanza(nomeStanza2);
		if(stanza1 != null && stanza2 != null) {
			stanza1.impostaStanzaAdiacente(direzione, stanza2);
		}
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nome, int peso) {
		Attrezzo at = new Attrezzo(nome, peso);
		if(ultimaStanza != null) {
			ultimaStanza.addAttrezzo(at);
		}
		return this;
	}
	
	public Labirinto getLabirinto() {
		return labirinto;
	}
	
	public static void main(String[] args) {
		Labirinto monolocale = new LabirintoBuilder().addStanzaIniziale("salotto").addStanzaVincente("cucina").addAdiacenza("Salotto", "Cucina", "nord").getLabirinto();	
		System.out.println(monolocale.getStanze());
		System.out.println();
		
		Labirinto trilocale = new LabirintoBuilder()
                .addStanzaIniziale("salotto")
                .addStanza("cucina")
                .addAttrezzo("pentola", 1)
                .addStanzaVincente("camera")
                .addStanza("camera")
                .addAdiacenza("salotto", "cucina", "nord")
                .addAdiacenza("cucina", "camera", "est")
                .getLabirinto();
		System.out.println(trilocale.getStanze());
	}
}
