package minidraw.framework.Factory.ss;

import java.awt.event.KeyEvent;

import minidraw.framework.DrawingEditor.ss.DrawingEditor;
import minidraw.framework.DrawingEditor.ss.NullTool;
import minidraw.standard.*;

/**
 * Display key events in the status message field.
 * 
 */
public class KeyShow {

  public static void main(String[] args) {
    DrawingEditor window = new MiniDrawApplication(
        "See key presses on the status bar (mouse click first)",
        new ChessBackgroundTextFieldFactory());
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
