package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interface_adapter.playerstatus.PlayerStatusController;
import interface_adapter.playerstatus.PlayerStatusState;
import interface_adapter.playerstatus.PlayerStatusViewModel;
import use_case.playerstatus.PlayerStatusUseCase;

/**
 * The View for the Player Status use case.
 */
public class PlayerStatusView extends JPanel implements ActionListener {

    private final String viewName = "Player Status";
    private PlayerStatusViewModel viewModel;
    private PlayerStatusUseCase useCase;
    private PlayerStatusController controller;

    private final JTextField firstNameField = new JTextField(15);
    private final JTextField lastNameField = new JTextField(15);
    private final JTextField teamNameField = new JTextField(15);

    private final JButton searchButton = new JButton("Search");
    private final JButton backButton = new JButton("Back");

    private final JTextArea resultArea = new JTextArea(10, 50);

    public PlayerStatusView(PlayerStatusViewModel playerStatusViewModel, PlayerStatusUseCase playerStatusUseCase) {
        this.viewModel = playerStatusViewModel;
        this.useCase = playerStatusUseCase;

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

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder("Player Status Result"));

        resultArea.setEditable(false);
        JScrollPane resultScrollPane = new JScrollPane(resultArea);
        resultPanel.add(resultScrollPane, BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        searchButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click" + e.getActionCommand());
    }

    public String getViewName() {
        return viewName;
    }

    public void setPlayerStatusController(PlayerStatusController controller) {
        this.controller = controller;
    }
}
