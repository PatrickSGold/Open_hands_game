package Test;

import Main.Computer;
import Main.Play;
import Main.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayTest {

    Computer computer;
    User user;
    Play play;

    @BeforeEach
    void setUp() {
        computer = new Computer();
        user = new User();
        play = new Play();

    }

    @org.junit.jupiter.api.Test
    void totalOpenHands() {
        assertEquals(4, user.countUserOpenHands("OO2") + computer.countComputerOpenHands("OO"));
        assertNotEquals(2, user.countUserOpenHands("OO2") + computer.countComputerOpenHands("OO"));
    }

    @org.junit.jupiter.api.Test
    void assignPredictionNumber() {   // cannot get this test to work??
    }

    @Test
    void gameIsWon() {
        user.setTurn(1);
        user.userIsPredictor();
        user.setUserAnswer("OO2");
    }

    @Test
    void replayAnswerFormatCorrect() {
        play.setPlayAgainAnswer("yes");
        assertTrue(play.replayAnswerFormatCorrect());
        play.setPlayAgainAnswer("no");
        assertTrue(play.replayAnswerFormatCorrect());
        play.setPlayAgainAnswer("ye");
        assertFalse(play.replayAnswerFormatCorrect());
    }

    @Test
    void endGame() {
        play.setPlayAgainAnswer("no");
        assertTrue(play.endGame());
        play.setPlayAgainAnswer("yes");
        assertFalse(play.endGame());
    }

    @Test
    void replayGame() {
        play.setPlayAgainAnswer("yes");
        assertTrue(play.replayGame());
        play.setPlayAgainAnswer("no");
        assertFalse(play.replayGame());
    }

    @Test
    void resetComputerAnswerBeforeNextRound() {
        play.resetComputerAnswerBeforeNextRound();
        assertTrue(computer.getComputerAnswer().length() == 0);;
    }
}