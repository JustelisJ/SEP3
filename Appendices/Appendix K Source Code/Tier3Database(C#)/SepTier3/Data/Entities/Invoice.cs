using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace SepTier3.Data.Entities
{
    public class Invoice
    {
        [Key]
        public int Id { get; set; }
        [Required]
        public int Year { get; set; }

        [ForeignKey("Customer")]
        public int CustomerId { get; set; }
        public virtual Customer Customer { get; set; }

        public int MonthPayJan { get; set; }
        public int MonthPayFeb { get; set; }
        public int MonthPayMar { get; set; }
        public int MonthPayApr { get; set; }
        public int MonthPayMay { get; set; }
        public int MonthPayJun { get; set; }
        public int MonthPayJul { get; set; }
        public int MonthPayAug { get; set; }
        public int MonthPaySep { get; set; }
        public int MonthPayOct { get; set; }
        public int MonthPayNov { get; set; }
        public int MonthPayDec { get; set; }

        public int MonthPaidJan { get; set; }
        public int MonthPaidFeb { get; set; }
        public int MonthPaidMar { get; set; }
        public int MonthPaidApr { get; set; }
        public int MonthPaidMay { get; set; }
        public int MonthPaidJun { get; set; }
        public int MonthPaidJul { get; set; }
        public int MonthPaidAug { get; set; }
        public int MonthPaidSep { get; set; }
        public int MonthPaidOct { get; set; }
        public int MonthPaidNov { get; set; }
        public int MonthPaidDec { get; set; }

        public DateTime WhenPaidJan { get; set; }
        public DateTime WhenPaidFeb { get; set; }
        public DateTime WhenPaidMar { get; set; }
        public DateTime WhenPaidApr { get; set; }
        public DateTime WhenPaidMay { get; set; }
        public DateTime WhenPaidJun { get; set; }
        public DateTime WhenPaidJul { get; set; }
        public DateTime WhenPaidAug { get; set; }
        public DateTime WhenPaidSep { get; set; }
        public DateTime WhenPaidOct { get; set; }
        public DateTime WhenPaidNov { get; set; }
        public DateTime WhenPaidDec { get; set; }
    }
}
