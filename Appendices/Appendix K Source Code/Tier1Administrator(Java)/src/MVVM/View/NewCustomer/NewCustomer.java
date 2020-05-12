package MVVM.View.NewCustomer;

import MVVM.ViewModel.NewCustomer.NewCustomerViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import shared.Customer;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class NewCustomer {

    @FXML
    private TextField FirstName;
    @FXML
    private TextField LastName;
    @FXML
    private TextField id;
    @FXML
    private TextField IDno;
    @FXML
    private DatePicker date;
    @FXML
    private TextField city;
    @FXML
    private TextField area;
    @FXML
    private TextField address;
    @FXML
    private TextField addressNr;
    @FXML
    private TextField addressBlock;         //Not necessary
    @FXML
    private TextField appartmentNr;         //Not necessary
    @FXML
    private TextField homeNr;               //Not necessary
    @FXML
    private TextField phone;
    @FXML
    private DatePicker startDate;
    @FXML
    private RadioButton homeOwner;
    @FXML
    private RadioButton company;
    @FXML
    private TextField password;
    @FXML
    private TextField confirmPassword;
    @FXML
    private Label response;

    private ToggleGroup group;


    private NewCustomerViewModel viewModel;

    public NewCustomer() {
    }

    public void init(NewCustomerViewModel viewModel)
    {
        this.viewModel = viewModel;
        group = new ToggleGroup();
        homeOwner.setToggleGroup(group);
        company.setToggleGroup(group);
    }

    public void addNewCustomer()
    {
        if(checkFields())
        {
            if(password.getText().equals(confirmPassword.getText()))
            {

                if(homeOwner.isSelected())
                {
                    response.setText(viewModel.createCustomer(FirstName.getText(), LastName.getText(), id.getText(), IDno.getText(),
                            date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), city.getText(), area.getText(),
                            address.getText(), addressNr.getText(), addressBlock.getText(), appartmentNr.getText(), homeNr.getText(),
                            phone.getText(), startDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), "HomeOwner", password.getText()));
                }
                else
                {
                    if(company.isSelected())
                    {
                        response.setText( viewModel.createCustomer(FirstName.getText(), LastName.getText(), id.getText(), IDno.getText(),
                                date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), city.getText(), area.getText(),
                                address.getText(), addressNr.getText(), addressBlock.getText(), appartmentNr.getText(), homeNr.getText(),
                                phone.getText(), startDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), "Company", password.getText()));
                    }
                    else
                    {
                        response.setText("Need to select if the new customer is a home owner or a company");
                    }
                }

            }
            else
            {
                response.setText("Passwords are not the same");
            }
        }
    }

    private boolean checkFields()
    {
        boolean complete = true;
        if(FirstName.getText().isBlank() || FirstName.getText().length() < 3 || FirstName.getText().length() > 50) {
            complete = false;
            FirstName.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        }
        else
        {
            FirstName.setStyle("");
        }
        if(LastName.getText().isBlank() || LastName.getText().length() < 3 || LastName.getText().length() > 50) {
            complete = false;
            LastName.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        }
        else
        {
            LastName.setStyle("");
        }
        if(id.getText().isBlank())
        {
            complete = false;
            id.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        }
        else
        {
            id.setStyle("");
        }
        if(IDno.getText().isBlank())
        {
            complete = false;
            IDno.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        }
        else
        {
            IDno.setStyle("");
        }
        if(date.getValue() == null)
        {
            complete = false;
            date.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        }
        else
        {
            date.setStyle("");
        }
        if(city.getText().isBlank())
        {
            complete = false;
            city.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        }
        else
        {
            city.setStyle("");
        }
        if(area.getText().isBlank())
        {
            complete = false;
            area.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        }
        else
        {
            area.setStyle("");
        }
        if(address.getText().isBlank())
        {
            complete = false;
            address.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        }
        else
        {
            address.setStyle("");
        }
        if(addressNr.getText().isBlank())
        {
            complete = false;
            addressNr.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        }
        else
        {
            addressNr.setStyle("");
        }
        if(addressBlock.getText().isBlank())
        {

            addressBlock.setText(" ");
        }
        else
        {
            if(addressBlock.getText().length() > 1)
            {
                addressBlock.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            }
            else
            {
                addressBlock.setStyle("");
            }
        }
        if(appartmentNr.getText().isBlank())
        {
            appartmentNr.setText("0");
        }
        if(phone.getText().isBlank())
        {
            complete = false;
            phone.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        }
        else
        {
            phone.setStyle("");
        }
        if(startDate.getValue() == null)
        {
            complete = false;
            startDate.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        }
        else
        {
            startDate.setStyle("");
        }
        if(password.getText().isBlank())
        {
            complete = false;
            password.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        }
        else
        {
            password.setStyle("");
        }
        if(confirmPassword.getText().isBlank())
        {
            complete = false;
            confirmPassword.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        }
        else
        {
            confirmPassword.setStyle("");
        }
        return complete;
    }
}
