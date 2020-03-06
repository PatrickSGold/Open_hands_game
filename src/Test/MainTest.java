package Test;

import Main.Computer;
import Main.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main.User user;
    Computer computer;


    @BeforeEach
    void init() {
        computer = new Computer();
        user = new User();
    }

    @Test
    void main() {
    }

    @Test
    void checkIfPredictionNumberIsAssignedToUserOnUnevenTurns() {
        int predictionNumber = 0;

        if (user.checkIfUserIsPredictor(1) == true) {
            predictionNumber = user.getUserPredictionNumber();
        }
        else {
            predictionNumber = computer.computerPredictionNumber();
        }

        assertTrue(predictionNumber == computer.computerPredictionNumber());  // test runs with no errors
        assertTrue(predictionNumber == user.getUserPredictionNumber());       // but only this is supposed to be true
    }

    @Test
    void checkIfPredictionNumberIsAssignedToComputerOnEvenTurns() {
        user.checkIfUserIsPredictor(1);

        int predictionNumber;
        if (user.checkIfUserIsPredictor(2) == true) {
            predictionNumber = user.getUserPredictionNumber();
        }
        else {
            predictionNumber = computer.computerPredictionNumber();
        }

        assertTrue(predictionNumber == user.getUserPredictionNumber());       // test runs with no errors
        assertTrue(predictionNumber == computer.computerPredictionNumber());  // but only this is supposed to be true
    }

}