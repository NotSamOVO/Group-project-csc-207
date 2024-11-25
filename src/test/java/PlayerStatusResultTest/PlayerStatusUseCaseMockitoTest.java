package PlayerStatusResultTest;

import api.NFLTeamDataBase;
import entity.Player;
import entity.Team;
import use_case.playerstatus.PlayerStatusUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing get player status.
 * The idea is that we don't want to wait for the specific API call to be implemented.
 * <p>
 * This demonstrates using the Mockito library for "mocking" the NFLTeamDataBase.
 */
public class PlayerStatusUseCaseMockitoTest {
    @Mock
    private NFLTeamDataBase mockNFLTeamDataBase;

    private PlayerStatusUseCase playerStatusUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        playerStatusUseCase = new PlayerStatusUseCase(mockNFLTeamDataBase);
    }

    @Test
    void testGetPlayerSuccessful() {
        // Arrange
        String firstName = "Lamar";
        String lastName = "Jackson";
        String teamName = "Ravens";

        Team mockTeam = mock(Team.class);
        when(mockTeam.getName()).thenReturn(teamName);

        Player mockPlayer = mock(Player.class);
        when(mockPlayer.getFirstName()).thenReturn(firstName);
        when(mockPlayer.getLastName()).thenReturn(lastName);
        when(mockPlayer.getTeam()).thenReturn(mockTeam);

        ArrayList<Player> mockPlayerList = new ArrayList<Player>();
        mockPlayerList.add(mockPlayer);

        when(mockNFLTeamDataBase.getAllPlayers()).thenReturn(mockPlayerList);

        // Act
        Player result = playerStatusUseCase.getPlayer(firstName, lastName, teamName);

        // Assert
        assertNotNull(result);
        assertEquals(firstName, result.getFirstName());
        assertEquals(lastName, result.getLastName());
        assertEquals(teamName, result.getTeam().getName());
    }

    @Test
    void testGetPlayerNotFound() {
        // Arrange
        String firstName = "Nonexistent";
        String lastName = "Player";
        String teamName = "FakeTeam";

        when(mockNFLTeamDataBase.getAllPlayers()).thenReturn(new ArrayList<>());

        // Act
        Player result = playerStatusUseCase.getPlayer(firstName, lastName, teamName);

        // Assert
        assertNull(result);
    }

    @Test
    void testGetPlayerStatusSuccessful() {
        // Arrange
        String firstName = "Lamar";
        String lastName = "Jackson";
        String teamName = "Ravens";
        String expectedStatus = "Player Status: Active";

        Team mockTeam = mock(Team.class);
        when(mockTeam.getName()).thenReturn(teamName);

        Player mockPlayer = mock(Player.class);
        when(mockPlayer.getFirstName()).thenReturn(firstName);
        when(mockPlayer.getLastName()).thenReturn(lastName);
        when(mockPlayer.getTeam()).thenReturn(mockTeam);
        when(mockPlayer.toString()).thenReturn(expectedStatus);

        ArrayList<Player> mockPlayerList = new ArrayList<Player>();
        mockPlayerList.add(mockPlayer);

        when(mockNFLTeamDataBase.getAllPlayers()).thenReturn(mockPlayerList);

        // Act
        String result = playerStatusUseCase.getPlayerStatus(firstName, lastName, teamName);

        // Assert
        assertEquals(expectedStatus, result);
    }

    @Test
    void testGetPlayerStatusNotFound() {
        // Arrange
        String firstName = "Nonexistent";
        String lastName = "Player";
        String teamName = "FakeTeam";

        when(mockNFLTeamDataBase.getAllPlayers()).thenReturn(new ArrayList<>());

        // Act
        String result = playerStatusUseCase.getPlayerStatus(firstName, lastName, teamName);

        // Assert
        assertEquals("Player not found", result);
    }
}
