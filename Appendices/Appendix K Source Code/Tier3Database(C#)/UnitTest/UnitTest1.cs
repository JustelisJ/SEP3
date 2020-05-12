using Microsoft.VisualStudio.TestTools.UnitTesting;
using Newtonsoft.Json;
using SepTier3.Data.Entities;
using System;
using System.Net.Http;
using System.Security.Cryptography;
using System.Text;

namespace UnitTest
{
    [TestClass]
    public class UnitTest1
    {
        private HttpClient client = new HttpClient();

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

        [TestMethod]
        public void TestGetEmployee()
        {
            Employee employee = new Employee
            {
                FirstName = "Dima",
                LastName = "Bors",
                BirthDay = new DateTime(1998, 4, 1),
                Address = "Aarhus. Yes",
                AddressNr = 11,
                IDNO = "0000000001",
                IDNONr = "1",
                IdReleaseDate = new DateTime(2017, 05, 27),
                Gender = 'M',
                PhoneNr = "82759437",
                JobTitle = "Administrator",
                Password = GetHashString("123")
            };
            string employeeJson = JsonConvert.SerializeObject(employee);
            string uri = "https://localhost:44397/api/Employee/1";
            HttpResponseMessage response = client.GetAsync(uri).Result;
            response.EnsureSuccessStatusCode();
            string responseBody = response.Content.ReadAsStringAsync().Result;
            Assert.AreEqual(employeeJson, responseBody);
        }
        [TestMethod]
        public void TestPushEmployee()
        {
        }
        [TestMethod]
        public void TestPutEmployee()
        {

        }
        [TestMethod]
        public void TestDeleteEmployee()
        {
        }

        [TestMethod]
        public void TestGetCustomer()
        {
        }
        [TestMethod]
        public void TestPushCustomer()
        {
        }
        [TestMethod]
        public void TestPutCustomer()
        {
        }
        [TestMethod]
        public void TestDeleteCustomer()
        {
        }

        [TestMethod]
        public void TestGetBin()
        {
        }
        [TestMethod]
        public void TestPushBin()
        {
        }
        [TestMethod]
        public void TestPutBin()
        {
        }
        [TestMethod]
        public void TestDeleteBin()
        {
        }

        [TestMethod]
        public void TestGetContracts()
        {
        }
        [TestMethod]
        public void TestPushContracts()
        {
        }
        [TestMethod]
        public void TestPutContracts()
        {
        }
        [TestMethod]
        public void TestDeleteContracts()
        {
        }

        [TestMethod]
        public void TestGetInvoice()
        {
        }
        [TestMethod]
        public void TestPushInvoice()
        {
        }
        [TestMethod]
        public void TestPutInvoice()
        {
        }
        [TestMethod]
        public void TestDeleteInvoice()
        {
        }

        [TestMethod]
        public void TestGetTrash()
        {
        }
        [TestMethod]
        public void TestPushTrash()
        {
        }
        [TestMethod]
        public void TestPutTrash()
        {
        }
        [TestMethod]
        public void TestDeleteTrash()
        {
        }

        [TestMethod]
        public void TestLogin()
        {
        }
    }
}
