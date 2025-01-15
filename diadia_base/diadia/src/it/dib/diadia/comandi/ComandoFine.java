package it.dib.diadia.comandi;

import it.dib.diadia.Partita;

public class ComandoFine implements Comando {

	@Override
	public void esegui(Partita partita) {
		System.out.println("Grazie di aver giocato!");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
