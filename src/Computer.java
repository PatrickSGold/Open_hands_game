class Computer {
    public int turn = 1;
    int computerOpenHands = 0;
    String computerAnswer = "";
    int computerPredictionNumber = 0;

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

    public int countComputerOpenHands() {
        if (computerAnswer.charAt(0) == 'O' || computerAnswer.charAt(0) == 'o') {
            computerOpenHands++;
        }
        if (computerAnswer.charAt(1) == 'O' || computerAnswer.charAt(1) == 'o') {
            computerOpenHands++;
        }
        return computerOpenHands;
    }

    public int getComputerPredictionNumber() {
        if (turn % 2 == 0) {
            computerPredictionNumber = Integer.parseInt(computerAnswer.substring(2, 3));
        }
        return computerPredictionNumber;
    }

    public void setTurn(int currentTurn) {
        turn = currentTurn;
    }

}