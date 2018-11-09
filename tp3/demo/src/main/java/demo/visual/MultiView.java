package demo.visual;

import java.awt.Point;

import javax.swing.*;

import minidraw.framework.DrawingEditor.ss.DrawingEditor;
import minidraw.framework.DrawingEditor.ss.DrawingEditorFacade;
import minidraw.framework.DrawingEditor.ss.DrawingView;
import minidraw.framework.Factory.ss.Factory;
import minidraw.framework.Factory.ss.FactoryFacade;
import minidraw.framework.Figure.ss.Figure;

/**
 * Demonstrate multiple views.
 * 
 */
public class MultiView {

  public static void main(String[] args) {
    FactoryFacade facade = new FactoryFacade(new ChessBackgroundFactory());
    DrawingEditor editor =  facade.createMiniDraw("Multi view");
    editor.open();

    DrawingEditorFacade<Object> deFacade = new DrawingEditorFacade<>();
    Figure blackKing = deFacade.createImageFigure("bking",
        new Point(14 + 3 * 40, 14 + 0 * 40));
    editor.drawing().add(blackKing);

    Figure whiteKing = deFacade.createImageFigure("wking",
        new Point(14 + 3 * 40, 14 + 7 * 40));
    editor.drawing().add(whiteKing);

    editor.setTool(deFacade.createSelectionTool(editor));

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
