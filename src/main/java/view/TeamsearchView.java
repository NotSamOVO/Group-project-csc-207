package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.teamsearch.SignupController;
import interface_adapter.teamsearch.SignupState;
import interface_adapter.teamsearch.TeamsearchViewModel;

/**
 * The View for the Signup Use Case.
 */
public class TeamsearchView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "team search";

    private final TeamsearchViewModel teamsearchViewModel;
    private final JTextField teamsearchInputField = new JTextField(15);
    private SignupController signupController;

    private final JButton leaguestanding;
    private final JButton matchresults;
    private final JButton historicalseasons;
    private final JButton playerstats;

    public TeamsearchView(TeamsearchViewModel teamsearchViewModel) {
        this.teamsearchViewModel = teamsearchViewModel;
        teamsearchViewModel.addPropertyChangeListener(this);

        final LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(TeamsearchViewModel.TEAMSEARCH_LABEL), teamsearchInputField);

        final JPanel buttons = new JPanel();
        historicalseasons = new JButton(TeamsearchViewModel.HISTORICAL_SEANSONS_BUTTON_LABEL);
        buttons.add(historicalseasons);
        leaguestanding = new JButton(TeamsearchViewModel.LEAGUE_STANDING_BUTTON_LABEL);
        buttons.add(leaguestanding);
        matchresults = new JButton(TeamsearchViewModel.MATCH_RESULTS_BUTTON_LABEL);
        buttons.add(matchresults);
        playerstats = new JButton(TeamsearchViewModel.PLAYER_STATS_BUTTON_LABEL);
        buttons.add(playerstats);

        leaguestanding.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(leaguestanding)) {
                            final SignupState currentState = teamsearchViewModel.getState();

                            signupController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword(),
                                    currentState.getRepeatPassword()
                            );
                        }
                    }
                }
        );

        historicalseasons.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        signupController.switchToLoginView();
                    }
                }
        );

        matchresults.addActionListener(this);

        addTeamsearchListener();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(usernameInfo);
        this.add(buttons);
    }

    private void addTeamsearchListener() {
        teamsearchInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final SignupState currentState = teamsearchViewModel.getState();
                currentState.setUsername(teamsearchInputField.getText());
                teamsearchViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setSignupController(SignupController controller) {
        this.signupController = controller;
    }
}
