import java.util.Scanner;

// declare field variables
class User {
    int turn = 1;
    int userOpenHands = 0;
    String userAnswer;
    int userPredictionNumber;

    // create default constructor
    User() {
    }

    // prompt user for input
    public void promptUserForInput() {
        Scanner input = new Scanner(System.in);

        // display message if user is the predictor
        if (turn % 2 != 0) {
            System.out.println("You are the predictor.");
        }

        // display message if user is not the predictor
        else {
            System.out.println("You are not the predictor");
        }

        // store input
        System.out.println("What is your input? ");
        userAnswer = input.nextLine();

        // display message if input length is incorrect and user is the predictor
        if (turn % 2 != 0) {
            if (userAnswer.length() != 3) {
                System.out.println("Bad input: correct input should be of the form CC3, " +
                        "where the first two letters indicate [O]pen or [C]losed state for each hand, " +
                        "followed by the prediction (0-4).");

                // start over
                promptUserForInput();
            }

        }
        // display message if input length is incorrect and user is not the predictor
        if (turn % 2 == 0) {
            if (userAnswer.length() < 2 || userAnswer.length() > 3) {
                System.out.println("Bad input: correct input should be of the form OC, " +
                        "where the letters indicate [O]pen or [C]losed state for each hand.");

                // start over
                promptUserForInput();
            }

            // display message if input length == 3, but user is not the predictor
            else if (userAnswer.length() == 3) {
                System.out.println("Bad input: no prediction expected, you are not the predictor.");

                // start over
                promptUserForInput();
            }
        }


        // check if input for open or closed hands is correct
        for (int i = 0; i < 2; i++) {
            switch (userAnswer.charAt(i)) {
                case 'O': break;
                case 'o': break;
                case 'C': break;
                case 'c': break;
                default:  // display message if input is not allowed
                    System.out.println("Bad input: correct input should be of the form CC3, " +
                            "where the first two letters indicate [O]pen or [C]losed state for each hand, " +
                            "followed by the prediction (0-4).");

                    // start over
                    promptUserForInput();
                    break;
            }
        }
    }

    // if user is predictor, obtain prediction number
    public void getUserPredictionNumber() {
        if (turn % 2 != 0) {
            try {
                userPredictionNumber = Integer.parseInt(userAnswer.substring(2, 3));
            }
            catch (NumberFormatException e) {
                System.out.println("Bad input. Prediction should be a number, in the range of 1-4.");

                promptUserForInput();
                getUserPredictionNumber();
            }

            // Display message if prediction number is not in the range of 1-4
            if (userPredictionNumber <= 0 || userPredictionNumber > 4) {
                System.out.println("Bad input. Prediction should be in the range of 1-4.");

                // start over
                promptUserForInput();
                getUserPredictionNumber();
            }
        }
    }

    // count and increment number of open hands in user's input
    public void countUserOpenHands () {
        if (userAnswer.charAt(0) == 'O' || userAnswer.charAt(0) == 'o') {
            userOpenHands++;
        }
        if (userAnswer.charAt(1) == 'O' || userAnswer.charAt(1) == 'o') {
            userOpenHands++;
        }
    }

    // allow the user to set the turn number
    public void setTurn ( int currentTurn){
        turn = currentTurn;
    }
}
