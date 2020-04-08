package org.pdfsam.ui.selection.multiple;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class DefaultTest {
    private Default concreteClass;
    @Before
    public void setUp() {
        concreteClass = new Default();
    }

    @After
    public void tearDown() {
        concreteClass = null;
    }

    @Test
    public void testCanMoveUP() {
        boolean canMove = concreteClass.canMove(SelectionChangedEvent.select(asList(2,3)).ofTotalRows(5));
        assertTrue("File can move towards UP ", canMove);
    }

    @Test
    public void testCanNotMoveUP() {
        boolean canMove = concreteClass.canMove(SelectionChangedEvent.select(asList(1,0)).ofTotalRows(5));
        assertFalse("File can not move towards UP ", canMove);
    }
}