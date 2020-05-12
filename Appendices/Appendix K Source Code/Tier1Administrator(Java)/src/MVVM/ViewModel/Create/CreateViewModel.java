package MVVM.ViewModel.Create;

import MVVM.Model.Model;
import shared.Customer;

public class CreateViewModel {

    private Model model;

    public CreateViewModel(Model model) {
        this.model = model;
    }

    public void createCustomer(Customer customer){
        model.createCustomer(customer);
    }

    public int convertStringToInt(String s) {
        return model.convertStringToInt(s);
    }
}
