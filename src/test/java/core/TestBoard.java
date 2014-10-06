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

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class TestBoard {

    @Mock
    private ArrayList<Pawn> pawns = new ArrayList<Pawn>();

    private Board board;

    private int ySize;
    private int xSize;
    private int xBonusSquare;
    private int yBonusSquare;
    private Pawn currentPawn;
    private int nbPlayer;

    @Before
    public void setUp(){

        board = new Board(2,6,6,5,5);
        for(int i=0; i<nbPlayer; i++){
            pawns.add(mock(Pawn.class));
        }
    }

    @Test
    public void testGetSquareContent(){

        when(pawns.get(0).getLetter()).thenReturn('a');
        when(pawns.get(0).getX()).thenReturn(2);
        when(pawns.get(0).getY()).thenReturn(2);
        assertEquals('a',board.getSquareContent(2,2).getLetter());

    }

}
