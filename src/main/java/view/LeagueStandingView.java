package view;

import interface_adapter.leaguestanding.LeagueStandingController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * View for displaying and interacting with league standings.
 */
public class LeagueStandingView extends JPanel {
    private final LeagueStandingController controller;
    private final JTable standingsTable;
    private final JTable searchResultTable;
    private final DefaultTableModel mainTableModel;
    private final DefaultTableModel searchTableModel;

    public LeagueStandingView(LeagueStandingController controller, int year) {
        this.controller = controller;
        setLayout(new BorderLayout());

        // Title label
        JLabel titleLabel = new JLabel(year + " NFL League Standings");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Main standings table
        String[] columnNames = {"Rank", "Team Name", "Wins", "Losses", "Ties", "Win %", "Home", "Away", "DIV", "CONF", "PF", "PA", "DIFF"};
        String[][] leagueData = controller.getLeagueStanding();

        mainTableModel = new DefaultTableModel(leagueData, columnNames);
        standingsTable = new JTable(mainTableModel);
        standingsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        standingsTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        standingsTable.setFillsViewportHeight(true);
        JScrollPane standingsScrollPane = new JScrollPane(standingsTable);

        // Search result table
        searchTableModel = new DefaultTableModel(columnNames, 0);
        searchResultTable = new JTable(searchTableModel);
        searchResultTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        searchResultTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        searchResultTable.setFillsViewportHeight(true);
        JScrollPane searchScrollPane = new JScrollPane(searchResultTable);

        // Split pane to show both tables
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, searchScrollPane, standingsScrollPane);
        splitPane.setResizeWeight(0.3);
        splitPane.setDividerSize(5);

        add(splitPane, BorderLayout.CENTER);
    }

    /**
     * Updates the search result table with the searched team's standing.
     *
     * @param teamName the name of the team to search for.
     * @return true if the team was found, false otherwise.
     */
    public boolean searchTeam(String teamName) {
        String[] teamStanding = controller.getTeamStanding(teamName);

        if (teamStanding != null) {
            searchTableModel.setRowCount(0);
            searchTableModel.addRow(teamStanding);
            return true;
        }
        else {
            searchTableModel.setRowCount(0);
            return false;
        }
    }
}
