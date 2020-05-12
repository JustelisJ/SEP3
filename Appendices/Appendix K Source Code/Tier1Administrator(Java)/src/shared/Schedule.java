package shared;

import java.util.Date;

public class Schedule {


    int scheduleid;
    String area;
    Date date;
    String trashType;
    String city;

    public Schedule(String area, Date date, String trashType, String city) {
        this.area = area;
        this.date = date;
        this.trashType=trashType;
        this.city = city;
    }

    public int getShiftid() {
        return scheduleid;
    }

    public void setShiftid(int shiftid) {
        this.scheduleid = shiftid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTrashType() {
        return trashType;
    }

    public void setTrashType(String trashType) {
        this.trashType = trashType;
    }
}
