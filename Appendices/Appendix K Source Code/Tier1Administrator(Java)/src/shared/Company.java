package shared;

public class Company {


    private String CompanyName;
    private int CompanyNumber;
    private String City;
    private String Address;
    private int  PhoneNr;
    private String email;
    private int Bank;
    private int StartingDate;
    private int Price;


    public Company(String companyName,  int companyNumber,String city, String address, int phoneNr, String email, int bank, int startingDate, int price) {
        this.CompanyName = companyName;
        this.CompanyNumber =companyNumber;
        this.City = city;
        this.Address = address;
        this.PhoneNr = phoneNr;
        this.email = email;
        this.Bank = bank;
        this.StartingDate = startingDate;
        this.Price = price;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPhoneNr() {
        return PhoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        PhoneNr = phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBank() {
        return Bank;
    }

    public void setBank(int bank) {
        Bank = bank;
    }

    public int getStartingDate() {
        return StartingDate;
    }

    public void setStartingDate(int startingDate) {
        StartingDate = startingDate;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getCompanyNumber() {
        return CompanyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        CompanyNumber = companyNumber;
    }


}
