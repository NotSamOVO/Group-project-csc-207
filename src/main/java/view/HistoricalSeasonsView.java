package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import entity.Season;
import interface_adapter.historicalseasons.HistoricalSeasonsController;
import interface_adapter.historicalseasons.HistoricalSeasonsViewModel;

/**
 * The View for the HistoricalSeasons Use Case.
 */
public class HistoricalSeasonsView extends JPanel {

    private final HistoricalSeasonsViewModel viewModel;
    private HistoricalSeasonsController controller;
    private final JTable table;
    private final DefaultTableModel tableModel;

    public HistoricalSeasonsView(HistoricalSeasonsViewModel viewModel) {
        this.viewModel = viewModel;
        this.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(HistoricalSeasonsViewModel.TITLE_LABEL, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(titleLabel, BorderLayout.NORTH);

        String[] columnNames = {"Year", "Wins", "Losses", "Ties", "Points For", "Points Against"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Team Search");
        backButton.addActionListener(e -> controller.switchToTeamSearchView());
        this.add(backButton, BorderLayout.SOUTH);
    }

    public void updateTable(ArrayList<Season> seasons) {
        tableModel.setRowCount(0);
        for (Season season : seasons) {
            tableModel.addRow(new Object[] {
                season.getYear(),
                season.getWins(),
                season.getLosses(),
                season.getTies(),
                season.getPointsFor(),
                season.getPointsAgainst(),
            });
        }
    }

    public void setController(HistoricalSeasonsController controller) {
        this.controller = controller;
    }
}
