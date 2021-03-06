package minidraw.boardgame.BoardDrawing.ss;

import javax.swing.JTextField;

import minidraw.framework.DrawingEditor.ss.DrawingEditorFacade;
import minidraw.framework.DrawingEditor.ss.DrawingView;
import minidraw.framework.DrawingEditor.ss.Drawing;
import minidraw.framework.DrawingEditor.ss.DrawingEditor;
import minidraw.framework.Factory.ss.Factory;
import minidraw.framework.Factory.ss.FactoryFacade;
import minidraw.boardgame.BoardDrawing.ss.Game;

/**
 * Experimental stuff. Testing the 'boardgame' package within Minidraw.
 * Boardgame uses a number of design patterns to allow quick development of user
 * interfaces for board games.
 *
 * Note: No real breakthrough domain code is implemented, only stub code to test
 * the visual code. 
 */
public class BreakThrough {

  public static void main(String[] args) {
    Game game = new GameStub();
    
    FactoryFacade facade = new FactoryFacade(new BreakthroughFactory(game));
    DrawingEditor window = facade.createMiniDraw("Breakthrough Demo: (0,0) illegal");
    window.open();
    
    ((GameStub) game).addObserver((BoardDrawing<Position>) window.drawing());
    window.setTool(new BoardActionTool(window));
  }
}


class GameStub implements Game {
  int[][] board = new int[8][8];

  public GameStub() {
    setAllInRowTo(0, BLACK);
    setAllInRowTo(1, BLACK);
    setAllInRowTo(6, WHITE);
    setAllInRowTo(7, WHITE);
  }

  @Override
  public int get(Position p) {
    return board[p.r][p.c];
  }

  private void setAllInRowTo(int row, int value) {
    for (int column = 0; column < 8; column++) {
      board[row][column] = value;
    }
  }

  @Override
  public boolean move(Position from, Position to) {
    System.out
        .println("GameStub: moving in domain code: " + from + " -> " + to);
    if (to.r == 0 && to.c == 0) {
      return false;
    }
    observer.pieceMovedEvent(from, to);
    return true;
  }

  private BoardGameObserver<Position> observer;

  public void addObserver(BoardGameObserver<Position> observer) {
    this.observer = observer;
  }
}

class BreakthroughFactory implements Factory {
  private Game game;
  private DrawingEditorFacade drawingFacade;

  public BreakthroughFactory(Game game) {
    super();
    this.game = game;
  }

  @Override
  public Drawing createDrawing(DrawingEditor editor) {
    return drawingFacade.createDrawing(editor, this.game);
  }

  @Override
  public DrawingView createDrawingView(DrawingEditor editor) {
    return drawingFacade.createDrawingView(editor, null);
  }

  @Override
  public JTextField createStatusField(DrawingEditor arg0) {
    return null;
  }
}