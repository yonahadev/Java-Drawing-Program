import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.Arrays;
import java.awt.event.MouseAdapter;

public class Canvas extends JComponent {
    private int width;
    private int height;

    private int[][] cells;

    private Color grey = new Color(20 ,20,20);
    private Color white = new Color(255,255,255);

    private Color selectedColor = white;

    public Canvas(int w, int h) {
        width = w;
        height = h;
        cells = new int[w][h];
//        System.out.println(Arrays.deepToString(cells));
    }

    public void changeColour() {
        if (selectedColor == white) {
            selectedColor = grey;
        } else {
            selectedColor = white;
        }
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //background
        Rectangle2D.Double bg = new Rectangle2D.Double(0,0,width,height);
        g2d.setColor(grey);
        g2d.fill(bg);
        g2d.setColor(selectedColor);
        for (int i = 0; i <= width; i ++) {
            for (int j = 0; j <= height; j ++) {
                int x = i;
                int y = j;
                Rectangle2D.Double r = new Rectangle2D.Double(x,y,1,1);
                g2d.fill(r);
            }
        }
    }
}
