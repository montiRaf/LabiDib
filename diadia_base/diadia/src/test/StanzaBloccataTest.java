package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.dib.diadia.ambienti.StanzaBloccata;
import it.dib.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	private StanzaBloccata sb;
	private StanzaBloccata sb1;
	private Attrezzo chiave;
	private Attrezzo martello;

	@BeforeEach
	void setUp() throws Exception {
		chiave = new Attrezzo("Chiave", 1);
		martello = new Attrezzo("Martello", 2);
		sb = new StanzaBloccata("Aula NB", "Nord", chiave);
		sb1 = new StanzaBloccata("Aula B", "Sud", martello);
		sb.addAttrezzo(chiave);
		sb.impostaStanzaAdiacente("Nord", sb1);
		sb1.addAttrezzo(chiave);
	}

	@Test
	void stanzaBloccata() {
		assertEquals(sb1, sb1.getStanzaAdiacente("Sud"));
	}
	
	@Test
	void stanzaNonBloccata() {
		assertNotEquals(sb, sb.getStanzaAdiacente("Nord"));
	}

}
