package app.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * GUI class for Team Search and Match Results.
 */
public class SimpleApplication {
    static final int WIDTH = 800;
    static final int HEIGHT = 300;

    /**
     * Main method to run the GUI.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final JFrame frame = new JFrame("Team and Match Results App");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(WIDTH, HEIGHT);

            final CardLayout cardLayout = new CardLayout();
            final JPanel cardPanel = new JPanel(cardLayout);

            // Creating individual cards (panels)
            final JPanel defaultCard = createDefaultCard();
            final JPanel teamSearchCard = createTeamSearchCard(frame);
            final JPanel matchResultsCard = createMatchResultsCard(frame);

            cardPanel.add(defaultCard, "DefaultCard");
            cardPanel.add(teamSearchCard, "TeamSearchCard");
            cardPanel.add(matchResultsCard, "MatchResultsCard");

            // Creating buttons for navigation
            final JButton teamSearchButton = new JButton("Team Search");
            teamSearchButton.addActionListener(event -> cardLayout.show(cardPanel, "TeamSearchCard"));

            final JButton matchResultsButton = new JButton("Match Results");
            matchResultsButton.addActionListener(event -> cardLayout.show(cardPanel, "MatchResultsCard"));

            // Adding buttons to the bottom panel
            final JPanel buttonPanel = new JPanel();
            buttonPanel.add(teamSearchButton);
            buttonPanel.add(matchResultsButton);

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
    private static JPanel createMatchResultsCard(JFrame jFrame) {
        final JPanel matchResultsCard = new JPanel();
        matchResultsCard.setLayout(new GridLayout(3, 2));

        final JTextField matchDateField = new JTextField(20);
        final JButton viewResultsButton = new JButton("View Results");
        final JLabel resultLabel = new JLabel();

        viewResultsButton.addActionListener(event -> {
            final String matchDate = matchDateField.getText();

            // Simulating match results logic
            if (matchDate.isEmpty()) {
                JOptionPane.showMessageDialog(jFrame, "Please enter a match date!");
            } else {
                // Replace with actual match result logic
                resultLabel.setText("Results for date: " + matchDate);
                JOptionPane.showMessageDialog(jFrame, "Results for " + matchDate + " displayed!");
            }
        });

        matchResultsCard.add(new JLabel("Enter Match Date (YYYY-MM-DD):"));
        matchResultsCard.add(matchDateField);
        matchResultsCard.add(viewResultsButton);
        matchResultsCard.add(resultLabel);
        return matchResultsCard;
    }
}
