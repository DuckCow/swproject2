package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame{

    public DrawingPanelView drawingPanelView;
    public ToolBarPanelView toolBarPanelView;

    public PropertyPanelView propertyPanelView;

    public MainView(){
        setSize(1000, 1200);
        this.setTitle("SWProject");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        BorderLayout borderlayout = new BorderLayout();
        this.setLayout(borderlayout);
        this.drawingPanelView=new DrawingPanelView();
        this.toolBarPanelView=new ToolBarPanelView();
        this.propertyPanelView=new PropertyPanelView();
        this.propertyPanelView.setLayout(new GridLayout(4,2));


        this.add(this.drawingPanelView,borderlayout.CENTER);
        this.add(this.toolBarPanelView,borderlayout.SOUTH);
        this.add(this.propertyPanelView,borderlayout.EAST);


    }

}
