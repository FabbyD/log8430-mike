package demo.visual;

import java.awt.event.KeyEvent;

import minidraw.framework.DrawingEditor.ss.DrawingEditor;
import minidraw.framework.DrawingEditor.ss.NullTool;
import minidraw.framework.Factory.ss.FactoryFacade;

/**
 * Display key events in the status message field.
 * 
 */
public class KeyShow {

  public static void main(String[] args) {
	  FactoryFacade facade = new FactoryFacade(new ChessBackgroundTextFieldFactory());
	  DrawingEditor window = facade.createMiniDraw("See key presses on the status bar (mouse click first)");
	  window.open();
	  window.setTool(new DisplayKeyTool(window));

  }
}

class DisplayKeyTool extends NullTool {
  String s;

  DisplayKeyTool(DrawingEditor e) {
    editor = e;
    s = "";
  }

  DrawingEditor editor;

  @Override
  public void keyDown(KeyEvent evt, int key) {
    s += evt.getKeyChar();
    editor.showStatus("s=" + s);
  }
}
