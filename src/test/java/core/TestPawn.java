package core;


import org.junit.Before;
import org.junit.Test;

import org.mockito.runners.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;


import simpleGame.core.Board;
import simpleGame.core.Pawn;


@RunWith(MockitoJUnitRunner.class)
public class TestPawn {

    @Mock
    private Board board;

    private Pawn pawn;


    //Default parameters Pawn
    private int posY = 4;
    private int posX = 4;
    private int gold = 0;
    private char letter = ' ';


    @Before
    public void init() {
        board = mock(Board.class);
        pawn = new Pawn(letter, posX, posY, board);
    }

    @Test
    public void test_getSizeY(){

    }

}
