package MVVM.View.Display;

import MVVM.ViewModel.Display.DisplayViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.Customer;

public class DisplayView {

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn<String, Customer> id;

    @FXML
    private TableColumn<String, Customer> firstName;

    @FXML
    private  TableColumn<String , Customer> lastName;
    @FXML
    private TableColumn<String, Customer> type;

    private DisplayViewModel viewModel;

    public DisplayView() {
    }

    public void init(DisplayViewModel viewModel){
        this.viewModel = viewModel;

        tableView.setItems(viewModel.getCustomers());

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));

    }


    public void updateTable(ActionEvent event){
        tableView.getItems().clear();

        tableView.setItems(viewModel.getCustomers());

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
    }


    public void deleteCustomer(ActionEvent event){
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();

        viewModel.deleteCustomer(selectedIndex);
        tableView.getItems().remove(selectedIndex);
    }
}
