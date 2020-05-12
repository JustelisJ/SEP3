package MVVM.View.Employee;

import MVVM.ViewModel.Employee.EmployeeViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeView {


    @FXML
    private TableView tableView;
    @FXML
    private TableColumn id;
    @FXML
    private TableColumn firstName;
    @FXML
    private TableColumn lastName;
    @FXML
    private TableColumn jobTitle;

    public EmployeeViewModel viewModel;

    public void init(EmployeeViewModel viewModel)
    {
        this.viewModel=viewModel;
        tableView.setItems(viewModel.getEmployees());

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        jobTitle.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));


    }
    public void updateTable(ActionEvent event) {
        tableView.getItems().clear();

        tableView.setItems(viewModel.getEmployees());

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        jobTitle.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
    }
    public void deleteEmployee(ActionEvent event){
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();

        viewModel.deleteEmployee(selectedIndex);
        tableView.getItems().remove(selectedIndex);
    }

}
