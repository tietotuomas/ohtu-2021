/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Kayttoliittyma {

    private static final Scanner scanner = new Scanner(System.in);
    Tuomari tuomari = new Tuomari();
    Tekoaly tekoaly = new Tekoaly();
    TekoalyParannettu parempiTekoaly = new TekoalyParannettu(20);

    public void kaynnista() {

        while (true) {
            tulostaValinnat();
            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                tulostaOhje();
                KiviPaperiSakset kaksinpeli = new KPSPelaajaVsPelaaja(scanner, tuomari);
                kaksinpeli.pelaa();
            } else if (vastaus.endsWith("b")) {
                tulostaOhje();
                KiviPaperiSakset yksinpeli = new KPSTekoaly(scanner, tuomari, tekoaly);
                yksinpeli.pelaa();
            } else if (vastaus.endsWith("c")) {
                tulostaOhje();
                KiviPaperiSakset pahaYksinpeli = new KPSParempiTekoaly(scanner, tuomari, parempiTekoaly);
                pahaYksinpeli.pelaa();
            } else {
                break;
            }

        }

    }

    public void tulostaValinnat() {

        System.out.println("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetataan");

    }

    public void tulostaOhje() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");

    }

}
