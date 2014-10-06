package core;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import simpleGame.core.Board;

@RunWith(MockitoJUnitRunner.class)
public class TestBoard {


    private Board board;

    @Before
    public void setUp(){
        Board board = new Board(2,6,6,6,6);
    }

    @Test
    public void testGetSquareContent(){

        assertTrue(true);
    }

}
