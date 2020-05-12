using SepTier3.Data.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace SepTier3.Data
{
    public static class DataInitializer
    {
        public static void Initialize(EmployeeContext context)
        {
            context.Database.EnsureCreated();

            if(!context.Employees.Any())
            {
                IniEmployees(context);
            }

            if(!context.Customers.Any())
            {
                IniCustomers(context);
            }

            if (!context.Contracts.Any())
            {
                IniContracts(context);
            }

            if(!context.Invoices.Any())
            {
                IniInvoices(context);
            }

            if (!context.Bins.Any())
            {
                IniBins(context);
            }

            if (!context.Trashes.Any())
            {
                IniTrash(context);
            }
        }

        private static void IniEmployees(EmployeeContext context)
        {
            var employees = new Employee[]
            {
                new Employee {FirstName = "Dima", LastName = "Bors", BirthDay = new DateTime(1998, 4, 1), Address = "Aarhus. Yes", AddressNr = 11, IDNO = "0000000001", IDNONr = "1",
                    IdReleaseDate = new DateTime(2017, 05, 27), Gender = 'M', PhoneNr = "82759437", JobTitle = "Administrator", Password = GetHashString("123")},
                new Employee {FirstName = "Nicoleta", LastName = "Sova", BirthDay = new DateTime(1999, 7, 13), Address = "Place", AddressNr = 5, AddressBlock = 'D', AppartmentNr = 201,
                    IDNO = "0000000002", IDNONr = "2", IdReleaseDate = new DateTime(2017, 01, 27), Gender = 'F', PhoneNr = "82649102", JobTitle = "Cashier", Password = GetHashString("asd")},
                new Employee {FirstName = "Sabin", LastName = "Sirbu", BirthDay = new DateTime(1999, 5, 27), Address = "Place #2", AddressNr = 1, IDNO = "0000000003", IDNONr = "3",
                    IdReleaseDate = new DateTime(2016, 05, 27), Gender = 'M', PhoneNr = "94628411", JobTitle = "Accountant", Password = GetHashString("qwe")},
                new Employee {FirstName = "Justinas", LastName = "Jancys", BirthDay = new DateTime(1999, 11, 13), Address = "Shithole", AddressNr = 22, IDNO = "0000000004", IDNONr = "4",
                    IdReleaseDate = new DateTime(2019, 7, 13), Gender = 'M', PhoneNr = "74461022", JobTitle = "Driver", Password = GetHashString("ass")},
            };

            foreach(Employee e in employees)
            {
                context.Add(e);
            }
            context.SaveChanges();
        }

        private static void IniCustomers(EmployeeContext context)
        {
            var customers = new Customer[]
            {
                new Customer {FirstName = "FirstName", LastName = "LastName", IDNO = "0000001111", IDNONr = "0000001111", IdReleaseDate = new DateTime(2011, 1, 1), City = "Horsens", Area = 1,
                    Address = "street", AddressNr = 15, PhoneNr = "27461047", StartingDate = DateTime.Today, type = "Company", Password = GetHashString("aaaa")},
                new Customer {FirstName = "Jurry", LastName = "Tarded", IDNO = "0000001234", IDNONr = "0000001234", IdReleaseDate = new DateTime(2016, 1, 1), City = "Horsens", Area = 3,
                    Address = "Place", AddressNr = 1, HomeNr = "420420420", PhoneNr = "74536201", StartingDate = new DateTime(2019, 12, 19), type = "HomeOwner", Password = GetHashString("asdasd")}
            };

            foreach (Customer c in customers)
            {
                context.Add(c);
            }
            context.SaveChanges();
        }

        private static void IniContracts(EmployeeContext context)
        {
            var contracts = new Contract[]
            {
                new Contract {CustomerId = 1, EmployeeId = 1, file = "asdasd"},
                new Contract {CustomerId = 2, EmployeeId = 2, file = "00000002"}
            };
            foreach (Contract c in contracts)
            {
                context.Add(c);
            }
            context.SaveChanges();
        }

        private static void IniInvoices(EmployeeContext context)
        {
            var invoices = new Invoice[]
            {
                new Invoice {CustomerId = 1, MonthPayDec = 50, MonthPaidDec = 50, WhenPaidDec = DateTime.Today, Year = 2019},
                new Invoice {CustomerId = 2, MonthPayDec = 100, MonthPaidDec = 80, Year = 2019}
            };
            foreach (Invoice i in invoices)
            {
                context.Add(i);
            }
            context.SaveChanges();
        }

        private static void IniBins(EmployeeContext context)
        {
            var bins = new Bin[]
            {
                new Bin{EmployeeId = 4, CustomerId = 1, BinType = "Paper", Amount = 2},
                new Bin{EmployeeId = 4, CustomerId = 1, BinType = "Glass", Amount = 1},
                new Bin{EmployeeId = 4, CustomerId = 1, BinType = "Burn", Amount = 1},
                new Bin{EmployeeId = 4, CustomerId = 2, BinType = "Glass", Amount = 1}
            };
            foreach(Bin b in bins)
            {
                context.Add(b);
            }
            context.SaveChanges();
        }

        private static void IniTrash(EmployeeContext context)
        {
            var _trash = new Trash[]
            {
                new Trash{ EmployeeId = 4, CustomerId = 1, Amount = 5, PickUpDate = new DateTime(2019, 12, 01), TrashType = "Plastic"},
                new Trash{ EmployeeId = 4, CustomerId = 2, Amount = 1, PickUpDate = new DateTime(2019, 12, 01), TrashType = "Plastic"},
                new Trash{ EmployeeId = 4, CustomerId = 1, PickUpDate = new DateTime(2020, 01, 15), TrashType = "Biological"},
                new Trash{ EmployeeId = 4, CustomerId = 2, PickUpDate = new DateTime(2020, 10, 15), TrashType = "Biological"}
            };
            foreach(Trash t in _trash)
            {
                context.Add(t);
            }
            context.SaveChanges();
        }


        public static byte[] GetHash(string inputString)
        {
            HashAlgorithm algorithm = SHA256.Create();
            return algorithm.ComputeHash(Encoding.UTF8.GetBytes(inputString));
        }

        public static string GetHashString(string inputString)
        {
            StringBuilder sb = new StringBuilder();
            foreach (byte b in GetHash(inputString))
                sb.Append(b.ToString("X2"));

            return sb.ToString();
        }
    }
}
