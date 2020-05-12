package Shared;

import java.util.Date;

public class Customer {
    public int Id;
    public String firstName;
    public String lastName;
    public String idno;
    public String idnoNr;
    public String idReleaseDate;
    public String city;
    public int area;
    public String address;
    public int addressNr;
    public char addressBlock;
    public int appartmentNr;
    public String homeNr;
    public String phoneNr;
    public String startingDate;
    public String type;
    public String password;

    public Customer(String firstName, String lastName, String idno, String idnoNr, String idReleaseDate, String city, int area, String adress, int adressNr, char adressBlock, int appartmentNr, String homeNr, String phoneNr, String StartingDate, String type, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idno = idno;
        this.idnoNr = idnoNr;
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

    public boolean equals(Object obj)
    {
        if(obj instanceof Customer)
        {
            if(!((Customer) obj).firstName.equals(firstName))
            {
                return false;
            }
            if(!((Customer) obj).lastName.equals(lastName))
            {
                return false;
            }
            if(!((Customer) obj).idno.equals(idno))
            {
                return false;
            }
            if(!((Customer) obj).idnoNr.equals(idnoNr))
            {
                return false;
            }
            if(!((Customer) obj).idReleaseDate.equals(idReleaseDate))
            {
                return false;
            }
            if(!((Customer) obj).city.equals(city))
            {
                return false;
            }
            if(((Customer) obj).area != area)
            {
                return false;
            }
            if(!((Customer) obj).address.equals(address))
            {
                return false;
            }
            if(((Customer) obj).addressNr != addressNr)
            {
                return false;
            }
            if(((Customer) obj).addressBlock != addressBlock)
            {
                return false;
            }
            if(((Customer) obj).appartmentNr != appartmentNr)
            {
                return false;
            }
            if(!((Customer) obj).homeNr.equals(homeNr))
            {
                return false;
            }
            if(!((Customer) obj).phoneNr.equals(phoneNr))
            {
                return false;
            }
            if(!((Customer) obj).startingDate.equals(startingDate))
            {
                return false;
            }
            if(!((Customer) obj).type.equals(type))
            {
                return false;
            }
            if(!((Customer) obj).password.equals(password))
            {
                return false;
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    public String ToString()
    {
        return firstName+" "+ lastName+" Area: " + area;
    }
}
