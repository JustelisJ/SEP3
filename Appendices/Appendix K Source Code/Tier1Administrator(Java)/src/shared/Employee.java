package shared;

import java.util.Date;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String address;
    private int addressNr;
    private char addressBlock;
    private int appartmentNr;
    private String iDNO;
    private String iDNONr;
    private String idReleaseDate ;
    private char gender;
    private String phoneNr ;
    private String jobTitle ;
    private String password;

    public Employee(int id, String firstName, String lastName, String birthDay, String address, int addressNr, char addressBlock, int appartmentNr, String IDNO, String IDNONr, String idReleaseDate, char gender, String phoneNr, String jobTitle, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.address = address;
        this.addressNr = addressNr;
        this.addressBlock = addressBlock;
        this.appartmentNr = appartmentNr;
        this.iDNO = IDNO;
        this.iDNONr = IDNONr;
        this.idReleaseDate = idReleaseDate;
        this.gender = gender;
        this.phoneNr = phoneNr;
        this.jobTitle = jobTitle;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAddressNr() {
        return addressNr;
    }

    public void setAddressNr(int addressNr) {
        this.addressNr = addressNr;
    }

    public char getAddressBlock() {
        return addressBlock;
    }

    public void setAddressBlock(char addressBlock) {
        this.addressBlock = addressBlock;
    }

    public int getAppartmentNr() {
        return appartmentNr;
    }

    public void setAppartmentNr(int appartmentNr) {
        this.appartmentNr = appartmentNr;
    }

    public String getIDNO() {
        return this.iDNO;
    }

    public void setIDNO(String IDNO) {
        this.iDNO = IDNO;
    }

    public String getIDNONr() {
        return iDNONr;
    }

    public void setIDNONr(String IDNONr) {
        this.iDNONr = IDNONr;
    }

    public String getIdReleaseDate() {
        return idReleaseDate;
    }

    public void setIdReleaseDate(String idReleaseDate) {
        this.idReleaseDate = idReleaseDate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



