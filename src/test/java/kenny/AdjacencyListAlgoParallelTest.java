package kenny;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Kenny on 5/17/2017.
 */
public class AdjacencyListAlgoParallelTest {

    @Test
    public void testSolve(){
        Knight k = new Knight();
        Board b = new Board(4,4);
        k.setBoard(b);
        IAlgo algo = new AdjacencyListAlgoParallel();
        algo.solve(2,1, k);
        String expected =  "1 2 3 4 \n2 3 0 3 \n1 2 3 2 \n4 1 2 1 \n";
        assertEquals(expected, b.toString());
    }

    @Test
    public void testSolveLarger(){
        //using Naive algo, assuming we trust it enough
        Knight k = new Knight();
        Board b1 = new Board(12,12);
        Board b2 = new Board(12,12);
        k.setBoard(b1);
        IAlgo algoParallel = new AdjacencyListAlgoParallel();
        algoParallel.solve(5,2, k);

        IAlgo algoNaive = new AdjacencyListAlgoNaive();
        k.setBoard(b2);
        algoNaive.solve(5,2, k);

        assertEquals(b2.toString(), b1.toString());

    }
}
