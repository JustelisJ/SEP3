package MVVM.ViewModel.Display;

import MVVM.Model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Customer;

import java.beans.PropertyChangeEvent;

public class DisplayViewModel {

    private Model model;

    private ObservableList<Customer> customers;

    public DisplayViewModel(Model model) {
        this.model = model;

        customers = FXCollections.observableArrayList();

        model.addListener("CustomerAdded", this::customerAdded);
        model.addListener("CustomerDeleted", this::customerDeleted);
    }

    public Customer getCustomer(int id){
        return model.getCustomer(id);
    }

    public ObservableList<Customer> getCustomers()
    {
        model.getCustomers();
        for (int i = 0; i < model.getCustomersSize(); i++) {
            customers.add(model.getCustomer(i));
        }

        return customers;
    }

    public void deleteCustomer(int id){
        model.deleteCustomer(id);
    }

    private void customerAdded(PropertyChangeEvent evt){
        customers.add((Customer) evt.getNewValue());
    }

    private void customerDeleted(PropertyChangeEvent evt){
        customers.remove((Customer) evt.getNewValue());
    }
}
