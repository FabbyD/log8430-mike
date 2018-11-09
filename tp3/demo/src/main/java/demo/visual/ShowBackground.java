package demo.visual;

import minidraw.framework.DrawingEditor.ss.DrawingEditor;
import minidraw.framework.Factory.ss.FactoryFacade;

/*
 * Basic demo of opening window with a static image background.

 */

public class ShowBackground {

  public static void main(String[] args) {
	  FactoryFacade facade = new FactoryFacade(new ChessBackgroundFactory());
	  
    DrawingEditor window = facade.createMiniDraw(
        "Static background image load testing");
    window.open();
  }
}
