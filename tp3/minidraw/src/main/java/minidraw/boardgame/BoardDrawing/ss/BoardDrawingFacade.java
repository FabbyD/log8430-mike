package minidraw.boardgame.BoardDrawing.ss;

import demo.breakthrough.Position;
import minidraw.framework.DrawingEditor.ss.DrawingEditor;

public class BoardDrawingFacade {
	
	public BoardActionTool createActionTool(DrawingEditor editor) {
		return new BoardActionTool(editor);
	}

	public BoardGameObserver<Position> getDrawing(DrawingEditor editor) {
		return (BoardDrawing<Position>) editor.drawing();
	}
	
	public BoardFigure createBoardFigure(String image, boolean isMobile, Command command) {
		return new BoardFigure(image, isMobile, command);
	}
	
	
}
