import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // create user and computer objects
        User user1 = new User();
        Computer computer1 = new Computer();

        int turn = 1;  // the current turn
        int openHands = 0;  // total number of open hands
        int predictionNumber = 0;  // current prediction number
        boolean stopPlaying = false;  // variable to end game

        // beginning of game
        while (stopPlaying == false) {
            // run the user class and add user open hands to total open hands
            user1.setTurn(turn);
            user1.promptUserForInput();
            user1.getUserPredictionNumber();
            user1.countUserOpenHands();
            openHands += user1.userOpenHands;

            // run the computer class and add computer open hands to total open hands
            computer1.setTurn(turn);
            computer1.getComputerAnswer();
            computer1.getComputerPredictionNumber();
            computer1.countComputerOpenHands();
            openHands += computer1.computerOpenHands;

            // Assign relevant prediction number to the predictionNumber variable
            if (turn % 2 != 0) {
                predictionNumber = user1.userPredictionNumber;
            } else {
                computer1.getComputerPredictionNumber();
                predictionNumber = computer1.computerPredictionNumber;
            }

            // display the computer's input and total number of open hands
            System.out.println("The computers response is: " + computer1.computerAnswer);
            System.out.println("Total number of open hands: " + openHands);

            // display winning message when game is won
            if (predictionNumber == openHands) {
                System.out.println("You win!");

                // ask if user wants to replay the game
                System.out.println("Do you want to play again? ");

                // store the answer
                String playAgainAnswer = input.nextLine();

                // end or restart the game
                while (stopPlaying == false) {
                    // end the game if user responds "no" to play again
                    if (playAgainAnswer.equalsIgnoreCase("no")) {
                        System.out.println("Goodbye!");
                        stopPlaying = true;
                    }

                    // replay the game if user responds "yes" to play again
                    else if (playAgainAnswer.equalsIgnoreCase("yes")) {
                        turn = 1;  // reset turn variable for new game
                        break;
                    }

                    // repeat if answer is not "yes" or "no"
                    else {
                        System.out.println("Bad input. Please put 'Yes' or 'No'");

                        playAgainAnswer = input.nextLine();
                    }
                }
            }

            // display message if there is no winner
            if (predictionNumber != openHands) {
                System.out.println("No winner!");
                turn++; // increment turn variable for next round
            }

            // reset relevant field variables for next round or new game
            openHands = 0;
            user1.userOpenHands = 0;
            computer1.computerOpenHands = 0;
            computer1.computerAnswer = "";

        }

    }
}

    




