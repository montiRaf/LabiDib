package test;

import it.dib.diadia.ambienti.Stanza;

public class StanzaTest1 {
    public static void main(String[] args) {
        Stanza bar = new Stanza("Bar");
        Stanza mensa = new Stanza("Mensa");
        bar.impostaStanzaAdiacente("NORD", mensa);
        mensa.impostaStanzaAdiacente("SUD", bar);

        // System.out.println(bar);

        System.out.println(bar.getStanzaAdiacente("NORD"));
        System.out.println(mensa.getStanzaAdiacente("SUD"));
    }
}
