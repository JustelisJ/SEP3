using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace SepTier3.Migrations
{
    public partial class V5 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Logins");

            migrationBuilder.AddColumn<string>(
                name: "Password",
                table: "Employees",
                nullable: false,
                defaultValue: "");

            migrationBuilder.AddColumn<string>(
                name: "Password",
                table: "Customers",
                nullable: false,
                defaultValue: "");

            migrationBuilder.CreateTable(
                name: "Bins",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    CustomerId = table.Column<int>(nullable: false),
                    EmployeeId = table.Column<int>(nullable: false),
                    Amount = table.Column<int>(nullable: false),
                    BinType = table.Column<string>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Bins", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Bins_Customers_CustomerId",
                        column: x => x.CustomerId,
                        principalTable: "Customers",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Bins_Employees_EmployeeId",
                        column: x => x.EmployeeId,
                        principalTable: "Employees",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "Invoices",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Year = table.Column<int>(nullable: false),
                    CustomerId = table.Column<int>(nullable: false),
                    MonthPayJan = table.Column<int>(nullable: false),
                    MonthPayFeb = table.Column<int>(nullable: false),
                    MonthPayMar = table.Column<int>(nullable: false),
                    MonthPayApr = table.Column<int>(nullable: false),
                    MonthPayMay = table.Column<int>(nullable: false),
                    MonthPayJun = table.Column<int>(nullable: false),
                    MonthPayJul = table.Column<int>(nullable: false),
                    MonthPayAug = table.Column<int>(nullable: false),
                    MonthPaySep = table.Column<int>(nullable: false),
                    MonthPayOct = table.Column<int>(nullable: false),
                    MonthPayNov = table.Column<int>(nullable: false),
                    MonthPayDec = table.Column<int>(nullable: false),
                    MonthPaidJan = table.Column<int>(nullable: false),
                    MonthPaidFeb = table.Column<int>(nullable: false),
                    MonthPaidMar = table.Column<int>(nullable: false),
                    MonthPaidApr = table.Column<int>(nullable: false),
                    MonthPaidMay = table.Column<int>(nullable: false),
                    MonthPaidJun = table.Column<int>(nullable: false),
                    MonthPaidJul = table.Column<int>(nullable: false),
                    MonthPaidAug = table.Column<int>(nullable: false),
                    MonthPaidSep = table.Column<int>(nullable: false),
                    MonthPaidOct = table.Column<int>(nullable: false),
                    MonthPaidNov = table.Column<int>(nullable: false),
                    MonthPaidDec = table.Column<int>(nullable: false),
                    WhenPaidJan = table.Column<DateTime>(nullable: false),
                    WhenPaidFeb = table.Column<DateTime>(nullable: false),
                    WhenPaidMar = table.Column<DateTime>(nullable: false),
                    WhenPaidApr = table.Column<DateTime>(nullable: false),
                    WhenPaidMay = table.Column<DateTime>(nullable: false),
                    WhenPaidJun = table.Column<DateTime>(nullable: false),
                    WhenPaidJul = table.Column<DateTime>(nullable: false),
                    WhenPaidAug = table.Column<DateTime>(nullable: false),
                    WhenPaidSep = table.Column<DateTime>(nullable: false),
                    WhenPaidOct = table.Column<DateTime>(nullable: false),
                    WhenPaidNov = table.Column<DateTime>(nullable: false),
                    WhenPaidDec = table.Column<DateTime>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Invoices", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Invoices_Customers_CustomerId",
                        column: x => x.CustomerId,
                        principalTable: "Customers",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "Trashes",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    CustomerId = table.Column<int>(nullable: false),
                    EmployeeId = table.Column<int>(nullable: false),
                    Amount = table.Column<int>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Trashes", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Trashes_Customers_CustomerId",
                        column: x => x.CustomerId,
                        principalTable: "Customers",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Trashes_Employees_EmployeeId",
                        column: x => x.EmployeeId,
                        principalTable: "Employees",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Bins_CustomerId",
                table: "Bins",
                column: "CustomerId");

            migrationBuilder.CreateIndex(
                name: "IX_Bins_EmployeeId",
                table: "Bins",
                column: "EmployeeId");

            migrationBuilder.CreateIndex(
                name: "IX_Invoices_CustomerId",
                table: "Invoices",
                column: "CustomerId");

            migrationBuilder.CreateIndex(
                name: "IX_Trashes_CustomerId",
                table: "Trashes",
                column: "CustomerId");

            migrationBuilder.CreateIndex(
                name: "IX_Trashes_EmployeeId",
                table: "Trashes",
                column: "EmployeeId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Bins");

            migrationBuilder.DropTable(
                name: "Invoices");

            migrationBuilder.DropTable(
                name: "Trashes");

            migrationBuilder.DropColumn(
                name: "Password",
                table: "Employees");

            migrationBuilder.DropColumn(
                name: "Password",
                table: "Customers");

            migrationBuilder.CreateTable(
                name: "Logins",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    CustomerId = table.Column<int>(type: "int", nullable: false),
                    EmployeeId = table.Column<int>(type: "int", nullable: false),
                    Password = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Username = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Logins", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Logins_Customers_CustomerId",
                        column: x => x.CustomerId,
                        principalTable: "Customers",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Logins_Employees_EmployeeId",
                        column: x => x.EmployeeId,
                        principalTable: "Employees",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Logins_CustomerId",
                table: "Logins",
                column: "CustomerId");

            migrationBuilder.CreateIndex(
                name: "IX_Logins_EmployeeId",
                table: "Logins",
                column: "EmployeeId");
        }
    }
}
