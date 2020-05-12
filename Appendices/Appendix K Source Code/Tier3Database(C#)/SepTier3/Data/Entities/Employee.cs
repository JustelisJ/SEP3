using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace SepTier3.Data.Entities
{
    public class Employee
    {
        [Key]
        public int Id { get; set; }
        [Required]
        [StringLength(50, MinimumLength = 3)]
        [RegularExpression(@"^[A-Z]+[a-zA-Z""'\s-]*$")]
        public string FirstName { get; set; }
        [Required]
        [StringLength(50, MinimumLength = 3)]
        [RegularExpression(@"^[A-Z]+[a-zA-Z""'\s-]*$")]
        public string LastName { get; set; }
        [Required]
        [DataType(DataType.Date)]
        public DateTime BirthDay { get; set; }
        [Required]
        public string Address { get; set; }
        [Required]
        public int AddressNr { get; set; }
        public char AddressBlock { get; set; }
        public int AppartmentNr { get; set; }
        [Required]
        public string IDNO { get; set; }
        [Required]
        public string IDNONr { get; set; }
        [Required]
        [DataType(DataType.Date)]
        public DateTime IdReleaseDate { get; set; }
        [Required]
        public char Gender { get; set; }
        [Required]
        public string PhoneNr { get; set; }
        [Required]
        public string JobTitle { get; set; }
        [Required]
        public string Password { get; set; }
    }
}
