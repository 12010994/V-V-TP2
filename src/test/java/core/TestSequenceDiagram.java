package core;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import simpleGame.core.*;
import simpleGame.exception.OutOfBoardException;

import java.util.ArrayList;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class TestSequenceDiagram {

    @InjectMocks
    private Board board = new Board(2, 4, 4, 4, 4);

    @Mock
    private ArrayList<Pawn> pawns;

    @Mock
    private Pawn pawn0;

    @Mock
    private Pawn pawn1;



    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }





    @Test
    public void test_numberOfPawns(){

        when(pawns.size()).thenReturn(2);
        System.out.println(pawns.size());

        assertEquals(board.numberOfPawns(),2);

        verify(pawns).size();
    }

    @Test
    public void test_maxGold() {

        Pawn p0 = mock(Pawn.class);
        Pawn p1 = mock(Pawn.class);

        board.removeAllPawns();
        assertEquals(board.numberOfPawns(), 0);

        board.addPawn(p0);
        assertEquals(board.numberOfPawns(), 1);


        when(p0.getX()).thenReturn(1);
        when(p0.getY()).thenReturn(1);
        board.addPawn(p1);
        when(p1.getX()).thenReturn(2);
        when(p1.getY()).thenReturn(1);

        assertEquals(board.numberOfPawns(), 2);

        when(p0.getGold()).thenReturn(1);
        when(p1.getGold()).thenReturn(3);

        board.maxGold();

        assertEquals(board.maxGold(), 3);

        InOrder mocksWithOrder = inOrder(p0, p1);
        mocksWithOrder.verify(p0).getGold();
        mocksWithOrder.verify(p1).getGold();

    }


}
