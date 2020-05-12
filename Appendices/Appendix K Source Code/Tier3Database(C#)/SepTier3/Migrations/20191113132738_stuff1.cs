using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace SepTier3.Migrations
{
    public partial class stuff1 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Customers",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    FirstName = table.Column<string>(nullable: false),
                    LastName = table.Column<string>(nullable: false),
                    IDNO = table.Column<string>(nullable: false),
                    IDNONr = table.Column<string>(nullable: false),
                    IdReleaseDate = table.Column<DateTime>(nullable: false),
                    city = table.Column<string>(nullable: false),
                    Address = table.Column<string>(nullable: false),
                    AddressNr = table.Column<int>(nullable: false),
                    AddressBlock = table.Column<string>(nullable: false),
                    AppartmentNr = table.Column<int>(nullable: false),
                    HomeNr = table.Column<string>(nullable: true),
                    PhoneNr = table.Column<string>(nullable: false),
                    StartingDate = table.Column<DateTime>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Customers", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Employees",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    FirstName = table.Column<string>(maxLength: 50, nullable: false),
                    LastName = table.Column<string>(maxLength: 50, nullable: false),
                    BirthDay = table.Column<DateTime>(nullable: false),
                    Address = table.Column<string>(nullable: false),
                    AddressNr = table.Column<int>(nullable: false),
                    AddressBlock = table.Column<string>(nullable: false),
                    AppartmentNr = table.Column<int>(nullable: false),
                    IDNO = table.Column<string>(nullable: false),
                    IDNONr = table.Column<string>(nullable: false),
                    IdReleaseDate = table.Column<DateTime>(nullable: false),
                    Gender = table.Column<string>(nullable: false),
                    PhoneNr = table.Column<string>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Employees", x => x.Id);
                });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Customers");

            migrationBuilder.DropTable(
                name: "Employees");
        }
    }
}
