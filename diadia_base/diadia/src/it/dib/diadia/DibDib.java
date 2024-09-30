package it.dib.diadia;


import java.util.Scanner;

import it.dib.diadia.ambienti.Stanza;
import it.dib.diadia.attrezzi.Attrezzo;

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
	
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto", "fine"};

	private Partita partita;
	private IOConsole io;

	public DibDib(IOConsole io) {
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
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equalsIgnoreCase("fine")) {
			this.fine(); 
			return true;
		}else if (comandoDaEseguire.getNome().equalsIgnoreCase("vai")){
			this.vai(comandoDaEseguire.getParametro());	
		}else if (comandoDaEseguire.getNome().equalsIgnoreCase("aiuto")){
			this.aiuto();
		}else if(comandoDaEseguire.getNome().equalsIgnoreCase("prendi")){
			this.prendiAttrezzo(comandoDaEseguire.getParametro());
		}else if(comandoDaEseguire.getNome().equalsIgnoreCase("posa")){
			this.posaAttrezzo(comandoDaEseguire.getParametro());
		}else
			io.mostraMessaggio("Comando sconosciuto");
		
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i] + " ");
		io.mostraMessaggio(" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	
	private void prendiAttrezzo(String nomeAttrezzo) {
		if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo) == true) {
			io.mostraMessaggio("Oggetto presente nella stanza!");
			Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().removeAttrezzo(a);
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			io.mostraMessaggio(nomeAttrezzo + " aggiunto alla tua borsa");
			System.out.println(partita.getGiocatore().getBorsa());
		}else {
			io.mostraMessaggio("L'oggetto non è presente nella stanza");
			System.out.println(partita.getGiocatore().getBorsa());
		}

	}
	
	private void posaAttrezzo(String nomeAttrezzo) {
		if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo) == true) {
			Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().addAttrezzo(a);
			io.mostraMessaggio(nomeAttrezzo + " rimosso dalla tua borsa");
			System.out.println(partita.getGiocatore().getBorsa());
		}else {
			io.mostraMessaggio("L'oggetto non è presente nella borsa");
			System.out.println(partita.getGiocatore().getBorsa());
		}

	}
	
	public static void main(String[] argc) {
		IOConsole io = new IOConsole();
		DibDib gioco = new DibDib(io);
		gioco.gioca();
	}
}