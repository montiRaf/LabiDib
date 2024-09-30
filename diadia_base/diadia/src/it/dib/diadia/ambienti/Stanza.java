package it.dib.diadia.ambienti;

import it.dib.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author Raffaele Monti
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
    private Attrezzo[] attrezzi;
    private int numeroAttrezzi;
    private Stanza[] stanzeAdiacenti;
    private int numeroStanzeAdiacenti;
	private String[] direzioni;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        // boolean aggiornato = false;
        
        if(this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
        	this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
        	this.direzioni[numeroStanzeAdiacenti] = direzione;
        	this.numeroStanzeAdiacenti++;
        }
        
        /*
    	for(int i=0; i<this.direzioni.length; i++) {
			if(numeroStanzeAdiacenti == 0){	// prima stanza
				this.stanzeAdiacenti[i] = stanza;
				aggiornato = true;
			}else if (direzione.equalsIgnoreCase(this.direzioni[i])) {
				this.stanzeAdiacenti[i] = stanza;
				aggiornato = true;
			}
		}
    	if (aggiornato == true) {
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.direzioni[numeroStanzeAdiacenti] = direzione;
				this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
				this.numeroStanzeAdiacenti++;
			}
		}*/
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = null;
		for(int i=0; i<this.numeroStanzeAdiacenti; i++) {
			if (this.direzioni[i].equalsIgnoreCase(direzione))
				stanza = this.stanzeAdiacenti[i];
		}
        return stanza;
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Attrezzo[] getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
        	this.attrezzi[numeroAttrezzi] = attrezzo;
        	this.numeroAttrezzi++;
        	return true;
        }
        else {
        	return false;
        }
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	for (String direzione : this.direzioni)
    		if (direzione!=null)
    			risultato.append(" " + direzione);
    	risultato.append("\nAttrezzi nella stanza: ");
    	if(this.numeroAttrezzi != 0) {
        	for (int i = 0; i < this.numeroAttrezzi; i++) {
        		risultato.append(attrezzi[i].toString()+" ");
        	}
    	}else {
    		risultato.append("non ci sono attrezzi nella stanza");
    	}

    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for (int i = 0; i < this.numeroAttrezzi; i++) {
			if (attrezzi[i].getNome().equalsIgnoreCase(nomeAttrezzo))
				trovato = true;
		}
		return trovato;
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato = null;
		for (int i = 0; i < numeroAttrezzi; i++) {
			if (attrezzi[i].getNome().equalsIgnoreCase(nomeAttrezzo))
				attrezzoCercato = attrezzi[i];
		}
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param attrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		for(int i = 0; i < this.numeroAttrezzi; i++) {
			if(attrezzi[i].getNome().equalsIgnoreCase(attrezzo.getNome()) == true) {
				for(int j = i; j < this.numeroAttrezzi-1; j++) {
					attrezzi[j] = attrezzi[j+1];
				}
				return true;
			}
		}
		return false;
	}
	

	public int getNumStanzeAdiacenti() {
		return numeroStanzeAdiacenti;
	}

	public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
	    for(int i=0; i<this.numeroStanzeAdiacenti; i++)
	    	direzioni[i] = this.direzioni[i];
	    return direzioni;
    }

}