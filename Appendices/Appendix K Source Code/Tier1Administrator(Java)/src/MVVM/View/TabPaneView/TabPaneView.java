package MVVM.View.TabPaneView;

import MVVM.View.Display.DisplayView;
import MVVM.View.Employee.EmployeeView;
import MVVM.View.Employee.NewEmployee;
import MVVM.View.NewCustomer.NewCustomer;
import MVVM.View.Schedule.ScheduleView;
import MVVM.ViewModel.ViewModelProvider;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabPaneView {

    @FXML
    private TabPane mainTabPane;

    @FXML
    private Tab createTab;
    @FXML
    private Tab createCustomerTab;
    @FXML
    private Tab displayEmployeeTab;
    @FXML
    private Tab createEmployeeTab;
    @FXML
    private Tab createScheduleTab;

    @FXML
    private DisplayView displayViewController;
    @FXML
    private NewCustomer createCustomerController;
    @FXML
    private EmployeeView displayEmployeesController;
    @FXML
    private NewEmployee createEmployeeController;
    @FXML
    private ScheduleView createScheduleController;

    public void init(ViewModelProvider viewModelProvider){
        displayViewController.init(viewModelProvider.getDisplayViewModel());
        createCustomerController.init(viewModelProvider.getNewCustomerViewModel());
        displayEmployeesController.init(viewModelProvider.getEmployeeViewModel());
        createEmployeeController.init(viewModelProvider.getNewEmployeeViewModel());
        //createScheduleController.init(viewModelProvider.getScheduleViewModel());
    }
}
