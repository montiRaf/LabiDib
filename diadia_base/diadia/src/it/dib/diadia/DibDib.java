package it.dib.diadia;


import java.util.Scanner;

import it.dib.diadia.ambienti.Stanza;
import it.dib.diadia.attrezzi.Attrezzo;
import it.dib.diadia.comandi.Comando;
import it.dib.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di dibdib, un semplice gioco di ruolo ambientato al dib (dipartimento di informatica).
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  Raffaele Monti
 *          
 * @version base
 */

public class DibDib {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	private Partita partita;
	private IO io;

	public DibDib(IO io) {
		this.partita = new Partita();
		this.io = new IOConsole();
	}

	public void gioca() {
		String istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		
		if(this.partita.vinta())
			System.out.println("Hai vinto!");
		if(!this.partita.giocatoreIsVivo())
			System.out.println("Hai esaurito i CFU");
		return this.partita.isFinita();
	}   
	
	
	public static void main(String[] argc) {
		IO io = new IOConsole();
		DibDib gioco = new DibDib(io);
		gioco.gioca();
	}
}