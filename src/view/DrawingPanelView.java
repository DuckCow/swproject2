package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DrawingPanelView extends JPanel {

    private Color lineColor;
    private Color fillColor;
    private Color backgroundColor;
    private Color objectbackgroundColor;

    private JButton jbtn;
    public DrawingPanelView(){
        this.lineColor=Color.BLACK;
        this.fillColor = null;
        this.backgroundColor = null;
        this.objectbackgroundColor = null;
        jbtn = new JButton("herllo");
        this.add(jbtn);

    }

    public void setDrawingPanelActionListener(ActionListener listener){
        jbtn.addActionListener(listener);
    }
}
