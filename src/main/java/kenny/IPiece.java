package kenny;
import java.util.List;
/**
 * Created by Kenny on 5/17/2017.
 */
public interface IPiece {

    /***
     * Given a starting point, return all the possible moves
     * @param x
     * @param y
     * @return
     */
    public List<Integer[]> getValidMoves(int x, int y);

    /***
     * Sets a game board for this piece
     * @param board
     */
    public void setBoard(Board board);

    /***
     * Gets a game board from this piece
     * @return
     */
    public Board getBoard();
}
