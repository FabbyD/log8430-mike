package demo.visual;

import javax.swing.JTextField;

import minidraw.framework.DrawingEditor.ss.Drawing;
import minidraw.framework.DrawingEditor.ss.DrawingEditor;
import minidraw.framework.DrawingEditor.ss.DrawingEditorFacade;
import minidraw.framework.DrawingEditor.ss.DrawingView;
import minidraw.framework.Factory.ss.Factory;
import minidraw.framework.Figure.ss.FigureFacade;

/**
 * A factory just for testing purposes. Defines a chess board background. 

 */
class ChessBackgroundFactory implements Factory {
	
	private FigureFacade figureFacade = new FigureFacade();
	private DrawingEditorFacade<Empty> drawingEditorFacade = new DrawingEditorFacade<>();
	
  @Override
  public DrawingView createDrawingView(DrawingEditor editor) {
    return drawingEditorFacade.createDrawingView(editor, "chessboard");
  }

  @Override
  public Drawing createDrawing(DrawingEditor editor) {
    return figureFacade.createDrawing();
  }

  @Override
  public JTextField createStatusField(DrawingEditor editor) {
    return null;
  }
  
  class Empty {
	  
  }
}
