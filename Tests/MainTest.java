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
        user.userAnswer = "OO2";
        user.userPredictionNumber = Integer.parseInt(user.userAnswer.substring(2, 3));
        user.countUserOpenHands();
        assertEquals(2, user.userPredictionNumber);
        openHands += user.userOpenHands;
        assertEquals(2, openHands);


        computer.setTurn(turn);
        computer.computerAnswer = "OO";
        computer.getComputerPredictionNumber();
        computer.countComputerOpenHands();
        openHands += computer.computerOpenHands;
        assertTrue(openHands == user.userOpenHands + computer.computerOpenHands);
        assertEquals(4, openHands);

        if (turn % 2 != 0) {
            predictionNumber = user.userPredictionNumber;
            assertEquals(2, predictionNumber);
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