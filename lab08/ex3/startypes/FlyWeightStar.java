package startypes;

import java.awt.*;

public class FlyWeightStar {
    private int x;
    private int y;
    private StarType type;

    public FlyWeightStar(int x, int y, StarType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics g) {
        g.setColor(type.getColor());
        g.fillOval(x, y, type.getSize(), type.getSize());
    }
}
