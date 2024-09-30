package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.dib.diadia.Partita;
import it.dib.diadia.ambienti.Stanza;

class PartitaTest {
	
	Stanza biblioteca;
	Partita partita;

	@BeforeEach
	void setUp() throws Exception {
		partita = new Partita();
		biblioteca = new Stanza("Biblioteca");
		partita.setStanzaCorrente(biblioteca);
	}
	
	@Test
	void testGetStanzaVincente() {
		assertEquals("Biblioteca", partita.getStanzaVincente().getNome());
	}

	@Test
	void testVinta() {
		assertTrue(partita.vinta());
	}

}
