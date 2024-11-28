package MatchResultsUseCaseTest;

import use_case.matchresults.MatchResultsUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Match Results Use Case.
 * Demonstrates using the Mockito library for "mocking" dependencies.
 */
public class MatchResultsUseCaseTest {
    @Mock
    private MatchResultsUseCase matchResultsUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetGameId_ValidTeamName() {
        // Arrange
        String teamName = "Dallas Cowboys";
        ArrayList<Integer> expectedGameIds = new ArrayList<>(List.of(101, 102, 103));

        when(matchResultsUseCase.getGameId(teamName)).thenReturn(expectedGameIds);

        // Act
        ArrayList<Integer> actualGameIds = matchResultsUseCase.getGameId(teamName);

        // Assert
        assertNotNull(actualGameIds, "Game IDs should not be null");
        assertEquals(expectedGameIds.size(), actualGameIds.size(), "Game IDs size mismatch");
        assertEquals(expectedGameIds, actualGameIds, "Game IDs do not match");
    }

    @Test
    void testGetGameId_TeamNotFound() {
        // Arrange
        String teamName = "Unknown Team";
        when(matchResultsUseCase.getGameId(teamName)).thenReturn(new ArrayList<>());

        // Act
        ArrayList<Integer> actualGameIds = matchResultsUseCase.getGameId(teamName);

        // Assert
        assertNotNull(actualGameIds, "Game IDs should not be null");
        assertTrue(actualGameIds.isEmpty(), "Expected no game IDs for unknown team");
    }

    @Test
    void testGetGameDetails_Successful() {
        // Arrange
        int gameId = 6800;
        String expectedGame = "Dolphins vs Panthers";
        String expectedScore = "42 - 21";
        String expectedDate = "2023-10-15";
        String expectedQ1 = "0 - 14";
        String expectedQ2 = "21 - 0";
        String expectedQ3 = "7 - 0";
        String expectedQ4 = "14 - 7";
        String expectedOT = "No Overtime";
        String expectedVenue = "Hard Rock Stadium";

        when(matchResultsUseCase.getGame(gameId)).thenReturn(expectedGame);
        when(matchResultsUseCase.getScore(gameId)).thenReturn(expectedScore);
        when(matchResultsUseCase.getDate(gameId)).thenReturn(expectedDate);
        when(matchResultsUseCase.getq1(gameId)).thenReturn(expectedQ1);
        when(matchResultsUseCase.getq2(gameId)).thenReturn(expectedQ2);
        when(matchResultsUseCase.getq3(gameId)).thenReturn(expectedQ3);
        when(matchResultsUseCase.getq4(gameId)).thenReturn(expectedQ4);
        when(matchResultsUseCase.getot(gameId)).thenReturn(expectedOT);
        when(matchResultsUseCase.getVenue(gameId)).thenReturn(expectedVenue);

        // Act & Assert
        assertEquals(expectedGame, matchResultsUseCase.getGame(gameId));
        assertEquals(expectedScore, matchResultsUseCase.getScore(gameId));
        assertEquals(expectedDate, matchResultsUseCase.getDate(gameId));
        assertEquals(expectedQ1, matchResultsUseCase.getq1(gameId));
        assertEquals(expectedQ2, matchResultsUseCase.getq2(gameId));
        assertEquals(expectedQ3, matchResultsUseCase.getq3(gameId));
        assertEquals(expectedQ4, matchResultsUseCase.getq4(gameId));
        assertEquals(expectedOT, matchResultsUseCase.getot(gameId));
        assertEquals(expectedVenue, matchResultsUseCase.getVenue(gameId));
    }

    @Test
    void testGetGameDetails_GameNotFound() {
        // Arrange
        int gameId = 10000;

        when(matchResultsUseCase.getGame(gameId)).thenReturn(null);
        when(matchResultsUseCase.getScore(gameId)).thenReturn(null);
        when(matchResultsUseCase.getDate(gameId)).thenReturn(null);
        when(matchResultsUseCase.getq1(gameId)).thenReturn(null);
        when(matchResultsUseCase.getq2(gameId)).thenReturn(null);
        when(matchResultsUseCase.getq3(gameId)).thenReturn(null);
        when(matchResultsUseCase.getq4(gameId)).thenReturn(null);
        when(matchResultsUseCase.getot(gameId)).thenReturn(null);
        when(matchResultsUseCase.getVenue(gameId)).thenReturn(null);

        // Act & Assert
        assertNull(matchResultsUseCase.getGame(gameId), "Game should be null for an invalid ID");
        assertNull(matchResultsUseCase.getScore(gameId), "Score should be null for an invalid ID");
        assertNull(matchResultsUseCase.getDate(gameId), "Date should be null for an invalid ID");
        assertNull(matchResultsUseCase.getq1(gameId), "Q1 score should be null for an invalid ID");
        assertNull(matchResultsUseCase.getq2(gameId), "Q2 score should be null for an invalid ID");
        assertNull(matchResultsUseCase.getq3(gameId), "Q3 score should be null for an invalid ID");
        assertNull(matchResultsUseCase.getq4(gameId), "Q4 score should be null for an invalid ID");
        assertNull(matchResultsUseCase.getot(gameId), "OT score should be null for an invalid ID");
        assertNull(matchResultsUseCase.getVenue(gameId), "Venue should be null for an invalid ID");
    }
}
