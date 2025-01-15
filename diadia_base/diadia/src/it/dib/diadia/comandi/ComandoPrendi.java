package it.dib.diadia.comandi;

import it.dib.diadia.Partita;
import it.dib.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo != null) {
			if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo) == true) {
				System.out.println("Oggetto presente nella stanza!");
				Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
				partita.getStanzaCorrente().removeAttrezzo(a);
				partita.getGiocatore().getBorsa().addAttrezzo(a);
				System.out.println(nomeAttrezzo + " aggiunto alla tua borsa");
				System.out.println(partita.getGiocatore().getBorsa());
			}else {
				System.out.println("L'oggetto non è presente nella stanza");
				System.out.println(partita.getGiocatore().getBorsa());
			}
		}
		
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;	
	}
}
