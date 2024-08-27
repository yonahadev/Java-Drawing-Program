import javax.swing.*;

public class Frame {
    public static void main(String[] args) {
        int width = 1500;
        int height = 1000;
        JFrame frame = new JFrame();
        Canvas canvas = new Canvas(width,height);
        Mouse mouse = new Mouse(canvas);
        canvas.addMouseListener(mouse);
        canvas.addMouseMotionListener(mouse);
        frame.setSize(width,height);
        frame.setTitle("Drawing Program");
        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
