package demo.breakthrough;

import java.util.*;

import minidraw.boardgame.*;
import minidraw.boardgame.BoardDrawing.ss.BoardDrawingFacade;
import minidraw.boardgame.BoardDrawing.ss.BoardFigure;
import minidraw.boardgame.BoardDrawing.ss.Command;
import minidraw.boardgame.BoardDrawing.ss.FigureFactory;
import minidraw.framework.DrawingEditor.ss.DrawingEditorFacade;

/**
 * The factory to generate all pieces.
 */
public class BreakthroughPieceFactory implements FigureFactory<Position> {

  private Game game;
  
  private BoardDrawingFacade boardDrawingFacade;

  public BreakthroughPieceFactory(Game game) {
    super();
    this.boardDrawingFacade = new BoardDrawingFacade();
    this.game = game;
  }

  @Override
  public Map<Position, List<BoardFigure>> generatePieceMultiMap() {
    Map<Position, List<BoardFigure>> m = new HashMap<Position, List<BoardFigure>>();
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        int whatIsOnThisSquare = game.get(new Position(row, col));
        List<BoardFigure> l = new ArrayList<BoardFigure>();
        if (whatIsOnThisSquare != Game.NONE) {
          String gifname = whatIsOnThisSquare == Game.WHITE
              ? Constants.WHITE_PAWN_IMAGE_NAME
              : Constants.BLACK_PAWN_IMAGE_NAME;
          BoardFigure bf = boardDrawingFacade.createBoardFigure(gifname, true, new MoveCommand(game));
          l.add(bf);
        }
        m.put(new Position(row, col), l);
      }
    }
    return m;
  }

  @Override
  public Map<String, BoardFigure> generatePropMap() {
    return null;
  }
}

class MoveCommand implements Command {
  private Game game;

  public MoveCommand(Game game) {
    super();
    this.game = game;
  }

  @Override
  public boolean execute() {
    Position from = new Position(
        (fy - Constants.SQUARE_OFFSET_Y) / Constants.SQUARE_SIZE,
        (fx - Constants.SQUARE_OFFSET_X) / Constants.SQUARE_SIZE);
    Position to = new Position(
        (ty - Constants.SQUARE_OFFSET_Y) / Constants.SQUARE_SIZE,
        (tx - Constants.SQUARE_OFFSET_X) / Constants.SQUARE_SIZE);
    // System.out.println( "Move command defined: "+from + " -> "+to);
    if (to.r < 0 || to.r >= 8 || to.c < 0 || to.c >= 8) {
      return false;
    }
    boolean valid = game.move(from, to);
    return valid;
  }

  private int fx, fy, tx, ty;

  @Override
  public void setFromCoordinates(int fromX, int fromY) {
    fx = fromX;
    fy = fromY;
  }

  @Override
  public void setToCoordinates(int toX, int toY) {
    tx = toX;
    ty = toY;
  }

}
