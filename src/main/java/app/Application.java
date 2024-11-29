package app.gui;

import app.Config;
import interface_adapter.TeamSearchViewModel;
import interface_adapter.matchresults.MatchResultsController;
import interface_adapter.matchresults.MatchResultsViewModel;
import use_case.matchresults.MatchResultsOutputData;
import use_case.matchresults.MatchResultsUseCase;
import use_case.playerstatus.PlayerStatusUseCase;
import use_case.teamsearch.TeamSearchUseCase;
import use_case.leaguestanding.LeagueStandingUseCase;

import java.awt.*;
import java.time.Year;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
        final MatchResultsController controller = new MatchResultsController(matchResultsUseCase);
        final MatchResultsViewModel viewModel = new MatchResultsViewModel(matchResultsUseCase);
        final TeamSearchUseCase teamSearchUseCase = config.getTeamSearchUseCase();
        final PlayerStatusUseCase playerStatusUseCase = config.getPlayerStatusUseCase();
        final LeagueStandingUseCase leagueStandingUseCase = config.getLeagueStandingUseCase();

        SwingUtilities.invokeLater(() -> {
            final JFrame frame = new JFrame("NFL Statistics App");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(WIDTH, HEIGHT);

            final CardLayout cardLayout = new CardLayout();
            final JPanel cardPanel = new JPanel(cardLayout);

            // Creating individual cards (panels)
            final JPanel defaultCard = createDefaultCard();
            final JPanel teamSearchCard = createTeamSearchCard(frame, teamSearchUseCase);
            final JPanel matchResultsCard = createMatchResultsCard(frame, viewModel, controller);
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

        final JLabel welcomeLabel = new JLabel("<html>Welcome to the NFL Statistics App!<br>"
                + "Use the buttons below to navigate.</html>", JLabel.CENTER);

        defaultCard.add(welcomeLabel);
        return defaultCard;
    }

    /**
     * Team Search Card: Allows user to search for a team.
     */
    private static JPanel createTeamSearchCard(JFrame jFrame, TeamSearchUseCase teamSearchUseCase) {
        final JPanel teamSearchCard = new JPanel();
        teamSearchCard.setLayout(new GridLayout(3, 2));

        final JTextField teamNameField = new JTextField(20);
        final JButton searchButton = new JButton(TeamSearchViewModel.SEARCH_LABEL);
        final JLabel resultLabel = new JLabel();

        searchButton.addActionListener(event -> {
            final String teamName = teamNameField.getText();

            // Simulating team search logic
            if (teamName.isEmpty()) {
                JOptionPane.showMessageDialog(jFrame, TeamSearchViewModel.TEAM_NAME_LABEL);
            }
            else {
                // Replace with actual team search logic
                final String message = teamSearchUseCase.getTeamId(teamName);
                JOptionPane.showMessageDialog(jFrame, message);
            }
        });

        teamSearchCard.add(new JLabel(TeamSearchViewModel.ENTER_TEAM_NAME_LABEL));
        teamSearchCard.add(teamNameField);
        teamSearchCard.add(searchButton);
        teamSearchCard.add(resultLabel);
        return teamSearchCard;
    }

    /**
     * Match Results Card: Displays match results based on user input.
     */
    private static JPanel createMatchResultsCard(JFrame jFrame, MatchResultsViewModel viewModel,
                                                 MatchResultsController controller) {
        final JPanel teamSearchCard = new JPanel();
        teamSearchCard.setLayout(new BorderLayout());

        final JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        final JTextField teamNameField = new JTextField(20);
        final JButton submit = new JButton(MatchResultsViewModel.SUBMIT_BUTTON_LABEL);

        inputPanel.add(new JLabel(MatchResultsViewModel.TEAM_NAME_LABEL));
        inputPanel.add(teamNameField);
        inputPanel.add(submit);

        final JPanel resultsPanel = new JPanel(new BorderLayout());
        final JLabel noResultsLabel = new JLabel(MatchResultsViewModel.NO_RESULTS_LABEL);
        noResultsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        final String[] columnNames = {MatchResultsViewModel.GAME_LABEL, MatchResultsViewModel.SCORES_LABEL,
                MatchResultsViewModel.DATE_LABEL, MatchResultsViewModel.Q1_LABEL, MatchResultsViewModel.Q2_LABEL,
                MatchResultsViewModel.Q3_LABEL, MatchResultsViewModel.Q4_LABEL, MatchResultsViewModel.OT_LABEL,
                MatchResultsViewModel.VENUE_LABEL};
        final JTable resultsTable = new JTable(new String[0][0], columnNames);
        final JScrollPane scrollPane = new JScrollPane(resultsTable);

        resultsPanel.add(noResultsLabel, BorderLayout.NORTH);
        resultsPanel.add(scrollPane, BorderLayout.CENTER);

        // Match Results Button Logic
        submit.addActionListener(event -> {
            final String teamName = teamNameField.getText().trim();

            if (teamName.isEmpty()) {
                JOptionPane.showMessageDialog(jFrame, "Please enter a team name to view match results!");
                return;
            }

            try {
                final boolean hasResults = controller.execute(teamName);

                if (!hasResults) {
                    noResultsLabel.setText("No match results found for team: " + teamName);
                    resultsTable.setModel(new DefaultTableModel(new Object[0][0], columnNames));
                }
                else {
                    ArrayList<Integer> gameIds = viewModel.getGameIds(teamName);
                    String[][] data = new String[gameIds.size()][9];
                    for (int i = 0; i < gameIds.size(); i++) {
                        int gameId = gameIds.get(i);

                        // Use controller to fetch game details
                        MatchResultsOutputData outputData = viewModel.getGameDetails(gameId);

                        data[i][0] = outputData.getMatchup();
                        data[i][1] = outputData.getScore();
                        data[i][2] = outputData.getDate();
                        data[i][3] = outputData.getQ1();
                        data[i][4] = outputData.getQ2();
                        data[i][5] = outputData.getQ3();
                        data[i][6] = outputData.getQ4();
                        data[i][7] = outputData.getOt();
                        data[i][8] = outputData.getVenue();
                    }

                    // Update table model
                    resultsTable.setModel(new DefaultTableModel(data, columnNames));
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
        final JPanel leagueStandingCard = new JPanel(new BorderLayout());
        final int year = Year.now().getValue();

        try {
            final JPanel inputPanel = new JPanel(new FlowLayout());
            final JLabel label = new JLabel("Enter Team Name:");
            final JTextField teamNameField = new JTextField(20);
            final JButton searchButton = new JButton("Search");

            inputPanel.add(label);
            inputPanel.add(teamNameField);
            inputPanel.add(searchButton);

            // Table setup
            final String[] columnNames = {"Rank", "Team Name", "Wins", "Losses", "Ties", "Win %", "Home", "Away",
                    "DIV", "CONF", "PF", "PA", "DIFF"};
            final String[][] data = leagueStandingUseCase.getLeagueStanding();

            // Panel for single-row search result
            final JPanel searchResultPanel = new JPanel(new BorderLayout());
            final JLabel searchResultLabel = new JLabel("Search Result");
            searchResultLabel.setHorizontalAlignment(SwingConstants.CENTER);

            // Single-row search result table
            final DefaultTableModel searchTableModel = new DefaultTableModel(columnNames, 0);
            final JTable searchResultTable = new JTable(searchTableModel);
            searchResultTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            searchResultTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            searchResultTable.setFillsViewportHeight(true);
            final JScrollPane searchTableScrollPane = new JScrollPane(searchResultTable);

            searchResultPanel.add(searchResultLabel, BorderLayout.NORTH);
            searchResultPanel.add(searchTableScrollPane, BorderLayout.CENTER);

            // Results panel to hold table and label
            final JPanel resultsPanel = new JPanel(new BorderLayout());
            final JLabel noResultsLabel = new JLabel(year + " NFL League Standings");
            noResultsLabel.setHorizontalAlignment(SwingConstants.CENTER);

            // JTable to display standings
            final JTable standingTable = new JTable(data, columnNames);
            standingTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            standingTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            standingTable.setFillsViewportHeight(true);

            // Scroll pane for table
            final JScrollPane scrollPane = new JScrollPane(standingTable);

            // Add components to the results panel
            resultsPanel.add(noResultsLabel, BorderLayout.NORTH);
            resultsPanel.add(scrollPane, BorderLayout.CENTER);

            // Create a JSplitPane to allow dynamic resizing between search result and full table
            final JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, searchResultPanel, resultsPanel);
            splitPane.setResizeWeight(0.3); // Allocate 30% of space to the top panel initially
            splitPane.setDividerSize(5); // Thin divider

            // Add results panel to the main card
            leagueStandingCard.add(inputPanel, BorderLayout.NORTH);
            leagueStandingCard.add(splitPane, BorderLayout.CENTER);

            searchButton.addActionListener(evt -> {
                final String teamName = teamNameField.getText().trim();
                searchTableModel.setRowCount(0);

                if (teamName.isEmpty()) {
                    JOptionPane.showMessageDialog(jFrame,
                            "Please enter a team name.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Call getTeamStanding to get the specific team data
                final String[] teamStanding = leagueStandingUseCase.getTeamStanding(teamName);
                if (teamStanding != null) {
                    // Add the result to the search result table
                    searchTableModel.addRow(teamStanding);
                }
                else {
                    JOptionPane.showMessageDialog(jFrame, "Team not found: " + teamName, "Search Result", JOptionPane.WARNING_MESSAGE);
                }
            });

        }
        catch (Exception eve) {
            // Show error dialog in case of issues
            JOptionPane.showMessageDialog(jFrame, "Error fetching league standings: " + eve.getMessage());
        }

        return leagueStandingCard;
    }
}
