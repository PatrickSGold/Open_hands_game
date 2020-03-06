package Main;
import java.util.Random;

public class Computer {
    Random random = new Random();
    private int turn = 1;
    private String computerAnswer = "";

    public void generateComputerOpenOrClosedAnswer() {
        while (computerAnswer.length() != 2) {
            // if random number < 50 == open hand, else == closed hand
            if ((random.nextInt(100 - 1) + 1) < 50) {
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

        try {
            if (checkIfComputerIsPredictor() == true) {
                computerAnswer += random.nextInt(4 - 1) + 1;  // generate prediction number
                computerPredictionNumber = Integer.parseInt(computerAnswer.substring(2, 3));
            }
        }

        catch (NumberFormatException e) {
            System.out.println("The generated prediction number is not a number");
        }

            return computerPredictionNumber;
        }


    public boolean checkIfComputerIsPredictor() {  // made public instead of private for testing
        if (this.turn % 2 == 0) {
            return true;
        }

        else {
            return false;
        }
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