package org.pdfsam.ui.selection.multiple;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class DownTest {
    private Down concreteClass;
    @Before
    public void setUp() {
        concreteClass = new Down();
    }

    @After
    public void tearDown() {
        concreteClass = null;
    }

    @Test
    public void testCanMoveDown() {
        boolean canMove = concreteClass.canMove(SelectionChangedEvent.select(asList(1,2)).ofTotalRows(5));
        assertTrue("File can move Down side ", canMove);
    }

    @Test
    public void testCanNotMoveDown() {
        boolean canMove = concreteClass.canMove(SelectionChangedEvent.select(asList(5,4)).ofTotalRows(5));
        assertFalse("File can not move Down side ", canMove);
    }
}