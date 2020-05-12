using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using SepTier3.Data;
using SepTier3.Data.Entities;

namespace SepTier3.Controllers
{
    
    [ApiController]
    public class LoginsController : ControllerBase
    {
        private readonly EmployeeContext context;

        public LoginsController(EmployeeContext context)
        {
            this.context = context;
        }

        // GET: api/Login
        [Route("api/[controller]")]
        [HttpGet]
        public async Task<ActionResult<bool>> IsLoggedIn([FromQuery]string username, [FromQuery]string passHash)
        {
            foreach(Employee e in context.Employees)
            {
                string name = e.FirstName.Substring(0, 3) + e.LastName.Substring(0, 3);
                if(e.Password.Equals(passHash) && name.Equals(username))
                {
                    return true;
                }
            }

            foreach (Customer c in context.Customers)
            {
                string name = c.FirstName.Substring(0, 3) + c.LastName.Substring(0, 3);
                if (c.Password.Equals(passHash) && name.Equals(username))
                {
                    return true;
                }
            }
            return false;
        }

        [Route("api/Employees/User")]
        [HttpGet]
        public async Task<IQueryable<Employee>> GetEmployee([FromQuery] string username, [FromQuery] string pass)
        {
            var employee = context.Employees.Where(e => username.Equals(e.FirstName.Substring(0, 3) + e.LastName.Substring(0, 3)) && pass.Equals(e.Password));

            if (employee == null)
            {
                return null;
            }

            return employee;
        }
        // GET: api/City
        [Route("api/City")]
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Customer>>> GetCustomers([FromQuery]string city)
        {
            return context.Customers.Where(c => c.City.Equals(city)).ToList();
        }
    }
}