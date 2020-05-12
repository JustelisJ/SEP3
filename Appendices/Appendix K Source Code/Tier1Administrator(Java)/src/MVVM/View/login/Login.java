package MVVM.View.login;

import MVVM.View.ViewHandler;
import MVVM.ViewModel.Login.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Login {

    @FXML
    private TextField username;

    @FXML
    private TextField password;
    @FXML
    private Label error;

    private  LoginViewModel viewModel;
    private ViewHandler viewHandler;

    public void init(LoginViewModel viewModel, ViewHandler viewHandler)
    {
        this.viewModel= viewModel;
        this.viewHandler = viewHandler;
        error.setText("");
    }

    public void login()
    {
        String Username = username.getText();
        String Password  =password.getText();

        error.setText(viewModel.login(Username,Password));
        if(error.getText().equals(""))
        {
            try {
                viewHandler.openView("MainTabPane");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }














}
