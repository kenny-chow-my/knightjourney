package kenny;

import java.util.List;

/**
 * Created by Kenny on 5/18/2017.
 */
public class AdjacencyListAlgoWorker extends Thread{
    private IPiece piece;
    private Board board;
    private int startX;
    private int startY;
    private int startCount;

    public AdjacencyListAlgoWorker(IPiece piece, Board board, int startX, int startY, int startCount){
        this.piece = piece;
        this.board = board;
        this.startX = startX;
        this.startY = startY;
        this.startCount = startCount;
    }

    @Override
    public void run(){
        solve(startX, startY, startCount);
    }

    public void solve(int x, int y, int count){
        if(board.getValue(x,y) < count) {
            return;
        }
        List<Integer[]> validMoves = piece.getValidMoves(x, y);
        board.setValueIfLower(x, y, count);
        for(Integer[] coord : validMoves){
            if(board.getValue(coord[0],coord[1]) > count) {
                solve(coord[0], coord[1], count + 1);
            }
        }
    }
}
