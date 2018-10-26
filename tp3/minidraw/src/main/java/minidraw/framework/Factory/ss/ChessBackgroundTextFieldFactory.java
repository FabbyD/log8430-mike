package minidraw.framework.Factory.ss;

import javax.swing.JTextField;

import minidraw.framework.DrawingEditor.ss.DrawingEditor;
import minidraw.framework.Factory.ss.ChessBackgroundFactory;

/**
 * A factory that creates the status line as well.
 * 
 */
class ChessBackgroundTextFieldFactory extends ChessBackgroundFactory {

  @Override
  public JTextField createStatusField(DrawingEditor editor) {
    return new JTextField("Hola...");
  }
}