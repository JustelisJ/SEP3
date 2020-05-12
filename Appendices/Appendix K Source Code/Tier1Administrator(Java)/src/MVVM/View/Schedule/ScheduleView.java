package MVVM.View.Schedule;
import MVVM.ViewModel.Schedule.ScheduleViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import shared.Schedule;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class ScheduleView {

    @FXML
    public RadioButton plastic;
    @FXML
    public RadioButton biological;
    @FXML
    public DatePicker date;
    @FXML
    public ListView scheduleList;
    @FXML
    public  ComboBox area;
    @FXML
    public ComboBox city;



    public ScheduleViewModel viewModel;

    public  void init (ScheduleViewModel scheduleViewModel)
    {
        this.viewModel = scheduleViewModel;

        date.setValue(LocalDate.now());

        ObservableList<String>  areas = FXCollections.observableArrayList("Area1", "Area2", "Area3");
        ObservableList<String>  cities = FXCollections.observableArrayList("Aarhus", "Aalborg", "Horsens");

        area.setItems(areas);
        area.getSelectionModel().selectFirst();


        city.setItems(cities);
        city.getSelectionModel().selectFirst();

        ToggleGroup toggleGroup = new ToggleGroup();

        plastic.setToggleGroup(toggleGroup);
        biological.setToggleGroup(toggleGroup);

        toggleGroup.selectToggle(plastic);
    }

    public void addNewDate()
    {


        String areaValue = area.getSelectionModel().getSelectedItem().toString();

        LocalDate localDate = date.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date dateValue = java.util.Date.from(instant);

        String cityValue =city.getSelectionModel().getSelectedItem().toString();
        String trashType = "None";
        if (plastic.isSelected()){
            trashType = "Plastic";
        }
        else if(biological.isSelected()){
            trashType = "Biological";
        }
        else {
            trashType = "Not selected";
        }

        Schedule schedule = new Schedule(areaValue, dateValue, trashType, cityValue);

        viewModel.addNewSchedule(schedule);
    }





}
