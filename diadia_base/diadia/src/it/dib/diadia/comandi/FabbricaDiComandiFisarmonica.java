package it.dib.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{

	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		
		if(scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();	// prima parola: nome del comando
		if(scannerDiParole.hasNext())
			parametro = scannerDiParole.next();		// seconda parola: eventuale paramentro
		
		if(nomeComando == null) 
			comando = new ComandoNonValido();
		else if(nomeComando.equalsIgnoreCase("vai"))
			comando = new ComandoVai();
		else if(nomeComando.equalsIgnoreCase("prendi"))
			comando = new ComandoPrendi();
		else if(nomeComando.equalsIgnoreCase("posa"))
			comando = new ComandoPosa();
		else if(nomeComando.equalsIgnoreCase("aiuto"))
			comando = new ComandoAiuto();
		else if(nomeComando.equalsIgnoreCase("fine"))
			comando = new ComandoFine();
		else if(nomeComando.equalsIgnoreCase("guarda"))
			comando = new ComandoGuarda();
		else
			comando = new ComandoNonValido();
		comando.setParametro(parametro);
		return comando;
	}
}
