package controller;

import model.DrawingPanel;
import model.MainModel;
import model.shape.GShape;
import view.DrawingPanelView;
import view.MainView;
import view.PropertyPanelView;
import view.ToolBarPanelView;

import java.awt.*;
import java.awt.event.*;

public class MainController {

    private MainView mainView;
    private MainModel mainModel;
    private DrawingPanelView drawingPanelView;
    private ToolBarPanelView toolBarPanelView;
    private PropertyPanelView propertyPanelView;



    public MainController(
            MainModel mainModel,
            MainView mainView)
    {
        this.mainModel=mainModel;
        this.mainView=mainView;
        this.drawingPanelView=mainView.drawingPanelView;
        this.toolBarPanelView=mainView.toolBarPanelView;
        this.propertyPanelView=mainView.propertyPanelView;


        //this.drawingPanelView.setDrawingPanelActionListener(this);
        MouseHandler mouseHandler = new MouseHandler();
        this.drawingPanelView.setDrawingPanelMouseHandler(mouseHandler);
        this.toolBarPanelView.setToolBarActionListener(new ToolBarHandler());
        this.propertyPanelView.setPropertyPanelActionListener(new PropertyPanelHandler());

    }

    
    

    /*
    //DrawingPanel, ToolBar
    @Override
    public void actionPerformed(ActionEvent e) {


    }*/

    public class MouseHandler implements MouseListener, MouseMotionListener{
        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("mousePressed ");
            drawingPanelView.gShape=mainModel.drawingPanel.shapeTool.generateShape(); //toolbar에서 고른 shape
            mainModel.drawingPanel.initAction(drawingPanelView.gShapes,drawingPanelView.gShape, e.getX(),e.getY());
        }


        @Override
        public void mouseDragged(MouseEvent e) {
                mainModel.drawingPanel.keepTransforming((Graphics2D) drawingPanelView.getGraphics(),e.getX(),e.getY());

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(mainModel.drawingPanel.getECurrenState()== DrawingPanel.ECurrentState.eDrawing){
                System.out.println("mouseReleased");
                mainModel.drawingPanel.finishTransforming((Graphics2D) drawingPanelView.getGraphics(),e.getX(),e.getY());
                drawingPanelView.repaint();
                drawingPanelView.gShapes.add(drawingPanelView.gShape);
            }
        }
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }


        @Override
        public void mouseMoved(MouseEvent e) {

        }

    }

    public class ToolBarHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //ToolBar button clicked
            // drawingPanel state= eDrawing
            //drawing
            mainModel.drawingPanel.toolbarFunction(e.getActionCommand());

        }
    }

    public class PropertyPanelHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //이때 string은 0 이상 자연수로 가정
            System.out.println("e.getActionCommand() = " + e.getActionCommand());
            //mainModel.drawingPanel.propertyFunction(drawingPanelView.gShape, )


        }
    }

}
