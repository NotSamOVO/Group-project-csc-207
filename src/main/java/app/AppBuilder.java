package app;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import interface_adapter.ViewManagerModel;
import interface_adapter.leaguestanding.LeagueStandingController;
import interface_adapter.leaguestanding.LeagueStandingPresenter;
import interface_adapter.leaguestanding.LeagueStandingViewModel;
import interface_adapter.teamsearch.TeamSearchController;
import interface_adapter.teamsearch.TeamSearchPresenter;
import interface_adapter.teamsearch.TeamSearchViewModel;
import interface_adapter.playerstatus.PlayerStatusController;
import interface_adapter.playerstatus.PlayerStatusPresenter;
import interface_adapter.playerstatus.PlayerStatusViewModel;
import use_case.leaguestanding.LeagueStandingInputBoundary;
import use_case.leaguestanding.LeagueStandingInteractor;
import use_case.leaguestanding.LeagueStandingOutputBoundary;
import use_case.leaguestanding.LeagueStandingUseCase;
import use_case.teamsearch.TeamSearchInputBoundary;
import use_case.teamsearch.TeamSearchInteractor;
import use_case.teamsearch.TeamSearchOutputBoundary;
import use_case.playerstatus.PlayerStatusUseCase;
import use_case.playerstatus.PlayerStatusInteractor;
import use_case.playerstatus.PlayerStatusInputBoundary;
import use_case.playerstatus.PlayerStatusOutputBoundary;
import interface_adapter.playerstatus.PlayerStatusViewModel;
import view.LeagueStandingView;
import view.TeamSearchView;
import view.PlayerStatusView;
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
    private static final int HEIGHT = 800;
    private static final int WIDTH = 1000;
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private TeamSearchView teamSearchView;
    private TeamSearchViewModel teamSearchViewModel;
    private LeagueStandingView leagueStandingView;
    private LeagueStandingViewModel leagueStandingViewModel;
    private PlayerStatusView playerStatusView;
    private PlayerStatusViewModel playerStatusViewModel;
    final Config config = new Config();

    private final LeagueStandingUseCase leagueStandingUseCase = config.getLeagueStandingUseCase();
    private final PlayerStatusUseCase playerStatusUseCase = config.getPlayerStatusUseCase();

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
     * Adds the League Standing View to the application.
     * @return this builder
     */
    public AppBuilder addLeagueStandingView() {
        leagueStandingViewModel = new LeagueStandingViewModel();
        leagueStandingView = new LeagueStandingView(leagueStandingViewModel, leagueStandingUseCase);
        cardPanel.add(leagueStandingView, leagueStandingView.getViewname());
        return this;
    }

    /**
     * Adds the Team Search Use Case to the application.
     * @return this builder
     */
    public AppBuilder addTeamSearchUseCase() {
        final TeamSearchOutputBoundary teamSearchOutputBoundary = new TeamSearchPresenter(viewManagerModel,
                leagueStandingViewModel, teamSearchViewModel);
        final TeamSearchInputBoundary userTeamSearchInteractor = new TeamSearchInteractor(teamSearchOutputBoundary);

        final TeamSearchController controller = new TeamSearchController(teamSearchViewModel, userTeamSearchInteractor);
        teamSearchView.setTeamSearchController(controller);
        return this;
    }

    /**
     * Adds the League Standing Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLeagueStandingUseCase() {
        final LeagueStandingOutputBoundary leagueStandingOutputBoundary = new LeagueStandingPresenter(viewManagerModel,
                leagueStandingViewModel, teamSearchViewModel);
        final LeagueStandingInputBoundary userLeagueStandingInteractor =
                new LeagueStandingInteractor(leagueStandingOutputBoundary);

        final LeagueStandingController controller = new LeagueStandingController(userLeagueStandingInteractor);
        leagueStandingView.setLeagueStandingController(controller);
        return this;
    }

    /**
     * Adds the Player Status View to the application.
     * @return this builder
     */
    public AppBuilder addPlayerStatusView() {
        final PlayerStatusViewModel playerStatusViewModel = new PlayerStatusViewModel();
        final PlayerStatusView playerStatusView = new PlayerStatusView(playerStatusViewModel, playerStatusUseCase);
        cardPanel.add(playerStatusView, playerStatusView.getViewName());
        return this;
    }

    /**
     * Adds the Player Status Use Case to the application.
     * @return this builder
     */
    public AppBuilder addPlayerStatusUseCase() {
        final PlayerStatusOutputBoundary playerStatusOutputBoundary = new PlayerStatusPresenter(viewManagerModel,
                playerStatusViewModel, teamSearchViewModel);
        final PlayerStatusInputBoundary playerStatusInteractor = new PlayerStatusInteractor(playerStatusOutputBoundary);

        final PlayerStatusController controller = new PlayerStatusController(playerStatusInteractor);
        playerStatusView.setPlayerStatusController(controller);
        return this;
    }

    /**
     * Creates the JFrame for the application and initially sets the TeamSearchView to be displayed.
     * @return the application
     */
    public JFrame build() {
        final JFrame application = new JFrame("Team Search");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setSize(WIDTH, HEIGHT);

        application.add(cardPanel);

        viewManagerModel.setState(teamSearchView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}
