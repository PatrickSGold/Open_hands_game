import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    User user1 = new User();
    Computer computer1 = new Computer();

    @Test
    void main() {
        int turn = 1;
        int openHands = 0;
        int predictorNumber = 0;
        boolean stopPlaying = false;
        String playAgainAnswer = "";

        user1.setTurn(turn);
        user1.userAnswer = "OO2";
        user1.userPredictorNumber = Integer.parseInt(user1.userAnswer.substring(2, 3));
        user1.countUserOpenHands();
        assertEquals(2, user1.userPredictorNumber);
        openHands += user1.userOpenHands;
        assertEquals(2, openHands);


        computer1.setTurn(turn);
        computer1.computerAnswer = "OO";
        computer1.getComputerPredictorNumber();
        computer1.countComputerOpenHands();
        openHands += computer1.computerOpenHands;
        assertTrue(openHands == user1.userOpenHands + computer1.computerOpenHands);
        assertEquals(4, openHands);

        if (turn % 2 != 0) {
            predictorNumber = user1.userPredictorNumber;
            assertEquals(2, predictorNumber);
        }
        else {
            computer1.computerAnswer = "OO2";
            predictorNumber = computer1.computerPredictorNumber;
            assertEquals(2, predictorNumber);
        }

        if (playAgainAnswer.equalsIgnoreCase("no")) {
            assertTrue(stopPlaying = true);
        }
    }
}

