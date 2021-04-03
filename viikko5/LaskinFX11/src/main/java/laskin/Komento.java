/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {

    protected TextField tulos;
    protected TextField syote;
    protected Button nollaa;
    protected Button undo;
    protected Sovelluslogiikka sovellus;
    protected int edellinen;

    public Komento(TextField tulos, TextField syote, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tulos = tulos;
        this.syote = syote;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    public abstract void suorita();

    public void peru() {
        tulos.setText("" + edellinen);
        undo.disableProperty().set(true);
    }
;

}
