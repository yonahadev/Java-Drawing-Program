import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.Arrays;
import java.awt.event.MouseAdapter;

public class Canvas extends JComponent {
    private int width;
    private int height;

    private Color[][] cells;

    private Color grey = new Color(20 ,20,20);
    private Color white = new Color(255,255,255);

    private Color selectedColor = white;

    public Canvas(int w, int h) {
        width = w;
        height = h;
        cells = new Color[w][h];
        for (int i = 0; i < width; i ++) {
            for (int j = 0; j < height; j ++) {
                cells[i][j] = white;
            }
        }
    }

    public void paintPixel(int x, int y,int radius) {
        int half = Math.floorDiv(radius,2);
        for (int i = -half; i < half; i++ ) {
            for (int j = -half; j < half; j++) {
                int currentX = x+i;
                int currentY = y+j;
                boolean validX = currentX >= 0 && currentX < width;
                boolean validY = currentY >= 0 && currentY < height;
                if (i*i+j*j < radius && validY && validX) {
                    cells[x + i][y + j] = grey;
                }
            }
        }
        repaint();
//        System.out.println(cells[x][y]);
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //background
        Rectangle2D.Double bg = new Rectangle2D.Double(0,0,width,height);
        g2d.setColor(grey);
        g2d.fill(bg);
        for (int i = 0; i < width; i ++) {
            for (int j = 0; j < height; j ++) {
                int x = i;
                int y = j;
                Color color = cells[x][y];
                if (color == grey) {
                    System.out.println("Grey" + " " + x + " " + y);
                }
                g2d.setColor(color);

                Rectangle2D.Double r = new Rectangle2D.Double(x,y,1,1);
                g2d.fill(r);
            }
        }
    }
}
