import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Main{
    public static int MAX_GAMES = 0;
    public static void main(String[] args) {
        RPS();
    }



//    Rock-Paper-Scissors Battle: Take on the Computer with Arrays!
//    The game should prompt the user to enter their choice of rock, paper, or scissors. Once the
//    user has made their choice, the game should generate a random choice for the computer.
//    The game should then determine the winner based on the rules of the game: rock beats
//    scissors, scissors beats paper, and paper beats rock. The game should keep track of the
//    score for the user and the computer, and display it after each round. The game should
//    continue until the user chooses to quit or until a predetermined number of rounds have
//    been played. Finally, the game should display the final score and congratulate the winner.
    public static void RPS1(){
        String[] choices = {"rock","paper","scissors"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int computerPoints = 0;
        int playerPoints = 0;
        while(true){
            String computerChoice = choices[random.nextInt(choices.length)];
            System.out.println("Enter your choice by typing: 'rock', 'paper' or 'scissors'");
            try {
                String playersChoice = scanner.nextLine().toLowerCase();
                if (playersChoice.equals("rock") || playersChoice.equals("paper") || playersChoice.equals("scissors")) {
                    if (score(computerChoice, playersChoice) == 1) {
                        playerPoints++;
                        System.out.println("Computer chose: " + computerChoice + " you chose: " + playersChoice);
                        System.out.println("YOU WON!");
                        System.out.println("You have: " + playerPoints + "\nThe computer has: " + computerPoints);
                        if (playerPoints == MAX_GAMES) {
                            System.out.println("Congratulations, YOU WIN!");
                            return;
                        }
                    } else if (score(computerChoice, playersChoice) == -1) {
                        computerPoints++;
                        System.out.println("Computer chose: " + computerChoice + " you chose: " + playersChoice);
                        System.out.println("YOU LOST!");
                        System.out.println("You have: " + playerPoints + "\nThe computer has: " + computerPoints);
                        if (computerPoints == MAX_GAMES) {
                            System.out.println("Oh no, you lost!");
                            System.out.println("Why don't you try again?");
                            return;
                        }
                    } else {
                        System.out.println("Computer chose: " + computerChoice + " you chose: " + playersChoice);
                        System.out.println("It's a draw!");
                        System.out.println("You have: " + playerPoints + "\nThe computer has: " + computerPoints);
                    }
                }else{
                    throw new IllegalArgumentException();
                }
            }catch (IllegalArgumentException exception){
                System.err.println("Wrong input");
            }
        }
    }
    public static void RPS(){
        String check;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Welcome to Rock, Paper, Scissors!\n Press 1 to play or 2 to exit");
            check = scanner.nextLine();
            if(check.equals("1")){
                while(true) {
                    try {
                        System.out.println("How with many rounds should a game be?(between 1 to 10)");
                        MAX_GAMES = scanner.nextInt();
                        if (MAX_GAMES < 1 || MAX_GAMES > 10) {
                            throw new IllegalArgumentException();
                        }
                        break;
                    } catch (IllegalArgumentException exception) {
                        System.err.println("Input a number between 1 to 10");
                    }catch (InputMismatchException exception){
                        scanner.next();
                        System.err.println("Input a number between 1 to 10");
                    }
                }
                System.out.println("Whoever gets "+MAX_GAMES+" wins first wins the game!");
                RPS1();
            }
            else if(check.equals("2")){
                System.out.println("Goodbye");
                return;
            }
            else {
                throw new IllegalArgumentException("PRESS 1 or 2");
            }
        }catch (IllegalArgumentException exception){
            System.err.println(exception.getMessage());
        }

        boolean check1 = true;

        while (check1) {
            System.out.println("Press yes if you want to play again or no if you want to exit");
            scanner.nextLine();
            String temp = scanner.nextLine();
            try {
                switch (temp) {
                    case "yes":
                        RPS1();
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
    public static int score(String computersChoice,String playersChoice){
        if(computersChoice.equals(playersChoice)){
            return 0;
        }
        else if(computersChoice.equals("rock")){
            if(playersChoice.equals("paper")){
                return 1;
            }
            else{
                return-1;
            }
        }
        else if(computersChoice.equals("paper")){
            if(playersChoice.equals("scissors")){
                return 1;
            }
            else{
                return -1;
            }
        }
        else{
            if(playersChoice.equals("rock")){
                return 1;
            }
            else return -1;
        }
    }
}
