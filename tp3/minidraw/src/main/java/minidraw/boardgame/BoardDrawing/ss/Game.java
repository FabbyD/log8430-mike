package minidraw.boardgame.BoardDrawing.ss;

public interface Game {
		  public static final int WHITE = +1;
		  public static final int NONE = 0;
		  public static final int BLACK = -1;

		  public boolean move(Position from, Position to);

		  public int get(Position p);
}