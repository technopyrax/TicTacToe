import java.util.Scanner;

public class UserInterface {

    private Scanner input;

    public UserInterface(Scanner input){
        this.input = input;
    }
    //starts game
    public void start(){
        
        //sets board and makes turn counter and gameWinnerBoolean
        Board board = new Board();
        int turn = 1;
        boolean win = false;

        //makes new game and displays hearder
        board.newGame();
        startHeader();

        //starts game loop
        while(!win){
            if(boardIsFull(board)){
                break;
            }

            turnHeader(turn);
            board.printBoard();
            playerTurn(turn, board);

            win = checkIfWin(board);
            turn++;
        }
        //prints if someone wins
        if(win){
            System.out.println("WE HAVE A WINNER!!!!");
            board.printBoard();
        //prints if draw
        } else if(!win && boardIsFull(board)){
            System.out.println("WE HAVE A DRAW!!!!");
            board.printBoard();
        } else {
            System.exit(-1);
        }
        
    }
    //game start header
    public static void startHeader(){
        System.out.println("------GAME BEGIN-----");
    }
    //turn start header
    public static void turnHeader(int turn){
        System.out.println("-------Turn " + turn + " -------");
    }
    //displays current players turn and has them make space selection
    public void playerTurn(int turn, Board board){
        char player = (turn % 2 == 0) ? 'X' : 'O';
        
        //make sure user enters correct input
        int choice = -1;
        while(true){
            //checks player input if valid
            System.out.print("Player " + player + " pick your space: ");
            while(choice < 1 || choice > 9){
                choice = input.nextInt();
            }
            //checks if board position is open and if it is, set space to current players symbol
            if(board.getBoard().get(choice - 1).getPos() == '*'){
                board.getBoard().get(choice - 1).setPos(player);
                break;
            } else {
                System.out.println("Space already taken, try again");
                choice = -1;
            }
        }
    }

    public boolean checkIfWin(Board board){
        //make a position array
        char[] pos = new char[9];
        for(int i = 0; i < 9; i++){
            pos[i] = board.getBoard().get(i).getPos();
        }

        //check if winner
        if(pos[0] + pos[1] + pos[2] == 'X' * 3 ||
           pos[3] + pos[4] + pos[5] == 'X' * 3 ||
           pos[6] + pos[7] + pos[8] == 'X' * 3 ||
           pos[0] + pos[3] + pos[6] == 'X' * 3 ||
           pos[1] + pos[4] + pos[7] == 'X' * 3 ||
           pos[2] + pos[5] + pos[8] == 'X' * 3 ||
           pos[0] + pos[4] + pos[8] == 'X' * 3 ||
           pos[6] + pos[4] + pos[2] == 'X' * 3) {
            return true;
           } else  if(pos[0] + pos[1] + pos[2] == 'X' * 3 ||
           pos[3] + pos[4] + pos[5] == 'O' * 3 ||
           pos[6] + pos[7] + pos[8] == 'O' * 3 ||
           pos[0] + pos[3] + pos[6] == 'O' * 3 ||
           pos[1] + pos[4] + pos[7] == 'O' * 3 ||
           pos[2] + pos[5] + pos[8] == 'O' * 3 ||
           pos[0] + pos[4] + pos[8] == 'O' * 3 ||
           pos[6] + pos[4] + pos[2] == 'O' * 3) {
            return true;
           }
           else {
            return false;
           }

    }

    public boolean boardIsFull(Board board){
        //makes pos array of chars for readability
        char[] pos = new char[9];
        for(int i = 0; i < 9; i++){
            pos[i] = board.getBoard().get(i).getPos();
        }

        if(pos[0] != '*' &&
            pos[1] != '*' &&
            pos[2] != '*' &&
            pos[3] != '*' &&
            pos[4] != '*' &&
            pos[5] != '*' &&
            pos[6] != '*' &&
            pos[7] != '*' &&
            pos[8] != '*'){
                return true;
            } else{
                return false;
            }
    }
}