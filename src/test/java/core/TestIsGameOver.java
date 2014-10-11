package core;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import simpleGame.core.Board;
import simpleGame.core.Game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestIsGameOver {


    private Game game;

    @Mock
    private Board board;


    @Before
    public void init_isGameOver(){
        game = new Game();
        board = mock(Board.class);
    }

    @Test
    public void test_isGameOver() {
        assertNotNull(game);

        assertEquals(false, game.isGameOver());
    }

}
