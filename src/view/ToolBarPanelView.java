package view;

import constant.TooltipShape;
import controller.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class ToolBarPanelView extends JToolBar {

    public ButtonGroup buttonGroup;
    public ToolBarPanelView(){
        buttonGroup = new ButtonGroup();

        for (TooltipShape TooltipButton : TooltipShape.values()) {
            JRadioButton button = new JRadioButton();
            button.setBackground(Color.YELLOW);
            button.setIcon(new ImageIcon(TooltipButton.getImage()));
            button.setSelectedIcon(new ImageIcon(TooltipButton.getSelectedImage()));
            button.setActionCommand(TooltipButton.toString());
            button.setToolTipText(TooltipButton.getTooltipname());
            this.add(button);
            buttonGroup.add(button);

        }

    }

    public void setToolBarActionListener(ActionListener listener){
        Enumeration<AbstractButton> jRadioButtonEnumeration= this.buttonGroup.getElements();
        while(jRadioButtonEnumeration.hasMoreElements()){
            jRadioButtonEnumeration.nextElement().addActionListener(listener);
        }
    }


}
