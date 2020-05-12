using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace SepTier3.Data.Entities
{
    public class Customer
    {
        [Key]
        public int Id { get; set; }
        [Required]
        [StringLength(50, MinimumLength = 3)]
        [RegularExpression(@"[a-zA-Z""'\s-]*$")]
        public string FirstName { get; set; }
        [Required]
        [StringLength(50, MinimumLength = 3)]
        [RegularExpression(@"[a-zA-Z""'\s-]*$")]
        public string LastName { get; set; }
        [Required]
        public string IDNO { get; set; }
        [Required]
        public string IDNONr { get; set; }
        [Required]
        [DataType(DataType.Date)]
        public DateTime IdReleaseDate { get; set; }
        [Required]
        public string City { get; set; }
        [Required]
        public int Area { get; set; }
        [Required]
        public string Address { get; set; }
        [Required]
        public int AddressNr { get; set; }
        public char AddressBlock { get; set; } = ' ';
        public int AppartmentNr { get; set; }
        public string HomeNr { get; set; }
        [Required]
        public string PhoneNr { get; set; }
        [Required]
        public DateTime StartingDate { get; set; }
        [Required]
        public string type { get; set; }
        [Required]
        public string Password { get; set; }
    }
}
