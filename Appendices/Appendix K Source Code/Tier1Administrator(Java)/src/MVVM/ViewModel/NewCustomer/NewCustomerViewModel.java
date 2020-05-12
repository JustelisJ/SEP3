package MVVM.ViewModel.NewCustomer;

import MVVM.Model.Model;
import shared.Customer;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class NewCustomerViewModel {

    private Model customerModel;


    public NewCustomerViewModel(Model customerModel) {
        this.customerModel = customerModel;
    }

    public String createCustomer(String firstName, String lastName, String IDNO, String IDNONr, String releaseDate,
                               String city, String area, String address, String addressNr, String addressBlock,
                               String appartmentNr, String homeNr, String phoneNr, String startingDate, String type,
                               String password)
    {
        Customer customer = new Customer(firstName, lastName, IDNO, IDNONr, releaseDate, city, area, address, addressNr, addressBlock.charAt(0), convertStringtoInt(appartmentNr), homeNr, phoneNr, startingDate, type, bytesToHex(password));
        return customerModel.createCustomer(customer);
    }

    public int convertStringtoInt(String s)
    {
        return customerModel.converStringToInt(s);
    }

    private static String bytesToHex(String toHash) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hashByte = digest.digest(toHash.getBytes(StandardCharsets.UTF_8));

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hashByte.length; i++) {
            String hex = Integer.toHexString(0xff & hashByte[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString().toUpperCase();
    }
}
