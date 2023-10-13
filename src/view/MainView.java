package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame{

    public DrawingPanelView drawingPanelView;
    public MainView(){
        setSize(1000, 1200);
        this.setTitle("SWProject");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        BorderLayout borderlayout = new BorderLayout();
        this.setLayout(borderlayout);
        this.drawingPanelView=new DrawingPanelView();

        this.add(this.drawingPanelView,borderlayout.CENTER);


    }

}
