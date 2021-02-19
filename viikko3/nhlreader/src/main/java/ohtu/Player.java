package ohtu;

public class Player implements Comparable<Player> {

    private String name;
    private String team;
    private String nationality;
    private String goals;
    private String assists;
    private Integer points;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAssists() {
        return assists;
    }

    public String getGoals() {
        return goals;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getNationality() {
        return nationality;
    }

    public Integer getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-5s %-3s+ %-3s= %-3s", name, team, goals, assists, points);
    }

    @Override
    public int compareTo(Player player) {
        if (this.points < player.getPoints()) {
            return 1;
        }
        if (this.points > player.getPoints()) {
            return -1;
        }
        if (this.points == player.getPoints() && Integer.parseInt(this.goals) < Integer.parseInt(player.getGoals())) {
            return 1;
        }
        if (this.points == player.getPoints() && Integer.parseInt(this.goals) > Integer.parseInt(player.getGoals())) {
            return -1;
        }
        return 0;
    }

}
