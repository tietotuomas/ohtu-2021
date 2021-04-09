package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

        QueryBuilder query = new QueryBuilder();

        Matcher defaultQuery = query.build();

        int montako = 0;
        for (Player player : stats.matches(defaultQuery)) {
            montako++;
        }
        System.out.println("montako yhteensä: " + montako);
        System.out.println("\nTehtävä 4: \n");

        Matcher m = query.playsIn("NYR")
                .hasAtLeast(5, "goals")
                .hasFewerThan(10, "goals").build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        
        System.out.println("\nTehtävä 5: \n");

        Matcher m2 = query.oneOf(
                query.playsIn("PHI")
                        .hasAtLeast(10, "assists")
                        .hasFewerThan(5, "goals").build(),
                query.playsIn("EDM")
                        .hasAtLeast(40, "points").build()
        ).build();

        for (Player player : stats.matches(m2)) {
            System.out.println(player);
        }

    }
}
