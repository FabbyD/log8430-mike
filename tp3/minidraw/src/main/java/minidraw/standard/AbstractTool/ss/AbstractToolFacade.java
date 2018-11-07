package minidraw.standard.AbstractTool.ss;

import minidraw.framework.DrawingEditor.ss.DrawingEditor;

public class AbstractToolFacade {
	
	private RubberBandSelectionStrategy rbss;
	
	public AbstractToolFacade() {
		this.rbss = new StandardRubberBandSelectionStrategy();
	}
	
	public SelectAreaTracker createSelectAreaTracker(DrawingEditor editor) {
		return new SelectAreaTracker(editor, this.rbss);
	}
}
