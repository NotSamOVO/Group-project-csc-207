package app.gui;

import app.Config;
import use_case.matchresults.MatchResultsUseCase;
import use_case.teamsearch.TeamSearchUseCase;

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
            final JPanel historicalSeason = createHistoricalSeasonCard(frame);
            final JPanel leagueStanding = createLeagueStandingCard(frame);
            final JPanel playerStats = createPlayerStats(frame);

            cardPanel.add(defaultCard, "DefaultCard");
            cardPanel.add(teamSearchCard, "TeamSearchCard");
            cardPanel.add(matchResultsCard, "MatchResultsCard");
            cardPanel.add(historicalSeason, "HistoricalSeasonCard");
            cardPanel.add(leagueStanding, "LeagueStandingCard");
            cardPanel.add(playerStats, "PlayerStatsCard");

            // Creating buttons for navigation
            final JButton teamSearchButton = new JButton("Team Search");
            teamSearchButton.addActionListener(event -> cardLayout.show(cardPanel, "TeamSearchCard"));

            final JButton matchResultsButton = new JButton("Match Results");
            matchResultsButton.addActionListener(event -> cardLayout.show(cardPanel, "MatchResultsCard"));

            final JButton historicalSeasonButton = new JButton("Historical Season");
            historicalSeasonButton.addActionListener(event -> cardLayout.show(cardPanel, "HistoricalSeasonCard"));

            final JButton leagueStandingButton = new JButton("League Standing");
            leagueStandingButton.addActionListener(event -> cardLayout.show(cardPanel, "LeagueStandingCard"));

            final JButton playerStatsButton = new JButton("Player Stats");
            playerStatsButton.addActionListener(event -> cardLayout.show(cardPanel, "PlayerStatsCard"));

            // Adding buttons to the bottom panel
            final JPanel buttonPanel = new JPanel();
            buttonPanel.add(teamSearchButton);
            buttonPanel.add(matchResultsButton);
            buttonPanel.add(historicalSeasonButton);
            buttonPanel.add(leagueStandingButton);
            buttonPanel.add(playerStatsButton);

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

    public static JPanel createLeagueStandingCard(JFrame jFrame) {
        final JPanel leagueStandingCard = new JPanel();
        leagueStandingCard.setLayout(new BorderLayout());
        return leagueStandingCard;
    }

    public static JPanel createHistoricalSeasonCard(JFrame jFrame) {
        final JPanel historicalSeasonCard = new JPanel();
        historicalSeasonCard.setLayout(new BorderLayout());
        return historicalSeasonCard;
    }

    public static JPanel createPlayerStats(JFrame jFrame) {
        final JPanel playerStats = new JPanel();
        playerStats.setLayout(new BorderLayout());
        return playerStats;
    }
}
