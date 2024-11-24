package entity;

/**
 * Represents a football game with details about the teams, date, scores, and venue.
 */
public class Game {
    private Integer id;
    private Team visitor_team;
    private Team home_team;
    private String date;
    private Integer home_team_score;
    private Integer visitor_team_score;
    private String venue;
    private Integer home_team_q1;
    private Integer visitor_team_q1;
    private Integer home_team_q2;
    private Integer visitor_team_q2;
    private Integer home_team_q3;
    private Integer visitor_team_q3;
    private Integer home_team_q4;
    private Integer visitor_team_q4;

    /**
     * Constructs a new Game instance.
     *
     * @param id               the unique identifier of the game
     * @param visitor_team     the visiting team
     * @param home_team        the home team
     * @param date             the date of the game
     * @param home_team_score  the score of the home team
     * @param visitor_team_score the score of the visiting team
     * @param venue            the venue where the game is played
     */
    public Game(Integer id, Team home_team, Team visitor_team, String date, Integer home_team_score, Integer visitor_team_score,
                String venue, Integer home_team_q1, Integer home_team_q2, Integer home_team_q3, Integer home_team_q4,
                Integer visitor_team_q1, Integer visitor_team_q2, Integer visitor_team_q3, Integer visitor_team_q4) {
        this.id = id;
        this.visitor_team = visitor_team;
        this.home_team = home_team;
        this.date = date;
        this.home_team_score = home_team_score;
        this.visitor_team_score = visitor_team_score;
        this.venue = venue;
        this.home_team_q1 = home_team_q1;
        this.visitor_team_q1 = visitor_team_q1;
        this.home_team_q2 = home_team_q2;
        this.visitor_team_q2 = visitor_team_q2;
        this.home_team_q3 = home_team_q3;
        this.visitor_team_q3 = visitor_team_q3;
        this.home_team_q4 = home_team_q4;
        this.visitor_team_q4 = visitor_team_q4;
    }

    /**
     * Returns the unique identifier of the game.
     *
     * @return the game ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Returns the home team.
     *
     * @return the home team
     */
    public Team getHome_team() {
        return home_team;
    }

    /**
     * Returns the visiting team.
     *
     * @return the visiting team
     */
    public Team getVisitor_team() {
        return visitor_team;
    }

    /**
     * Returns the date of the game.
     *
     * @return the game date as a String
     */
    public String getDate() {
        return date;
    }

    /**
     * Returns the score of the home team.
     *
     * @return the home team score
     */
    public Integer getHome_team_score() {
        return home_team_score;
    }

    /**
     * Returns the score of the visiting team.
     *
     * @return the visiting team score
     */
    public Integer getVisitor_team_score() {
        return visitor_team_score;
    }

    /**
     * Returns the venue of the game.
     *
     * @return the game venue
     */
    public String getVenue() {
        return venue;
    }

    public Integer getHome_team_q1() {
        return home_team_q1;
    }

    public Integer getVisitor_team_q1() {
        return visitor_team_q1;
    }

    public Integer getHome_team_q2() {
        return home_team_q2;
    }

    public Integer getVisitor_team_q2() {
        return visitor_team_q2;
    }

    public Integer getHome_team_q3() {
        return home_team_q3;
    }

    public Integer getVisitor_team_q3() {
        return visitor_team_q3;
    }

    public Integer getHome_team_q4() {
        return home_team_q4;
    }

    public Integer getVisitor_team_q4() {
        return visitor_team_q4;
    }

    /**
     * Creates a new GameBuilder for constructing Game instances.
     *
     * @return a new GameBuilder
     */
    public static GameBuilder builder() {
        return new GameBuilder();
    }

    /**
     * A builder class for constructing instances of {@link Game}.
     */
    public static class GameBuilder {
        private Integer id;
        private Team visitor_team;
        private Team home_team;
        private String date;
        private Integer home_team_score;
        private Integer visitor_team_score;
        private String venue;
        private Integer home_team_q1;
        private Integer visitor_team_q1;
        private Integer home_team_q2;
        private Integer visitor_team_q2;
        private Integer home_team_q3;
        private Integer visitor_team_q3;
        private Integer home_team_q4;
        private Integer visitor_team_q4;

        /**
         * Constructs an empty GameBuilder instance.
         */
        public GameBuilder() {
        }

        /**
         * Sets the ID for the game.
         *
         * @param id the game ID
         * @return this GameBuilder instance
         */
        public GameBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the visiting team for the game.
         *
         * @param visitor_team the visiting team
         * @return this GameBuilder instance
         */
        public GameBuilder visitor_team(Team visitor_team) {
            this.visitor_team = visitor_team;
            return this;
        }

        /**
         * Sets the home team for the game.
         *
         * @param home_team the home team
         * @return this GameBuilder instance
         */
        public GameBuilder home_team(Team home_team) {
            this.home_team = home_team;
            return this;
        }

        /**
         * Sets the date for the game.
         *
         * @param date the game date
         * @return this GameBuilder instance
         */
        public GameBuilder date(String date) {
            this.date = date;
            return this;
        }

        /**
         * Sets the home team score for the game.
         *
         * @param home_team_score the home team score
         * @return this GameBuilder instance
         */
        public GameBuilder home_team_score(Integer home_team_score) {
            this.home_team_score = home_team_score;
            return this;
        }

        /**
         * Sets the visiting team score for the game.
         *
         * @param visitor_team_score the visiting team score
         * @return this GameBuilder instance
         */
        public GameBuilder visitor_team_score(Integer visitor_team_score) {
            this.visitor_team_score = visitor_team_score;
            return this;
        }

        /**
         * Sets the venue for the game.
         *
         * @param venue the game venue
         * @return this GameBuilder instance
         */
        public GameBuilder venue(String venue) {
            this.venue = venue;
            return this;
        }

        public GameBuilder home_team_q1(Integer home_team_q1) {
            this.home_team_score = home_team_q1;
            return this;
        }

        public GameBuilder visitor_team_q1(Integer visitor_team_q1) {
            this.visitor_team_score = visitor_team_q1;
            return this;
        }

        public GameBuilder home_team_q2(Integer home_team_q2) {
            this.home_team_score = home_team_q2;
            return this;
        }

        public GameBuilder visitor_team_q2(Integer visitor_team_q2) {
            this.visitor_team_score = visitor_team_q2;
            return this;
        }

        public GameBuilder home_team_q3(Integer home_team_q3) {
            this.home_team_score = home_team_q3;
            return this;
        }

        public GameBuilder visitor_team_q3(Integer visitor_team_q3) {
            this.visitor_team_score = visitor_team_q3;
            return this;
        }

        public GameBuilder home_team_q4(Integer home_team_q4) {
            this.home_team_score = home_team_q4;
            return this;
        }

        public GameBuilder visitor_team_q4(Integer visitor_team_q4) {
            this.visitor_team_score = visitor_team_q4;
            return this;
        }

        /**
         * Builds a new {@link Game} instance with the current builder state.
         *
         * @return a new Game instance
         */
        public Game build() {
            return new Game(id, home_team, visitor_team, date, home_team_score, visitor_team_score, venue, home_team_q1,
                    home_team_q2, home_team_q3, home_team_q4, visitor_team_q1, visitor_team_q2,
                    visitor_team_q3, visitor_team_q4);
        }
    }
}
