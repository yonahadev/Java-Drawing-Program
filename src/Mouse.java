import java.awt.event.*;

public class Mouse extends MouseAdapter {
    private  Canvas canvas;
    private boolean mouseHeld = false;

    private int radius = 10;

    public Mouse (Canvas c) {
        canvas = c;
    };

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
//        System.out.println(e.getX()+" "+e.getY());
        canvas.paintPixel(x,y,radius);
    }
}
