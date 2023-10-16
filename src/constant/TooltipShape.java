package constant;

import model.shape.GRectangle;
import model.shape.GShape;

public enum TooltipShape {

    eRectangle(new GRectangle(), "images/rectangle.png", "images/rectangle-selected.png", "rectangle");



    private GShape shapeTool;
    private String image;
    private String selectedimage;
    private String tooltipname;

    private TooltipShape(GShape shapeTool, String image, String selectedimage, String tooltipname) {
        this.shapeTool = shapeTool;
        this.image = image;
        this.selectedimage = selectedimage;
        this.tooltipname = tooltipname;

    }

    public GShape newInstance() {
        return shapeTool;
    }

    public String getImage() {
        return image;
    }

    public String getSelectedImage() {
        return selectedimage;
    }

    public String getTooltipname() {
        return tooltipname;
    }


}
