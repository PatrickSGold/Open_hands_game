package Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Play play = new Play();

        int turn = 1;
        boolean stopPlaying = false;

        System.out.println("Welcome to the game!");

        while (!stopPlaying) {
            play.setTurn(turn);
            play.runUserAndComputerClass();
            play.assignPredictionNumber();
            play.displayComputerAnswerAndOpenHands();

            if (play.gameIsWon()) {
                System.out.println("\nYou win!");
                play.askToReplayGame();

                while (!play.replayAnswerFormatCorrect()) {
                    System.out.println("\nBad input. Please enter 'Yes' or 'No'");
                    play.setPlayAgainAnswer(input.nextLine());
                }

                if (play.endGame()) {
                    System.out.println("\nThank you for playing! Goodbye!");
                    stopPlaying = true;
                }

                else if (play.replayGame()) {
                    turn = 1;  // reset turn for next game
                }
            }

            else {
                System.out.println("\nNo winner!");
                turn++;  // increment turn for next round
            }

            play.resetComputerAnswerBeforeNextRound();
        }
    }
}