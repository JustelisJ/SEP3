package MVVM.ViewModel.Schedule;

import MVVM.Model.Model;
import MVVM.View.Schedule.ScheduleView;
import shared.Schedule;

public class ScheduleViewModel {

    private Model scheduleModel;


    public ScheduleViewModel(Model scheduleModel) {
        this.scheduleModel = scheduleModel;
    }

    public void addNewSchedule(Schedule schedule)
    {
         scheduleModel.addNewSchedule(schedule);
    }
}
