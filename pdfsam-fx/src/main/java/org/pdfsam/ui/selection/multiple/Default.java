package org.pdfsam.ui.selection.multiple;


/**
 * @see org.pdfsam.ui.selection.multiple.move.MoveType#UP/DEFAULT
 */
public class Default extends DirectionalMove {
	public boolean canMove(SelectionChangedEvent selectionChangedEvent) {
		return selectionChangedEvent.getTop() > 0;
	}
}