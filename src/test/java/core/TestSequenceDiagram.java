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

import java.util.ArrayList;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class TestSequenceDiagram {

    private Game game;


    @Before
    public void init_isGameOver(){
        game = new Game();
    }

    @Test
    public void test_isGameOver(){
        assertNotNull(game);

        assertEquals(false, game.isGameOver());
    }

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
        //assertEquals(board.numberOfPawns(),2);
       // verify(pawns).size();
    }

    @Test
    public void test_maxGold() {

        ArrayList<Pawn> pawns = new ArrayList<Pawn>();

        Pawn p0 = mock(Pawn.class);
        Pawn p1 = mock(Pawn.class);
        Board board1 = new Board(2, 4,4,4,4);
        board1.removeAllPawns();
        assertEquals(board1.numberOfPawns(), 0);

        board1.addPawn(p0);
        assertEquals(board1.numberOfPawns(), 1);


        when(p0.getX()).thenReturn(1);
        when(p0.getY()).thenReturn(1);
        board1.addPawn(p1);
        when(p1.getX()).thenReturn(2);
        when(p1.getY()).thenReturn(1);

        assertEquals(board1.numberOfPawns(), 2);

        when(p0.getGold()).thenReturn(1);
        when(p1.getGold()).thenReturn(3);

        board1.maxGold();

        assertEquals(board1.maxGold(), 3);

        InOrder mocksWithOrder = inOrder(p0, p1);
        mocksWithOrder.verify(p0).getGold();
        mocksWithOrder.verify(p1).getGold();



    }






}
