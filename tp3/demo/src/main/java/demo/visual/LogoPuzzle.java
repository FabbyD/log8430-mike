package demo.visual;

import java.awt.Point;

import javax.swing.JTextField;

import minidraw.framework.DrawingEditor.ss.Drawing;
import minidraw.framework.DrawingEditor.ss.DrawingEditor;
import minidraw.framework.DrawingEditor.ss.DrawingEditorFacade;
import minidraw.framework.DrawingEditor.ss.DrawingView;
import minidraw.framework.DrawingEditor.ss.SelectionTool;
import minidraw.framework.Factory.ss.Factory;
import minidraw.framework.Factory.ss.FactoryFacade;
import minidraw.framework.Figure.ss.FigureFacade;


/**
 * A (very small) jigsaw puzzle on the Aarhus University Logo. A demonstration
 * of a "minimal" MiniDraw application.
 * 
 */
public class LogoPuzzle {

  public static void main(String[] args) {
	  FactoryFacade facade = new FactoryFacade(new PuzzleFactory());
	  DrawingEditor editor = facade.createMiniDraw("Put the pieces into place");
	  
	  DrawingEditorFacade<Empty> drawingEditorFacade = new DrawingEditorFacade<>();
	  editor.open();
	  editor.setTool(drawingEditorFacade.createSelectionTool(editor));

	  Drawing drawing = facade.createDrawing(editor);
	  drawing.add(drawingEditorFacade.createImageFigure("11", new Point(5, 5)));
	  drawing.add(drawingEditorFacade.createImageFigure("12", new Point(10, 10)));
	  drawing.add(drawingEditorFacade.createImageFigure("13", new Point(15, 15)));
	  drawing.add(drawingEditorFacade.createImageFigure("21", new Point(20, 20)));
	  drawing.add(drawingEditorFacade.createImageFigure("22", new Point(25, 25)));
	  drawing.add(drawingEditorFacade.createImageFigure("23", new Point(30, 30)));
	  drawing.add(drawingEditorFacade.createImageFigure("31", new Point(35, 35)));
	  drawing.add(drawingEditorFacade.createImageFigure("32", new Point(40, 40)));
	  drawing.add(drawingEditorFacade.createImageFigure("33", new Point(45, 45)));
  }
  
  class Empty {
	  
  }
}

class PuzzleFactory implements Factory {
	
	private DrawingEditorFacade<Object> facade = new DrawingEditorFacade<>();
	private FigureFacade figureFacade = new FigureFacade();

  @Override
  public DrawingView createDrawingView(DrawingEditor editor) {
      return facade.createDrawingView(editor, "au-logo");
  }

  @Override
  public Drawing createDrawing(DrawingEditor editor) {
    return figureFacade.createDrawing();
  }

  @Override
  public JTextField createStatusField(DrawingEditor editor) {
    return null;
  }
}
