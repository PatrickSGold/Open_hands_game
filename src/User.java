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

        // check if input is correct format
        if (turn % 2 != 0) {  // check if user is predictor
            if (userAnswer.length() != 3) {  // display message if answer is != 3 characters long
                System.out.println("Bad input: correct input should be of the form CC3, " +
                        "where the first two letters indicate [O]pen or [C]losed state for each hand, " +
                        "followed by the prediction (0-4).");

                // start over
                promptUserForInput();
            }

        }

        if (turn % 2 == 0) {  // if user is not predictor
            if (userAnswer.length() != 2) {   // display message if user answer is != 2
                System.out.println("Bad input: correct input should be of the form OC, " +
                        "where the letters indicate [O]pen or [C]losed state for each hand.");

                // start over
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

    // get the user's predictor number
    public void getUserPredictorNumber() {
        if (turn % 2 != 0) {  // check that user is predictor
            userPredictorNumber = Integer.parseInt(userAnswer.substring(2, 3));

            // Display message if prediction number is not in the range of 1-4
            if (userPredictorNumber <= 0 || userPredictorNumber > 4) {
                System.out.println("Bad input. Prediction should be in the range of 1-4.");

                // start over
                promptUserForInput();
            }
        }
    }

        // count number of open hands in user's answer
        public void countUserOpenHands () {

            // count open hands and increment userOpenHands variable
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



