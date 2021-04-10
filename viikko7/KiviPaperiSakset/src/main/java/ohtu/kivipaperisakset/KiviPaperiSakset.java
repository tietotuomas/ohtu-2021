/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KiviPaperiSakset {

    Scanner scanner;
    Tuomari tuomari;
    Tekoaly tekoaly;
    TekoalyParannettu parempiTekoaly;
    public String ekanSiirto;

    public KiviPaperiSakset(Scanner scanner, Tuomari tuomari) {
        this.scanner = scanner;
        this.tuomari = tuomari;

    }

    public KiviPaperiSakset(Scanner scanner, Tuomari tuomari, Tekoaly tekoaly) {
        this(scanner, tuomari);
        this.tekoaly = tekoaly;
    }

    public KiviPaperiSakset(Scanner scanner, Tuomari tuomari, TekoalyParannettu tekoaly) {
        this(scanner, tuomari);
        this.parempiTekoaly = tekoaly;
    }

    // tämä on ns template metodit
    public void pelaa() {

        ekanSiirto = ensimmaisenSiirto();
        String tokanSiirto = toisenSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
            ekanSiirto = ensimmaisenSiirto();
            tokanSiirto = toisenSiirto();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    protected String ensimmaisenSiirto() {
        System.out.println("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }

    // tämä on abstrakti metodi sillä sen toteutus vaihtelee eri pelityypeissä
    abstract protected String toisenSiirto();

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
