package kenny;


import java.util.Arrays;

/**
 * Created by Kenny on 5/17/2017.
 */
public class Board {

    private int rows;
    private int cols;

    private int[][] board;
    /***
     * Create a new game board
     * @param m columns
     * @param n rows
     */
    public Board(int m, int n){
        this.cols = m;
        this.rows = n;
        this.board = new int[cols][rows];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++){
                board[j][i] =  Integer.MAX_VALUE;
            }
        }
    }

    public boolean isValidPosition(int x, int y){
        return (x < cols && y < rows && x >= 0 && y >= 0);
    }

    public int getValue(int x, int y){
        return board[x][y];
    }


    public void setValue(int x, int y, int val){
        board[x][y] = val;
    }

    public void setValueIfLower(int x, int y, int val){
        if(board[x][y] > val)
        {
            board[x][y] = val;
        };
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

            for(int j = 0; j < this.rows; j++){
                for(int i = 0; i < this.cols; i++) {
                    int val = board[i][j] == Integer.MAX_VALUE ? -1 : board[i][j];
                    sb.append(val);
                    sb.append(" ");
                }
                sb.append("\n");
            }

        return sb.toString();
    }
}
