package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.SortedSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.dib.diadia.attrezzi.Attrezzo;
import it.dib.diadia.giocatore.Borsa;

class BorsaTest {
	Borsa b;
	Attrezzo piuma = new Attrezzo("Piuma", 1);
	Attrezzo libro = new Attrezzo("Libro", 5);
	Attrezzo piombo = new Attrezzo("Piombo", 10);
	Attrezzo martello = new Attrezzo("Martello", 10);
	Attrezzo ps = new Attrezzo("Ps", 5);

	@BeforeEach
	void setUp() throws Exception {
		b = new Borsa(50);
		b.addAttrezzo(piuma);
		b.addAttrezzo(libro);
		b.addAttrezzo(piombo);
		b.addAttrezzo(ps);
		b.addAttrezzo(martello);
	}

	@Test
	void testOrdinamento() {
		SortedSet<Attrezzo> l = b.getSortedSetOrdinatoPerPeso();
		assertEquals(piuma.getNome(), l.getFirst().getNome());
	}

}
