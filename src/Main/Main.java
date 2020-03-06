package Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        User user = new User();
        Computer computer = new Computer();

        int turn = 1;
        int openHands = 0;
        int predictionNumber = 0;
        boolean stopPlaying = false;

        // beginning of game
        while (stopPlaying == false) {
            // run the user class and add user open hands to total open hands
            user.setTurn(turn);
            user.promptUserForInput();
            openHands += user.countUserOpenHands(user.getUserAnswer());

            // run the computer class and add computer open hands to total open hands
            computer.setTurn(turn);
            computer.generateComputerOpenOrClosedAnswer();
            openHands += computer.countComputerOpenHands(computer.getComputerAnswer());

            // Assign relevant prediction number
            if (user.getCheckIfUserIsPredictor() == true) {
                predictionNumber = user.getUserPredictionNumber();
            }
            else {
                predictionNumber = computer.computerPredictionNumber();
            }

            System.out.println("The computers answer is: " + computer.getComputerAnswer());
            System.out.println("Total number of open hands: " + openHands);

            // display winning message when game is won
            if (predictionNumber == openHands) {
                System.out.println("You win!");
                System.out.println("Do you want to play again? ");
                String playAgainAnswer = input.nextLine();

                // end or restart the game
                while (stopPlaying == false) {
                    if (playAgainAnswer.equalsIgnoreCase("no")) {
                        System.out.println("Goodbye!");
                        stopPlaying = true;
                    }
                    else if (playAgainAnswer.equalsIgnoreCase("yes")) {
                        turn = 1;  // reset turn before new game
                        break;
                    }
                    else {
                        System.out.println("Bad input. Please put 'Yes' or 'No'");

                        playAgainAnswer = input.nextLine();
                    }
                }
            }

            // display message if there is no winner
            else {
                System.out.println("No winner!");
                turn++; // increment turn for next round
            }

            // reset openHands and computerAnswer for next round or the new game
            openHands = 0;
            computer.setComputerAnswer("");

        }
    }
}


