package minidraw.framework.DrawingEditor.ss;

import java.awt.Point;

import javax.swing.*;

import minidraw.framework.Factory.ss.FactoryFacade;
import minidraw.framework.Figure.ss.Figure;

/**
 * Demonstrate multiple views.
 * 
 */
public class MultiView {

  public static void main(String[] args) {
	FactoryFacade facade = new FactoryFacade(FactoryFacade.createChessBackGroundFactory());
    DrawingEditor editor = facade.createMiniDraw("Multi view");
    editor.open();

    Figure blackKing = new ImageFigure("bking",
        new Point(14 + 3 * 40, 14 + 0 * 40));
    editor.drawing().add(blackKing);

    Figure whiteKing = new ImageFigure("wking",
        new Point(14 + 3 * 40, 14 + 7 * 40));
    editor.drawing().add(whiteKing);

    editor.setTool(new SelectionTool(editor));

    // create second view
    JFrame newWindow = new JFrame("Extra View");
    JFrame.setDefaultLookAndFeelDecorated(true);
    newWindow.setLocation(620, 20);
    newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    DrawingView extraView = facade.createDrawingView(editor);
    JPanel panel = (JPanel) extraView;
    newWindow.getContentPane().add(panel);
    newWindow.pack();
    newWindow.setVisible(true);
  }
}
