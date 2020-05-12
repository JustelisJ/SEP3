package shared;

public class Request {
    private String requestType;         //GET, CREATE, UPDATE, DELETE
    private String requestInformation;  //Employees, Customers, Invoices, ect.
    private String requestContent;      //all, specific id, specific area

    public Request(String type, String info, String content)
    {
        requestType = type;
        requestInformation = info;
        requestContent = content;
    }
}
