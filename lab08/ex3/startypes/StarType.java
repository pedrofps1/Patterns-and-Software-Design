package startypes;

import java.awt.*;

public abstract class StarType {

    private int size;
    private Color color;
    protected String description;
    protected Float[] physicalProperties;

    public StarType(int size, Color color) {
        this.size = size;
        this.color = color;
        this.physicalProperties = new Float[10];
    }

    public void draw(Graphics g, int x, int y) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    public Color getColor() {
        return this.color;
    }

    public int getSize() {
        return this.size;
    }

}
