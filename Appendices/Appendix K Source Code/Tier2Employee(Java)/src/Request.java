import Shared.Customer;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

    String CallTier3()
    {
        final int PORT = 6666;          //Tier3 server port
        final String HOST = "127.0.0.1";
        try {
            Socket socket= new Socket(HOST, PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            if(requestType.equals("GET"))
            {
                return getMethod(in, out);
            }

            if(requestType.equals("CREATE"))
            {
                return createMethod(in, out);
            }

            if(requestType.equals("UPDATE"))
            {
                return updateMethod(in, out);
            }

            if(requestType.equals("DELETE"))
            {
                return deleteMethod(in, out);
            }

            return "Bad format";
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage() + ". Server down";
        }
    }

    private String getMethod(BufferedReader in, PrintWriter out)
    {
        //Get employees
        if(requestInformation.equals("employees"))
        {
            String req = "GET|api/Employees";
            out.println(req);
            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                return "Error while sending request. " + e.getMessage();
            }
        }
        if(requestInformation.equals("employeeId"))
        {
            String req = "GET|api/Employees/"+requestContent;
            out.println(req);
            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                return "Error while sending request. " + e.getMessage();
            }
        }
        if(requestInformation.equals("employee"))
        {
            String[] context = requestContent.split(",");
            String req = "GET|api/Employees/User?username="+context[0]+"&pass="+context[1];
            out.println(req);
            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                return "Error while sending request. " + e.getMessage();
            }
        }


        //Get customers
        if(requestInformation.equals("customers"))
        {
            String req = "GET|api/Customers";
            out.println(req);
            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                return "Error while sending request. " + e.getMessage();
            }
        }
        if(requestInformation.equals("customerId"))
        {
            String req = "GET|api/Customers/"+requestContent;
            out.println(req);
            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                return "Error while sending request. " + e.getMessage();
            }
        }
        if(requestInformation.equals("customersArea"))
        {
            //TODO filter only the customers to a specific area
            String req = "GET|api/Customers/";
            out.println(req);

            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                return "Error while sending request. " + e.getMessage();
            }
        }

        //Get invoices
        if(requestInformation.equals("invoices"))
        {
            String req = "GET|api/Invoices";
            out.println(req);
            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                return "Error while sending request. " + e.getMessage();
            }
        }
        if(requestInformation.equals("invoiceId"))
        {
            String req = "GET|api/Invoices/"+requestContent;
            out.println(req);
            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                return "Error while sending request. " + e.getMessage();
            }
        }

        //Get contracts
        if(requestInformation.equals("contracts"))
        {
            String req = "GET|api/Contracts";
            out.println(req);
            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                return "Error while sending request. " + e.getMessage();
            }
        }
        if(requestInformation.equals("contrantId"))
        {
            String req = "GET|api/Contracts/"+requestContent;
            out.println(req);
            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                return "Error while sending request. " + e.getMessage();
            }
        }

        //Get trash
        if(requestInformation.equals("trash"))
        {
            String req = "GET|api/Trashes";
            out.println(req);
            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                return "Error while sending request. " + e.getMessage();
            }
        }
        if(requestInformation.equals("trashId"))
        {
            String req = "GET|api/Trashes/"+requestContent;
            out.println(req);
            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                return "Error while sending request. " + e.getMessage();
            }
        }

        //Get bins
        if(requestInformation.equals("bins"))
        {
            String req = "GET|api/Bins";
            out.println(req);
            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                return "Error while sending request. " + e.getMessage();
            }
        }
        if(requestInformation.equals("binId"))
        {
            String req = "GET|api/Bins/"+requestContent;
            out.println(req);
            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                return "Error while sending request. " + e.getMessage();
            }
        }
        if(requestInformation.equals("login"))
        {
            String[] content = requestContent.split(",");
            String req = "GET|api/Logins?username="+content[0]+"&passHash="+content[1];
            out.println(req);
            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                return "Error while sending request. " + e.getMessage();
            }
        }
        if(requestInformation.equals("city"))
        {
            String req = "GET|api/City?city="+requestContent;
            out.println(req);
            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                return "Error while sending request. " + e.getMessage();
            }
        }
        return "Wrong format";
    }

    private String createMethod(BufferedReader in, PrintWriter out)
    {
        if(requestInformation.equals("customer"))
        {
            String req = "POST|api/Customers|"+requestContent;
            out.println(req);
            try {
                String reply = in.readLine();
                return reply;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "Wrong format";
    }

    private String updateMethod(BufferedReader in, PrintWriter out)
    {
        return "";
    }

    private String deleteMethod(BufferedReader in, PrintWriter out)
    {
        return "";
    }

}
