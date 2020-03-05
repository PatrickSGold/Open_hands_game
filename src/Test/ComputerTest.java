package Test;
import Main.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    void init() {
        computer = new Computer();
    }

    @Test
    void computerAnswerIfUserIsNotPredictor() {
        computer.setTurn(1);
        computer.computerAnswer();
        computer.computerPredictionNumber();
        assertEquals(2, computer.getComputerAnswer().length());
    }

    @Test
    void computerAnswerIfUserIsPredictor() {
        computer.setTurn(2);
        computer.computerAnswer();
        computer.computerPredictionNumber();
        assertEquals(3, computer.getComputerAnswer().length());
    }

    @Test
    void countComputerOpenHands() {
        assertEquals(1, computer.countComputerOpenHands("OC"));
        assertEquals(2, computer.countComputerOpenHands("OO"));
        assertEquals(0, computer.countComputerOpenHands("CC"));
    }

    @Test
    void computerPredictionNumberAddedToComputerAnswerIfComputerIsPredictor() {
        computer.setTurn(2);
        computer.computerAnswer();
        computer.computerPredictionNumber();
        assertEquals(3, computer.getComputerAnswer().length());
    }

    @Test
    void computerPredictionNumberNotAddedToComputerAnswerIfComputerIsNotPredictor() {
        computer.setTurn(1);
        computer.computerAnswer();
        computer.computerPredictionNumber();
        assertEquals(2, computer.getComputerAnswer().length());
    }

    @Test
    @Disabled
    void checkComputerPredictionNumberIsCorrect() {
        computer.setTurn(2);
        computer.checkIfComputerIsPredictor(2);
        computer.computerAnswer();
        computer.computerPredictionNumber();
        assertTrue(computer.getComputerAnswer().charAt(2) == 1
                || computer.getComputerAnswer().charAt(2) == 2
                || computer.getComputerAnswer().charAt(2) == 3
                || computer.getComputerAnswer().charAt(2) == 4);
    }
    @Test
    void checkIfComputerIsPredictor() {
        assertTrue(computer.checkIfComputerIsPredictor(2));
        assertFalse(computer.checkIfComputerIsPredictor(1));

    }

}