package model;

import constant.TooltipShape;
import model.shape.GShape;
import model.transformer.GDrawer;
import model.transformer.GTransformer;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

//객체 리스트 갖고 있어야.

public class DrawingPanel extends JPanel{

    public GShape shapeTool;


    private Vector<GShape> shapes;

    //mouse로 클릭된 객체됐거나, 생성될 객체
    private GShape selectedShape;

    //Tooltip에서 선택한 객체 폼
    private TooltipShape selectedShapeTool;
    private GTransformer transformer;
    private ECurrentState eCurrentState;


    public enum ECurrentState {

        //eIdle : eSelecting -> eDrawing 의 중간 단계
        eIdle, eDrawing, eSelecting
    }

    public DrawingPanel(){

        this.eCurrentState=ECurrentState.eSelecting;

    }

    public void setSelection(GShape shapeTool) {
        this.shapeTool = shapeTool;
    }

    public void setColorInfo() {
        this.selectedShape.setFillColor(this.selectedShape.getFillColor());
        this.selectedShape.setLineColor(this.selectedShape.getLineColor());
    }

    public ECurrentState getECurrenState(){
        return this.eCurrentState;
    }

    public void toolbarFunction(String command) {
        System.out.println("in toolbarFunction  ");

        //TODO: equals cheking
        if(selectedShapeTool==null || !selectedShapeTool.getTooltipname().equals(command)){ //초기 shape 설정. 이전 shape이 없음.
            // 다른 shape 로 변경. eDrawing 모드 .  이미 shape 이 설정되어 있었으나, 다른 shape으로 변경.
            selectedShapeTool = TooltipShape.valueOf(command);
            this.eCurrentState=ECurrentState.eDrawing;
            shapeTool= selectedShapeTool.newInstance();
        }
        else{ // 이미 해당 버튼이 눌러져 있었는데 또 누른 상태: 선택 취소, select mode로 변경. 즉 toolBar 같은 버튼 두 번 클릭
            //selectedShapeTool.getTooltipname()==command
            this.eCurrentState=ECurrentState.eSelecting;
            selectedShapeTool = null;
        }
        System.out.println("this.selectedShapeTool.getTooltipname() = " + this.selectedShapeTool.getTooltipname());
                

    }

    public GShape initAction(GShape ViewShape, int x, int y) {
        if(this.eCurrentState==ECurrentState.eDrawing){

            this.transformer = new GDrawer();
            //shapeTool= selectedShapeTool.newInstance();  -> 이미 수행됨.
            this.selectedShape = ViewShape;
            this.setColorInfo();

            this.transformer.setGShape(this.selectedShape);
            this.transformer.initTransforming(x, y);
        }

        /*
        else{ //Selecting
            if(해당 x,y 좌표에 이미 생성된 객체가 있을 때){ //Selecting && Mover

            }else{ //아무 것도 없는데 pressed. 즉 그림판 빈 공간 pressed -> property panel 바꿔줘야.

            }
        }
        */
        return this.selectedShape;
    }


    public void keepTransforming(Graphics2D view, int x2, int y2) {
        Graphics2D g2 = view;
        g2.setXORMode(this.getBackground());
        try {
            this.transformer.keepTransforming(g2, x2, y2);
        } catch (NullPointerException ignored) {

        }

    }


    public void finishTransforming(Graphics2D view,int x2, int y2) {
        this.transformer.finishTransforming(view, x2, y2);

    }


}
