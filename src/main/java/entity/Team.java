package entity;

/**
 * Represents a team with team statistics.
 * This class provides a builder for creating instances of a Team.
 */
public class Team {
    private int id;
    private String conference;
    private String division;
    private String location;
    private String name;
    private String fullName;
    private String abbreviation;

    public Team(int id, String conference, String division, String location, String name,
                String fullName, String abbreviation) {
        this.id = id;
        this.conference = conference;
        this.division = division;
        this.location = location;
        this.name = name;
        this.fullName = fullName;
        this.abbreviation = abbreviation;
    }

    /**
     * Returns the id of the team.
     * @return the id of the team.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the conference of the team.
     * @return the conference of the team.
     */
    public String getConference() {
        return conference;
    }

    /**
     * Returns the division of the team.
     * @return the division of the team.
     */
    public String getDivision() {
        return division;
    }

    /**
     * Returns the location of the team.
     * @return the location of the team.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Returns the name of the team.
     * @return the name of the team.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the full_name of the team.
     * @return the full_name of the team.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Returns the abbreviation of the team.
     * @return the abbreviation of the team.
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    public String toString() {
        return "Team: " + id + "/n" + conference + "/n" + division + "/n" + location + "/n" + name + "/n"
                + fullName + "/n" + abbreviation;
    }

    /**
     * Returns a new TeamBuilder instance.
     * @return a new TeamBuilder instance.
     */
    public static TeamBuilder builder() {
        return new TeamBuilder();
    }

    /**
     * Represents a builder for creating instances of a Team.
     */
    public static class TeamBuilder {
        private int id;
        private String conference;
        private String division;
        private String location;
        private String name;
        private String fullName;
        private String abbreviation;

        TeamBuilder() {
        }

        /**
         * Sets the id of the team.
         * @param id the id of the team.
         * @return the TeamBuilder instance.
         */
        public TeamBuilder id(int id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the conference of the team.
         * @param conference the conference of the team.
         * @return the TeamBuilder instance.
         */
        public TeamBuilder conference(String conference) {
            this.conference = conference;
            return this;
        }

        /**
         * Sets the division of the team.
         * @param division the division of the team.
         * @return the TeamBuilder instance.
         */
        public TeamBuilder division(String division) {
            this.division = division;
            return this;
        }

        /**
         * Sets the location of the team.
         * @param location the location of the team.
         * @return the TeamBuilder instance.
         */
        public TeamBuilder location(String location) {
            this.location = location;
            return this;
        }

        /**
         * Sets the name of the team.
         * @param name the name of the team.
         * @return the TeamBuilder instance.
         */
        public TeamBuilder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the fullName of the team.
         * @param fullName the fullName of the team.
         * @return the TeamBuilder instance.
         */
        public TeamBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        /**
         * Sets the abbreviation of the team.
         * @param abbreviation the abbreviation of the team.
         * @return the TeamBuilder instance.
         */
        public TeamBuilder abbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
            return this;
        }

        /**
         * Builds an instance of a Team.
         * @return an instance of a Team.
         */
        public Team build() {
            return new Team(id, conference, division, location, name, fullName, abbreviation);
        }
    }

}
