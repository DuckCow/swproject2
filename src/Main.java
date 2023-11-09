import controller.MainController;
import model.MainModel;
import view.MainView;

public class Main {
    public static void main(String[] args) {

        MainView mainView=new MainView();
        MainModel mainModel = new MainModel();

        mainView.setVisible(true);
        mainView.setResizable(true);
        mainView.setLocationRelativeTo(null);

        MainController mainController = new MainController(
                        mainModel,
                        mainView
                );

    }
}