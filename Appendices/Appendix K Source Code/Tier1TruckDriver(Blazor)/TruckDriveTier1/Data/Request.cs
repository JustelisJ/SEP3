using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace TruckDriveTier1.Data
{
    public class Request
    {
        public string requestType { get; set; }         //GET, CREATE, UPDATE, DELETE
        public string requestInformation { get; set; }  //Employees, Customers, Invoices, ect.
        public string requestContent { get; set; }      //all, specific id, specific area
    }
}
