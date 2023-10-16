package controller;

import model.DrawingPanel;
import model.MainModel;
import model.shape.GShape;
import view.DrawingPanelView;
import view.MainView;
import view.ToolBarPanelView;

import java.awt.*;
import java.awt.event.*;

public class MainController implements ActionListener {

    private MainView mainView;
    private MainModel mainModel;
    private DrawingPanelView drawingPanelView;
    private ToolBarPanelView toolBarPanelView;
    private ToolBarHandler toolBarHandler;


    public MainController(
            MainModel mainModel,
            MainView mainView,
            DrawingPanelView drawingPanelView,
            ToolBarPanelView toolBarPanelView)
    {
        this.mainModel=mainModel;
        this.mainView=mainView;
        this.drawingPanelView=drawingPanelView;
        //this.drawingPanelView.setDrawingPanelActionListener(this);
        MouseHandler mouseHandler = new MouseHandler();
        this.drawingPanelView.setDrawingPanelMouseHandler(mouseHandler);
        this.toolBarPanelView=toolBarPanelView;
        this.toolBarHandler = new ToolBarHandler();
        this.toolBarPanelView.setToolBarActionListener(this.toolBarHandler);

    }

    
    
    
    //DrawingPanel, ToolBar
    @Override
    public void actionPerformed(ActionEvent e) {


    }

    public class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener{
        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("mousePressed ");
            drawingPanelView.gShape=mainModel.drawingPanel.shapeTool.generateShape();
            mainModel.drawingPanel.initAction(drawingPanelView.gShape, e.getX(),e.getY());
        }


        @Override
        public void mouseDragged(MouseEvent e) {
            if(mainModel.drawingPanel.getECurrenState()== DrawingPanel.ECurrentState.eDrawing){
                mainModel.drawingPanel.keepTransforming((Graphics2D) drawingPanelView.getGraphics(),e.getX(),e.getY());
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(mainModel.drawingPanel.getECurrenState()== DrawingPanel.ECurrentState.eDrawing){
                System.out.println("mouseReleased");
                mainModel.drawingPanel.finishTransforming((Graphics2D) drawingPanelView.getGraphics(),e.getX(),e.getY());
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

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

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
}
