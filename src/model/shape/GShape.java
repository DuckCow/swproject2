package model.shape;

import java.awt.*;
import java.awt.geom.AffineTransform;

@SuppressWarnings("serial")
abstract public class GShape {

    // components

    protected boolean selected;
    private Color lineColor;
    private Color fillColor;
    private int stroke;
    public Shape shape;


    private AffineTransform af = null;

    public GShape() {
        af = new AffineTransform();
        this.lineColor = Color.BLACK;
        this.fillColor = null;
        this.selected = false;
        this.stroke = 0;
    }


    public boolean isSelected() {
        return selected;
    }

    public void setStroke(int index) {
        this.stroke = index;
    }


    public Shape getShape() {
        return this.shape;
    }


    public void setLineColor(Color color) {
        this.lineColor = color;
    }

    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    public Color getLineColor(){
        return this.lineColor;
    }

    public Color getFillColor(){
        return this.fillColor;
    }




    public void draw(Graphics2D graphics2d) {
        if (this.stroke != 0) {
            graphics2d.setStroke(new BasicStroke(this.stroke));
        }

        if (this.fillColor != null) {
            graphics2d.setColor(fillColor);
            graphics2d.fill(this.shape);
        }

        graphics2d.setColor(this.lineColor);
        graphics2d.draw(this.shape);
        graphics2d.setStroke(new BasicStroke(1));

    }


    public abstract void setInitPoint(int x1, int y1);

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public abstract void movePoint(int x, int y);

    public abstract GShape generateShape();

    public boolean lineContains(int x, int y) { //rectangular가 해당 (x,y) 포안트를 포함하는가.
        if (this.shape.getBounds().contains(new Point(x, y))) {return true;	}
        else {	return false;}
    }

    public void move(int dw, int dh) {
        af.setToTranslation(dw, dh);
        this.shape = af.createTransformedShape(this.shape);
    }

    public abstract void finishMoving(Graphics2D graphics2d, int x, int y);



}
