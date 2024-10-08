import java.awt.event.*;

public class Mouse extends MouseAdapter {
    private final Canvas canvas;


    public Mouse (Canvas c) {
        canvas = c;
    };

    private void paintAtMouseLocation(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        canvas.paint(x,y);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        canvas.clearMousePos();
        paintAtMouseLocation(e);
    }

    public void mouseDragged(MouseEvent e) {
        paintAtMouseLocation(e);
    }
}
