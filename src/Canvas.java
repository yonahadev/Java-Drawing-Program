import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Canvas extends JComponent {
    private int width;
    private int height;

    public Canvas(int w, int h) {
        width = w;
        height = h;
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //background
        Rectangle2D.Double r = new Rectangle2D.Double(0,0,width,height);
        g2d.setColor(new Color(20 ,20,20));
        g2d.fill(r);
    }
}
