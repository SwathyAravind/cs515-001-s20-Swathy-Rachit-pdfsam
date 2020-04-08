package org.pdfsam.ui.selection.multiple;


/**
 * @see org.pdfsam.ui.selection.multiple.move.MoveType#TOP
 */
public class Top extends DirectionalMove {
	public boolean canMove(SelectionChangedEvent selectionChangedEvent) {
		return selectionChangedEvent.isSingleSelection() && selectionChangedEvent.getTop() > 0;
	}
}