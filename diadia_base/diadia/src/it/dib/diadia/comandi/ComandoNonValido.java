package it.dib.diadia.comandi;

import it.dib.diadia.Partita;

public class ComandoNonValido implements Comando {

	@Override
	public void esegui(Partita partita) {
		System.out.println("Inserisci un comando valido");

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
