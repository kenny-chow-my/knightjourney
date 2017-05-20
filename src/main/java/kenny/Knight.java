package kenny;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kenny on 5/17/2017.
 */
public class Knight implements IPiece {

    private int[] possibleX = {1, 1,2, 2,-1,-1,-2,-2};
    private int[] possibleY = {2,-2,1,-1, 2,-2, 1,-1};

    private Board board;

    public void setBoard(Board board){
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public List<Integer[]> getValidMoves(int x, int y){
        List<Integer[]> validMoves = new ArrayList();

        for (int i = 0; i < possibleX.length; i++){
            if(board.isValidPositionUpperLeftDiagonal(x + possibleX[i], y + possibleY[i])){
                Integer[] tmp = {x + possibleX[i], y + possibleY[i]};
                validMoves.add(tmp);
            }
        }
        return validMoves;
    }
}
