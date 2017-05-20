package kenny;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kenny on 5/18/2017.
 */
public class AdjacencyListAlgoParallel implements IAlgo {
    private IPiece piece;
    private Board board;

    private static final int MAX_WORKERS = 8;

    public AdjacencyListAlgoParallel(){

    }
    public void solve(int startX, int startY, IPiece piece){
        this.piece = piece;

        this.board = piece.getBoard();

        List<Integer[]> validMoves = piece.getValidMoves(startX, startY);
        board.setValue(startX, startY, 0);
        List<Thread> workers = new ArrayList();
        for(Integer[] coord : validMoves){
            if(workers.size() < MAX_WORKERS) {
                AdjacencyListAlgoWorker worker = new AdjacencyListAlgoWorker(piece, board, coord[0], coord[1], 1);
                workers.add(worker);
                worker.start();
            }
        }
        for(Thread t : workers){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
