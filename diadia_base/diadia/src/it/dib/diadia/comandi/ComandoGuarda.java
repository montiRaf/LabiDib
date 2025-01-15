package it.dib.diadia.comandi;

import it.dib.diadia.Partita;
import it.dib.diadia.ambienti.Stanza;
import it.dib.diadia.attrezzi.Attrezzo;
import it.dib.diadia.giocatore.Giocatore;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita) {
		System.out.println("---------------------------------------------------------------");
		Giocatore g = partita.getGiocatore();
		System.out.println("STATO PARTITA: " + g.getCfu() + "CFU");
		System.out.println("BORSA: " + g.getBorsa());
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		System.out.println("STANZA CORRENTE: " + stanzaCorrente.getNome());
		if(stanzaCorrente.getNumStanzeAdiacenti() > 0) {
			System.out.print("DIREZIONI DISPONIBILI: ");
			String[] s = stanzaCorrente.getDirezioni();
			for(int i = 0; i < stanzaCorrente.getNumStanzeAdiacenti(); i++) {
				System.out.print(s[i] + " | ");
			}
			System.out.println("");
		}else {
			System.out.println("Non ci sono stanze adiacenti");
		}
		
		if(stanzaCorrente.getNumAttrezzi() > 0) {
			System.out.print("ATTREZZI: ");
			Attrezzo[] a = stanzaCorrente.getAttrezzi();
			for(int i = 0; i < stanzaCorrente.getNumAttrezzi(); i++) {
				System.out.print(a[i] + " | ");
			}
			System.out.println("");
		}else {
			System.out.println("Non ci sono attrezzi nella stanza");
		}
		System.out.println("---------------------------------------------------------------\n");
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
