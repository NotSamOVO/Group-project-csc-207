package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interface_adapter.playerstatus.PlayerStatusController;
import interface_adapter.playerstatus.PlayerStatusState;

/**
 * The View for the Player Status use case.
 */
public class PlayerStatusView extends JPanel implements ActionListener {

    private final String viewName = "Player Status";
    private final PlayerStatusState playerStatusState;
    private PlayerStatusController playerStatusController;

    private final JTextField firstNameField = new JTextField(15);
    private final JTextField lastNameField = new JTextField(15);
    private final JTextField teamNameField = new JTextField(15);

    private final JButton searchButton = new JButton("Search");
    private final JButton backButton = new JButton("Back");

    private final JTextArea resultArea = new JTextArea(10, 50);

    public PlayerStatusView(PlayerStatusState playerStatusState) {
        this.playerStatusState = playerStatusState;

        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("First Name:"));
        inputPanel.add(firstNameField);

        inputPanel.add(new JLabel("Last Name:"));
        inputPanel.add(lastNameField);

        inputPanel.add(new JLabel("Team Name:"));
        inputPanel.add(teamNameField);

        inputPanel.add(searchButton);
        inputPanel.add(backButton);

        // Result Panel
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder("Player Status Result"));

        resultArea.setEditable(false);
        JScrollPane resultScrollPane = new JScrollPane(resultArea);
        resultPanel.add(resultScrollPane, BorderLayout.CENTER);

        // Add Panels to the Main Layout
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        // Set Button Actions
        searchButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String firstName = firstNameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String teamName = teamNameField.getText().trim();

            if (!playerStatusState.getErrorMessage().isEmpty()) {
                resultArea.setText("Error: " + playerStatusState.getErrorMessage());
            } else {
                resultArea.setText(playerStatusState.getPlayerInfo());
            }
        } else if (e.getSource() == backButton) {
            playerStatusController.switchToTeamSearchView();
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setPlayerStatusController(PlayerStatusController controller) {
        this.playerStatusController = controller;
    }
}
