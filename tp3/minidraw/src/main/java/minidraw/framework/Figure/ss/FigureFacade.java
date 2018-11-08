package minidraw.framework.Figure.ss;

public class FigureFacade {
    public StandardDrawing createDrawing(){
        return new StandardDrawing();
    }

    public CompositeFigure createGroupFigure(){
        return new GroupFigure();
    }
}