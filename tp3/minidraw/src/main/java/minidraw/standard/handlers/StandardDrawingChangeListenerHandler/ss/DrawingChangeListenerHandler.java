package minidraw.standard.handlers.StandardDrawingChangeListenerHandler.ss;

/**
 * The DrawingChangeListenerHandler defines a role for an object that maintains
 * the set of DrawingChangeListener's used by a Drawing.
 * 
 * Responsibility A) Maintain the list of DrawingListeners
 * 
 */
public interface DrawingChangeListenerHandler {
  /**
   * Adds a listener for this drawing.
   * 
   * @param listener
   *          the listener to add to this handler
   */
  void addDrawingChangeListener(DrawingChangeListener listener);

  /**
   * Removes a listener from this drawing.
   * 
   * @param listener
   *          the listener to remove from this handler
   */
  void removeDrawingChangeListener(DrawingChangeListener listener);
}
