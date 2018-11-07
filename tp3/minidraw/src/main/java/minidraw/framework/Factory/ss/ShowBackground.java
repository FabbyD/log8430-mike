package minidraw.framework.Factory.ss;

import minidraw.framework.DrawingEditor.ss.DrawingEditor;
import minidraw.framework.Factory.ss.ChessBackgroundFactory;

/*
 * Basic demo of opening window with a static image background.

 */

public class ShowBackground {

  public static void main(String[] args) {
    DrawingEditor window = new MiniDrawApplication(
        "Static background image load testing", new ChessBackgroundFactory());
    window.open();
  }
}
