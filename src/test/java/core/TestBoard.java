package core;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import simpleGame.core.Board;
import simpleGame.core.Direction;
import simpleGame.core.Game;
import simpleGame.core.Pawn;
import simpleGame.exception.OutOfBoardException;

import java.util.ArrayList;
import java.util.LinkedList;

@RunWith(MockitoJUnitRunner.class)
public class TestBoard {


    private Board board;

    //Default parameters for Board
    private final int ySize = 4;
    private final int xSize = 4;
    private int xBonusSquare = 4;
    private int yBonusSquare = 4;
    private int numberOfPawns = 1;

    private ArrayList<Pawn> getAllPawn(Board board) {

        ArrayList<Pawn> pawns = new ArrayList<Pawn>();
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
            board.removeAllPawns();
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

            Pawn pawn1 = new Pawn('l', 3, 4, board);
            board.addPawn(pawn1);
            assertEquals(numberOfPawns + 1, board.numberOfPawns());
        }

        @Test
        public void test_isBonusSquare(){
            assertNotNull(board);

            assertFalse(board.isBonusSquare(2,2));
            assertTrue(board.isBonusSquare(4,4));
        }

        @Test
        public void test_removePawn(){
            assertNotNull(board);
            board.removeAllPawns();
            numberOfPawns=0;

            assertEquals(numberOfPawns, board.numberOfPawns());
            Pawn pawn1 = new Pawn('l', 3,4, board);
            Pawn pawn2 = new Pawn('m', 2,3, board);

            board.addPawn(pawn1);
            assertEquals(numberOfPawns + 1, board.numberOfPawns());

            board.addPawn(pawn2);
            assertEquals(numberOfPawns +2, board.numberOfPawns());

            board.removePawn(pawn2);
            assertEquals(numberOfPawns+2-1, board.numberOfPawns());

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

        }

        @Test
        public void test_getNextPawn(){
            assertNotNull(board);

            board = new Board(2, xSize, ySize, xBonusSquare, yBonusSquare);
            ArrayList<Pawn> pawns = getAllPawn(board);

            for (int i = 0; i < pawns.size(); i++) {
                assertNotNull(pawns.get(i));
            }

            for (int i = 0; i < pawns.size() - 1; i++) {
                for (int j = i + 1; j < pawns.size(); j++) {
                    assertNotSame(pawns.get(i), pawns.get(j));
                }
            }

        }

        @Test
        public void test_squareContentSprite(){
            assertNotNull(board);

            ArrayList<Pawn> pawns = getAllPawn(board);

            //if current Pawn
            assertEquals(board.squareContentSprite(pawns.get(0).getX(), pawns.get(0).getY()), 'c');

            board.removeAllPawns();
            numberOfPawns=0;

            Pawn pawn1 = new Pawn('l', 3,4, board);
            board.addPawn(pawn1);

            //a number for a non-current Pawn
            assertEquals(board.squareContentSprite(3, 4), 'l');

            //if bonus
            assertEquals(board.squareContentSprite(4, 4), '#');

            //if empty
            assertEquals(board.squareContentSprite(1,3), '.');

        }

    @Test
    public void test_toString(){
        assertNotNull(board);
        board.removeAllPawns();

        Pawn pawn1 = new Pawn('l', 2,2, board);
        board.addPawn(pawn1);

        Pawn pawn2 = new Pawn('m', 2,1, board);
        board.addPawn(pawn2);
        assertNotNull(board.toString());

    }

    @Test
    public void test_removeAllPawns(){
        assertNotNull(board);

        assertEquals(numberOfPawns, board.numberOfPawns());
        Pawn pawn1 = new Pawn('l', 3,4, board);
        Pawn pawn2 = new Pawn('m', 2,3, board);
        board.addPawn(pawn1);
        board.addPawn(pawn2);

        board.removeAllPawns();
        assertEquals(board.numberOfPawns(), 0);


    }
/*
    @Test
    public void test_movement(){
        assertNotNull(board);


        Pawn pawn1 = new Pawn('l', 5,4, board);
        Pawn pawn2 = new Pawn('m', 5,5, board);


        board.addPawn(pawn1);
        board.addPawn(pawn2);

        //System.out.println(board.toString());

        try {
            pawn1.move(Direction.Down);
        } catch (OutOfBoardException e) {
            e.printStackTrace();
        }
    }
*/

}
