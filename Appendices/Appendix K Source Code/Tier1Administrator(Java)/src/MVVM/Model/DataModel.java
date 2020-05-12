package MVVM.Model;

import MVVM.Model.Networking.ConnectionInterface;
import MVVM.Model.Networking.ServerConnection;
import com.google.gson.Gson;
import shared.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataModel implements Model {
    //company
    public ArrayList<Company> companies;
    public ArrayList<Customer> customers;
    public ArrayList<Schedule> schedules;
    public ArrayList<Employee> employees;
    private PropertyChangeSupport changeSupport;
    private ConnectionInterface serverConnection;
    private Gson gson;

    public DataModel() {
        companies = new ArrayList<Company>();
        customers = new ArrayList<Customer>();
        schedules = new ArrayList<Schedule>();
        employees = new ArrayList<Employee>();

        changeSupport = new PropertyChangeSupport(this);
        serverConnection = new ServerConnection();
        gson = new Gson();
    }


    @Override
    public ArrayList<Company> getCompanies() {
        return companies;
    }

    @Override
    public void addCompany(Company company) {
        companies.add(company);
        System.out.println(" Company Added ");
    }

    @Override
    public Company getCompany(int CompanyNumber) {
        return companies.get(CompanyNumber);
    }

    @Override
    public void deleteCompany(int CompanyNumber) {
        companies.remove(CompanyNumber);

    }

    @Override
    public void editCompany(int CompanyNumber) {
        companies.get(CompanyNumber);


    }

    @Override
    public int convertStringToInt(String s) {
        return Integer.parseInt(s);
    }

    //customer


    @Override
    public ArrayList<Customer> getCustomers() {
        Request request = new Request("GET", "customers", "all");
        String jsonResponse = serverConnection.Send(request);
        customers = new ArrayList<Customer>(Arrays.asList(gson.fromJson(jsonResponse, Customer[].class)));
        return customers;
    }

    @Override
    public Customer getCustomer(int id) {
        return customers.get(id);
    }

    @Override
    public int getCustomersSize() {
        return customers.size();
    }

    @Override
    public String createCustomer(Customer customer) {
        String json = gson.toJson(customer);
        System.out.println("Added");
        Request request = new Request("CREATE", "customer", json);
        String result = serverConnection.Send(request);
        try
        {
            Customer c = gson.fromJson(result, Customer.class);
            customers.add(c);
            changeSupport.firePropertyChange("CustomerAdded",null,c);
            return "Customer created";
        }
        catch (Exception e)
        {
            return "Customer not created";
        }
    }

    @Override
    public void editCustomer(int id) {
        customers.get(id);

    }

    @Override
    public void deleteCustomer(int id) {
        customers.remove(id);
    }

    @Override
    public int converStringToInt(String s) {
        return Integer.parseInt(s);
    }


    //login

    @Override
    public String login(String username, String password) {
        Request request = new Request("GET", "login", username + "," + bytesToHex(password));
        String response = serverConnection.Send(request);
        if(response.equals("true"))
        {
            Request request1 = new Request("GET", "employee", username + "," + bytesToHex(password));
            String response1 = serverConnection.Send(request1);
            response1 = response1.substring(1, response1.length() - 1);
            Employee emp = gson.fromJson(response1, Employee.class);
            if(emp.getJobTitle().equals("Administrator"))
            {
                return "";
            }
            else
            {
                return "Not implemented for other users yet. Just administrator";
            }
        }
        if (response.equals("false"))
        {
            return "Incorrect username or password";
        }
        else
            return "Servers are down";
    }
    //workschedule

    @Override
    public ArrayList<Schedule> getSchedule() {
        return schedules;
    }

    @Override
    public void addNewSchedule(Schedule schedule) {
        schedules.add(schedule);
        System.out.println("added schedule");
    }

    @Override
    public void editSchedule(int shiftId) {
        schedules.get(shiftId);
    }

    @Override
    public void deleteSchedule(int shiftId) {
        schedules.remove(shiftId);

    }

    @Override
    public Employee getEmployee(int id) {
        return employees.get(id);

    }
    @Override
    public List<Employee> getEmployees() {
        return employees;
    }
    @Override
    public void createEmployee(Employee employee) {
        employees.add(employee);
        changeSupport.firePropertyChange("EmployeeView added",null,employee);
        System.out.println("EmployeeView created succesfully");

    }

    @Override
    public void editCustomer(int id, Customer customer) {
        customers.set(id, customer);

    }

    @Override
    public void editEmployee(int id, Employee employee) {
        employees.set(id,employee);

    }
    @Override
    public void deleteEmployee(int id) {
        employees.remove(id);

    }
    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(eventName, listener);
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