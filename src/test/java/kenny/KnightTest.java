package kenny;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Kenny on 5/17/2017.
 */
public class KnightTest {

    private Board board;

    @Before
    public void before(){
        board = new Board(4,3);
    }

    @Test
    public void testValidMoves(){
        Knight k = new Knight();
        k.setBoard(new Board(4,3));
        List<Integer[]> validMoves = k.getValidMoves(1,1);
        List<Integer[]> expected = new ArrayList();
        expected.add(new Integer[] {3,2});
        expected.add(new Integer[] {3,0});
        for(int i = 0; i < expected.size(); i++){
            assertThat(validMoves.get(i), is(expected.get(i)));
        }
    }
}

