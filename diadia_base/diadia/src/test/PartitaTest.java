package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.dib.diadia.Partita;
import it.dib.diadia.ambienti.Labirinto;
import it.dib.diadia.ambienti.LabirintoBuilder;
import it.dib.diadia.ambienti.Stanza;

class PartitaTest {
	
	Stanza biblioteca;
	Partita partita;
	Labirinto monolocale;

	@BeforeEach
	void setUp() throws Exception {
		monolocale = new LabirintoBuilder()
				.addStanzaIniziale("salotto") 
				.addStanzaVincente("salotto") 
				.getLabirinto();
		partita = new Partita(monolocale);
	}
	
	@Test
	void testGetStanzaVincente() {
		assertEquals("salotto", partita.getStanzaVincente().getNome());
	}

	@Test
	void testVinta() {
		assertTrue(partita.vinta());
	}

}
