package minidraw.framework.Factory.ss;

import java.awt.event.MouseEvent;

import minidraw.framework.DrawingEditor.ss.DrawingEditor;
import minidraw.framework.DrawingEditor.ss.NullTool;
import minidraw.standard.*;

/**
 * Demonstrate different messages in the status bar.
 * 
 */
public class ShowMessage {

  public static void main(String[] args) {
    DrawingEditor window = new MiniDrawApplication(
        "Click to see messages in status field", new ChessBackgroundTextFieldFactory());
    window.open();

    window.setTool(new DisplayMessageTool(window));
  }
}

class DisplayMessageTool extends NullTool {
  DisplayMessageTool(DrawingEditor e) {
    editor = e;
  }

  DrawingEditor editor;

  @Override
  public void mouseUp(MouseEvent e, int x, int y) {
    editor.showStatus("Mouse Up event at (" + x + "," + y + ")");
  }
}
