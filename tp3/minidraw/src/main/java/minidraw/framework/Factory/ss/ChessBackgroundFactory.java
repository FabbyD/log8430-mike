package minidraw.framework.Factory.ss;

import javax.swing.JTextField;

import minidraw.framework.*;
import minidraw.framework.DrawingEditor.ss.Drawing;
import minidraw.framework.DrawingEditor.ss.DrawingEditor;
import minidraw.framework.DrawingEditor.ss.DrawingEditorFacade;
import minidraw.framework.DrawingEditor.ss.DrawingView;
import minidraw.framework.Figure.ss.StandardDrawing;
import minidraw.standard.*;

/**
 * A factory just for testing purposes. Defines a chess board background. 

 */
public class ChessBackgroundFactory implements Factory {
	
	private DrawingEditorFacade drawingFacade;
  @Override
  public DrawingView createDrawingView(DrawingEditor editor) {
//    DrawingView view = new StdViewWithBackground(editor, "chessboard");
	  DrawingView view = drawingFacade.createDrawingView(editor, "chessboard");
	  
    return view;
  }

  @Override
  public Drawing createDrawing(DrawingEditor editor) {
    return new StandardDrawing();
  }

  @Override
  public JTextField createStatusField(DrawingEditor editor) {
    return null;
  }
}
