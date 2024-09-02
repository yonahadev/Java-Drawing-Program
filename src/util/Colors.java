package util;

import java.awt.*;

public enum Colors {
    WHITE(new Color(255 ,255,255)),
    BLACK(new Color(0,0,0));

    private final Color color;

    Colors(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
