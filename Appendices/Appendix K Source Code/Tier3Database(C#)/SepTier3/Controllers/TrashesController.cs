using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using SepTier3.Data;
using SepTier3.Data.Entities;

namespace SepTier3.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class TrashesController : ControllerBase
    {
        private readonly EmployeeContext _context;

        public TrashesController(EmployeeContext context)
        {
            _context = context;
        }

        // GET: api/Trashes
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Trash>>> GetTrashes()
        {
            return await _context.Trashes.ToListAsync();
        }

        // GET: api/Trashes/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Trash>> GetTrash(int id)
        {
            var trash = await _context.Trashes.FindAsync(id);

            if (trash == null)
            {
                return NotFound();
            }

            return trash;
        }

        // PUT: api/Trashes/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for
        // more details see https://aka.ms/RazorPagesCRUD.
        [HttpPut("{id}")]
        public async Task<IActionResult> PutTrash(int id, Trash trash)
        {
            if (id != trash.Id)
            {
                return BadRequest();
            }

            _context.Entry(trash).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!TrashExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Trashes
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for
        // more details see https://aka.ms/RazorPagesCRUD.
        [HttpPost]
        public async Task<ActionResult<Trash>> PostTrash(Trash trash)
        {
            _context.Trashes.Add(trash);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetTrash", new { id = trash.Id }, trash);
        }

        // DELETE: api/Trashes/5
        [HttpDelete("{id}")]
        public async Task<ActionResult<Trash>> DeleteTrash(int id)
        {
            var trash = await _context.Trashes.FindAsync(id);
            if (trash == null)
            {
                return NotFound();
            }

            _context.Trashes.Remove(trash);
            await _context.SaveChangesAsync();

            return trash;
        }

        private bool TrashExists(int id)
        {
            return _context.Trashes.Any(e => e.Id == id);
        }
    }
}
