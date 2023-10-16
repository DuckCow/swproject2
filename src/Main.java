import controller.MainController;
import model.MainModel;
import view.MainView;

public class Main {
    public static void main(String[] args) {
        MainView mainView=new MainView();

        mainView.setVisible(true);
        mainView.setResizable(true);
        mainView.setLocationRelativeTo(null);

        MainModel mainModel = new MainModel();
        MainController mainController = new MainController(
                        mainModel,
                        mainView,
                        mainView.drawingPanelView,
                        mainView.toolBarPanelView);

    }
}