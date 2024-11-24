<<<<<<< HEAD

=======
>>>>>>> origin/main
package entity;

/**
 * Represents a player with all statistics.
 * This class provides a builder for creating instances of a Player.
 */
public class Player {
    private int id;
    private String firstName;
    private String lastName;
    private String position;
    private String positionAbbreviation;
    private String height;
    private String weight;
    private String jerseyNumber;
    private String college;
    private String experience;
    private int age;
    private Team team;
<<<<<<< HEAD

    public Player(int id, String firstName, String lastName, String position, String positionAbbreviation
            , String height, String weight, String jerseyNumber, String college, String experience, int age, Team team) {
=======
    public Player(int id, String firstName, String lastName, String position, String positionAbbreviation
    , String height, String weight, String jerseyNumber, String college, String experience, int age, Team team) {
>>>>>>> origin/main
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.positionAbbreviation = positionAbbreviation;
        this.height = height;
        this.weight = weight;
        this.jerseyNumber = jerseyNumber;
        this.college = college;
        this.experience = experience;
        this.age = age;
        this.team = team;
    }

    /**
     * Returns the id of the player.
     * @return the id of the player.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the first name of the player.
     * @return the first name of the player.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of the player.
     * @return the last name of the player.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the position of the player.
     * @return the position of the player.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Returns the abbreviation of the player.
     * @return the abbreviation of the player.
     */
    public String getPositionAbbreviation() {
        return positionAbbreviation;
    }

    /**
     * Returns the height of the player.
     * @return the height of the player.
     */
    public String getHeight() {
        return height;
    }

    /**
     * Returns the weight of the player.
     * @return the weight of the player.
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Returns the jersey number of the player.
     * @return the jersey number of the player.
     */
    public String getJerseyNumber() {
        return jerseyNumber;
    }

    /**
     * Returns the college of the player.
     * @return the college of the player.
     */
    public String getCollege() {
        return college;
    }

    /**
     * Returns the experience of the player.
     * @return the experience of the player.
     */
    public String getExperience() {
        return experience;
    }

    /**
     * Returns the age of the player.
     * @return the age of the player.
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the team info of the player.
     * @return the team info of the player.
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Returns a new PlayerBuilder instance.
     * @return a new PlayerBuilder instance.
     */
<<<<<<< HEAD
    public static PlayerBuilder builder() {
=======
    public static PlayerBuilder builder(){
>>>>>>> origin/main
        return new PlayerBuilder();
    }

    /**
     * Represents a builder for creating instances of a Player.
     */
<<<<<<< HEAD
    public static class PlayerBuilder {
=======
    public static class PlayerBuilder{
>>>>>>> origin/main
        private int id;
        private String firstName;
        private String lastName;
        private String position;
        private String positionAbbreviation;
        private String height;
        private String weight;
        private String jerseyNumber;
        private String college;
        private String experience;
        private int age;
        private Team team;

<<<<<<< HEAD
        PlayerBuilder() {
=======
        PlayerBuilder(){
>>>>>>> origin/main
        }

        /**
         * Sets the id of the player.
         * @param id the id of the player.
         * @return the PlayerBuilder instance.
         */
<<<<<<< HEAD
        public PlayerBuilder id(int id) {
=======
        public PlayerBuilder id(int id){
>>>>>>> origin/main
            this.id = id;
            return this;
        }

        /**
         * Sets the firstName of the player.
         * @param firstName the firstName of the player.
         * @return the PlayerBuilder instance.
         */
<<<<<<< HEAD
        public PlayerBuilder firstName(String firstName) {
=======
        public PlayerBuilder firstName(String firstName){
>>>>>>> origin/main
            this.firstName = firstName;
            return this;
        }

        /**
         * Sets the lastName of the player.
         * @param lastName the lastName of the player.
         * @return the PlayerBuilder instance.
         */
<<<<<<< HEAD
        public PlayerBuilder lastName(String lastName) {
=======
        public PlayerBuilder lastName(String lastName){
>>>>>>> origin/main
            this.lastName = lastName;
            return this;
        }

        /**
         * Sets the position of the player.
         * @param position the position of the player.
         * @return the PlayerBuilder instance.
         */
<<<<<<< HEAD
        public PlayerBuilder position(String position) {
=======
        public PlayerBuilder position(String position){
>>>>>>> origin/main
            this.position = position;
            return this;
        }

        /**
         * Sets the positionAbbreviation of the player.
         * @param positionAbbreviation the positionAbbreviation of the player.
         * @return the PlayerBuilder instance.
         */
<<<<<<< HEAD
        public PlayerBuilder positionAbbreviation(String positionAbbreviation) {
=======
        public PlayerBuilder positionAbbreviation(String positionAbbreviation){
>>>>>>> origin/main
            this.positionAbbreviation = positionAbbreviation;
            return this;
        }

        /**
         * Sets the height of the player.
         * @param height the height of the player.
         * @return the PlayerBuilder instance.
         */
<<<<<<< HEAD
        public PlayerBuilder height(String height) {
=======
        public PlayerBuilder height(String height){
>>>>>>> origin/main
            this.height = height;
            return this;
        }

        /**
         * Sets the weight of the player.
         * @param weight the weight of the player.
         * @return the PlayerBuilder instance.
         */
<<<<<<< HEAD
        public PlayerBuilder weight(String weight) {
=======
        public PlayerBuilder weight(String weight){
>>>>>>> origin/main
            this.weight = weight;
            return this;
        }

        /**
         * Sets the jerseyNumber of the player.
         * @param jerseyNumber the jerseyNumber of the player.
         * @return the PlayerBuilder instance.
         */
<<<<<<< HEAD
        public PlayerBuilder jerseyNumber(String jerseyNumber) {
=======
        public PlayerBuilder jerseyNumber(String jerseyNumber){
>>>>>>> origin/main
            this.jerseyNumber = jerseyNumber;
            return this;
        }

        /**
         * Sets the college of the player.
         * @param college the college of the player.
         * @return the PlayerBuilder instance.
         */
<<<<<<< HEAD
        public PlayerBuilder college(String college) {
=======
        public PlayerBuilder college(String college){
>>>>>>> origin/main
            this.college = college;
            return this;
        }

        /**
         * Sets the experience of the player.
         * @param experience the experience of the player.
         * @return the PlayerBuilder instance.
         */
<<<<<<< HEAD
        public PlayerBuilder experience(String experience) {
=======
        public PlayerBuilder experience(String experience){
>>>>>>> origin/main
            this.experience = experience;
            return this;
        }

        /**
         * Sets the age of the player.
         * @param age the age of the player.
         * @return the PlayerBuilder instance.
         */
<<<<<<< HEAD
        public PlayerBuilder age(int age) {
=======
        public PlayerBuilder age(int age){
>>>>>>> origin/main
            this.age = age;
            return this;
        }

        /**
         * Sets the team of the player.
         * @param team the team of the player.
         * @return the PlayerBuilder instance.
         */
<<<<<<< HEAD
        public PlayerBuilder team(Team team) {
=======
        public PlayerBuilder team(Team team){
>>>>>>> origin/main
            this.team = team;
            return this;
        }

        /**
         * Builds a new Player instance.
         * @return a new Player instance.
         */
<<<<<<< HEAD
        public Player build() {
            return new Player(id, firstName, lastName, position, positionAbbreviation
                    , height, weight, jerseyNumber, college, experience, age, team);
        }
    }
}
=======
        public Player build(){
            return new Player(id,firstName,lastName,position,positionAbbreviation
                    ,height,weight,jerseyNumber,college,experience,age,team);
        }
    }
}

>>>>>>> origin/main
