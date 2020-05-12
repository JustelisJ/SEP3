using Microsoft.EntityFrameworkCore.Migrations;

namespace SepTier3.Migrations
{
    public partial class V2 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "city",
                table: "Customers",
                newName: "City");

            migrationBuilder.AddColumn<int>(
                name: "Area",
                table: "Customers",
                nullable: false,
                defaultValue: 0);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Area",
                table: "Customers");

            migrationBuilder.RenameColumn(
                name: "City",
                table: "Customers",
                newName: "city");
        }
    }
}
