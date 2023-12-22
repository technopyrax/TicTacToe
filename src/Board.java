import java.util.ArrayList;

public class Board {

    private ArrayList<Space> board;

    public Board(){
        //holds all 9 board positions
        board = new ArrayList<>();
    }
    //makes new board
    public void newGame(){
        for(int i = 0; i < 9; i++){
            board.add(new Space());
            board.get(i).setPos('*');;
        }
    }
    //displays board
    public void printBoard(){
        System.out.println("     " + board.get(0).getPos() + " | " + 
                            board.get(1).getPos() + " | " + board.get(2).getPos());
        System.out.println("     " + "---------");
        System.out.println("     " + board.get(3).getPos() + " | " + 
                            board.get(4).getPos() + " | " + board.get(5).getPos());
        System.out.println("     " + "---------");
        System.out.println("     " + board.get(6).getPos() + " | " + 
                            board.get(7).getPos() + " | " + board.get(8).getPos());

    }

    //get arraylist board
    public ArrayList<Space> getBoard(){
        return this.board;
    }
}