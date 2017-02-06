package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {

    private TicTacToeModel model;

    @Before
    public void setup() {
        model = new TicTacToeModel();
    }

    @Test
    public void testInitialBoardIsEmpty() {

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int m = model.getMark(row, col);
                assertEquals(0, m);
            }
        }

    }

    @Test
    public void testMarkXInUpperRightCorner() {

        model.setMark(0, 2);
        int m = model.getMark(0, 2);
        assertEquals(1, m);
    }

    @Test
    public void testMarkOInBottomLeftCorner() {

        model.setMark(1, 0);
        model.setMark(2, 0);
        int m = model.getMark(2, 0);
        assertEquals(2, m);
    }

    @Test
    public void testUnableToMarkOverExistingMark() {

        model.setMark(0, 0);
        model.setMark(0, 0);
        assertEquals(1, model.getMark(0, 0));

    }

    @Test
    public void testGameIsNotOverAfterTheFirstMark() {

        model.setMark(2, 1);
        model.CheckForWin();
        assertEquals("", model.Winner);
    }

    @Test
    public void testGameIsWonByXHorizontallyAcrossTopRow() {

        model.setMark(0, 0);
        model.setMark(1, 1);
        model.setMark(0, 1);
        model.setMark(2, 0);
        model.setMark(0, 2);
        model.CheckForWin();
        assertEquals("X", model.Winner);

    }

    @Test
    public void testGameIsOverByTieIfAllLocationsAreFilled() {

        model.setMark(0, 0);
        model.setMark(0, 1);
        model.setMark(2, 0);
        model.setMark(1, 0);
        model.setMark(1, 1);
        model.setMark(2, 2);
        model.setMark(2, 1);
        model.setMark(0, 2);
        model.setMark(1, 2);
        model.CheckForWin();
        assertEquals("TIE", model.Winner);
    }

}
