import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        User user1 = new User();
        Computer computer1 = new Computer();

        int turn = 1;
        int openHands = 0;
        int predictionNumber = 0;
        boolean stopPlaying = false;

        // beginning of game
        while (stopPlaying == false) {
            // run the user class and add user open hands to total open hands
            user1.setTurn(turn);
            user1.promptUserForInput();
            user1.userPredictionNumber(user1.getUserAnswer());
            user1.countUserOpenHands(user1.getUserAnswer());
            openHands += user1.getUserOpenHands();

            // run the computer class and add computer open hands to total open hands
            computer1.setTurn(turn);
            computer1.getComputerAnswer();
            computer1.getComputerPredictionNumber();
            computer1.countComputerOpenHands();
            openHands += computer1.computerOpenHands;

            // Assign relevant prediction number to the predictionNumber variable
            if (turn % 2 != 0) {
                predictionNumber = user1.getUserPredictionNumber();
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

                System.out.println("Do you want to play again? ");

                String playAgainAnswer = input.nextLine();

                // end or restart the game
                while (stopPlaying == false) {
                    if (playAgainAnswer.equalsIgnoreCase("no")) {
                        System.out.println("Goodbye!");
                        stopPlaying = true;
                    }
                    else if (playAgainAnswer.equalsIgnoreCase("yes")) {
                        turn = 1;  // reset turn variable before new game
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
                turn++; // increment turn variable for next round
            }

            // reset relevant field variables for next round or new game
            openHands = 0;
            user1.setUserOpenHands(0);
            computer1.computerOpenHands = 0;
            computer1.computerAnswer = "";

        }

    }
}


