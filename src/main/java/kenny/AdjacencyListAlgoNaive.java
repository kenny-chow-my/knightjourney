package kenny;

import java.util.List;

/**
 * Created by Kenny on 5/17/2017.
 */
public class AdjacencyListAlgoNaive implements IAlgo {

    private IPiece piece;
    private Board board;

    private int countMiss = 0;

    public AdjacencyListAlgoNaive(){

    }

    public void solve(int startX, int startY, IPiece piece){
        this.piece = piece;
        this.board = piece.getBoard();
        this.board.calculateDiagonal(startX, startY);
        List<Integer[]> validMoves = piece.getValidMoves(startX, startY);
        board.setValue(startX, startY, 0);
        for(Integer[] coord : validMoves){
            solveRecursive(coord[0], coord[1],  1);
        }
    }

    public void solveRecursive(int x, int y, int count){
        if(board.getValue(x,y) < count) {
            countMiss++;
            return;
        }
        List<Integer[]> validMoves = piece.getValidMoves(x, y);
        board.setValue(x, y, count);
        for(Integer[] coord : validMoves){
            if(board.getValue(coord[0],coord[1]) > count) {
                solveRecursive(coord[0], coord[1], count + 1);
            }
        }
    }

    public int getCountMiss(){
        return countMiss;
    }
}
