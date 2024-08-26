import javax.swing.*;

public class Frame {
    public static void main(String[] args) {
        int width = 640;
        int height = 480;
        JFrame frame = new JFrame();
        Canvas canvas = new Canvas(width,height);
        Mouse mouse = new Mouse(canvas);
        canvas.addMouseListener(mouse);
        frame.setSize(width,height);
        frame.setTitle("FRAME MENTIONED ? WHAT EVEN IS AN ENGINE");
        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
