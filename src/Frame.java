import javax.swing.*;

public class Frame {
    public static void main(String[] args) {
        int width = 640;
        int height = 480;
        JFrame frame = new JFrame();
        Mouse mouse = new Mouse();
        Canvas canvas = new Canvas(width,height);
        canvas.addMouseListener(mouse);
        frame.setSize(width,height);
        frame.setTitle("FRAME MENTIONED ? WHAT EVEN IS AN ENGINE");
        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
