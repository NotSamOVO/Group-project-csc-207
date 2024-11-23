package view;

import interface_adapter.matchresults.MatchResultsViewModel;
import use_case.matchresults.MatchResultsUseCase;

import javax.swing.*;
import java.awt.*;

public class MatchResultsView extends JPanel {
    private final MatchResultsViewModel matchResultsViewModel;
    private final String viewname = "Match Results";
    private final MatchResultsUseCase outputdata;

    public MatchResultsView(MatchResultsViewModel matchResultsViewModel, MatchResultsUseCase outputdata) {
        this.matchResultsViewModel = matchResultsViewModel;
        this.outputdata = outputdata;

        // Set layout
        this.setLayout(new BorderLayout());

        // Add a title
        final JLabel titleLabel = new JLabel("Match Results", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(titleLabel, BorderLayout.NORTH);

        // Add a table to display match results
        final String[] columnNames = {"Game", "Score", "Date"};

        // Ensure outputdata is not null before calling methods on it
        final String[][] data;
        if (outputdata != null) {
            data = new String[][] {
                    {outputdata.getGame(7001), outputdata.getScore(7001), outputdata.getDate(7001)}
            };
        }
        else {
            data = new String[][] {{"No data available", "-", "-"}};
        }

        final JTable matchResultsTable = new JTable(data, columnNames);
        this.add(new JScrollPane(matchResultsTable), BorderLayout.CENTER);
    }

    public String getViewName() {
        return viewname;
    }
}
