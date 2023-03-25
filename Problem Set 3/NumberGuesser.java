import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
class GuessTheNumberGame {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 1000;
    public static final String RED = "\u001B[31;1m";
    public static final String RESET = "\u001B[0m";
    public static final String BLACK_BACKGROUND = "\u001B[40;1m";
    public static void main(String[] args) {
        numberGuesser();
    }
//    Guess the Number: Can You Beat the Odds and Crack the Code?
//    The game should randomly select a secret number from an array of integers. The player
//    should be prompted to input a guess for the secret number. If the guess is correct, the
//    player wins the game. If the guess is incorrect, the player is informed whether their guess
//    was too high or too low relative to the secret number.
//    After each guess, the player should be informed of the number of remaining guesses. If the
//    player runs out of guesses without correctly guessing the secret number, the game ends
//    and the player loses. At the end of the game, the player should be informed of the secret
//    number, whether they won or lost, and given the option to play again. The game should
//    continue until the player chooses to quit or runs out of guesses.

    public static void nrGuesser() {

        int[] numbers = new int[MAX_NUMBER];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean win = false;
        int nrGuessed;

        int secretNumber = numbers[random.nextInt(numbers.length)];
        int NR_OF_GUESSES = 10;
        System.out.println("I am thinking of a number between " + MIN_NUMBER + " and " + MAX_NUMBER);
        System.out.print("You have " + NR_OF_GUESSES + " guesses to begin with.");
        while (!win) {

            try {
                System.out.println(" Guess the number: ");
                nrGuessed = scanner.nextInt();
                if (nrGuessed <= 1000 && nrGuessed >= 0) {
                    if (nrGuessed == secretNumber) {
                        win = true;
                        System.out.println("\u001B[45;1m\u001B[94mCongratulations! You found the secret number which was: "
                                + secretNumber + " \u001B[0m\u001B[0m");
                    } else {
                        if (nrGuessed < secretNumber) {
                            System.out.println("The number that you guessed is\u001B[94m SMALLER \u001B[0mthan the secret number");
                            NR_OF_GUESSES--;
                            if (NR_OF_GUESSES == 0) {
                                System.out.println(BLACK_BACKGROUND+RED+" YOU LOST! "+RESET+RESET);
                                System.out.println("The number was:\u001B[35m" +secretNumber+"\u001B[0m");
                                win = true;
                            } else {
                                if(NR_OF_GUESSES==9 || NR_OF_GUESSES==8) {
                                    System.out.println("You have: \033[32m" + NR_OF_GUESSES + RESET + " guesses left");
                                }
                                if(NR_OF_GUESSES==7 || NR_OF_GUESSES==6) {
                                    System.out.println("You have: \033[92m" + NR_OF_GUESSES + RESET + " guesses left");
                                }
                                if(NR_OF_GUESSES==5 || NR_OF_GUESSES==4) {
                                    System.out.println("You have: \033[38;2;215;255;0m" + NR_OF_GUESSES + RESET + " guesses left");
                                }
                                if(NR_OF_GUESSES==3 || NR_OF_GUESSES==2) {
                                    System.out.println("You have: \033[38;5;208m" + NR_OF_GUESSES + RESET + " guesses left");
                                }
                                if(NR_OF_GUESSES==1) {
                                    System.out.println("You have: " + RED + NR_OF_GUESSES + RESET + " guesses left");
                                }
                            }
                        } else {
                            System.out.println("The number that you guessed is \u001B[38;5;165mBIGGER\u001B[0m than the secret number");
                            NR_OF_GUESSES--;
                            if (NR_OF_GUESSES == 0) {
                                System.err.println(BLACK_BACKGROUND+RED+" YOU LOST! "+RESET+RESET);
                                System.out.println("The number was: \u001B[35m" +secretNumber+"\u001B[0m");
                                win = true;
                            } else {
                                if(NR_OF_GUESSES==9 || NR_OF_GUESSES==8) {
                                    System.out.println("You have: \033[32m" + NR_OF_GUESSES + RESET + " guesses left");
                                }
                                if(NR_OF_GUESSES==7 || NR_OF_GUESSES==6) {
                                    System.out.println("You have: \033[92m" + NR_OF_GUESSES + RESET + " guesses left");
                                }
                                if(NR_OF_GUESSES==5 || NR_OF_GUESSES==4) {
                                    System.out.println("You have: \033[38;2;215;255;0m" + NR_OF_GUESSES + RESET + " guesses left");
                                }
                                if(NR_OF_GUESSES==3 || NR_OF_GUESSES==2) {
                                    System.out.println("You have: \033[38;5;208m" + NR_OF_GUESSES + RESET + " guesses left");
                                }
                                if(NR_OF_GUESSES==1) {
                                    System.out.println("You have: " + RED + NR_OF_GUESSES + RESET + " guesses left");
                                }
                            }
                        }
                    }
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (IndexOutOfBoundsException exception){
                System.err.println("Number guessed should be between " + MIN_NUMBER + " and " + MAX_NUMBER);
            }
            catch (InputMismatchException e){
                scanner.next();
                System.err.println("NUMBERS ONLY!");

            }
        }
    }
    public static void numberGuesser() {
        String check;
        Scanner scanner = new Scanner(System.in);
        while(true){
        try {
            System.out.println("\033[44mWelcome to number guessing game!\033[0m\n Press 1 to play or 2 to exit");
            check = scanner.nextLine();
            if(check.equals("1")){
                nrGuesser();
                break;
            }
            else if(check.equals("2")){
                System.out.println("Goodbye");
                return;
            }
            else {
                throw new IllegalArgumentException("1 to play or 2 to exit!");
            }
        }catch (IllegalArgumentException exception){
            System.err.println(exception.getMessage());
        }
        }
        boolean check1 = true;

        while (check1) {
            System.out.println("Press \033[32myes"+RESET+" if you want to play again or"+RED+" no"+RESET+" if you want to exit");
            String temp = scanner.nextLine();
            try {

                switch (temp) {
                    case "yes":
                        nrGuesser();
                        break;
                    case "no":
                        check1=false;
                        break;

                    default: throw new IllegalArgumentException("Invalid choice");
                }
            } catch (IllegalArgumentException exception) {
                System.err.println("Please input only 'yes' or 'no'");
            }
        }
        System.out.println("Bye");
    }

}
