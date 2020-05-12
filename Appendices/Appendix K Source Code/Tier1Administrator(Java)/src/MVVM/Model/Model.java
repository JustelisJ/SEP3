package MVVM.Model;

import shared.Company;
import shared.Customer;
import shared.Employee;
import shared.Schedule;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public interface Model {


    //company

    ArrayList<Company> getCompanies();

    void addCompany(Company company);

    Company getCompany(int CompanuNumber);

    void deleteCompany(int CompanyNumber);

    void editCompany(int CompanyNumber);

    int convertStringToInt( String s);



//customer
    ArrayList<Customer> getCustomers();

    Customer getCustomer(int id);

    int getCustomersSize();

    String createCustomer(Customer customer);

    void editCustomer(int id);

    void deleteCustomer(int id);

    int converStringToInt(String s);


    //login
    String login( String username, String password);


    //viewModel

    ArrayList<Schedule> getSchedule();

    void addNewSchedule(Schedule schedule);

    void editSchedule(int shiftId);
    void deleteSchedule(int shiftId);

    //EmployeeView
        Employee getEmployee(int id);
        List<Employee>getEmployees();

        void createEmployee(Employee employee);

        void editCustomer(int id, Customer customer);
        void editEmployee(int id, Employee employee);

        void deleteEmployee(int id);

        void addListener(String eventName, PropertyChangeListener listener);

    }



