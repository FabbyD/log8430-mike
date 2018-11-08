package minidraw.framework.DrawingEditor.ss;

import java.awt.Point;

import minidraw.framework.*;
import minidraw.framework.Factory.ss.ChessBackgroundFactory;
import minidraw.framework.Factory.ss.FactoryFacade;
import minidraw.framework.Factory.ss.MiniDrawApplication;
import minidraw.framework.Figure.ss.FigureFacade;
import minidraw.framework.Figure.ss.CompositeFigure;
import minidraw.framework.Figure.ss.Figure;
import minidraw.standard.*;

/**
 * Demonstrate putting several figures into a composite figure.
 * 
 */
public class ShowCompositeFigure {

  public static void main(String[] args) {
	FactoryFacade facade = new FactoryFacade(FactoryFacade.createChessBackGroundFactory());
    DrawingEditor window = facade.createMiniDraw("CompositeFigure test: moves as a unit");
    window.open();

    Figure blackKing = new ImageFigure("bking",
        new Point(14 + 3 * 40, 14 + 0 * 40));
    Figure blackPawn = new ImageFigure("bpawn",
        new Point(14 + 4 * 40, 14 + 1 * 40));

    FigureFacade ffacade = new FigureFacade();
    CompositeFigure composite = ffacade.createGroupFigure();

    composite.add(blackKing);
    composite.add(blackPawn);

    window.setTool(new SelectionTool(window));

    window.drawing().add(composite);
  }
}
