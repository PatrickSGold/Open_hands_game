package Test;
import Main.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    Computer computer;

    @BeforeEach
    void init() {
        computer = new Computer();
    }

    @Test
    void computerAnswerIfUserIsNotPredictor() {
        computer.setTurn(2);
        computer.generateComputerOpenOrClosedAnswer();
        computer.getComputerPredictionNumber();

        assertEquals(3, computer.getComputerAnswer().length());
    }

    @Test
    void computerAnswerIfUserIsPredictor() {
        computer.setTurn(2);
        computer.generateComputerOpenOrClosedAnswer();
        computer.getComputerPredictionNumber();
        assertEquals(3, computer.getComputerAnswer().length());
    }

    @Test
    void countComputerOpenHands() {
        assertEquals(1, computer.getComputerOpenHands("OC"));
        assertEquals(2, computer.getComputerOpenHands("OO"));
        assertEquals(0, computer.getComputerOpenHands("CC"));
    }

    @Test
    void computerPredictionNumberAddedToComputerAnswerIfComputerIsPredictor() {
        computer.setTurn(2);
        computer.generateComputerOpenOrClosedAnswer();
        computer.getComputerPredictionNumber();
        assertEquals(3, computer.getComputerAnswer().length());
    }


    @Test
    void checkIfComputerIsPredictor() {
        int turn = 2;
        boolean computerIsPredictor = false;
        boolean userIsPredictor = false;

        if (turn % 2 == 0) {
            computerIsPredictor = true;
        }
        else {
            userIsPredictor = true;
        }
        assertTrue(computerIsPredictor);
        assertFalse(userIsPredictor);
    }

}