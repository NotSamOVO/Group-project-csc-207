package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import interface_adapter.leaguestanding.LeagueStandingController;
import interface_adapter.leaguestanding.LeagueStandingState;
import interface_adapter.leaguestanding.LeagueStandingViewModel;
import interface_adapter.teamsearch.TeamSearchController;

import use_case.leaguestanding.LeagueStandingUseCase;

/**
 * The View for the League Standing Use case.
 */
public class LeagueStandingView extends JPanel implements ActionListener {

    private final String viewname = "League Standing";
    private LeagueStandingViewModel leagueStandingViewModel;
    private final JButton cancel = new JButton("Cancel");
    private LeagueStandingController leagueStandingController;
    private LeagueStandingUseCase leagueStandingUseCase;

    public LeagueStandingView(LeagueStandingViewModel leagueStandingViewModel,
                              LeagueStandingUseCase leagueStandingUseCase) {
        this.leagueStandingViewModel = leagueStandingViewModel;
        this.leagueStandingUseCase = leagueStandingUseCase;

        final String[][] data = leagueStandingUseCase.getLeagueStanding();

        final String[] columnNames = {
                "Rank", "Team Name", "Wins", "Losses", "Ties", "Win %", "Home", "Away", "DIV",
                "CONF", "PF", "PA", "DIFF"};

        final DefaultTableModel model = new DefaultTableModel(data, columnNames);
        final JTable table = new JTable(model);

        centerAlignTableContent(table);
        adjustColumnWidths(table);
        centerAlignTableHeaders(table);

        final JScrollPane scrollPane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 500));
        this.add(scrollPane, BorderLayout.CENTER);

        final JPanel buttonPanel = new JPanel();
        buttonPanel.add(cancel);
        this.add(buttonPanel, BorderLayout.SOUTH);

        cancel.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        leagueStandingController.switchTeamSearchView();
                    }
                }
        );

        this.add(cancel);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click" + evt.getActionCommand());
    }

    public String getViewname() {
        return viewname;
    }

    public void setLeagueStandingController(LeagueStandingController leagueStandingController) {
        this.leagueStandingController = leagueStandingController;
    }

    private void adjustColumnWidths(JTable table) {
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            int preferredWidth = 50;
            for (int row = 0; row < table.getRowCount(); row++) {
                Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
                preferredWidth = Math.max(comp.getPreferredSize().width + 10, preferredWidth);
            }
            tableColumn.setPreferredWidth(preferredWidth);
        }
    }

    private void centerAlignTableContent(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int column = 0; column < table.getColumnCount(); column++) {
            table.getColumnModel().getColumn(column).setCellRenderer(centerRenderer);
        }
    }

    private void centerAlignTableHeaders(JTable table) {
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Center-align header text

        for (int column = 0; column < table.getColumnCount(); column++) {
            table.getColumnModel().getColumn(column).setHeaderRenderer(headerRenderer);
        }
    }
}
