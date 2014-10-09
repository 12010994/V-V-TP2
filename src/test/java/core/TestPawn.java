package core;


import org.junit.Before;
import org.junit.Test;


import org.mockito.runners.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import simpleGame.core.Board;
import simpleGame.core.Direction;
import simpleGame.core.Pawn;
import simpleGame.exception.OutOfBoardException;


@RunWith(MockitoJUnitRunner.class)
public class TestPawn {

    @Mock
    private Board board;

    private Pawn pawn;

    //Default parameters Pawn
    private int posX = 2;
    private int posY = 2;
    private int gold = 0;
    private char letter = 'm';
    private boolean isDead = false;


    @Before
    public void init() {
        board = mock(Board.class);
        pawn = new Pawn(letter, posX, posY, board);
        board.addPawn(pawn);
    }

    @Test
    public void test_getSizeY(){
        assertNotNull(pawn);
        assertEquals(posY, pawn.getY());
    }

    @Test
    public void test_getSizeX(){
        assertNotNull(pawn);
        assertEquals(posX, pawn.getX());
    }

    @Test
    public void test_letter(){
        assertNotNull(pawn);
        assertEquals(letter, pawn.getLetter());
    }

    @Test
    public void test_gold(){
        assertNotNull(pawn);
        assertEquals(gold, pawn.getGold());
    }

    @Test
    public void test_isDead(){
        assertNotNull(pawn);
        assertEquals(isDead, pawn.isDead());
    }

  /*  @Test
    public void test_movement() throws OutOfBoardException{
        assertNotNull(pawn);

        //Four direction
        Direction dirDown = Direction.Down;
        Direction dirUp = Direction.Up;
        Direction dirRight = Direction.Right;
        Direction dirLeft = Direction.Left;


        when(board.getXSize()).thenReturn(4);
        when(board.getYSize()).thenReturn(4);

        pawn.move(dirDown);
        assertEquals(pawn.getX(), posX);
        assertEquals(pawn.getY(), posY-1);

        pawn.move(dirUp);
        assertEquals(pawn.getX(), posX);
        assertEquals(pawn.getY(), posY);

        pawn.move(dirRight);
        assertEquals(pawn.getX(), posX+1);
        assertEquals(pawn.getY(), posY);

        pawn.move(dirLeft);
        assertEquals(pawn.getX(), posX);
        assertEquals(pawn.getY(), posY);

    }*/

    @Test
    public void test_moveAttack() throws OutOfBoardException{

        when(board.getXSize()).thenReturn(4);
        when(board.getYSize()).thenReturn(4);

        Pawn pawn1 = new Pawn('e', 3,2,board);
        when(board.getSquareContent(3,2)).thenReturn(pawn1);

        assertTrue(pawn.move(Direction.Right).contains("attacks"));
    }

}
