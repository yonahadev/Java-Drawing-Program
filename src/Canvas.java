import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.Arrays;
import java.awt.event.MouseAdapter;

public class Canvas extends JComponent {
    private int width;
    private int height;

    private int[][] cells = new int[5][5];

    public Canvas(int w, int h) {
        width = w;
        height = h;
        System.out.println(Arrays.deepToString(cells));
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //background
        Rectangle2D.Double bg = new Rectangle2D.Double(0,0,width,height);
        g2d.setColor(new Color(20 ,20,20));
        g2d.fill(bg);

        g2d.setColor(new Color(255 ,255,255));
        for (int i = 0; i <= 5; i ++) {
            for (int j = 0; j <= 5; j ++) {
                int x = 50*i;
                int y = 50*j;
                Rectangle2D.Double r = new Rectangle2D.Double(x,y,50,50);
                g2d.fill(r);
            }
        }
    }
}
