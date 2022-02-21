package tools;

import daos.EmployeeDAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Employee;

public class EmployeeCRUD implements CRUD {

    DbConnection connection = new DbConnection();
    EmployeeDAO edao = new EmployeeDAO(connection.getConncetion());
    Scanner scan = new Scanner(System.in);
    List<String> employeeListsStr = new ArrayList<>();
    List<Integer> employeeListsInt = new ArrayList<>();
    
     public void ListOfEmployees(){
        edao.getAll().forEach((i) -> employeeListsStr.add(i.getEmail() + i.getPhoneNumber()));
        edao.getAll().forEach((i) -> employeeListsInt.add(i.getEmployeeId())); 
     }

    @Override
    public void show() {
       System.out.println("id -- first_name -- last_name --  email -- phone_number - hire_date -- job -- salary -- comission_pct -- manager -- department");
       for (Employee employee : edao.getAll()) {
           System.out.println(employee.getEmployeeId() + " -- " + employee.getFirstName() + " -- " + employee.getLastName() + " -- "
           + employee.getEmail() + " -- " + employee.getPhoneNumber() + " -- " + employee.getHireDate() + " -- "
           + employee.getJobTitle() + " -- " + employee.getSalary() + " -- "+ employee.getCommissionPCT() + " -- "
           + employee.getCommissionPCT() + " -- " + employee.getManagerId() + " -- " + employee.getDepartmentId());;
       }
    }

    @Override
    public void insert() {
        System.out.print("Insert Employee ID: ");
        int employeeId_Insert = scan.nextInt();
        scan.nextLine();
        System.out.print("Insert first name: ");
        String firstName_Insert = scan.nextLine();
        System.out.print("Insert last name: ");
        String lastName_Insert = scan.nextLine();
        System.out.print("Insert emai: ");
        String email_Insert = scan.nextLine();
        System.out.print("Insert phone number: ");
        String phoneNumber_Insert = scan.nextLine();
        System.out.print("Insert hire date(yyyy-MM-dd): ");
        String hireDate_Insert = scan.nextLine();
        Date hireDateSQLFormat = Date.valueOf(hireDate_Insert);
        System.out.print("Insert Job ID: ");
        String jobTitle_Insert = scan.nextLine();
        System.out.print("Insert salary: ");
        double salary_Insert = scan.nextDouble();
        scan.nextLine();
        System.out.print("Insert commissionPCT: ");
        double commissionPCT_Insert = scan.nextDouble();
        scan.nextLine();
        System.out.print("Insert manager ID: ");
        int managerId_Insert = scan.nextInt();
        scan.nextLine();
        System.out.print("Insert Department ID: ");
        int departmentId_Insert = scan.nextInt();
        scan.nextLine();

        ListOfEmployees();
        boolean validasiStrEmail = employeeListsStr.stream().anyMatch(email_Insert::contains);
        boolean validasiStrPhone = employeeListsStr.stream().anyMatch(phoneNumber_Insert::contains);
        boolean validasiIntEmpId = employeeListsInt.stream().anyMatch(n -> (n == employeeId_Insert));
       
        if (validasiStrEmail == false && validasiStrPhone == false && validasiIntEmpId == false) {
            Employee employeeInsert = new Employee(employeeId_Insert, firstName_Insert, lastName_Insert,
                    email_Insert, phoneNumber_Insert, hireDateSQLFormat, jobTitle_Insert, salary_Insert,
                    commissionPCT_Insert, managerId_Insert, departmentId_Insert);
            edao.insert(employeeInsert);
        } else {
            System.out.println("Employee ID, Email, or Phone Number already exists in the database");
        }
    }

    @Override
    public void update() {
        System.out.print("Job ID: ");
        int employeeId_Update = scan.nextInt();
        scan.nextLine();

        ListOfEmployees();
        boolean validasiEmployeeID = employeeListsInt.stream().anyMatch(n -> ((int) n == employeeId_Update));

        if (validasiEmployeeID == true) {
            System.out.println("Current data:\n" + edao.getById(employeeId_Update));
            System.out.print("New Email: ");
            String email_Update = scan.nextLine();
            System.out.print("New Phone Number: ");
            String phoneNumber_Update = scan.nextLine();
            System.out.print("New Salary: ");
            double salary_Update = scan.nextDouble();
            scan.nextLine();
            System.out.print("New Comission PCT: ");
            double comissionPCT_Update = scan.nextDouble();
            scan.nextLine();

            Employee updateEmployee = new Employee(employeeId_Update,
                    edao.getById(employeeId_Update).getFirstName(), edao.getById(employeeId_Update).getLastName(),
                    email_Update, phoneNumber_Update, edao.getById(employeeId_Update).getHireDate(),
                    edao.getById(employeeId_Update).getJobTitle(), salary_Update, comissionPCT_Update,
                    edao.getById(employeeId_Update).getManagerId(), edao.getById(employeeId_Update).getDepartmentId());
            edao.update(employeeId_Update, updateEmployee);

        } else {
            System.out.println("Data do not exists in the database");
        }
    }

    @Override
    public void delete() {
        System.out.print("Select Employee ID: ");
        int employeeId_Delete = scan.nextInt();
        scan.nextLine();

        ListOfEmployees();
        boolean validasiDelete = employeeListsInt.stream().anyMatch(n -> (n == employeeId_Delete));

        if (validasiDelete == true) {
            System.out.println("Target data to delete:\n" + edao.getById(employeeId_Delete));
            System.out.print("Type job_id again to delete: ");
            int confirmDelete = scan.nextInt();
            scan.nextLine();
            edao.delete(confirmDelete);
            System.out.println("the data successfully deleted");
        } else {
            System.out.println("the data is not exist in the database");
        }
    }       
    
}
