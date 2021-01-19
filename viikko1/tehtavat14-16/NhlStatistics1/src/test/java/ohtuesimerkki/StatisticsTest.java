/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void searchFindsExistingPlayer() {
        assertEquals("Kurri                EDM 37 + 53 = 90", stats.search("Kurri").toString());
    }
    
    @Test
    public void searchDoesntFindNonExistingPlayer() {
        assertEquals(null, stats.search("Alan Turing"));
    }
    
    @Test
    public void teamReturnsCorretPlayers() {
        List<Player> Edmonton = stats.team("EDM");
        assertTrue(Edmonton.size() == 3);
        List<Player> Detroit = stats.team("DET");
        assertTrue(Detroit.size() == 1);
        assertEquals(Detroit.get(0).getName(), "Yzerman");
    }
    
    @Test
    public void topScorersReturnsCorrectPlayerIfHowManyIsOne() {
        List<Player> topScorer = stats.topScorers(1);
        assertEquals("Gretzky", topScorer.get(0).getName());
    }
    
    @Test
    public void topScorersReturnsCorrectPlayersIfHowManyIsThree() {
        List<Player> topScorers = stats.topScorers(3);
        assertTrue(topScorers.size() == 3);
        System.out.println(topScorers);
    }
}
