package app.gui;

import app.Config;
import use_case.matchresults.MatchResultsUseCase;
import use_case.playerstatus.PlayerStatusUseCase;
import use_case.teamsearch.TeamSearchUseCase;
import use_case.leaguestanding.LeagueStandingUseCase;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * GUI class for Team Search and Match Results.
 */
public class Application {
    static final int WIDTH = 800;
    static final int HEIGHT = 300;

    /**
     * Main method to run the GUI.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        final Config config = new Config();

        final MatchResultsUseCase matchResultsUseCase = config.getMatchResultsUseCase();
        final TeamSearchUseCase teamSearchUseCase = config.getTeamSearchUseCase();
        final PlayerStatusUseCase playerStatusUseCase = config.getPlayerStatusUseCase();
        final LeagueStandingUseCase leagueStandingUseCase = config.getLeagueStandingUseCase();

        SwingUtilities.invokeLater(() -> {
            final JFrame frame = new JFrame("Team and Match Results App");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(WIDTH, HEIGHT);

            final CardLayout cardLayout = new CardLayout();
            final JPanel cardPanel = new JPanel(cardLayout);

            // Creating individual cards (panels)
            final JPanel defaultCard = createDefaultCard();
            final JPanel teamSearchCard = createTeamSearchCard(frame);
            final JPanel matchResultsCard = createMatchResultsCard(frame, matchResultsUseCase);
            final JPanel playerStatusCard = createPlayerStatusCard(frame, playerStatusUseCase);
            final JPanel leageuStandingCard = createLeagueStandingCard(frame, leagueStandingUseCase);

            cardPanel.add(defaultCard, "DefaultCard");
            cardPanel.add(teamSearchCard, "TeamSearchCard");
            cardPanel.add(matchResultsCard, "MatchResultsCard");
            cardPanel.add(playerStatusCard, "PlayerStatusCard");
            cardPanel.add(leageuStandingCard, "LeagueStandingCard");

            // Creating buttons for navigation
            final JButton teamSearchButton = new JButton("Team Search");
            teamSearchButton.addActionListener(event -> cardLayout.show(cardPanel, "TeamSearchCard"));

            final JButton matchResultsButton = new JButton("Match Results");
            matchResultsButton.addActionListener(event -> cardLayout.show(cardPanel, "MatchResultsCard"));

            final JButton playerStatusButton = new JButton("Player Status");
            playerStatusButton.addActionListener(event -> cardLayout.show(cardPanel, "PlayerStatusCard"));

            final JButton leagueStandingButton = new JButton("League Standing");
            leagueStandingButton.addActionListener(event -> cardLayout.show(cardPanel, "LeagueStandingCard"));

            // Adding buttons to the bottom panel
            final JPanel buttonPanel = new JPanel();
            buttonPanel.add(teamSearchButton);
            buttonPanel.add(matchResultsButton);
            buttonPanel.add(playerStatusButton);
            buttonPanel.add(leagueStandingButton);

            // Adding components to the frame
            frame.getContentPane().add(cardPanel, BorderLayout.CENTER);
            frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }

    /**
     * Default Card: Welcome message.
     */
    private static JPanel createDefaultCard() {
        final JPanel defaultCard = new JPanel();
        defaultCard.setLayout(new GridLayout(1, 1));

        final JLabel welcomeLabel = new JLabel("<html>Welcome to the Team & Match Results App!<br>"
                + "Use the buttons below to navigate.</html>", JLabel.CENTER);

        defaultCard.add(welcomeLabel);
        return defaultCard;
    }

    /**
     * Team Search Card: Allows user to search for a team.
     */
    private static JPanel createTeamSearchCard(JFrame jFrame) {
        final JPanel teamSearchCard = new JPanel();
        teamSearchCard.setLayout(new GridLayout(3, 2));

        final JTextField teamNameField = new JTextField(20);
        final JButton searchButton = new JButton("Search");
        final JLabel resultLabel = new JLabel();

        searchButton.addActionListener(event -> {
            final String teamName = teamNameField.getText();

            // Simulating team search logic
            if (teamName.isEmpty()) {
                JOptionPane.showMessageDialog(jFrame, "Please enter a team name!");
            } else {
                // Replace with actual team search logic
                resultLabel.setText("Results for team: " + teamName);
                JOptionPane.showMessageDialog(jFrame, "Team " + teamName + " found!");
            }
        });

        teamSearchCard.add(new JLabel("Enter Team Name:"));
        teamSearchCard.add(teamNameField);
        teamSearchCard.add(searchButton);
        teamSearchCard.add(resultLabel);
        return teamSearchCard;
    }

    /**
     * Match Results Card: Displays match results based on user input.
     */
    private static JPanel createMatchResultsCard(JFrame jFrame, MatchResultsUseCase matchResultsUseCase) {
        final JPanel teamSearchCard = new JPanel();
        teamSearchCard.setLayout(new BorderLayout());

        final JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        final JTextField teamNameField = new JTextField(20);
        final JButton searchButton = new JButton("Search");
        final JButton submit = new JButton("Submit");
        final JLabel resultLabel = new JLabel();

        inputPanel.add(new JLabel("Enter Team Name:"));
        inputPanel.add(teamNameField);
        inputPanel.add(searchButton);
        inputPanel.add(submit);

        final JPanel resultsPanel = new JPanel(new BorderLayout());
        final JLabel noResultsLabel = new JLabel("Results will appear here...");
        noResultsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        final String[] columnNames = {"Game", "Score", "Date", "q1", "q2", "q3", "q4", "venue"};
        final JTable resultsTable = new JTable(new String[0][0], columnNames);
        final JScrollPane scrollPane = new JScrollPane(resultsTable);

        resultsPanel.add(noResultsLabel, BorderLayout.NORTH);
        resultsPanel.add(scrollPane, BorderLayout.CENTER);

        // Search Button Logic
        searchButton.addActionListener(event -> {
            final String teamName = teamNameField.getText().trim();

            if (teamName.isEmpty()) {
                JOptionPane.showMessageDialog(jFrame, "Please enter a team name!");
            } else {
                // Simulating search logic
                resultLabel.setText("Results for team: " + teamName);
                JOptionPane.showMessageDialog(jFrame, "Team " + teamName + " found!");
            }
        });

        // Match Results Button Logic
        submit.addActionListener(event -> {
            final String teamName = teamNameField.getText().trim();

            if (teamName.isEmpty()) {
                JOptionPane.showMessageDialog(jFrame, "Please enter a team name to view match results!");
                return;
            }

            try {
                ArrayList<Integer> gameIds = matchResultsUseCase.getGameId(teamName);

                if (gameIds.isEmpty()) {
                    noResultsLabel.setText("No match results found for team: " + teamName);
                    resultsTable.setModel(new javax.swing.table.DefaultTableModel(new Object[0][0], columnNames));
                }
                else {
                    // Populate table data
                    String[][] data = new String[gameIds.size()][8];
                    for (int i = 0; i < gameIds.size(); i++) {
                        int gameId = gameIds.get(i);
                        data[i][0] = matchResultsUseCase.getGame(gameId);
                        data[i][1] = matchResultsUseCase.getScore(gameId);
                        data[i][2] = matchResultsUseCase.getDate(gameId);
                        data[i][3] = matchResultsUseCase.getq1(gameId);
                        data[i][4] = matchResultsUseCase.getq2(gameId);
                        data[i][5] = matchResultsUseCase.getq3(gameId);
                        data[i][6] = matchResultsUseCase.getq4(gameId);
                        data[i][7] = matchResultsUseCase.getVenue(gameId);
                    }

                    // Update table model
                    resultsTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
                    noResultsLabel.setText("Displaying match results for team: " + teamName);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(jFrame, "Error fetching match results: " + e.getMessage());
            }
        });

        teamSearchCard.add(inputPanel, BorderLayout.NORTH);
        teamSearchCard.add(resultsPanel, BorderLayout.CENTER);
        return teamSearchCard;
    }

    /**
     * Player Status Card: Allows user to search for player status.
     */
    private static JPanel createPlayerStatusCard(JFrame frame, PlayerStatusUseCase playerStatusUseCase) {
        final JPanel playerStatusCard = new JPanel();
        playerStatusCard.setLayout(new BorderLayout());

        // Input Panel
        final JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        final JTextField firstNameField = new JTextField(20);
        final JTextField lastNameField = new JTextField(20);
        final JTextField teamNameField = new JTextField(20);
        final JButton searchButton = new JButton("Search");
        final JLabel errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED);

        inputPanel.add(new JLabel("First Name:"));
        inputPanel.add(firstNameField);

        inputPanel.add(new JLabel("Last Name:"));
        inputPanel.add(lastNameField);

        inputPanel.add(new JLabel("Team Name:"));
        inputPanel.add(teamNameField);

        inputPanel.add(searchButton);
        inputPanel.add(errorLabel);

        // Results Panel
        final JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder("Player Status Result"));

        final JTextArea resultArea = new JTextArea(10, 50);
        resultArea.setEditable(false);
        final JScrollPane scrollPane = new JScrollPane(resultArea);
        resultPanel.add(scrollPane, BorderLayout.CENTER);

        // Search Button Logic
        searchButton.addActionListener(event -> {
            String firstName = firstNameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String teamName = teamNameField.getText().trim();

            if (firstName.isEmpty() || lastName.isEmpty() || teamName.isEmpty()) {
                errorLabel.setText("Please fill out all fields!");
                resultArea.setText("");
                return;
            }

            try {
                String playerInfo = playerStatusUseCase.getPlayerStatus(firstName, lastName, teamName);

                if (playerInfo == null || playerInfo.isEmpty()) {
                    errorLabel.setText("Player not found.");
                    resultArea.setText("");
                } else {
                    errorLabel.setText("");
                    resultArea.setText(playerInfo);
                }
            } catch (Exception e) {
                errorLabel.setText("Error fetching player status: " + e.getMessage());
                resultArea.setText("");
            }
        });

        playerStatusCard.add(inputPanel, BorderLayout.NORTH);
        playerStatusCard.add(resultPanel, BorderLayout.CENTER);
        return playerStatusCard;
    }

    /**
     * League Standing Card: Displays league standings of the current year.
     *
     * @param jFrame the parent frame.
     * @param leagueStandingUseCase the use case for retrieving league standings.
     * @return a JPanel displaying league standings.
     */
    private static JPanel createLeagueStandingCard(JFrame jFrame, LeagueStandingUseCase leagueStandingUseCase) {
        final JPanel teamSearchCard = new JPanel(new BorderLayout());

        try {
            // Results panel to hold table and label
            final JPanel resultsPanel = new JPanel(new BorderLayout());
            final JLabel noResultsLabel = new JLabel("Results will appear here...");
            noResultsLabel.setHorizontalAlignment(SwingConstants.CENTER);

            // Table setup
            final String[] columnNames = {
                    "Rank", "Team Name", "Wins", "Losses", "Ties", "Win %", "Home", "Away", "DIV",
                    "CONF", "PF", "PA", "DIFF"};
            final String[][] data = leagueStandingUseCase.getLeagueStanding();

            // JTable to display standings
            final JTable standingTable = new JTable(data, columnNames);
            standingTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            standingTable.setFillsViewportHeight(true);

            // Scroll pane for table
            final JScrollPane scrollPane = new JScrollPane(standingTable);

            // Add components to the results panel
            resultsPanel.add(noResultsLabel, BorderLayout.NORTH);
            resultsPanel.add(scrollPane, BorderLayout.CENTER);

            // Add results panel to the main card
            teamSearchCard.add(resultsPanel, BorderLayout.CENTER);

        }
        catch (Exception e) {
            // Show error dialog in case of issues
            JOptionPane.showMessageDialog(jFrame, "Error fetching league standings: " + e.getMessage());
        }

        return teamSearchCard;
    }
}
