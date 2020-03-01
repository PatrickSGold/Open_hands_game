import java.util.Scanner;

// create user class and declare field variables
class User {
    int turn = 1;
    int userOpenHands = 0;
    String userAnswer;
    int userPredictorNumber;

    // create user object
    User() {
    }

    // get input from user
    public void promptUserForInput() {
        Scanner input = new Scanner(System.in);

        // user is the predictor
        if (turn % 2 != 0) {
            System.out.println("You are the predictor.");
        }

        // user is not the predictor
        else {
            System.out.println("You are not the predictor");
        }

        // prompt for input
        System.out.println("What is your input? ");
        userAnswer = input.nextLine();

        if (turn % 2 != 0) {
            userPredictorNumber = Integer.parseInt(userAnswer.substring(2, 3));
        }

        // check if input is correct format
        // if user is predictor
        // if user answer is less or more than 3 characters
        if (turn % 2 != 0) {
            if (userAnswer.length() != 3) {
                System.out.println("Bad input: correct input should be of the form CC3, " +
                        "where the first two letters indicate [O]pen or [C]losed state for each hand, " +
                        "followed by the prediction (0-4).");

                promptUserForInput();
            }

            // if user predictor number is not in the range of 1-4
            if (userPredictorNumber <= 0 || userPredictorNumber > 4) {
                System.out.println("Bad input. Prediction should be in the range of 1-4.");

                promptUserForInput();
            }
        }

        // if user is not predictor
        // if user answer is less or more than 2
        if (turn % 2 == 0) {
            if (userAnswer.length() != 2) {
                System.out.println("Bad input: correct input should be of the form OC, " +
                        "where the letters indicate [O]pen or [C]losed state for each hand.");

                promptUserForInput();
            }
        }

        // check if open or closed hands response is correct format
        for (int i = 0; i < 2; i++) {
            switch (userAnswer.charAt(i)) {
                case 'O': break;
                case 'o': break;
                case 'C': break;
                case 'c': break;
                default:
                    System.out.println("Bad input: correct input should be of the form CC3, " +
                            "where the first two letters indicate [O]pen or [C]losed state for each hand, " +
                            "followed by the prediction (0-4).");

                    promptUserForInput();
                    break;
            }
        }
    }

    // count number of open hands in user's answer
    public void countUserOpenHands() {

        // count open hands
        if (userAnswer.charAt(0) == 'O' || userAnswer.charAt(0) == 'o') {
            userOpenHands++;
        }
        if (userAnswer.charAt(1) == 'O' || userAnswer.charAt(1) == 'o') {
            userOpenHands++;
        }
    }

    // allow the user to set the turn number
    public void setTurn(int currentTurn) {
        turn = currentTurn;
    }


}

