package view;

import controller.MainController;


import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PropertyPanelView extends JPanel {

    public JLabel widthLabel;
    public JLabel heightLabel;
    public JTextField widthText;
    public JTextField heightText;
    public JLabel LineColorLabel;
    public JLabel FillColorLabel;
    public JButton LineColorButton;
    public JButton FillColorButton;



    public PropertyPanelView(){
        widthLabel=new JLabel("width");
        heightLabel=new JLabel("height");
        widthText=new JTextField("");
        heightText=new JTextField("");
        LineColorLabel=new JLabel("Linecolor");
        FillColorLabel=new JLabel("FillColor");


        this.add(widthLabel);
        this.add(heightLabel);
        this.add(widthText);
        this.add(heightText);
        this.add(LineColorLabel);
        this.add(FillColorLabel);
    }
    public void setPropertyPanelActionListener(ActionListener listener) {
        this.widthText.addActionListener(listener);
        this.heightText.addActionListener(listener);
    }


}
