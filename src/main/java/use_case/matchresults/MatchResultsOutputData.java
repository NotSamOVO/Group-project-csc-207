package use_case.matchresults;

/**
 * OutputData class for representing game details in a structured format.
 */
public class MatchResultsOutputData {
    private final String matchup;
    private final String score;
    private final String q1;
    private final String q2;
    private final String q3;
    private final String q4;
    private final String ot;
    private final String date;
    private final String venue;

    /**
     * Constructs an OutputData instance.
     *
     * @param matchup the matchup description
     * @param score the game score
     * @param date the game date
     * @param q1 q1 score
     * @param q2 q2 score
     * @param q3 q3 score
     * @param q4 q4 score
     * @param ot ot score
     * @param venue the game venue
     */
    public MatchResultsOutputData(String matchup, String score, String date, String q1, String q2, String q3, String q4,
                                  String ot, String venue) {
        this.matchup = matchup;
        this.score = score;
        this.date = date;
        this.venue = venue;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.ot = ot;
    }

    public String getMatchup() {
        return matchup;
    }

    public String getScore() {
        return score;
    }

    public String getQ1() {
        return q1;
    }

    public String getQ2() {
        return q2;
    }

    public String getQ3() {
        return q3;
    }

    public String getQ4() {
        return q4;
    }

    public String getOt() {
        return ot;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }
}
