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
    private Pawn pawn2;

    //Default parameters Pawn
    private int posX = 4;
    private int posY = 4;
    private int gold = 0;
    private char letter = 'm';
    private boolean isDead = false;


    @Before
    public void init() {
        board = mock(Board.class);
        pawn = new Pawn(letter, posX, posY, board);
        pawn2  = new Pawn('l', 5,4, board);
        board.addPawn(pawn);
        board.addPawn(pawn2);
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

    @Test
    public void test_movement() throws OutOfBoardException{
        assertNotNull(pawn);

        //Four direction
        Direction dirDown = Direction.Down;
        Direction dirUp = Direction.Up;
        Direction dirRight = Direction.Right;
        Direction dirLeft = Direction.Left;


        when(board.getXSize()).thenReturn(6);
        when(board.getYSize()).thenReturn(6);

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

        System.out.println(board.numberOfPawns());




    }

}
