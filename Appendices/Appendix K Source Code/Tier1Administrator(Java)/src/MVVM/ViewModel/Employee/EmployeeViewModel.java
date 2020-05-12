package MVVM.ViewModel.Employee;

import MVVM.Model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Employee;

import java.beans.PropertyChangeEvent;

public class EmployeeViewModel {
    public Model model;
    private ObservableList<Employee> employees;

    public EmployeeViewModel(Model model) {
        this.model = model;


        employees = FXCollections.observableArrayList();

        model.addListener("EmployeeView added", this::employeeAdded);
        model.addListener("EmployeeView deleted", this::employeeDeleted);

    }

    public Employee getEmployee(int id) {
        return model.getEmployee(id);
    }

    public ObservableList<Employee> getEmployees() {
        for (int i = 0; i < model.getEmployees().size(); i++) {
            employees.add(model.getEmployee(i));
        }
        return employees;
    }

    public void deleteEmployee(int id)
    {
        model.deleteEmployee(id);
    }
    public  void employeeAdded(PropertyChangeEvent evt)
    {
        employees.add((Employee)evt.getNewValue());
    }
    private void employeeDeleted(PropertyChangeEvent evt){
        employees.remove((Employee) evt.getNewValue());
    }
}
