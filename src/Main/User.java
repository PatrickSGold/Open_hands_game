package Main;

import java.util.Scanner;

public class User {

    private int turn = 1;
    private String userAnswer;
    private int userPredictionNumber;

    public void promptUserForInput() {
        Scanner input = new Scanner(System.in);

        if (userIsPredictor()) {
            System.out.println("\nYou are the predictor.");
        } else {
            System.out.println("\nYou are not the predictor");
        }

        System.out.print("What is your input? ");
        userAnswer = input.nextLine();

        checkAllInput();
    }

    private void checkAllInput() {
        checkIfOpenClosedExist(getUserAnswer());

        if (!checkIfOpenClosedExist(getUserAnswer())) {
            displayErrorMessageIfOpenClosedDoNotExist();
        }

        if (userIsPredictor()) {
            checkInputLengthUserIsPredictor(getUserAnswer());
            checkUserPredictionNumber(getUserAnswer());
        }

        else {
            checkInputLengthUserNotPredictor(getUserAnswer());
        }
    }

    private boolean checkIfOpenClosedExist(String userAnswer) {
        return (userAnswer.charAt(0) == 'O'
                || userAnswer.charAt(0) == 'o'
                || userAnswer.charAt(0) == 'C'
                || userAnswer.charAt(0) == 'c')
                &&
                (userAnswer.charAt(1) == 'O'
                        || userAnswer.charAt(1) == 'o'
                        || userAnswer.charAt(1) == 'C'
                        || userAnswer.charAt(1) == 'c');
    }

    private void checkInputLengthUserIsPredictor(String userAnswer) {
        if (userAnswer.length() != 3) {
            System.out.println("\nBad input: correct input should be of the form CC3, " +
                    "where the first two letters indicate [O]pen or [C]losed state for each hand, " +
                    "followed by the prediction (0-4).");

            promptUserForInput();  // start over
        }
    }

    private void checkUserPredictionNumberRange() {
        if (userPredictionNumber <= 0 || userPredictionNumber > 4) {
            System.out.println("\nBad input. Prediction should be in the range of 1-4.");

            promptUserForInput();
        }
    }

    private void checkInputLengthUserNotPredictor(String userAnswer) {
        if (userAnswer.length() < 2 || userAnswer.length() > 3) {
            System.out.println("\nBad input: correct input should be of the form OC, " +
                    "where the letters indicate [O]pen or [C]losed state for each hand.");

            promptUserForInput();
        }

        else if (userAnswer.length() == 3) {
            System.out.println("\nBad input: no prediction expected, you are not the predictor.");

            promptUserForInput();
        }
    }

    private void displayErrorMessageIfOpenClosedDoNotExist() {
        if (!checkIfOpenClosedExist(getUserAnswer())) {
            System.out.println("\nBad input: the first two letters should indicate [O]pen or [C]losed state for each hand.");

            promptUserForInput();
        }
    }

    private int checkUserPredictionNumber(String userAnswer) {
        try {
            userPredictionNumber = Integer.parseInt(userAnswer.substring(2, 3));
        }

        catch (NumberFormatException e) {
            System.out.println("\nBad input. Prediction should be a number, in the range of 1-4.");

            promptUserForInput();
        }

        checkUserPredictionNumberRange();
        return userPredictionNumber;
    }

    public int getUserOpenHands(String userAnswer) {
        int userOpenHands = 0;

        if (userAnswer.charAt(0) == 'O' || userAnswer.charAt(0) == 'o') {
            userOpenHands++;
        }

        if (userAnswer.charAt(1) == 'O' || userAnswer.charAt(1) == 'o') {
            userOpenHands++;
        }

        return userOpenHands;
    }

    public boolean userIsPredictor() {  // made public instead of private for testing
        return turn % 2 != 0;
    }

    public void setTurn(int currentTurn) {
        this.turn = currentTurn;
    }

    public void setUserAnswer(String newUserAnswer) {  // used for testing purposes
        userAnswer = newUserAnswer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public int getUserPredictionNumber() {
        return userPredictionNumber;
    }

}



