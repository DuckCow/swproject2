package view;

import controller.MainController;
import model.shape.GShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class DrawingPanelView extends JPanel {

    private Color lineColor;
    private Color fillColor;
    private Color backgroundColor;
    private Color objectbackgroundColor;

    public Vector<GShape> gShapes;
    public GShape gShape;


    //객체 리스트 포함

    private JButton jbtn;
    public DrawingPanelView(){
        this.lineColor=Color.BLACK;
        this.fillColor = null;
        this.backgroundColor = null;
        this.objectbackgroundColor = null;
        this.setForeground(Color.BLACK);
        this.setBackground(Color.WHITE);
        this.gShape=null;
        this.gShapes=new Vector<GShape>();
    }

    public void paint(Graphics g) {

        Graphics2D graphics2d = (Graphics2D) g;
        super.paint(g);

        if (this.gShape != null) {
            this.gShape.draw(graphics2d);
        }

        if(this.gShapes != null){
            for (GShape shape : gShapes) {
                shape.draw(graphics2d);
            }
        }
        repaint();
    }



    public void setDrawingPanelActionListener(ActionListener listener){
        jbtn.addActionListener(listener);
    }

    public void setDrawingPanelMouseHandler(MainController.MouseHandler mouseHandler){
        // button
        this.addMouseListener(mouseHandler);
        // position
        this.addMouseMotionListener(mouseHandler);
        // wheel
        this.addMouseWheelListener(mouseHandler);

    }



}
