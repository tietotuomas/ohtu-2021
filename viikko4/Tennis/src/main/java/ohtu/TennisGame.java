package ohtu;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return evenScore();
        } else if (player1Score >= 4 || player2Score >= 4) {
            return overThreePoints();
        } else {
            return underFourPoints();
        }
    }

    public String evenScore() {

        switch (player1Score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";

        }

    }

    public String overThreePoints() {
        int difference = player1Score - player2Score;

        switch (difference) {
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            case 2:
            case 3:
            case 4:
                return "Win for player1";
            default:
                return "Win for player2";

        }
    }

    public String underFourPoints() {
        String score = "";
        score += pointsToString(player1Score);
        score += "-";
        score += pointsToString(player2Score);

        return score;

    }

    public String pointsToString(int points) {
        switch (points) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }

    }
}
