package minidraw.framework.DrawingEditor.ss;

import java.awt.Dimension;
import java.awt.Point;

import minidraw.boardgame.BoardDrawing.ss.BoardDrawing;
import minidraw.boardgame.BoardDrawing.ss.BreakthroughPieceFactory;
import minidraw.framework.Figure.ss.Figure;
import minidraw.boardgame.BoardDrawing.ss.Position;
//import minidraw.boardgame.BoardDrawing.ss.StdViewWithBackground;
import minidraw.boardgame.BoardDrawing.ss.ChessBoardPositioningStrategy;
import minidraw.boardgame.BoardDrawing.ss.Game;
import minidraw.framework.DrawingEditor.ss.Drawing;
import minidraw.framework.DrawingEditor.ss.DrawingEditor;
import minidraw.framework.DrawingEditor.ss.DrawingView;
import minidraw.framework.Factory.ss.MiniDrawApplication;


public class DrawingEditorFacade {
	
	public DragTracker createDragTracker(DrawingEditor editor, Figure f) {
		return new DragTracker(editor, f);
	}

	public Drawing createDrawing(DrawingEditor editor, Game game) {
		return new BoardDrawing<Position>(new BreakthroughPieceFactory(game),
	        new ChessBoardPositioningStrategy(),
	        null /* no props in breakthrough */ );
	}
	
	public DrawingView createDrawingView(DrawingEditor editor, String str) {
	    return new StdViewWithBackground(editor, str);
	}

	public ImageFigure createImageFigure(int tick){
		return new ImageFigure(
				"bpawn", new Point(14 + tick * 40, 14 + tick * 40));
	}

	public ImageManager createImageManager(MiniDrawApplication miniDrawApplication) {
		// TODO Auto-generated method stub
		return new ImageManager(miniDrawApplication);
	}

	public Tool createNullTool() {
		return new NullTool();
	}

	public Tool createSelectionTool(DrawingEditor window) {
		return new SelectionTool(window);
	}

	public DrawingView createStandardDrawingView(DrawingEditor editor, Dimension dimension) {
		// TODO Auto-generated method stub
		return new StandardDrawingView(editor, dimension);
	}

}
