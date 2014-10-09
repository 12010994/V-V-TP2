package core;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
        assertEquals(board.numberOfPawns(),2);
        verify(pawns).size();
    }

    @Test
    public void test_maxGold() {

        ArrayList<Pawn> pawns = new ArrayList<Pawn>();

        pawns.add(pawn0);
        pawns.add(pawn1);

        board = new Board(2, 4, 4, 4, 4);

        when(pawn0.getGold()).thenReturn(1);
        when(pawn1.getGold()).thenReturn(3);

        //System.out.println(board.maxGold());

        assertEquals(board.maxGold(), 3);

        verify(pawn0).getGold();
        verify(pawn1).getGold();

    }






}
