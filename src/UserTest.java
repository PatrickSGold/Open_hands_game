import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user1 = new User();

    @org.junit.jupiter.api.Test
    void promptUserForInput() {
        user1.setTurn(1);
        user1.userAnswer = "OO2";
        assertTrue(user1.userAnswer.length() == 3);
        user1.userPredictorNumber = Integer.parseInt(user1.userAnswer.substring(2, 3));
        assertEquals(2, user1.userPredictorNumber);
    }

    @org.junit.jupiter.api.Test
    void countUserOpenHands() {
        user1.setTurn(1);
        user1.userAnswer = "OO2";
        user1.countUserOpenHands();
        assertEquals(2, user1.userOpenHands);
        user1.userOpenHands = 0;
        user1.userAnswer = "oc2";
        user1.countUserOpenHands();
        assertEquals(1, user1.userOpenHands);
    }

    @org.junit.jupiter.api.Test
    void setTurn() {
        user1.setTurn(5);
        assertEquals(5, user1.turn);
    }
}