using API.Models;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Headers;
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

        public static int getLastCustomerInDatabase()
        {
            HttpClient client = new HttpClient();
            int id = 0;
            string uri = "https://localhost:44397/api/Customers";
            HttpResponseMessage response = client.GetAsync(uri).Result;
            string responseBody = response.Content.ReadAsStringAsync().Result;
            List<Customer> customers = JsonConvert.DeserializeObject<List<Customer>>(responseBody);
            foreach(Customer c in customers)
            {
                if(id < c.Id && (c.FirstName.Equals("test") || c.FirstName.Equals("testTest")))
                {
                    id = c.Id;
                }
            }
            return id;
        }

        [TestMethod]
        public void Test1GetCustomer()
        {
            Customer customer = new Customer
            {
                Id = 1,
                FirstName = "Jurry",
                LastName = "Tarded",
                IDNO = "0000001234",
                IDNONr = "0000001234",
                IdReleaseDate = new DateTime(2016, 1, 1),
                City = "Horsens",
                Area = 3,
                Address = "Place",
                AddressNr = 1,
                AddressBlock = ' ',
                AppartmentNr = 0,
                HomeNr = "420420420",
                PhoneNr = "74536201",
                StartingDate = new DateTime(2019, 12, 19),
                type = "HomeOwner",
                Password = GetHashString("asdasd")
            };
            string uri = "https://localhost:44397/api/Customers/1";
            HttpResponseMessage response = client.GetAsync(uri).Result;
            response.EnsureSuccessStatusCode();
            string responseBody = response.Content.ReadAsStringAsync().Result;
            Customer gotCustomer = JsonConvert.DeserializeObject<Customer>(responseBody);
            Assert.AreEqual(customer, gotCustomer);
        }
        [TestMethod]
        public void Test2PostCustomer()
        {
            Customer customer = new Customer
            {
                FirstName = "test",
                LastName = "test",
                IDNO = "123",
                IDNONr = "123",
                IdReleaseDate = new DateTime(2016, 1, 1),
                City = "Horsens",
                Area = 3,
                Address = "Place",
                AddressNr = 1,
                AddressBlock = 'T',
                AppartmentNr = 123,
                HomeNr = "123",
                PhoneNr = "123",
                StartingDate = new DateTime(2019, 12, 19),
                type = "HomeOwner",
                Password = GetHashString("test")
            };
            string customerJson = JsonConvert.SerializeObject(customer);
            string uri = "https://localhost:44397/api/Customers";
            client.BaseAddress = new Uri(uri);
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));//ACCEPT header
            HttpRequestMessage request1 = new HttpRequestMessage(HttpMethod.Post, "Customers");
            request1.Content = new StringContent(JsonConvert.SerializeObject(customer),
                                                Encoding.UTF8,
                                                "application/json");//CONTENT-TYPE header
            HttpResponseMessage response = client.SendAsync(request1).Result;
            Customer responceCustomer = JsonConvert.DeserializeObject<Customer>(response.Content.ReadAsStringAsync().Result);
            Assert.AreEqual(customer, responceCustomer);
        }
        [TestMethod]
        public void Test3PutCustomer()
        {
            int id = getLastCustomerInDatabase();
            Customer customer = new Customer
            {
                Id = id,
                FirstName = "testTest",
                LastName = "test",
                IDNO = "123",
                IDNONr = "123",
                IdReleaseDate = new DateTime(2016, 1, 1),
                City = "Horsens",
                Area = 3,
                Address = "Place",
                AddressNr = 1,
                AddressBlock = 'T',
                AppartmentNr = 123,
                HomeNr = "123",
                PhoneNr = "123",
                StartingDate = new DateTime(2019, 12, 19),
                type = "HomeOwner",
                Password = GetHashString("test")
            };
            string uri = "https://localhost:44397/api/Customers";
            client.BaseAddress = new Uri(uri);
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));//ACCEPT header
            HttpRequestMessage request1 = new HttpRequestMessage(HttpMethod.Put, "Customers/"+id);
            request1.Content = new StringContent(JsonConvert.SerializeObject(customer),
                                                Encoding.UTF8,
                                                "application/json");//CONTENT-TYPE header
            HttpResponseMessage response = client.SendAsync(request1).Result;
            Assert.IsTrue(response.IsSuccessStatusCode);
        }
        [TestMethod]
        public void Test4DeleteCustomer()
        {
            int id = getLastCustomerInDatabase();
            Customer customer = new Customer
            {
                Id = id,
                FirstName = "testTest",
                LastName = "test",
                IDNO = "123",
                IDNONr = "123",
                IdReleaseDate = new DateTime(2016, 1, 1),
                City = "Horsens",
                Area = 3,
                Address = "Place",
                AddressNr = 1,
                AddressBlock = 'T',
                AppartmentNr = 123,
                HomeNr = "123",
                PhoneNr = "123",
                StartingDate = new DateTime(2019, 12, 19),
                type = "HomeOwner",
                Password = GetHashString("test")
            };
            string uri = "https://localhost:44397/api/Customers";
            client.BaseAddress = new Uri(uri);
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));//ACCEPT header
            HttpRequestMessage request1 = new HttpRequestMessage(HttpMethod.Delete, "Customers/" + id);
            request1.Content = new StringContent(JsonConvert.SerializeObject(customer),
                                                Encoding.UTF8,
                                                "application/json");//CONTENT-TYPE header
            HttpResponseMessage response = client.SendAsync(request1).Result;
            Customer responceCustomer = JsonConvert.DeserializeObject<Customer>(response.Content.ReadAsStringAsync().Result);
            Assert.AreEqual(customer, responceCustomer);
        }

        [TestMethod]
        public void TestLogin1()
        {
            string username = "DimBor";
            string password = GetHashString("123");
            string uri = "https://localhost:44397/api/Logins?username="+username+"&passHash="+password;
            HttpResponseMessage response = client.GetAsync(uri).Result;
            Assert.AreEqual(response.Content.ReadAsStringAsync().Result, "true");
        }
        [TestMethod]
        public void TestLogin2()
        {
            string username = "DimBor";
            string password = GetHashString("asd");
            string uri = "https://localhost:44397/api/Logins?username=" + username + "&passHash=" + password;
            HttpResponseMessage response = client.GetAsync(uri).Result;
            Assert.AreEqual(response.Content.ReadAsStringAsync().Result, "false");
        }
    }
}
