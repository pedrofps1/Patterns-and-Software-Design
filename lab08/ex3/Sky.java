import javax.swing.*;

import startypes.FlyWeightStar;
import startypes.StarType;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sky extends JFrame {
    private List<FlyWeightStar> stars = new ArrayList<>();

    public void placeStar(FlyWeightStar flyWeightStar) {
        stars.add(flyWeightStar);
    }

    @Override
    public void paint(Graphics graphics) {
        for (FlyWeightStar star : stars) {
            star.draw(graphics);
        }
    }
}