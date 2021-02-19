package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println(bodyText);
        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        List<Player> finnishPlayers = new ArrayList<>();

        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                player.setPoints(Integer.parseInt(player.getGoals()) + Integer.parseInt(player.getAssists()));
                finnishPlayers.add(player);
            }
        }
        System.out.println("Suomalaisten pisteitä NHL-liigassa 2019:\n");
        Collections.sort(finnishPlayers);
        finnishPlayers.stream().forEach(finnish -> System.out.println(finnish));
    }

}
