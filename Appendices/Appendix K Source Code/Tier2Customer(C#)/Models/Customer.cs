using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace API.Models
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

        public override bool Equals(object obj)
        {
            if(obj is Customer)
            {
                Customer test = (Customer)obj;
                if(!FirstName.Equals(test.FirstName))
                {
                    return false;
                }
                if (!LastName.Equals(test.LastName))
                {
                    return false;
                }
                if (!IDNO.Equals(test.IDNO))
                {
                    return false;
                }
                if (!IDNONr.Equals(test.IDNONr))
                {
                    return false;
                }
                if (!IdReleaseDate.Equals(test.IdReleaseDate))
                {
                    return false;
                }
                if (!City.Equals(test.City))
                {
                    return false;
                }
                if (!Area.Equals(test.Area))
                {
                    return false;
                }
                if (!Address.Equals(test.Address))
                {
                    return false;
                }
                if (!AddressNr.Equals(test.AddressNr))
                {
                    return false;
                }
                if (!AddressBlock.Equals(test.AddressBlock))
                {
                    return false;
                }
                if (!AppartmentNr.Equals(test.AppartmentNr))
                {
                    return false;
                }
                if (!HomeNr.Equals(test.HomeNr))
                {
                    return false;
                }
                if (!PhoneNr.Equals(test.PhoneNr))
                {
                    return false;
                }
                if (!StartingDate.Equals(test.StartingDate))
                {
                    return false;
                }
                if (!type.Equals(test.type))
                {
                    return false;
                }
                if (!Password.Equals(test.Password))
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
    }
}
