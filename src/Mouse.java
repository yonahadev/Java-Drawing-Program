import java.awt.event.*;

public class Mouse extends MouseAdapter {
    private  Canvas canvas;

    public Mouse (Canvas c) {
        canvas = c;
    };

    public void mouseClicked (MouseEvent e) {
        System.out.println(e.getX());
        canvas.changeColour();
        canvas.repaint();
    }

}
