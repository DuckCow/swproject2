package model.shape;

import java.awt.*;
import java.awt.geom.Ellipse2D;


@SuppressWarnings("serial")
public class GOval extends GShape{

    public GOval() {
        this.shape = new Ellipse2D.Float();
    }
    @Override
    public GShape generateShape() {
        return new GOval();
    }

    @Override
    public void setInitPoint(int x1, int y1) {
        Ellipse2D ellipse = (Ellipse2D) this.shape;
        ellipse.setFrame(x1, y1, 0, 0);
    }

    @Override
    public void movePoint(int x2, int y2) {
        Ellipse2D ellipse = (Ellipse2D) this.shape;
        ellipse.setFrame(ellipse.getX(), ellipse.getY(), x2 - ellipse.getX(), y2 - ellipse.getY());
    }


}
