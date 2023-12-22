import java.util.Scanner;

public class Game {
    
    public static void main(String[] args){
        
        //user interface
        Scanner input = new Scanner(System.in);
        UserInterface ui = new UserInterface(input);
        boolean playAgain = true;
        int choice = 0;

        
        while(playAgain){
            playAgain = false;
            ui.start();
            System.out.print("Would you like to play again? 1 = yes, 2 = no: ");
            while(choice < 1 || choice > 2){
            choice = input.nextInt();
            }
            if(choice == 1){
                playAgain = true;
                choice = 0;
            }
        }
    }
}
