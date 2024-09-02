import util.Tuple;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.MouseAdapter;

public class Canvas extends JComponent {
    private int width;
    private int height;
    private Tuple offset;

    private Color[][] cells;

    private Color grey = new Color(20 ,20,20);
    private Color white = new Color(255,255,255);
    private Color selectedColor = white;

    private BufferedImage bufferedImage;


    private Tuple lastMousePos;

    public Canvas(int w, int h, Tuple offset) {
        this.offset = offset;
        width = w;
        height = h;
        resetCanvas();
    }

    public void clearMousePos() {
        lastMousePos = null;
    }

    public void resetCanvas() {
        cells = new Color[width][height];
        bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_4BYTE_ABGR);
        for (int i = 0; i < width; i ++) { //init in array
            for (int j = 0; j < height; j ++) {
                cells[i][j] = white;
            }
        }
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(white);
        g2d.fillRect(0, 0, width,height);
        g2d.dispose();
        repaint();
    }

    private void paintRadius(int x, int y, int radius, Graphics2D g2d) {
        int half = Math.floorDiv(radius,2);
        for (int i = -half; i < half; i++ ) {
            for (int j = -half; j < half; j++) {
                int currentX = x+i;
                int currentY = y+j;
                boolean validX = currentX >= 0 && currentX < width;
                boolean validY = currentY >= 0 && currentY < height;
                if (i*i+j*j < radius && validY && validX) {
                    Rectangle2D.Double r = new Rectangle2D.Double(currentX, currentY, 1, 1); //draws on existing graphic
                    g2d.setColor(grey);
                    g2d.fill(r);
                }
            }
        }
    }

    public void paint(int x, int y,int radius) {
        x -= offset.x;
        y -= offset.y;
        Graphics2D g2d = bufferedImage.createGraphics(); //creates graphic
        if (lastMousePos == null) {
            paintRadius(x,y,radius,g2d);
        } else {
            Tuple currentMousePos = new Tuple(x,y);



            //use y = mx + c
            double changeInY = currentMousePos.y-lastMousePos.y;
            double changeInX = currentMousePos.x-lastMousePos.x;
            double m = 0;
            if (changeInX != 0 && changeInY != 0) {
                m = changeInY/changeInX;
            }

            double c = -m*currentMousePos.x + currentMousePos.y;

            System.out.println(lastMousePos.x + " " + lastMousePos.y + " " + currentMousePos.x + " " + currentMousePos.y);
            System.out.println("Gradient " + m + " Intercept "+ c);

            if (lastMousePos.x < currentMousePos.x) {
                for (int i = lastMousePos.x; i < currentMousePos.x; i ++) {
                    double yPos = m*i+c;
                    int roundedY = (int) Math.floor(yPos);
                    paintRadius(i,roundedY,radius,g2d);
                }
            } else if(m == 0) {
                if (lastMousePos.y > currentMousePos.y) {
                    for (int i = currentMousePos.y; i < lastMousePos.y; i ++) {
                        paintRadius(currentMousePos.x,i,radius,g2d);
                    }
                } else {
                    for (int i = lastMousePos.y; i < currentMousePos.y; i ++) {
                        paintRadius(currentMousePos.x,i,radius,g2d);
                    }
                }

            } else {
                for (int i = currentMousePos.x; i < lastMousePos.x; i ++) {
                    double yPos = m*i+c;
                    int roundedY = (int) Math.floor(yPos);
                    paintRadius(i,roundedY,radius,g2d);
                }
            }

        }
        //deletes it in this scope but maintains what was drawn

        g2d.dispose();
        repaint();
        lastMousePos = new Tuple(x,y);
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bufferedImage,offset.x, offset.y, null);
    }
}
