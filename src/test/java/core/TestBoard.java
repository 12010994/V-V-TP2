package core;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import simpleGame.core.Board;
import simpleGame.core.Pawn;

import java.util.LinkedList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestBoard {


    private Board board;

    //Default parameters for Board
    private final int ySize = 6;
    private final int xSize = 5;
    private int xBonusSquare = 6;
    private int yBonusSquare = 6;
    private final int numberOfPawns = 2;
    //private Pawn currentPawn;
    //private int nbPlayer = 2;

    private List<Pawn> getAllPawn(Board board) {

        List<Pawn> pawns = new LinkedList<Pawn>();
        int numberOfPawns = board.numberOfPawns();

        for (int i = 0; i < numberOfPawns; i++) {
            pawns.add(board.getNextPawn());
        }

        return pawns;
    }

    @Before
    public void Init() {

        board = new Board(numberOfPawns, xSize, ySize, xBonusSquare, yBonusSquare);
    }
    /*
    getXSize : OK
    getYSize : OK
    getSquareContent : OK
    removePawn : OK
    addPawn ; OK
    isBonusSquare : OK
    numberOfPawns : OK
    maxGold :
    getNextPawn :
    squareContentSprite :
    removeAllPawns : OK
     */

    @Test
    public void test_getXSize() {
        assertNotNull(board);

        assertEquals(xSize, board.getXSize());
    }

    @Test
    public void test_getYSize() {
        assertNotNull(board);

        assertEquals(ySize, board.getYSize());
    }


    @Test
    public void testGetSquareContent() {

        Pawn pawn1 = new Pawn('a', 2, 2, board);
        board.addPawn(pawn1);
        if (board.getSquareContent(2, 2) != null) {
            assertEquals('a', board.getSquareContent(2, 2).getLetter());
        } else {
            fail();
        }

    }

    @Test
    public void test_numberOfPawns() {
        assertNotNull(board);

        assertEquals(numberOfPawns, board.numberOfPawns());
    }

    @Test
    public void test_addPawn() {
        assertNotNull(board);

        assertEquals(numberOfPawns, board.numberOfPawns());

        Pawn pawn1 = new Pawn('l', 5, 4, board);
        board.addPawn(pawn1);
        assertEquals(numberOfPawns + 1, board.numberOfPawns());
    }

    @Test
    public void test_isBonusSquare(){
        assertNotNull(board);

        assertFalse(board.isBonusSquare(2,2));
        assertTrue(board.isBonusSquare(6,6));
    }

    @Test
    public void test_removePawn(){
        assertNotNull(board);

        assertEquals(numberOfPawns, board.numberOfPawns());
        Pawn pawn1 = new Pawn('l', 5,4, board);
        Pawn pawn2 = new Pawn('m', 2,3, board);
        board.addPawn(pawn1);
        assertEquals(numberOfPawns+1, board.numberOfPawns());
        board.addPawn(pawn2);
        assertEquals(numberOfPawns+2, board.numberOfPawns());

        board.removePawn(pawn1);
        assertEquals(numberOfPawns+1, board.numberOfPawns());
    }

    @Test
    public void test_maxGold(){
        assertNotNull(board);

        assertEquals(board.maxGold(), 0);

        int maxGold = 3;

        Pawn pawn = mock(Pawn.class);
        when(pawn.getGold()).thenReturn(maxGold);
        board.addPawn(pawn);
        assertEquals(maxGold, board.maxGold());
        //System.out.println(board.maxGold());
    }

    @Test
    public void test_removeAllPawns(){
        assertNotNull(board);

        assertEquals(numberOfPawns, board.numberOfPawns());
        Pawn pawn1 = new Pawn('l', 5,4, board);
        Pawn pawn2 = new Pawn('m', 2,3, board);
        board.addPawn(pawn1);
        board.addPawn(pawn2);
        assertEquals(numberOfPawns+2, board.numberOfPawns());

        board.removeAllPawns();
        assertEquals(board.numberOfPawns(), 0);

    }


}
