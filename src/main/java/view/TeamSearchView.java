package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.teamsearch.TeamSearchViewModel;

/**
 *  The View for the Team Search and Selection Use Case.
 */
public class TeamSearchView extends JPanel implements ActionListener {
    private final String viewName = "Team Search";

    private final TeamSearchViewModel teamSearchViewModel;
    private final JTextField teamIdInputField = new JTextField(15);

    private final JButton leagueStanding;
    private final JButton matchResults;
    private final JButton historicalSeasons;
    private final JButton playerStats;

    public TeamSearchView(TeamSearchViewModel teamSearchViewModel) {
        this.teamSearchViewModel = teamSearchViewModel;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final LabelTextPanel teamSearchPanel = new LabelTextPanel(
                new JLabel(TeamSearchViewModel.TEAMSEARCH_LABEL), teamIdInputField);
        this.add(teamSearchPanel);

        final JPanel buttonPanel = new JPanel();
        historicalSeasons = new JButton(teamSearchViewModel.HISTORICAL_SEANSONS_BUTTON_LABEL);
        buttonPanel.add(historicalSeasons);
        leagueStanding = new JButton(teamSearchViewModel.LEAGUE_STANDING_BUTTON_LABEL);
        buttonPanel.add(leagueStanding);
        matchResults = new JButton(teamSearchViewModel.MATCH_RESULTS_BUTTON_LABEL);
        buttonPanel.add(matchResults);
        playerStats = new JButton(teamSearchViewModel.PLAYER_STATS_BUTTON_LABEL);
        buttonPanel.add(playerStats);

        this.add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Cancel not implemented yet.");
    }

    public String getViewName() {
        return viewName;
    }
}
