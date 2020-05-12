using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace SepTier3.Data.Entities
{
    public class Trash
    {
        [Key]
        public int Id { get; set; }
        [Required]
        [ForeignKey("Customer")]
        public int CustomerId { get; set; }
        public virtual Customer Customer { get; set; }
        [Required]
        [ForeignKey("Employee")]
        public int EmployeeId { get; set; }
        public virtual Employee Employee { get; set; }
        public int Amount { get; set; } = 0;
        [Required]
        public string TrashType { get; set; }           //Plastic, Bio, Glass or Burn
        [Required]
        public DateTime PickUpDate { get; set; }
    }
}
