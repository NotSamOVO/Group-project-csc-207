package use_case.playerstatus;

public class PlayerStatusOutputData {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String position;
    private final String positionAbbreviation;
    private final String height;
    private final String weight;
    private final String jerseyNumber;
    private final String college;
    private final String experience;
    private final int age;
    private final String teamName;
    private final String teamAbbreviation;

    public PlayerStatusOutputData(int id, String firstName, String lastName, String position,
                                  String positionAbbreviation, String height, String weight,
                                  String jerseyNumber, String college, String experience,
                                  int age, String teamName, String teamAbbreviation) {
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
        this.teamName = teamName;
        this.teamAbbreviation = teamAbbreviation;
    }

    // Getters for all fields
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPosition() { return position; }
    public String getPositionAbbreviation() { return positionAbbreviation; }
    public String getHeight() { return height; }
    public String getWeight() { return weight; }
    public String getJerseyNumber() { return jerseyNumber; }
    public String getCollege() { return college; }
    public String getExperience() { return experience; }
    public int getAge() { return age; }
    public String getTeamName() { return teamName; }
    public String getTeamAbbreviation() { return teamAbbreviation; }
}
