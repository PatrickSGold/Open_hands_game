import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // create user and computer object
        User user1 = new User();
        Computer computer1 = new Computer();

        // declare turn, number of open hands, and predictor number
        int turn = 1;
        int openHands = 0;
        int predictorNumber = 0;
        boolean stopPlaying = false;
        boolean correctPlayAgainAnswer = false;

        // beginning of loop
        while (stopPlaying == false) {
            // run the user class and add number of open hands to the openHands variable
            user1.setTurn(turn);
            user1.promptUserForInput();
            user1.getUserPredictorNumber();
            user1.countUserOpenHands();
            openHands += user1.userOpenHands;

            // run the computer class and add number of open hands to the openHands variable
            computer1.setTurn(turn);
            computer1.getComputerAnswer();
            computer1.getComputerPredictorNumber();
            computer1.countComputerOpenHands();
            openHands += computer1.computerOpenHands;

            // find out who is predictor, and assign predictor number to the predictorNumber variable
            if (turn % 2 != 0) {
                predictorNumber = user1.userPredictorNumber;
            } else {
                computer1.getComputerPredictorNumber();
                predictorNumber = computer1.computerPredictorNumber;
            }

            // display the computer's input and total number of open hands
            System.out.println("The computers response is: " + computer1.computerAnswer);
            System.out.println("Total number of open hands: " + openHands);

            // check if predictor number == number of open hands, and display winning message
            if (predictorNumber == openHands) {
                System.out.println("You win!");

                // ask if user wants to replay the game
                System.out.println("Do you want to play again? ");

                // assign answer to variable
                String playAgainAnswer = input.nextLine();


                while (correctPlayAgainAnswer == false) {
                    // end the game if user responds "no"
                    if (playAgainAnswer.equalsIgnoreCase("no")) {
                        System.out.println("Goodbye!");
                        stopPlaying = true; // stop playing
                        correctPlayAgainAnswer = true; // break out of loop
                    }

                    // replay the game if user responds "yes"
                    else if (playAgainAnswer.equalsIgnoreCase("yes")) {
                        turn = 1;  // reset turn
                        correctPlayAgainAnswer = true; // break out of loop
                    }

                    // repeat if answer is not "yes" or "no"
                    else {
                        System.out.println("Bad input. Please put 'Yes' or 'No'");

                        playAgainAnswer = input.nextLine();
                    }
                }
            }

            // display message if there is no winner
            if (predictorNumber != openHands) {
                System.out.println("No winner!");
                turn++;  // increment turn variable 
            }

            // reset open hands and computer answer
            openHands = 0;
            user1.userOpenHands = 0;
            computer1.computerOpenHands = 0;
            computer1.computerAnswer = "";
            correctPlayAgainAnswer = false; 

        }

    }
}

    




