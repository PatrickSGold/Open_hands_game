package Test;
import Main.Computer;
import Main.User;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    Computer computer;

    @BeforeEach
    void init() {
        user = new User();
        computer = new Computer();
    }


    @org.junit.jupiter.api.Test
    void checkIfOpenClosedExist() {
        boolean correctInput = false;
        user.setUserAnswer("oC");

        if ((user.getUserAnswer().charAt(0) == 'O'
                || user.getUserAnswer().charAt(0) == 'o'
                || user.getUserAnswer().charAt(0) == 'C'
                || user.getUserAnswer().charAt(0) == 'c')
                &&
                (user.getUserAnswer().charAt(1) == 'O'
                        || user.getUserAnswer().charAt(1) == 'o'
                        || user.getUserAnswer().charAt(1) == 'C'
                        || user.getUserAnswer().charAt(1) == 'c')) {
            correctInput = true;
        }
        else {
            correctInput = false;
        }

        assertTrue(correctInput == true);
    }

    @org.junit.jupiter.api.Test
    void checkUserPredictionNumber() {
        user.setUserAnswer("OO2");
        int userPredictionNumber = Integer.parseInt(user.getUserAnswer().substring(2, 3));
        assertEquals(2, userPredictionNumber);
    }

    @org.junit.jupiter.api.Test
    void countUserOpenHands() {
        assertEquals(2, user.getUserOpenHands("OO2"));
        assertEquals(0, user.getUserOpenHands("CC3"));
        assertNotEquals(2, user.getUserOpenHands("OC"));
    }

    @org.junit.jupiter.api.Test
    void userIsPredictor() {
        user.setTurn(1);
        assertTrue(user.userIsPredictor());
        user.setTurn(2);
        assertFalse(user.userIsPredictor());
    }



}