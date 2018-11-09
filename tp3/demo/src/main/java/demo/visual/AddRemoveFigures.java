package demo.visual;

import java.awt.event.MouseEvent;

import minidraw.framework.DrawingEditor.ss.DrawingEditor;
import minidraw.framework.DrawingEditor.ss.DrawingEditorFacade;
import minidraw.framework.DrawingEditor.ss.NullTool;
import minidraw.framework.Factory.ss.FactoryFacade;
import minidraw.framework.Figure.ss.Figure;

/**
 * Demonstrates how figures can be added and removed from the drawing and
 * demonstrates how a tool can be implemented for driving a test.
 * 
 */
public class AddRemoveFigures {

  public static void main(String[] args) {
	  FactoryFacade facade = new FactoryFacade(new ChessBackgroundFactory());
	  DrawingEditor window = facade.createMiniDraw("Add + Remove figures: Click for action");
	  window.open();
	  window.setTool(new AddRemoveTool(window));
  }
}

class AddRemoveTool extends NullTool {
  private DrawingEditor editor;
  Figure[] list;
  private DrawingEditorFacade<Empty> drawingFacade;

  public AddRemoveTool(DrawingEditor e) {
    editor = e;
    list = new Figure[6];
  }

  private int tick = 0;

  @Override
  public void mouseUp(MouseEvent e, int x, int y) {
    System.out.println("MD: " + tick);
    if (tick < 6) {

//      list[tick] = new ImageFigure("bpawn",
//          new Point(14 + tick * 40, 14 + tick * 40));
    	list[tick] = drawingFacade.createImageFigure(tick);
    	editor.drawing().add(list[tick]);
    } else {
      editor.drawing().remove(list[tick - 6]);
    }
    tick++;
    if (tick == 12) {
      tick = 0;
    }
  }
  
  class Empty {
	  
  }
}
