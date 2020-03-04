import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    User user = new User();
    Computer computer = new Computer();

    @Test
    void main() {
        int turn = 1;
        int openHands = 0;
        int predictionNumber = 0;
        boolean stopPlaying = false;
        String playAgainAnswer = "";

        user.setTurn(turn);
        user.userPredictionNumber("OO2");
        user.countUserOpenHands("OO2");
        assertEquals(2, user.getUserPredictionNumber());
        openHands += user.getUserOpenHands();
        assertEquals(2, openHands);


        computer.setTurn(turn);
        computer.computerAnswer = "OO";
        computer.getComputerPredictionNumber();
        computer.countComputerOpenHands();
        openHands += computer.computerOpenHands;
        assertTrue(openHands == user.getUserOpenHands() + computer.computerOpenHands);
        assertEquals(4, openHands);

        if (turn % 2 != 0) {
            predictionNumber = user.userPredictionNumber("OO3");
            assertEquals(3, predictionNumber);
        }
        else {
            computer.computerAnswer = "OO2";
            predictionNumber = computer.computerPredictionNumber;
            assertEquals(2, predictionNumber);
        }

        if (playAgainAnswer.equalsIgnoreCase("no")) {
            assertTrue(stopPlaying = true);
        }
    }
}