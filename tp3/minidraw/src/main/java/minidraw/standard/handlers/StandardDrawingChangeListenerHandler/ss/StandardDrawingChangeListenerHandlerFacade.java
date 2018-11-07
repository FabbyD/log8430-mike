package minidraw.standard.handlers.StandardDrawingChangeListenerHandler.ss;

import java.awt.Rectangle;

import minidraw.framework.DrawingEditor.ss.Drawing;

public class StandardDrawingChangeListenerHandlerFacade {
	StandardDrawingChangeListenerHandler SDCLH;
	DrawingChangeEvent DCE;
	public StandardDrawingChangeListenerHandlerFacade() {
		
	}
	public StandardDrawingChangeListenerHandler StandardDrawingChangeListenerHandler() {
		SDCLH=new StandardDrawingChangeListenerHandler();
		return (SDCLH);
	}
	public DrawingChangeEvent DrawingChangeEvent(Drawing source, Rectangle r) {
		DCE = new DrawingChangeEvent(source,r);
		return DCE;
	}
	public void DrawingChangeEvent(DrawingChangeEvent e) {
		DCE= e;
	}

	public Rectangle getInvalidatedRectangle() {
		return (DCE.getInvalidatedRectangle());
	}
	
	public void addDrawingChangeListener(DrawingChangeListener listener) {
		SDCLH.addDrawingChangeListener(listener);
	}
	public void removeDrawingChangeListener(DrawingChangeListener listener) {
		SDCLH.removeDrawingChangeListener(listener);
	}
	public void fireDrawingInvalidated(Drawing A, Rectangle rec) {
		SDCLH.fireDrawingInvalidated(A, rec);
	}
	public void fireDrawingRequestUpdate(Drawing A) {
		SDCLH.fireDrawingRequestUpdate(A);
	}
	
	
}
