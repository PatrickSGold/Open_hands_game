import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


class UserTest {

    private User user;

    @BeforeEach
    void init () {
        user = new User();
    }

    @org.junit.jupiter.api.Test
    void promptUserForInput() {
        user.setTurn(1);
        user.userAnswer = "OO2";
        assertTrue(user.userAnswer.length() == 3);
    }

    @org.junit.jupiter.api.Test
    void getUserPredictionNumber() {
        user.setTurn(1);
        user.userAnswer = "OO2";
        user.userPredictionNumber = Integer.parseInt(user.userAnswer.substring(2, 3));
        assertEquals(2, user.userPredictionNumber);
    }

    @org.junit.jupiter.api.Test
    void countUserOpenHands() {
        user.setTurn(1);
        user.userAnswer = "OO2";
        user.countUserOpenHands();
        assertEquals(2, user.userOpenHands);
        user.userOpenHands = 0;
        user.userAnswer = "oc2";
        user.countUserOpenHands();
        assertEquals(1, user.userOpenHands);
    }

    @org.junit.jupiter.api.Test
    void setTurn() {
        user.setTurn(5);
        assertEquals(5, user.turn);
    }
}