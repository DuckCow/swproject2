package controller;

import model.DrawingPanelModel;
import model.MainModel;
import view.DrawingPanelView;
import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

    private MainView mainView;
    private MainModel mainModel;
    private DrawingPanelView drawingPanelView;
    public MainController(MainModel mainModel, MainView mainView, DrawingPanelView drawingPanelView){
        this.mainModel=mainModel;
        this.mainView=mainView;
        this.drawingPanelView=drawingPanelView;
        this.drawingPanelView.setDrawingPanelActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
