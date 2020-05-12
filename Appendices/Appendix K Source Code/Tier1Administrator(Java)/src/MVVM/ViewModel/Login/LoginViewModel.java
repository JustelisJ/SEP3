package MVVM.ViewModel.Login;

import MVVM.Model.Model;

public class LoginViewModel {

    private Model loginInterface;

    public LoginViewModel(Model loginInterface) {
        this.loginInterface = loginInterface;
    }

    public String login(String username ,String password)
    {
        return loginInterface.login(username, password);
    }
}
