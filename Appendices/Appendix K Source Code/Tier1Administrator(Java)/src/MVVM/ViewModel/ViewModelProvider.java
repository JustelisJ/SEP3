package MVVM.ViewModel;

import MVVM.Model.Model;
import MVVM.ViewModel.Create.CreateViewModel;
import MVVM.ViewModel.Display.DisplayViewModel;
import MVVM.ViewModel.Employee.EmployeeViewModel;
import MVVM.ViewModel.Employee.NewEmployeeViewModel;
import MVVM.ViewModel.Login.LoginViewModel;
import MVVM.ViewModel.NewCustomer.NewCustomerViewModel;
import MVVM.ViewModel.Schedule.ScheduleViewModel;

public class ViewModelProvider {

    private Model model;

    private NewEmployeeViewModel newEmployeeViewModel;
    private NewCustomerViewModel newCustomerViewModel;
    private LoginViewModel loginViewModel;
    private ScheduleViewModel scheduleViewModel;

    private CreateViewModel createViewModel;
    private DisplayViewModel displayViewModel;
    private EmployeeViewModel employeeViewModel;


    public ViewModelProvider(Model model) {
        this.model = model;

        newEmployeeViewModel = new NewEmployeeViewModel(model);
        newCustomerViewModel = new NewCustomerViewModel(model);
        loginViewModel = new LoginViewModel(model);
        scheduleViewModel = new ScheduleViewModel(model);
        createViewModel = new CreateViewModel(model);
        displayViewModel = new DisplayViewModel(model);
        employeeViewModel = new EmployeeViewModel(model);
    }

    public NewEmployeeViewModel getNewEmployeeViewModel()
    {
        return newEmployeeViewModel;
    }

    public NewCustomerViewModel getNewCustomerViewModel() {
        return newCustomerViewModel;
    }

    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }

    public ScheduleViewModel getScheduleViewModel() {
        return scheduleViewModel;
    }

    public CreateViewModel getCreateViewModel() {
        return createViewModel;
    }

    public DisplayViewModel getDisplayViewModel() {
        return displayViewModel;
    }

    public EmployeeViewModel getEmployeeViewModel() {
        return employeeViewModel;


    }
}
