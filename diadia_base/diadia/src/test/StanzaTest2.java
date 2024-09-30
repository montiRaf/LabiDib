package test;

import it.dib.diadia.ambienti.Stanza;
import it.dib.diadia.attrezzi.Attrezzo;

public class StanzaTest2 {
    public static void main(String[] args) {
        Stanza bar = new Stanza("Bar");
        Stanza mensa = new Stanza("Mensa");
        Attrezzo tazzina = new Attrezzo("Tazzina", 1);
        Attrezzo piatto = new Attrezzo("Piatto", 2);

        bar.impostaStanzaAdiacente("NORD", mensa);
        mensa.impostaStanzaAdiacente("SUD", bar);

        System.out.println(bar.addAttrezzo(tazzina));
        System.out.println(mensa.addAttrezzo(piatto));

        System.out.println(bar.getStanzaAdiacente("NORD").getAttrezzo("Piatto"));
        System.out.println(mensa.getStanzaAdiacente("SUD").getAttrezzo("Tazzina"));
    }
}
