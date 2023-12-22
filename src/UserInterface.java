import java.util.Scanner;

public class UserInterface {

    private Scanner input;

    public UserInterface(){
        input = new Scanner(System.in);
    
    }

    public void start(){
        int turn = 1;
        
        startHeader();

        while(true){
            turnHeader(turn);
            displayGamePanel();
            
            turn++;
            break;
        }
        
    }

    public static void startHeader(){
        System.out.println("------GAME BEGIN-----");
    }

    public static void turnHeader(int turn){
        System.out.println("------Turn " + turn + " ------");
    }

    public static void displayGamePanel(){
        System.out.println("     * | * | *");
        System.out.println("     ---------");
        System.out.println("     * | * | *");
        System.out.println("     ---------");
        System.out.println("     * | * | *");
    }
}