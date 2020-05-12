package shared;

public class Customer {
   private int id;
   private String firstName;
   private String lastName;
   private String iDNO;
   private String iDNONr;
   private String idReleaseDate;
   private String city;
   private String area;
   private String address;
   private String addressNr;
   private char addressBlock;
   private int appartmentNr;
   private String homeNr;
   private String  phoneNr;
   private String startingDate;
   private String type;
   private String password;


    public Customer(String firstName, String lastName, String IDno, String IDNONr, String idReleaseDate, String city, String area, String adress, String adressNr, char adressBlock, int appartmentNr, String homeNr, String phoneNr, String StartingDate, String type, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.iDNO = IDno;
        this.iDNONr = IDNONr;
        this.idReleaseDate = idReleaseDate;
        this.city = city;
        this.area = area;
        this.address = adress;
        this.addressNr = adressNr;
        this.addressBlock = adressBlock;
        this.appartmentNr = appartmentNr;
        this.homeNr = homeNr;
        this.phoneNr = phoneNr;
        this.startingDate = StartingDate;
        this.type = type;
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

    public String getIDno() {
        return iDNO;
    }

    public void setIDno(String IDno) {
        this.iDNO = IDno;
    }

    public String getIdReleaseDate() {
        return idReleaseDate;
    }

    public void setIdReleaseDate(String idReleaseDate) {
        this.idReleaseDate = idReleaseDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getAddressNr() {
        return addressNr;
    }

    public void setAddressNr(String addressNr) {
        this.addressNr = addressNr;
    }

    public char getAddressBlock() {
        return addressBlock;
    }

    public void setAddressBlock(char addressBlock) {
        this.addressBlock = addressBlock;
    }

    public int getApartmentNr() {
        return appartmentNr;
    }

    public void setApartmentNr(int appartmentNr) {
        this.appartmentNr = appartmentNr;
    }

    public String getHomeNr() {
        return homeNr;
    }

    public void setHomeNr(String homeNr) {
        this.homeNr = homeNr;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getStartDate() {
        return startingDate;
    }

    public void setStartDate(String startDate) {
        this.startingDate = startDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword()
    {
        return password;
    }

    public  void setPassword(String password)
    {
        this.password = password;
    }
}
