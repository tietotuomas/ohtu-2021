package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {

    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa kauppa;

    @Before
    public void setUp() {
        this.pankki = mock(Pankki.class);

        this.viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).thenReturn(42);

        this.varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.saldo(3)).thenReturn(0);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "kalja", 10));
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "dom perignon", 1000));

        this.kauppa = new Kauppa(varasto, pankki, viite);

    }

    @Test
    public void ostoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaan() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), anyInt());
    }

    @Test
    public void ostoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
    }

    @Test
    public void kahdenEriTuotteenOstoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("turing", "12345");

        verify(pankki).tilisiirto("turing", 42, "12345", "33333-44455", 15);
    }

    @Test
    public void kahdenSamanTuotteenOstoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("dijkstra", "12345");

        verify(pankki).tilisiirto("dijkstra", 42, "12345", "33333-44455", 10);
    }

    @Test
    public void kahdenSamanTuotteenOstoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreillaKunToinenTuoteLoppuVarastosta() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.tilimaksu("lovelace", "12345");

        verify(pankki).tilisiirto("lovelace", 42, "12345", "33333-44455", 5);
    }

    @Test
    public void aloitaAsiointiNollaaEdellisenOstoksenTiedot() {

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("selanne", "12345");
        
        verify(pankki).tilisiirto(eq("selanne"), anyInt(), eq("12345"), anyString(), eq(5));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("karalahti", "54321");
        
        verify(pankki).tilisiirto(eq("karalahti"), anyInt(), eq("54321"), anyString(), eq(10));        

    }
    
    @Test
    public void poistaKoristaPoistaaValitunTuotteen() {
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("turing", "112");
        
        verify(varasto, times(2)).otaVarastosta(any());
        verify(varasto, times(1)).palautaVarastoon(any());
        
        verify(pankki).tilisiirto(eq("turing"), anyInt(), eq("112"), anyString(), eq(10));
    }
}
