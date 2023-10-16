package model.transformer;

import model.shape.GShape;

import java.awt.*;

public abstract class GTransformer {

    protected GShape gShape;  // 객체의 shape
    protected Point fromPoint;  // from
    protected Point toPoint; // to

    //
    public GTransformer() {
        this.setGShape(null);
        this.fromPoint = new Point(0, 0);
        this.toPoint = new Point(0, 0);
    }

    public void setGShape(GShape gShape) { this.gShape = gShape; }

    public void setFromPoint(int x, int y){
        this.fromPoint.x = x;
        this.fromPoint.y = y;
    }

    abstract public void initTransforming(int x, int y);

    abstract public void keepTransforming(Graphics2D graphics2d, int x, int y);

    abstract public void finishTransforming(Graphics2D graphics2d, int x, int y);

}
