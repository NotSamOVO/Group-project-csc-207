package entity;

/**
 * Represents a football game with details about the teams, date, scores, and venue.
 */
public class Game {
    private int id;
    private Team visitor_team;
    private Team home_team;
    private String date;
    private int home_team_score;
    private int visitor_team_score;
    private String venue;

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
    public Game(int id, Team visitor_team, Team home_team, String date, int home_team_score, int visitor_team_score,
                String venue) {
        this.id = id;
        this.visitor_team = visitor_team;
        this.home_team = home_team;
        this.date = date;
        this.home_team_score = home_team_score;
        this.visitor_team_score = visitor_team_score;
        this.venue = venue;
    }

    /**
     * Returns the unique identifier of the game.
     *
     * @return the game ID
     */
    public int getId() {
        return id;
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
     * Returns the home team.
     *
     * @return the home team
     */
    public Team getHome_team() {
        return home_team;
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
    public int getHome_team_score() {
        return home_team_score;
    }

    /**
     * Returns the score of the visiting team.
     *
     * @return the visiting team score
     */
    public int getVisitor_team_score() {
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
        private int id;
        private Team visitor_team;
        private Team home_team;
        private String date;
        private int home_team_score;
        private int visitor_team_score;
        private String venue;

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
        public GameBuilder id(int id) {
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
        public GameBuilder home_team_score(int home_team_score) {
            this.home_team_score = home_team_score;
            return this;
        }

        /**
         * Sets the visiting team score for the game.
         *
         * @param visitor_team_score the visiting team score
         * @return this GameBuilder instance
         */
        public GameBuilder visitor_team_score(int visitor_team_score) {
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

        /**
         * Builds a new {@link Game} instance with the current builder state.
         *
         * @return a new Game instance
         */
        public Game build() {
            return new Game(id, visitor_team, home_team, date, home_team_score, visitor_team_score, venue);
        }
    }
}
