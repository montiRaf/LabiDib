package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.dib.diadia.ambienti.Stanza;
import it.dib.diadia.attrezzi.Attrezzo;

class StanzaTest {
	
	Stanza stanzaTest1;
	String direzioneTest;
	Stanza stanzaAdiacente;
	Attrezzo attrezzo;

	@BeforeEach
	public void setUp() {
		stanzaTest1 = new Stanza("Stanza Test 1");
		direzioneTest = "nord";
		stanzaAdiacente = new Stanza("Stanza adiacente");
		stanzaTest1.impostaStanzaAdiacente(direzioneTest, stanzaAdiacente);
		attrezzo = new Attrezzo("AttrezzoTest", 2);
	}
	
	@Test
	public void testAggiornaStanzaAdiacente() {
		assertEquals(1, stanzaTest1.getNumStanzeAdiacenti());
	}
	
	@Test
	public void testGetStanzaAdiacente() {
		assertEquals(stanzaAdiacente.getNome(), stanzaTest1.getStanzaAdiacente(direzioneTest).getNome());
	}
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(stanzaTest1.addAttrezzo(attrezzo));
	}
	
	@Test
	public void testAddAttrezzoFail() {
		for(int i = 0; i < 10; i++) {
			stanzaTest1.addAttrezzo(attrezzo);
		}
		assertFalse(stanzaTest1.addAttrezzo(attrezzo));
	}

}
