package kenny;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest{
    private Board board;

    @Before
    public void before(){
        board = new Board(3,4);
    }


    @Test
    public void testIsValidPosition(){
        assertTrue(board.isValidPosition(0,0));
        assertTrue(board.isValidPosition(2,3));
        assertFalse(board.isValidPosition(0,4));
        assertFalse(board.isValidPosition(-1,0));
    }

    @Test
    public void showBoard(){
        String expected = "-1 -1 -1 \n-1 -1 -1 \n-1 -1 -1 \n-1 -1 -1 \n";
        assertEquals(expected, board.toString());
    }

    @Test
    public void boardZeroSize(){
        Board b = new Board(0,0);
        String s = b.toString();
        assertEquals("", s);
        assertFalse(b.isValidPosition(1,0));
        assertFalse(b.isValidPosition(0,0));
    }
}