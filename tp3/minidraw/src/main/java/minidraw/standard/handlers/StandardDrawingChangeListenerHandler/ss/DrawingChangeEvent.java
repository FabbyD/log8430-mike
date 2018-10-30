package minidraw.standard.handlers.StandardDrawingChangeListenerHandler.ss;

import java.awt.Rectangle;
import java.util.EventObject;

import minidraw.framework.DrawingEditor.ss.Drawing;

/**
 * The change event originating from a drawing.
 */
public class DrawingChangeEvent extends EventObject {

  /**
   *
   */
  private static final long serialVersionUID = -5338576544951896195L;
  private Rectangle fRectangle;

  /**
   * Constructs a drawing change event.
   *
   * @param source
   *          the Drawing instance this change event stems from
   * @param r
   *          the rectangle that needs to be redrawn
   */
  DrawingChangeEvent(Drawing source, Rectangle r) {
    super(source);
    fRectangle = r;
  }

  /**
   * Return the drawing that was changed
   *
   * @return a reference to the changed drawing
   */
  Drawing getDrawing() {
    return (Drawing) getSource();
  }

  /**
   * Gets the changed rectangle
   *
   * @return the rectangle that needs to be redrawn
   */
  Rectangle getInvalidatedRectangle() {
    return fRectangle;
  }
}
