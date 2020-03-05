package Test;
import Main.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void init() {
        user = new User();
    }

    @org.junit.jupiter.api.Test
    void promptUserForInput() {
    }

    @org.junit.jupiter.api.Test
    void checkAllInput() {
    }

    @org.junit.jupiter.api.Test
    void checkInputLengthUserIsPredictor() {
    }

    @org.junit.jupiter.api.Test
    void checkInputLengthUserNotPredictor() {
    }

    @org.junit.jupiter.api.Test
    void checkIfOpenClosedExist() {
        assertTrue(user.checkIfOpenClosedExist("OC2"));
    }

    @org.junit.jupiter.api.Test
    void calculateAndCheckUserPredictionNumber() {
        assertEquals(2, user.calculateAndCheckUserPredictionNumber("OO2"));
    }

    @org.junit.jupiter.api.Test
    void checkUserPredictionNumberRange() {
    }

    @org.junit.jupiter.api.Test
    void countUserOpenHands() {
        assertEquals(2, user.countUserOpenHands("OO2"));
        assertEquals(0, user.countUserOpenHands("CC3"));
    }

    @org.junit.jupiter.api.Test
    void checkIfUserIsPredictor() {
        assertTrue(user.checkIfUserIsPredictor(1));
        assertFalse(user.checkIfUserIsPredictor(2));
    }


}