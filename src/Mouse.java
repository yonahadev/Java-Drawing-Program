import java.awt.event.*;

public class Mouse extends MouseAdapter {
    public void mouseClicked (MouseEvent e) {
        System.out.println(e.getX());
    }
}
