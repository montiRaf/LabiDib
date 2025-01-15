package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.dib.diadia.ambienti.Stanza;
import it.dib.diadia.ambienti.StanzaMagica;
import it.dib.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {

	Stanza stanza;
	StanzaMagica stanzaMagica;
	Attrezzo a1, a2, a3;
	
	
	@BeforeEach
	void setUp() throws Exception {
		stanza = new Stanza("test");
		stanzaMagica = new StanzaMagica("magica", 2);
		a1 = new Attrezzo("Martello", 1);
		a2 = new Attrezzo("Ascia", 2);
		a3 = new Attrezzo("Coltello", 3);
		
	}

	@Test
	void modificaAttrezzotest() {
		stanzaMagica.addAttrezzo(a1);
		stanzaMagica.addAttrezzo(a2);
		stanzaMagica.addAttrezzo(a3);
		assertEquals("olletloC", a3.getNome());
		assertEquals(6, a3.getPeso());
		assertEquals("Martello", a1.getNome());
		assertEquals(1, a1.getPeso());
	}

}
