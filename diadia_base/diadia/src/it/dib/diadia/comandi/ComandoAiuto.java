package it.dib.diadia.comandi;

import it.dib.diadia.Partita;

public class ComandoAiuto implements Comando {

	static final private String[] elencoComandi = {"vai", "prendi", "posa", "guarda", "aiuto", "fine"};
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.println(elencoComandi[i] + " ");
		System.out.println(" ");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
