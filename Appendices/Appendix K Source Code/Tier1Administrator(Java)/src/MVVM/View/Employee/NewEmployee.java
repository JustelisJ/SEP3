package MVVM.View.Employee;

import MVVM.ViewModel.Display.DisplayViewModel;
import MVVM.ViewModel.Employee.NewEmployeeViewModel;
import MVVM.ViewModel.NewCustomer.NewCustomerViewModel;
import javafx.scene.control.cell.PropertyValueFactory;

public class NewEmployee {

    private NewEmployeeViewModel viewModel;

    public void init(NewEmployeeViewModel viewModel){
        this.viewModel = viewModel;
    }

}
