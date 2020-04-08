package org.pdfsam.ui.selection.multiple;


/**
 * @see org.pdfsam.ui.selection.multiple.move.MoveType#DOWN
 */
public class Down extends DirectionalMove {
	public boolean canMove(SelectionChangedEvent selectionChangedEvent) {
		return selectionChangedEvent.getBottom() < selectionChangedEvent.getTotalRows() - 1;
	}
}