package tennisgame;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
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
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (m_score1 == m_score2) {
            String score1;
            score1 = getScoreForTie();
            score = score1;
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            String score1;
            int minusResult = m_score1 - m_score2;

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
            score = score + baseScores[m_score1] + "-" + score + baseScores[m_score2];
        }
        return score;
    }

    String[] baseScores = {"Love", "Fifteen", "Thirty", "Forty"};

    private String getScoreForTie() {
        String score1;
        switch (m_score1) {
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
