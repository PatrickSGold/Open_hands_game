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
        assertEquals(4, user.getUserOpenHands("OO2") + computer.getComputerOpenHands("OO"));
        assertNotEquals(2, user.getUserOpenHands("OO2") + computer.getComputerOpenHands("OO"));
    }

    @org.junit.jupiter.api.Test
    void assignPredictionNumber() {
        int predictionNumber = 0;
        user.setTurn(1);

        if (user.userIsPredictor()) {
            predictionNumber = user.getUserPredictionNumber();
        }

        else {
            predictionNumber = computer.getComputerPredictionNumber();
        }

        assertTrue(predictionNumber == user.getUserPredictionNumber());
    }

    @Test
    void gameIsWon() {
        user.setTurn(1);
        user.userIsPredictor();
        user.setUserAnswer("OO2");
    }

    @Test
    void replayAnswerCorrectFormat() {
        play.setPlayAgainAnswer("yes");
        assertTrue(play.replayAnswerCorrectFormat());
        play.setPlayAgainAnswer("no");
        assertTrue(play.replayAnswerCorrectFormat());
        play.setPlayAgainAnswer("ye");
        assertFalse(play.replayAnswerCorrectFormat());
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