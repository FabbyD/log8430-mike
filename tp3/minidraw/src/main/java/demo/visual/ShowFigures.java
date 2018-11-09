package demo.visual;

import java.awt.Point;

import minidraw.framework.*;
import minidraw.framework.DrawingEditor.ss.DrawingEditor;
import minidraw.framework.DrawingEditor.ss.DrawingEditorFacade;
import minidraw.framework.Factory.ss.FactoryFacade;
import minidraw.framework.Figure.ss.Figure;
import minidraw.standard.*;

/**
 * Test that figures can be added to the drawing and that the selection tool
 * works. Test that selection tool can move individual figures as well as select
 * a set of figures for composite movement.
 * 
 */
public class ShowFigures {

  public static void main(String[] args) {
	  FactoryFacade facade = new FactoryFacade(new ChessBackgroundFactory());
	  
	    DrawingEditor editor = facade.createMiniDraw(
	        "Test: Figures appear; select tool works");
	    editor.open();
	  
	    DrawingEditorFacade<Object> deFacade = new DrawingEditorFacade<>();

    Figure blackKing = deFacade.createImageFigure("bking",
        new Point(14 + 3 * 40, 14 + 0 * 40));
    editor.drawing().add(blackKing);

    Figure whiteKing = deFacade.createImageFigure("wking",
        new Point(14 + 3 * 40, 14 + 7 * 40));
    editor.drawing().add(whiteKing);

    Figure blackPawn = deFacade.createImageFigure("bpawn",
        new Point(14 + 4 * 40, 14 + 1 * 40));
    editor.drawing().add(blackPawn);

    Figure whitePawn = deFacade.createImageFigure("wpawn",
        new Point(14 + 4 * 40, 14 + 6 * 40));
    editor.drawing().add(whitePawn);

    editor.setTool(deFacade.createSelectionTool(editor));

  }
}
