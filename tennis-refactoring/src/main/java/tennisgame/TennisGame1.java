package tennisgame;

public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (player1Score == player2Score) {
            String score1;
            score1 = getScoreForTie();
            score = score1;
        } else if (player1Score >= 4 || player2Score >= 4) {
            String score1;
            int minusResult = player1Score - player2Score;

            if (minusResult == 1) {
                score1 = "Advantage player1";
            } else if (minusResult == -1) {
                score1 = "Advantage player2";
            } else if (minusResult >= 2) {
                score1 = "Win for player1";
            } else {
                score1 = "Win for player2";
            }

            score = score1;
        } else {
            score = score + baseScores[player1Score] + "-" + score + baseScores[player2Score];
        }
        return score;
    }

    String[] baseScores = {"Love", "Fifteen", "Thirty", "Forty"};

    private String getScoreForTie() {
        String score1;
        switch (player1Score) {
            case 0:
                score1 = "Love-All";
                break;
            case 1:
                score1 = "Fifteen-All";
                break;
            case 2:
                score1 = "Thirty-All";
                break;
            default:
                score1 = "Deuce";
                break;

        }
        return score1;
    }

}
