package it.dib.diadia.ambienti;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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
	
	private String nome;
    private Set<Attrezzo> attrezzi;
	private Map<String, Stanza> stanzeAdiacenti; // <Direzione, Stanza>
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new HashSet<>();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        if(stanzeAdiacenti.size() < NUMERO_MASSIMO_DIREZIONI) {
        	this.stanzeAdiacenti.put(direzione, stanza);
        }
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
       return this.stanzeAdiacenti.get(direzione);
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
    public Set<Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        return this.attrezzi.add(attrezzo);
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
    	for (String direzione : stanzeAdiacenti.keySet())
    		if (direzione!=null)
    			risultato.append(" " + direzione);
    	risultato.append("\nAttrezzi nella stanza: ");
    	if(attrezzi.size() != 0) {
        	for (Attrezzo a : attrezzi) {
        		risultato.append(a.getNome() + " ");
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
		Iterator<Attrezzo> it = attrezzi.iterator();
		while(it.hasNext()) {
			if(it.next().getNome().equalsIgnoreCase(nomeAttrezzo))
				return true;
		}
		return false;	
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato = null;
		for (Attrezzo a : attrezzi) {
			if (a.getNome().equalsIgnoreCase(nomeAttrezzo))
				attrezzoCercato = a;
		}
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param attrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return attrezzi.remove(attrezzo);
	}
	
	/**
	 * Restituisce il numero di attrezzi
	 * @return num attrezzi presenti nella stanza
	 */
	public int getNumAttrezzi() {
		return attrezzi.size();
	}

	public int getNumStanzeAdiacenti() {
		return stanzeAdiacenti.size();
	}

	public Set<String> getDirezioni() {
	    return stanzeAdiacenti.keySet();
    }

	
    public Collection<Stanza> getStanzeAdiacenti() {
		return stanzeAdiacenti.values();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		Stanza s = (Stanza)obj;
		return this.nome.equalsIgnoreCase(s.getNome());
	}
    
    

}