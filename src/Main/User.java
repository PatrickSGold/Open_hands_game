package Main;

import java.util.Scanner;

public class User {

    private int turn = 1;
    private String userAnswer;
    private int userPredictionNumber;

    public void promptUserForInput() {
        Scanner input = new Scanner(System.in);

        if (checkIfUserIsPredictor(turn) == true) {
            System.out.println("You are the predictor.");
        }

        else {
            System.out.println("You are not the predictor");
        }

        System.out.println("What is your input? ");
        userAnswer = input.nextLine();

        checkAllInput(getUserAnswer());
    }

    private void checkAllInput(String userAnswer) {
        if (checkIfUserIsPredictor(turn) == true) {
            checkInputLengthUserIsPredictor(getUserAnswer());
            calculateAndCheckUserPredictionNumber(getUserAnswer());
        }
        else {
            checkInputLengthUserNotPredictor(getUserAnswer());
        }
        checkIfOpenClosedExist(getUserAnswer());
    }

    private void checkInputLengthUserIsPredictor(String userAnswer) {
        if (userAnswer.length() != 3) {
            System.out.println("Bad input: correct input should be of the form CC3, " +
                    "where the first two letters indicate [O]pen or [C]losed state for each hand, " +
                    "followed by the prediction (0-4).");

            promptUserForInput();  // start over
        }
    }

    private void checkInputLengthUserNotPredictor(String userAnswer) {
        if (userAnswer.length() < 2 || userAnswer.length() > 3) {
            System.out.println("Bad input: correct input should be of the form OC, " +
                    "where the letters indicate [O]pen or [C]losed state for each hand.");

            promptUserForInput();
        }

        else if (userAnswer.length() == 3) {
            System.out.println("Bad input: no prediction expected, you are not the predictor.");

            promptUserForInput();
        }
    }

    public boolean checkIfOpenClosedExist(String userAnswer) {  // made public instead of private for testing
        boolean opedClosedExists = false;

        if ((userAnswer.charAt(0) == 'O'
                || userAnswer.charAt(0) == 'o'
                || userAnswer.charAt(0) == 'C'
                || userAnswer.charAt(0) == 'c')
                &&
                (userAnswer.charAt(1) == 'O'
                || userAnswer.charAt(1) == 'o'
                || userAnswer.charAt(1) == 'C'
                || userAnswer.charAt(1) == 'c')) {

            opedClosedExists = true;
        }
        else {
            System.out.println("Bad input: the first two letters should indicate [O]pen or [C]losed state for each hand.");
            promptUserForInput();
        }
        return opedClosedExists;
    }

    public int calculateAndCheckUserPredictionNumber(String userAnswer) {  // made public instead of private for testing
        try {
            userPredictionNumber = Integer.parseInt(userAnswer.substring(2, 3));
        }
        catch (NumberFormatException e) {
            System.out.println("Bad input. Prediction should be a number, in the range of 1-4.");

            promptUserForInput();
        }
        checkUserPredictionNumberRange();
        return userPredictionNumber;
    }

    public boolean checkUserPredictionNumberRange() {   // made public instead of private for testing
        boolean inRange = false;
        if (userPredictionNumber <= 0 || userPredictionNumber > 4) {
            System.out.println("Bad input. Prediction should be in the range of 1-4.");

            promptUserForInput();
        }
        else {
            inRange = true;
        }
        return inRange;
    }

    public int countUserOpenHands(String userAnswer) {
        int userOpenHands = 0;

        if (userAnswer.charAt(0) == 'O' || userAnswer.charAt(0) == 'o') {
            userOpenHands++;
        }
        if (userAnswer.charAt(1) == 'O' || userAnswer.charAt(1) == 'o') {
            userOpenHands++;
        }
        return userOpenHands;
    }

    public boolean checkIfUserIsPredictor(int turn) {  // made public instead of private for testing
        boolean userIsPredictor = false;

        if (turn % 2 != 0) {
            userIsPredictor = true;
        }
        return userIsPredictor;
    }

    public void setTurn(int currentTurn) {
        turn = currentTurn;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public int getUserPredictionNumber() {
        return userPredictionNumber;
    }

    public boolean getCheckIfUserIsPredictor() {
        return checkIfUserIsPredictor(turn);
    }
}

