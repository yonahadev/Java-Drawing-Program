import util.Tuple;

import javax.swing.*;
import java.awt.*;

public class Frame {
    public static void main(String[] args) {
        int width = 500;
        int height = 500;
        Tuple offset = new Tuple(50,20);
        JFrame frame = new JFrame();
        Canvas canvas = new Canvas(width,height,offset);
        Mouse mouse = new Mouse(canvas);
        canvas.addMouseListener(mouse);
        canvas.addMouseMotionListener(mouse);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton clear = new JButton("Clear");
        JButton eraser = new JButton("Eraser");
        buttonPanel.add(clear);
        buttonPanel.add(eraser);

        clear.addActionListener(e -> {
            System.out.println("Clear Canvas");
            canvas.resetCanvas();
        });

        frame.add(buttonPanel,BorderLayout.NORTH);

        frame.setSize(width+2*offset.x,height);
        frame.setTitle("Drawing Program");
        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Insets insets = frame.getInsets();
        Dimension buttonPanelSize = buttonPanel.getSize();
        frame.setSize(width + 2 * offset.x, height + insets.top + insets.bottom + 2*offset.y + buttonPanelSize.height);
    }
}
