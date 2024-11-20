package app;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import interface_adapter.ViewManagerModel;
import interface_adapter.teamsearch.TeamSearchViewModel;
import view.TeamSearchView;
import view.ViewManager;

/**
 * The AppBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * <p/>
 * This is done by adding each View and then adding related Use Cases.
 */
// Checkstyle note: you can ignore the "Class Data Abstraction Coupling"
//                  and the "Class Fan-Out Complexity" issues for this lab; we encourage
//                  your team to think about ways to refactor the code to resolve these
//                  if your team decides to work with this as your starter code
//                  for your final project this term.
public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private TeamSearchView teamSearchView;
    private TeamSearchViewModel teamSearchViewModel;

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    /**
     * Adds the Team Search View to the application.
     * @return this builder
     */
    public AppBuilder addTeamSearchView() {
        teamSearchViewModel = new TeamSearchViewModel();
        teamSearchView = new TeamSearchView(teamSearchViewModel);
        cardPanel.add(teamSearchView, teamSearchView.getViewName());
        return this;
    }

    /**
     * Adds the Team Search Use Case to the application.
     * @return this builder
     */
    public AppBuilder addTeamSearchUseCase() {
        return this;
    }

    /**
     * Creates the JFrame for the application and initially sets the TeamSearchView to be displayed.
     * @return the application
     */
    public JFrame build() {
        final JFrame application = new JFrame("Login Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(teamSearchView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}
