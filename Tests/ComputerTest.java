import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    void init() {
        computer = new Computer();
    }

    @Test
    void getComputerAnswer() {
        computer.getComputerAnswer();
        if (computer.turn == 1) {
            assertEquals(2, computer.computerAnswer.length());
        }
        else {
            assertEquals(3, computer.computerAnswer.length());
        }
    }

    @Test
    void countComputerOpenHands() {
        computer.getComputerAnswer();
        if (computer.computerAnswer == "OC") {
            assertEquals(1, computer.computerOpenHands);
        }
        if (computer.computerAnswer == "oo") {
            assertEquals(2, computer.computerOpenHands);
        }
    }

    @Test
    void getComputerPredictionNumber() {
        if (computer.turn % 2 == 0) {
            computer.computerAnswer = "oc2";
            computer.getComputerPredictionNumber();
            assertEquals(2,computer.computerPredictionNumber);
        }
    }

    @Test
    void setTurn() {
        computer.setTurn(5);
        assertEquals(5, computer.turn);
    }
}