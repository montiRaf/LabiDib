package it.dib.diadia.ambienti;

import it.dib.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {
	private int sogliaMagica;	// num di attrezzi da posare prima che si attivi il comp magico
	private final static int SOGLIA_MAGICA_DEFAULT = 3;
	
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.sogliaMagica = soglia;
	}
	
	public StanzaMagica(String nome) {
		super(nome);
	}
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		String nomeAttrezzo = attrezzo.getNome();
		String nomeInvertito = new StringBuilder(nomeAttrezzo).reverse().toString();
		attrezzo.setNome(nomeInvertito);
		attrezzo.setPeso(attrezzo.getPeso()*2);
		return attrezzo;
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(super.getNumAttrezzi() >= this.sogliaMagica || super.getNumAttrezzi() >= SOGLIA_MAGICA_DEFAULT) {
			// la stanza si comporta magicamente modificando l'attrezzo
			modificaAttrezzo(attrezzo);
			return super.addAttrezzo(attrezzo);
		}
		return super.addAttrezzo(attrezzo);
		
    }
	
	
}
