package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import interface_adapter.leaguestanding.LeagueStandingController;
import interface_adapter.leaguestanding.LeagueStandingState;
import interface_adapter.leaguestanding.LeagueStandingViewModel;
import interface_adapter.teamsearch.TeamSearchController;

/**
 * The View for the League Standing Use case.
 */
public class LeagueStandingView extends JPanel implements ActionListener {

    private final String viewname = "League Standing";
    private LeagueStandingViewModel leagueStandingViewModel;
    private final JButton cancel = new JButton("Cancel");
    private LeagueStandingController leagueStandingController;

    public LeagueStandingView(LeagueStandingViewModel leagueStandingViewModel) {
        this.leagueStandingViewModel = leagueStandingViewModel;

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
}
