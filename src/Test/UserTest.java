package Test;
import Main.User;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void init() {
        user = new User();
    }

    @org.junit.jupiter.api.Test
    void checkIfOpenClosedExist() {
        assertTrue(user.checkIfOpenClosedExist("OC2"));
        assertFalse(user.checkIfOpenClosedExist("AC2"));
    }

    @org.junit.jupiter.api.Test
    void calculateAndCheckUserPredictionNumber() {
        assertEquals(2, user.calculateAndCheckUserPredictionNumber("OO2"));
    }

    @org.junit.jupiter.api.Test
    void countUserOpenHands() {
        assertEquals(2, user.countUserOpenHands("OO2"));
        assertEquals(0, user.countUserOpenHands("CC3"));
    }

    @org.junit.jupiter.api.Test
    void checkIfUserIsPredictor() {
        user.setTurn(1);
        assertTrue(user.userIsPredictor());
        user.setTurn(2);
        assertFalse(user.userIsPredictor());
    }


}