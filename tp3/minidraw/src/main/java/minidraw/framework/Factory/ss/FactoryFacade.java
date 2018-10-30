package minidraw.framework.Factory.ss;

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
	
	public static Factory createChessBackGroundFactory() {
		return new ChessBackgroundFactory();
	}
	
	public DrawingView createDrawingView(DrawingEditor editor) {
		return factory.createDrawingView(editor);
	}
}
