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
        user.setUserAnswer("OO2");
        assertTrue(user.getUserAnswer().length() == 3);
    }

    @org.junit.jupiter.api.Test
    void getUserPredictionNumber() {
        user.setTurn(1);
        user.userPredictionNumber("OO3");
        assertEquals(3, user.getUserPredictionNumber());
    }

    @org.junit.jupiter.api.Test
    void countUserOpenHands() {
        user.setTurn(1);
        user.countUserOpenHands("OO1");
        assertEquals(2, user.getUserOpenHands());
    }


}