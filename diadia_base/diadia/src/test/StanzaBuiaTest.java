package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.dib.diadia.ambienti.Stanza;
import it.dib.diadia.ambienti.StanzaBuia;
import it.dib.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

	StanzaBuia stanza;
	Attrezzo lanterna;
	String buio = "Qui c'è buio pesto";
	
	@BeforeEach
	void setUp() throws Exception {
		stanza = new StanzaBuia("Buia Test", "Lanterna");
		lanterna = new Attrezzo("Lanterna", 1);
	}

	@Test
	void stanzaBuia() {
		assertEquals(buio, stanza.getDescrizione());
	}
	
	@Test
	void stanzaBuiaConAttrezzo() {
		Attrezzo martello = new Attrezzo("Martello", 2);
		assertEquals(buio, stanza.getDescrizione());
	}
	
	
	@Test
	void stanzaNonBuia() {
		stanza.addAttrezzo(lanterna);
		assertNotEquals(buio, stanza.getDescrizione());
	}

}
