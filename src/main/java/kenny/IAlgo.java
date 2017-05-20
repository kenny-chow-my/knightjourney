package kenny;

/**
 * Created by Kenny on 5/17/2017.
 */
public interface IAlgo {


    /***
     * Given a starting point, solveRecursive the IPiece's movements on the board
     * @param startX
     * @param startY
     */
    public void solve(int startX, int startY, IPiece piece);
}
