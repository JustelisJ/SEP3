import Shared.Customer;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.junit.After;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class RequestTest {

    @Test
    public void callCreateCustomer() {
        Gson gson = new Gson();
        Customer customer = new Customer("test", "test", "123", "123", "2017-01-01T00:00:00", "Horsens", 1, "test", 123, 'A', 2, "123123", "123123", "2020-03-01T00:00:00", "HomeOwner", bytesToHex("test"));
        String json = gson.toJson(customer);
        Request request = new Request("CREATE", "customer", json);
        String response = request.CallTier3();
        Customer compare = gson.fromJson(response, Customer.class);
        assertTrue(customer.equals(compare));
    }
    @Test
    public void callLoginSuccess() {
        String username = "DimBor";
        String password = "123";
        Request request = new Request("GET", "login", username + "," + bytesToHex(password));
        assertEquals(request.CallTier3(), "true");
    }
    @Test
    public void callLoginFail() {
        String username = "DimBor";
        String password = "12";
        Request request = new Request("GET", "login", username + "," + bytesToHex(password));
        assertEquals(request.CallTier3(), "false");
    }
    @Test
    public void callGetCustomer()
    {
        Gson gson = new Gson();
        String username = "DimBor";
        String password = "123";
        Request request1 = new Request("GET", "employee", username + "," + bytesToHex(password));
        String json = request1.CallTier3();
        json = json.substring(1, json.length() - 1);
        Customer customer = gson.fromJson(json, Customer.class);
        assertNotNull(customer);
    }
    @Test
    public void callGetCustomersInCity1()
    {
        Gson gson = new Gson();
        Request request = new Request("GET", "city", "Vejle");
        String json = request.CallTier3();
        ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList(gson.fromJson(json, Customer[].class)));
        assertNotNull(customers);
    }
    @Test
    public void callGetCustomersInCity2()
    {
        Gson gson = new Gson();
        Request request = new Request("GET", "city", "Horsens");
        String json = request.CallTier3();
        ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList(gson.fromJson(json, Customer[].class)));
        assertNotNull(customers);
    }
    @Test
    public void callGetCustomersInCity3()
    {
        Gson gson = new Gson();
        Request request = new Request("GET", "city", "Aarhus");
        String json = request.CallTier3();
        ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList(gson.fromJson(json, Customer[].class)));
        assertNotNull(customers);

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