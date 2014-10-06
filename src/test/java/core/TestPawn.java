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
    private int posY = 4;
    private int posX = 4;
    private int gold = 0;
    private char letter = 'm';
    private boolean isDead = false;


    @Before
    public void init() {
        board = mock(Board.class);
        pawn = new Pawn(letter, posX, posY, board);
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
        Direction dirDown = Direction.Down;


        when(board.getXSize()).thenReturn(posX);
        when(board.getYSize()).thenReturn(posY);

        pawn.move(dirDown);

        assertEquals(pawn.getX(), posX);
        assertEquals(pawn.getY(), posY);
    }

}
