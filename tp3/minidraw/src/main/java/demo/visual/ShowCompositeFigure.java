package demo.visual;

import java.awt.Point;

import minidraw.framework.*;
import minidraw.framework.DrawingEditor.ss.DrawingEditor;
import minidraw.framework.DrawingEditor.ss.DrawingEditorFacade;
import minidraw.framework.Factory.ss.FactoryFacade;
import minidraw.framework.Figure.ss.CompositeFigure;
import minidraw.framework.Figure.ss.Figure;
import minidraw.framework.Figure.ss.FigureFacade;
import minidraw.standard.*;

/**
 * Demonstrate putting several figures into a composite figure.
 * 
 */
public class ShowCompositeFigure {

  public static void main(String[] args) {
	  	FactoryFacade facade = new FactoryFacade(new ChessBackgroundFactory());
	  
	    DrawingEditor window = facade.createMiniDraw(
	        "CompositeFigure test: moves as a unit");
	    window.open();
	    
	    DrawingEditorFacade<Object> deFacade = new DrawingEditorFacade<>();

    Figure blackKing = deFacade.createImageFigure("bking",
        new Point(14 + 3 * 40, 14 + 0 * 40));
    Figure blackPawn = deFacade.createImageFigure("bpawn",
        new Point(14 + 4 * 40, 14 + 1 * 40));

    
    FigureFacade figureFacade = new FigureFacade();
    CompositeFigure composite = figureFacade.createGroupFigure();

    composite.add(blackKing);
    composite.add(blackPawn);

    window.setTool(deFacade.createSelectionTool(window));

    window.drawing().add(composite);
  }
}
