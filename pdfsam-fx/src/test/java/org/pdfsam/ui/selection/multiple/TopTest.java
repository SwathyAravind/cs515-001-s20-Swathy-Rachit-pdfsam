package org.pdfsam.ui.selection.multiple;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class TopTest {
    private Top concreteClass;
    @Before
    public void setUp() {
        concreteClass = new Top();
    }

    @After
    public void tearDown() {
        concreteClass = null;
    }

    @Test
    public void testCanMoveTop() {
        boolean canMove = concreteClass.canMove(SelectionChangedEvent.select(asList(2)).ofTotalRows(5));
        assertTrue("File can move Top side ", canMove);
    }

    @Test
    public void testCanNotMoveTop() {
        boolean canMove = concreteClass.canMove(SelectionChangedEvent.select(asList(0, 0)).ofTotalRows(5));
        assertFalse("File can not move Top side ", canMove);
    }
}