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

    protected Shape shape;
    protected GAnchor gAnchors;

    private AffineTransform af = null;

    public GShape() {
        af = new AffineTransform();
        this.lineColor = Color.BLACK;
        this.fillColor = null;
        this.selected = false;
        this.stroke = 0;
        this.gAnchors = new GAnchor();
    }

    public GAnchor getGAnchor() {
        return this.gAnchors;
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

    public void setSelected(boolean selected) {
        this.selected = selected;
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

    public void setNullFillColor() {
        fillColor = null;
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

        if (this.selected) {
            this.gAnchors.setBoundingRect(this.shape.getBounds());
            this.gAnchors.draw(graphics2d);
        }
    }


    public abstract void setInitPoint(int x1, int y1);

    public abstract void movePoint(int x, int y);

    public abstract GShape generateShape();


}
