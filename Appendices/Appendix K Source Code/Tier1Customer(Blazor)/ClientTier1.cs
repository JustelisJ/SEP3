using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Runtime.Serialization.Json;
using System.Threading.Tasks;
using CustomerClient.Data;
using Newtonsoft.Json;

namespace CustomerClient
{
    public class ClientTier1
    {
        static readonly HttpClient client = new HttpClient();

        public void ShowCustomer(Customer customer)
        {
            Console.WriteLine($"ID: {customer.Id}, Name: {customer.FirstName}, Paid: {customer.type}");
        }

        public async Task<Uri> CreateCustomerAsync(Customer customer)
        {
            HttpResponseMessage response = await client.PostAsJsonAsync("https://localhost:44395/api/Customers", customer);
            response.EnsureSuccessStatusCode();

            // return URI of the created resource.
            return response.Headers.Location;
        }

        public async Task<Customer> GetCustomerAsync(int id)
        {
            Customer customer = null;
            HttpResponseMessage response = await client.GetAsync($"https://localhost:44395/api/Customers/{id}");
            if (response.IsSuccessStatusCode)
            {
                customer = await response.Content.ReadAsAsync<Customer>();
            }
            return customer;
        }

        public async Task<List<Customer>> GetCustomers()
        {
            client.DefaultRequestHeaders.Accept.Clear();
            var streamTask = client.GetStringAsync("https://localhost:44395/api/Customers");
            Console.WriteLine(streamTask);
            var customers = JsonConvert.DeserializeObject<List<Customer>>(streamTask.Result);
            return customers;
        }

        public async Task<Customer> UpdateCustomerAsync(int id, Customer customer)
        {
            HttpResponseMessage response = await client.PutAsJsonAsync(
                $"https://localhost:44395/api/Customers/{id}", customer);
            response.EnsureSuccessStatusCode();

            // Deserialize the updated customer from the response body.
            customer = await response.Content.ReadAsAsync<Customer>();

            return customer;
        }

        public async Task<HttpStatusCode> DeleteCustomerAsync(int id)
        {
            HttpResponseMessage response = await client.DeleteAsync(
                $"https://localhost:44395/api/Customers/{id}");

            return response.StatusCode;
        }

        async Task RunAsync()
        {
            // Update port # in the following line.
            client.BaseAddress = new Uri("https://localhost:5003");
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(
                new MediaTypeWithQualityHeaderValue("application/json"));

            Console.WriteLine("Good connection");

            try
            {

                // Create a new customer
                Customer customer = new Customer
                {
                    FirstName = "Peter",
                    LastName = "Johnson",
                    IDNO = "790",
                    IDNONr = "790",
                    IdReleaseDate = DateTime.Today,
                    City = "Aalborg",
                    Area = 7,
                    Address = "H.C. Andersen gade",
                    AddressNr = 5,
                    PhoneNr = "72900119",
                    StartingDate = DateTime.Today,
                    type = "Company"
                };


                var url = await CreateCustomerAsync(customer);
                Console.WriteLine($"Created at {url}");

                Console.WriteLine("Successfully created a customer");

                // Get the customer
                //customer = await GetCustomerAsync(url.PathAndQuery);
                ShowCustomer(customer);

                Console.WriteLine("Successfully returned a customer");

                // Update the customer
                Console.WriteLine("Updating name...");
                customer.FirstName = "Carl";
                //await UpdateCustomerAsync(customer);

                Console.WriteLine("Successfully updated a customer");

                // Get the updated customer
                //customer = await GetCustomerAsync(url.PathAndQuery);
                ShowCustomer(customer);

                // Delete the customer
                var statusCode = await DeleteCustomerAsync(customer.Id);
                Console.WriteLine($"Deleted (HTTP Status = {(int)statusCode})");

            }
            catch (Exception e)
            {
                Console.WriteLine("Bad connection");
                Console.WriteLine(e.Message);
            }
        }
    }
}
