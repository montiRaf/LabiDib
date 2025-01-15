package it.dib.diadia.comandi;

import it.dib.diadia.Partita;
import it.dib.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	
	String nomeAttrezzo;

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo != null) {
			if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo) == true) {
				Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
				partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				partita.getStanzaCorrente().addAttrezzo(a);
				System.out.println(nomeAttrezzo + " rimosso dalla tua borsa");
				System.out.println(partita.getGiocatore().getBorsa());
			}else {
				System.out.println("L'oggetto non è presente nella borsa");
				System.out.println(partita.getGiocatore().getBorsa());
			}
		}else {
			System.out.println("L'oggetto non è presente nella borsa");
		}

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

}
