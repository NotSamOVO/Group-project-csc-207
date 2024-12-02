package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import use_case.leaguestanding.LeagueStandingUseCase;

/**
 * View for league standing.
 */
public class LeagueStandingView extends JPanel {

    private final JTable fullStandingTable;
    private final JTable searchResultTable;
    private final DefaultTableModel searchTableModel;

    private static final String[] COLUMN_NAMES = {
            "Rank", "Team Name", "Wins", "Losses", "Ties", "Win %", "Home", "Away", "DIV", "CONF", "PF", "PA", "DIFF"
    };

    public LeagueStandingView(LeagueStandingUseCase leagueStandingUseCase, int year) {
        this.setLayout(new BorderLayout());

        // Full standings table
        final String[][] data = leagueStandingUseCase.getLeagueStanding();
        final DefaultTableModel fullTableModel = new DefaultTableModel(data, COLUMN_NAMES);
        fullStandingTable = new JTable(fullTableModel);
        configureTable(fullStandingTable);

        final JScrollPane fullTableScrollPane = new JScrollPane(fullStandingTable);
        final JLabel standingsLabel = new JLabel(year + " NFL League Standings");
        standingsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel standingsPanel = new JPanel(new BorderLayout());
        standingsPanel.add(standingsLabel, BorderLayout.NORTH);
        standingsPanel.add(fullTableScrollPane, BorderLayout.CENTER);

        // Search result table
        searchTableModel = new DefaultTableModel(COLUMN_NAMES, 0);
        searchResultTable = new JTable(searchTableModel);
        configureTable(searchResultTable);

        final JScrollPane searchTableScrollPane = new JScrollPane(searchResultTable);
        final JLabel searchResultLabel = new JLabel("Search Result");
        searchResultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(searchResultLabel, BorderLayout.NORTH);
        searchPanel.add(searchTableScrollPane, BorderLayout.CENTER);

        // SplitPane for dynamic resizing
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, searchPanel, standingsPanel);
        splitPane.setResizeWeight(0.3);
        splitPane.setDividerSize(5);

        this.add(splitPane, BorderLayout.CENTER);
    }

    private void configureTable(JTable table) {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        table.setFillsViewportHeight(true);
    }

    /**
     * Searches for a team and updates the search result table.
     *
     * @param teamName The name of the team to search for.
     * @param leagueStandingUseCase The use case instance to fetch standings data.
     * @return True if the team was found, false otherwise.
     */
    public boolean searchTeam(String teamName, LeagueStandingUseCase leagueStandingUseCase) {
        searchTableModel.setRowCount(0);
        final String[] teamStanding = leagueStandingUseCase.getTeamStanding(teamName);

        if (teamStanding != null) {
            searchTableModel.addRow(teamStanding);
            return true;
        }
        return false;
    }
}
