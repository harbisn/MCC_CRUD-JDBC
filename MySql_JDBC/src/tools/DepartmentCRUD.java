package tools;

import daos.DepartmentDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Department;

public class DepartmentCRUD implements CRUD {

    DbConnection connection = new DbConnection();
    DepartmentDAO ddao = new DepartmentDAO(connection.getConncetion());
    Scanner scan = new Scanner(System.in);
    List<String> departmentListsStr = new ArrayList<>();
    List<Integer> departmentListsInt = new ArrayList<>();

    public void ListOfDepartments() {
        ddao.getAll().forEach((i) -> departmentListsStr.add(i.getDepartmentName()));
        ddao.getAll().forEach((i) -> departmentListsInt.add(i.getDepartmenId()));
    }
     
    @Override
    public void show() {
       System.out.println("Department ID -- Department Name -- manager ID -- location ID");
       for (Department department : ddao.getAll()) {
           System.out.println(department.getDepartmenId() + " -- " + department.getDepartmentName() + " -- "
           + department.getManagerId() + " -- " + department.getLocationId());
       }
    }

    @Override
    public void insert() {
        System.out.print("Insert new ID: ");
        int departmentId_Insert = scan.nextInt();
        scan.nextLine();
        System.out.print("Insert new Department Name: ");
        String departmentname_Insert = scan.nextLine();
        System.out.print("Insert new Manager ID: ");
        int managerId_Insert = scan.nextInt();
        scan.nextLine();
        System.out.print("Insert new Location ID: ");
        int locationId_Insert = scan.nextInt();
        scan.nextLine();

        ListOfDepartments();
        boolean validasiInsert_DN = departmentListsStr.stream().anyMatch(departmentname_Insert::contains);
        boolean validasiInsert_Did = departmentListsInt.stream().anyMatch(n -> (n == departmentId_Insert));

        if (validasiInsert_Did == false) {
            if (validasiInsert_DN == false && validasiInsert_Did == false) {
                Department departmentInsert = new Department(departmentId_Insert, departmentname_Insert,
                        managerId_Insert, locationId_Insert);
                ddao.insert(departmentInsert);
                System.out.println("a new Department successfully inserted");
            } else if (validasiInsert_DN == true && validasiInsert_Did == false) {
                System.out.println("Department Name already exists in the data base. Insert data is fail");
            } else if (validasiInsert_DN == false && validasiInsert_Did == true) {
                System.out.println("Department ID already exists in the data base. Insert data is fail");
            } else if (validasiInsert_DN == true && validasiInsert_Did == true) {
                System.out.println("Both Department Name and Department ID already exists in the data base. Insert data is fail");
            }
        } else {
            System.out.println("Department with ID of " + departmentId_Insert + " already exists in the database. Insert data is fail.");
        }
    }

    @Override
    public void update() {
        System.out.print("Department ID: ");
        int departmentId_Update = scan.nextInt();
        scan.nextLine();
        System.out.println("Current data:\n" + ddao.getById(departmentId_Update));
        System.out.print("new Department Name: ");
        String departmentName_Update = scan.nextLine();
        System.out.print("Insert Manager ID: ");
        int managerId_Update = scan.nextInt();
        scan.nextLine();
        System.out.print("Insert Location ID: ");
        int locationId_Update = scan.nextInt();
        scan.nextLine();

        ListOfDepartments();
        boolean validasiUpdate_DN = departmentListsStr.stream().anyMatch(departmentName_Update::contains);

        if (validasiUpdate_DN == false || departmentName_Update.equals(ddao.getById(departmentId_Update).getDepartmentName())) {
            Department updateDepartment = new Department(departmentId_Update, departmentName_Update,
                    managerId_Update, locationId_Update);
            ddao.update(departmentId_Update, updateDepartment);
        } else {
            System.out.println("Department already exists in the database");
        }
    }

    @Override
    public void delete() {
        System.out.print("Select department ID: ");
        int departmentId_Delete = scan.nextInt();
        scan.nextLine();
        System.out.println("Target data to delete:\n" + ddao.getById(departmentId_Delete));
        System.out.print("Type department name to delete: ");
        String departmenName_Delete = scan.nextLine();

        ListOfDepartments();
        boolean validasiDelete_N = departmentListsStr.stream().anyMatch(departmenName_Delete::contains);

        if (validasiDelete_N == true) {
            ddao.delete(departmentId_Delete);
            System.out.println("the data successfully deleted");
        } else {
            System.out.println("the data is not exist in the database");
        }
    }    
}
