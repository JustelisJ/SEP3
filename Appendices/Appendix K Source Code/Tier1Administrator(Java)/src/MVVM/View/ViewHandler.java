package MVVM.View;

import MVVM.View.Employee.EmployeeView;
import MVVM.View.NewCustomer.NewCustomer;
import MVVM.View.Schedule.ScheduleView;
import MVVM.View.TabPaneView.TabPaneView;
import MVVM.View.login.Login;
import MVVM.ViewModel.ViewModelProvider;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ViewHandler {
    private Stage stage;
    private ViewModelProvider viewModelProvider;

    public ViewHandler(Stage stage, ViewModelProvider viewModelProvider) {
        this.stage = stage;
        this.viewModelProvider = viewModelProvider;
    }

    public void start() throws IOException {
        openView("Login");
    }

    public void openView(String viewToOpen) throws IOException {
        Scene scene=null;
        FXMLLoader loader = new FXMLLoader();
        Parent root =null;

        if("MainTabPane".equals(viewToOpen)){
            loader.setLocation(getClass().getResource("TabPaneView/TabPane.fxml"));
            root = loader.load();
            TabPaneView view = loader.getController();
            view.init(viewModelProvider);
            stage.setTitle("SEP3");
        }

        if("NewCustomerView".equals(viewToOpen)){
            loader.setLocation(getClass().getResource("NewCustomer/NewCustomer.fxml"));
            root= loader.load();
            NewCustomer view =loader.getController();
            view.init(viewModelProvider.getNewCustomerViewModel());
            stage.setTitle("Create Customer");

        }

        if ("Employee".equals(viewToOpen))
        {
            loader.setLocation(getClass().getResource("Employee/Employee.fxml"));
            root=loader.load();
            EmployeeView employee =loader.getController();
            employee.init(viewModelProvider.getEmployeeViewModel());
            stage.setTitle("Employee");

        }
        if("Login".equals(viewToOpen))
        {
            loader.setLocation(getClass().getResource("login/Login.fxml"));
            root=loader.load();
            Login view =loader.getController();
            view.init(viewModelProvider.getLoginViewModel(), this);
            stage.setTitle("Login");
        }
        if("ScheduleView".equals(viewToOpen))
        {
            loader.setLocation(getClass().getResource("Schedule/Schedule.fxml"));
            root= loader.load();
            ScheduleView view =loader.getController();
            view.init(viewModelProvider.getScheduleViewModel());
            stage.setTitle("Create ScheduleView");
        }


        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
