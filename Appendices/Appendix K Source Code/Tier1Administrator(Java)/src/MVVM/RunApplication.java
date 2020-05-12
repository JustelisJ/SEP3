package MVVM;

import MVVM.Model.DataModel;
import MVVM.View.ViewHandler;
import MVVM.ViewModel.ViewModelProvider;
import javafx.application.Application;
import javafx.stage.Stage;


public class RunApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        DataModel model= new DataModel();


        ViewModelProvider viewModelProvider= new ViewModelProvider(model);
        ViewHandler viewHandler= new ViewHandler(stage,viewModelProvider);
        viewHandler.start();


    }
}
