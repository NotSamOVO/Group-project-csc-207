package entity;

/**
 * Represents a season's statistics for a team.
 */
public class Season {
    private int wins;
    private int losses;
    private int ties;
    private String conferenceRecord;
    private String divisionRecord;
    private String homeRecord;
    private String awayRecord;
    private String fullName;
    private int pointsFor;
    private int pointsAgainst;
    private int pointsDiff;
    private int teamId;

    public Season(int teamId, String fullName, int pointsFor, int pointsAgainst, int pointsDiff, int wins, int losses, int ties,
                  String conferenceRecord, String divisionRecord, String homeRecord, String awayRecord) {
        this.fullName = fullName;
        this.pointsFor = pointsFor;
        this.pointsAgainst = pointsAgainst;
        this.pointsDiff = pointsDiff;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
        this.conferenceRecord = conferenceRecord;
        this.divisionRecord = divisionRecord;
        this.homeRecord = homeRecord;
        this.awayRecord = awayRecord;
    }

    public int getTeamId() { return teamId; }

    public String getFullName() {
        return fullName;
    }

    public String getAwayRecord() {
        return awayRecord;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTies() {
        return ties;
    }

    public String getConferenceRecord() {
        return conferenceRecord;
    }

    public String getDivisionRecord() {
        return divisionRecord;
    }

    public String getHomeRecord() {
        return homeRecord;
    }

    public int getPointsFor() {
        return pointsFor;
    }

    public int getPointsAgainst() {
        return pointsAgainst;
    }

    public int getPointsDiff() {
        return pointsDiff;
    }

    /**
     * Returns a new Seasonbuilder instance.
     * @return a new Seasonbuilder instance.
     */
    public static SeasonBuilder builder() {
        return new SeasonBuilder();
    }

    /**
     * Represents a builder for creating instances of a Team's season record.
     */
    public static class SeasonBuilder {
        private int wins;
        private int losses;
        private int ties;
        private String conferenceRecord;
        private String divisionRecord;
        private String homeRecord;
        private String awayRecord;
        private String fullName;
        private int pointsFor;
        private int pointsAgainst;
        private int pointsDiff;
        private int teamId;

        SeasonBuilder() {
        }

        /**
         * Sets the ID of the team.
         * @param teamId the ID of the team.
         * @return the TeamBuilderInstance.
         */
        public SeasonBuilder teamId(int teamId) {
            this.teamId = teamId;
            return this;
        }

        /**
         * Sets the full name of the team.
         * @param fullname the full name of the team.
         * @return the TeamBuilder instance.
         */
        public SeasonBuilder fullName(String fullname) {
            this.fullName = fullname;
            return this;
        }

        /**
         * Sets the conference record of the team.
         * @param conferencerecord the conference record of the team.
         * @return the TeamBuilder instance.
         */
        public SeasonBuilder conferenceRecord(String conferencerecord) {
            this.conferenceRecord = conferencerecord;
            return this;
        }

        /**
         * Sets the division record of the team.
         * @param divisionrecord the division record of the team.
         * @return the TeamBuilder instance.
         */
        public SeasonBuilder divisionRecord(String divisionrecord) {
            this.divisionRecord = divisionrecord;
            return this;
        }

        /**
         * Sets the away record of the team.
         * @param awayrecord the home record of the team.
         * @return the TeamBuilder instance.
         */
        public SeasonBuilder awayRecord(String awayrecord) {
            this.awayRecord = awayrecord;
            return this;
        }

        /**
         * Sets the home record of the team.
         * @param homerecord the home record of the team.
         * @return the TeamBuilder instance.
         */
        public SeasonBuilder homeRecord(String homerecord) {
            this.homeRecord = homerecord;
            return this;
        }

        /**
         * Sets the number of wins of the team.
         * @param win the number of wins of the team.
         * @return the TeamBuilder instance.
         */
        public SeasonBuilder wins(int win) {
            this.wins = win;
            return this;
        }

        /**
         * Sets the number of losses of the team.
         * @param lose the number of losses of the team.
         * @return the TeamBuilder instance.
         */
        public SeasonBuilder losses(int lose) {
            this.losses = lose;
            return this;
        }

        /**
         * Sets the number of ties of the team.
         * @param tie the number of ties of the team.
         * @return the TeamBuilder instance.
         */
        public SeasonBuilder ties(int tie) {
            this.ties = tie;
            return this;
        }

        /**
         * Sets the total earned points of the team.
         * @param pointsfor the total earned points of the team.
         * @return the TeamBuilder instance.
         */
        public SeasonBuilder pointsFor(int pointsfor) {
            this.pointsFor = pointsfor;
            return this;
        }

        /**
         * Sets the total lost points of the team.
         * @param pointsagainst the total lost points of the team.
         * @return the TeamBuilder instance.
         */
        public SeasonBuilder pointsAgainst(int pointsagainst) {
            this.pointsAgainst = pointsagainst;
            return this;
        }

        /**
         * Sets the differential between total earned and lost points of the team.
         * @param pointsdiff the differential between total earned and lost points of the team.
         * @return the TeamBuilder instance.
         */
        public SeasonBuilder pointsDiff(int pointsdiff) {
            this.pointsDiff = pointsdiff;
            return this;
        }

        /**
         * Builds an instance of a Team's seasonal reocrd.
         * @return an instance of a Team's seasonal reocrd.
         */
        public Season build() {
            return new Season(teamId, pointsFor, pointsAgainst, pointsDiff, wins, losses, ties,
                    conferenceRecord, divisionRecord, homeRecord, awayRecord);
        }
    }
}
