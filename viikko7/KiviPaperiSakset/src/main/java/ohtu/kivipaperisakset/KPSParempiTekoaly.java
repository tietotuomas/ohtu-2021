package ohtu.kivipaperisakset;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {

    public KPSParempiTekoaly(Scanner scanner, Tuomari tuomari, TekoalyParannettu parempiTekoaly) {
        super(scanner, tuomari, parempiTekoaly);
    }

    @Override
    protected String toisenSiirto() {
        String tokanSiirto = parempiTekoaly.annaSiirto();
        System.out.println("");
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        parempiTekoaly.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }

}
