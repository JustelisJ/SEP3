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
    public class BinsController : ControllerBase
    {
        private readonly EmployeeContext _context;

        public BinsController(EmployeeContext context)
        {
            _context = context;
        }

        // GET: api/Bins
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Bin>>> GetBins()
        {
            return await _context.Bins.ToListAsync();
        }

        // GET: api/Bins/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Bin>> GetBin(int id)
        {
            var bin = await _context.Bins.FindAsync(id);

            if (bin == null)
            {
                return NotFound();
            }

            return bin;
        }

        // PUT: api/Bins/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for
        // more details see https://aka.ms/RazorPagesCRUD.
        [HttpPut("{id}")]
        public async Task<IActionResult> PutBin(int id, Bin bin)
        {
            if (id != bin.Id)
            {
                return BadRequest();
            }

            _context.Entry(bin).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!BinExists(id))
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

        // POST: api/Bins
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for
        // more details see https://aka.ms/RazorPagesCRUD.
        [HttpPost]
        public async Task<ActionResult<Bin>> PostBin(Bin bin)
        {
            _context.Bins.Add(bin);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetBin", new { id = bin.Id }, bin);
        }

        // DELETE: api/Bins/5
        [HttpDelete("{id}")]
        public async Task<ActionResult<Bin>> DeleteBin(int id)
        {
            var bin = await _context.Bins.FindAsync(id);
            if (bin == null)
            {
                return NotFound();
            }

            _context.Bins.Remove(bin);
            await _context.SaveChangesAsync();

            return bin;
        }

        private bool BinExists(int id)
        {
            return _context.Bins.Any(e => e.Id == id);
        }
    }
}
