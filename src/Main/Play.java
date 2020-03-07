package Main;

import java.util.Scanner;

public class Play {
    User user = new User();
    Computer computer = new Computer();

    private int turn = 1;
    private String playAgainAnswer = "";


    public void runUserAndComputerClass() {
        user.setTurn(this.turn);
        user.promptUserForInput();

        computer.setTurn(this.turn);
        computer.generateComputerOpenOrClosedAnswer();
    }

    public int totalOpenHands() {
        return user.countUserOpenHands(user.getUserAnswer()) + computer.countComputerOpenHands(computer.getComputerAnswer());
    }

    public int assignPredictionNumber() {
        if (user.userIsPredictor()) {
            return user.getUserPredictionNumber();
        }

        else {
            return computer.computerPredictionNumber();
        }
    }

    public void displayComputerAnswerAndOpenHands() {
        System.out.println("\nThe computers answer is: " + computer.getComputerAnswer());
        System.out.println("Total number of open hands: " + totalOpenHands());
    }

    public boolean gameIsWon() {
        return (assignPredictionNumber() == totalOpenHands());
    }

    public void askToReplayGame() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nDo you want to play again? ");
        playAgainAnswer = input.nextLine();
    }

    public boolean replayAnswerFormatCorrect() {
        return playAgainAnswer.equalsIgnoreCase("no") || playAgainAnswer.equalsIgnoreCase("yes");
    }

    public boolean endGame() {
        return playAgainAnswer.equalsIgnoreCase("no");
    }

    public boolean replayGame() {
        return playAgainAnswer.equalsIgnoreCase("yes");
    }

    public void resetComputerAnswerBeforeNextRound() {
        computer.setComputerAnswer("");
    }

    public void setTurn(int newTurn) {
        turn = newTurn;
    }

    public void setPlayAgainAnswer(String newPlayAgainAnswer) {
        playAgainAnswer = newPlayAgainAnswer;
    }

}
