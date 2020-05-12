using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using API.Models;
using System.Net.Http;
using Newtonsoft.Json;

namespace API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CustomersController : ControllerBase
    {
        private HttpClient client;

        public CustomersController()
        {
            client = new HttpClient();
        }

        // GET: api/Customers
        [HttpGet]
        public async Task<string> GetCustomers()
        {
            return await client.GetStringAsync("https://localhost:44397/api/Customers");
        }

        // GET: api/Customers/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Customer>> GetCustomer(long id)
        {
            var customer = await client.GetStringAsync("https://localhost:44397/api/Customers/"+id);

            if (customer == null)
            {
                return NotFound();
            }
            Customer c = JsonConvert.DeserializeObject<Customer>(customer);
            return c;
        }

        // PUT: api/Customers/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for
        // more details see https://aka.ms/RazorPagesCRUD.
        [HttpPut("{id}")]
        public async Task<IActionResult> PutCustomer(long id, Customer customer)
        {
            if (id != customer.Id)
            {
                return BadRequest();
            }

            await client.PutAsJsonAsync("https://localhost:44397/api/Customers/" + id, customer);
            return Ok();
        }

        // POST: api/TodoItems
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for
        // more details see https://aka.ms/RazorPagesCRUD.
        [HttpPost]
        public async Task<ActionResult<Customer>> Post(Customer todoItem)
        {
            await client.PostAsJsonAsync("https://localhost:44397/api/Customers/", todoItem);

            //return CreatedAtAction("GetTodoItem", new { id = todoItem.Id }, todoItem);
            return CreatedAtAction(nameof(GetCustomer), new { id = todoItem.Id }, todoItem);
        }

        // DELETE: api/TodoItems/5
        [HttpDelete("{id}")]
        public async Task<ActionResult<Customer>> DeleteCustomer(long id)
        {
            var todoItem = JsonConvert.DeserializeObject<Customer>(await client.GetStringAsync("https://localhost:44397/api/Customers/" + id));
            if (todoItem == null)
            {
                return NotFound();
            }

            await client.DeleteAsync("https://localhost:44397/api/Customers/" + id);

            return todoItem;
        }
    }
}
