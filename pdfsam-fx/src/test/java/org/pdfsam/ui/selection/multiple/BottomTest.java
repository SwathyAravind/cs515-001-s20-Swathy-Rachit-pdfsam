package org.pdfsam.ui.selection.multiple;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class BottomTest {
    private Bottom concreteClass;

    @Before
    public void setUp() {
        concreteClass = new Bottom();
    }

    @After
    public void tearDown() {
        concreteClass = null;
    }

    @Test
    public void testCanMoveBottom() {
        boolean canMove = concreteClass.canMove(SelectionChangedEvent.select(asList(3)).ofTotalRows(5));
        assertTrue("File can move towards Bottom ", canMove);
    }

    @Test
    public void testCanNotMoveBottom() {
        boolean canMove = concreteClass.canMove(SelectionChangedEvent.select(asList(5, 5)).ofTotalRows(5));
        assertFalse("File can not move towards Bottom ", canMove);
    }
}