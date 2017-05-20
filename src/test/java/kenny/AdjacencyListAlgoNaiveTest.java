package kenny;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

/**
 * Created by Kenny on 5/17/2017.
 */
public class AdjacencyListAlgoNaiveTest {

    @Test
    public void testSolve(){
        Knight k = new Knight();
        Board b = new Board(4,4);
        k.setBoard(b);
        AdjacencyListAlgoNaive algo = new AdjacencyListAlgoNaive();
        algo.solve(2,1, k);
        String expected =  "1 2 3 4 \n2 3 0 3 \n1 2 3 2 \n4 1 2 1 \n";
        assertEquals(expected, b.toString());
    }

}
