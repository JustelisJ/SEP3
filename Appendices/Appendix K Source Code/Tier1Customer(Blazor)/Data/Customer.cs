using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace CustomerClient.Data
{
    public class Customer
    {
        public int Id { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string IDNO { get; set; }
        public string IDNONr { get; set; }
        public DateTime IdReleaseDate { get; set; }
        public string City { get; set; }
        public int Area { get; set; }
        public string Address { get; set; }
        public int AddressNr { get; set; }
        public char AddressBlock { get; set; }
        public int AppartmentNr { get; set; }
        public string HomeNr { get; set; }
        public string PhoneNr { get; set; }
        public DateTime StartingDate { get; set; }
        public string type { get; set; }
        public string Password { get; set; }
    }
}
