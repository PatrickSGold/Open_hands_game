// declare field variables
class Computer {
    public int turn = 1;
    int computerOpenHands = 0;
    String computerAnswer = "";
    int computerPredictionNumber = 0;

    // create default constructor
    Computer() {
    }

    // get input from computer
    public void getComputerAnswer() {
        // loop to generate total number of open or closed hands in computer's input
        for (int i = 0; i < 2; i++) {
            // random number < 50 == open hand, random number > 50 == closed hand
            if ((int)(Math.random() * 101) < 50) {
                computerAnswer += 'O';
            }
            else {
                computerAnswer += 'C';
            }
        }

        // if computer is predictor, add prediction number to computer's input
        if (turn % 2 == 0) {
            computerAnswer += (int)(Math.random() * 5);
        }
    }

    // count and increment number of open hands in computer's input
    public void countComputerOpenHands() {

        // count number of open hands and increment computerOpenHands variable
        if (computerAnswer.charAt(0) == 'O' || computerAnswer.charAt(0) == 'o') {
            computerOpenHands++;
        }
        if (computerAnswer.charAt(1) == 'O' || computerAnswer.charAt(1) == 'o') {
            computerOpenHands++;
        }
    }

    // if computer if predictor, assign prediction number to variable
    public void getComputerPredictionNumber() {
        if (turn % 2 == 0) {
            computerPredictionNumber = Integer.parseInt(computerAnswer.substring(2, 3));
        }
    }

    // allow user to set the turn number
    public void setTurn(int currentTurn) {
        turn = currentTurn;
    }

}
