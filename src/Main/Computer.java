package Main;

public class Computer {
    private int turn = 1;
    private String computerAnswer = "";

    public void computerAnswer() {
        // loop to generate open and closed hands in computer's answer
        for (int i = 0; i < 2; i++) {
            // random number < 50 == open hand, random number > 50 == closed hand
            if ((int)(Math.random() * 101) < 50) {
                computerAnswer += 'O';
            }
            else {
                computerAnswer += 'C';
            }
        }
    }

    public int countComputerOpenHands(String computerAnswer) {
        int computerOpenHands = 0;

        if (computerAnswer.charAt(0) == 'O' || computerAnswer.charAt(0) == 'o') {
            computerOpenHands++;
        }
        if (computerAnswer.charAt(1) == 'O' || computerAnswer.charAt(1) == 'o') {
            computerOpenHands++;
        }
        return computerOpenHands;
    }

    public int computerPredictionNumber() {
        int computerPredictionNumber = 0;

        if (checkIfComputerIsPredictor(turn) == true) {
            computerAnswer += (int)(Math.random() * 5);  // generate prediction number
            computerPredictionNumber = Integer.parseInt(computerAnswer.substring(2, 3));
        }
        return computerPredictionNumber;
    }

    public boolean checkIfComputerIsPredictor(int turn) {  // made public instead of private for testing
        boolean computerIsPredictor = false;
        if (turn % 2 == 0) {
            computerIsPredictor = true;
        }
        return computerIsPredictor;
    }

    public void setTurn(int currentTurn) {
        turn = currentTurn;
    }

    public void setComputerAnswer(String newComputerAnswer) {
        computerAnswer = newComputerAnswer;
    }

    public String getComputerAnswer() {
        return computerAnswer;
    }

}