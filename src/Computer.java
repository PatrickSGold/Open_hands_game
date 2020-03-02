// create computer class and declare field variables
class Computer {
    public int turn = 1;
    int computerOpenHands = 0;
    String computerAnswer = "";
    int computerPredictorNumber = 0;

    // create computer object
    Computer() {
    }

    // get input from computer
    public void getComputerAnswer() {
        // loop that runs twice, to get number of open or closed hands
        for (int i = 0; i < 2; i++) {
            if ((int) (Math.random() * 101) < 50) { // random number < 50 == open hand, random number > 50 == closed hand
                computerAnswer += 'O';
            }

            else {
                computerAnswer += 'C';
            }
        }

        // if computer is predictor, add predictor number to computer's answer
        if (turn % 2 == 0) {
            computerAnswer += (int)(Math.random() * 5);
        }
    }

    // count number of open hands in computer's answer
    public void countComputerOpenHands() {

        // count number of open hands and increment computerOpenHands variable
        if (computerAnswer.charAt(0) == 'O' || computerAnswer.charAt(0) == 'o') {
            computerOpenHands++;
        }
        if (computerAnswer.charAt(1) == 'O' || computerAnswer.charAt(1) == 'o') {
            computerOpenHands++;
        }
    }

    // if computer if predictor, get predictor number
    public void getComputerPredictorNumber() {
        if (turn % 2 == 0) {
            computerPredictorNumber = Integer.parseInt(computerAnswer.substring(2, 3));
        }
    }

    // allow user to set the turn number
    public void setTurn(int currentTurn) {
        turn = currentTurn;
    }

}
