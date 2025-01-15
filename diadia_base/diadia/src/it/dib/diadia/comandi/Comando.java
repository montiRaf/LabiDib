package it.dib.diadia.comandi;


import java.util.Scanner;

import it.dib.diadia.Partita;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *  
 *  Per esercizio è stata successivamente trasformata in una interfaccia
 *
 * @author  Raffaele Monti
 * @version base
 */

public interface Comando {
	
	/**
	 * Semantica del comando specifico
	 * @param partita
	 */
	public void esegui(Partita partita);
	
	/**
	 * set parametro del comando
	 * @param parametro
	 */
	public void setParametro(String parametro);

//	private String nome;
//    private String parametro;
//
//    public Comando(String istruzione) {
//		Scanner scannerDiParole = new Scanner(istruzione);
//
//		// prima parola: nome del comando
//		if (scannerDiParole.hasNext())
//			this.nome = scannerDiParole.next(); 
//
//		// seconda parola: eventuale parametro
//		if (scannerDiParole.hasNext())
//			this.parametro = scannerDiParole.next();
//    }
//
//    public String getNome() {
//        return this.nome;
//    }
//
//    public String getParametro() {
//        return this.parametro;
//    }
//
//    public boolean sconosciuto() {
//        return (this.nome == null);
//    }
}