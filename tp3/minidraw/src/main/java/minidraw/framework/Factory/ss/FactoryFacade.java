package minidraw.framework.Factory.ss;

import minidraw.framework.DrawingEditor.ss.Drawing;
import minidraw.framework.DrawingEditor.ss.DrawingEditor;
import minidraw.framework.DrawingEditor.ss.DrawingView;

public class FactoryFacade {
	
	Factory factory;
	
	public FactoryFacade(Factory f) {
		factory = f;
	}
	
	public DrawingEditor createMiniDraw(String title) {
		return new MiniDrawApplication(title, factory);
	}
	
	public DrawingView createDrawingView(DrawingEditor editor) {
		return factory.createDrawingView(editor);
	}
	
	public Drawing createDrawing(DrawingEditor editor) {
		return editor.drawing();
	}
}
