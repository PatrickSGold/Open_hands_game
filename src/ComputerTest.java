import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    Computer computer1 = new Computer();

    @Test
    void getComputerAnswer() {
        computer1.getComputerAnswer();
        if (computer1.turn == 1) {
            assertEquals(2, computer1.computerAnswer.length());
        }
        else {
            assertEquals(3, computer1.computerAnswer.length());
        }
    }

    @Test
    void countComputerOpenHands() {
        computer1.getComputerAnswer();
        if (computer1.computerAnswer == "OC") {
            assertEquals(1, computer1.computerOpenHands);
        }
        if (computer1.computerAnswer == "oo") {
            assertEquals(2, computer1.computerOpenHands);
        }
    }

    @Test
    void getComputerPredictorNumber() {
        if (computer1.turn % 2 == 0) {
            computer1.computerAnswer = "oc2";
            computer1.getComputerPredictorNumber();
            assertEquals(2,computer1.computerPredictorNumber);
        }
    }

    @Test
    void setTurn() {
        computer1.setTurn(5);
        assertEquals(5, computer1.turn);
    }
}