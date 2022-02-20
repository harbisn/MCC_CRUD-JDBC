package tools;

import daos.JobDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Job;

public class JobCRUD implements CRUD {
    
    DbConnection connection = new DbConnection();
    JobDAO jdao = new JobDAO(connection.getConncetion());
    Scanner scan = new Scanner(System.in);
    List<String> jobLists = new ArrayList<>();

    public void ListOfJobs() {
        jdao.getAll().forEach((i) -> jobLists.add(i.getJobId() + i.getJobTitle()));
    }

    @Override
    public void show() {
        System.out.println("Job ID -- Job Title -- Min Salary -- Max Salary");
        for (Job job : jdao.getAll()) {
            System.out.println(job.getJobId() + " -- " + job.getJobTitle() + " -- " + job.getMinSalary() + " -- " + job.getMaxSalary());
        }
    }

    @Override
    public void insert() {
        System.out.print("Insert new Job ID: ");
        String jobId_Insert = scan.nextLine();
        System.out.print("Insert new Job Title: ");
        String jobTitle_Insert = scan.nextLine();
        System.out.print("Insert new Min Salary: ");
        double minSalary_Insert = scan.nextDouble();
        scan.nextLine();
        System.out.print("Insert new Max Salary: ");
        double maxSalary_Insert = scan.nextDouble();
        scan.nextLine();

        ListOfJobs();
        boolean validasiInsert_JID = jobLists.stream().anyMatch(jobId_Insert::contains);
        boolean validasiInsert_JT = jobLists.stream().anyMatch(jobTitle_Insert::contains);

        if (validasiInsert_JID == false && validasiInsert_JT == false) {
            Job jobInsert = new Job(jobId_Insert, jobTitle_Insert, minSalary_Insert, maxSalary_Insert);
            jdao.insert(jobInsert);
            System.out.println("a new job successfully inserted");
        } else if (validasiInsert_JID == true && validasiInsert_JT == false) {
            System.out.println("Department Name already exists in the data base. Insert data is fail");
        } else if (validasiInsert_JID == false && validasiInsert_JT == true) {
            System.out.println("Department ID already exists in the data base. Insert data is fail");
        } else if (validasiInsert_JID == true && validasiInsert_JT == true) {
            System.out.println("Both Department Name and Department ID already exists in the data base. Insert data is fail");
        }
    }

    @Override
    public void update() {

               
        System.out.print("Job ID: ");
        String jobId_beforeUpdate = scan.nextLine();

        ListOfJobs();
        boolean validasiAwalJobID = jobLists.stream().anyMatch(jobId_beforeUpdate::contains);
       
        if (validasiAwalJobID == true) {
            System.out.println("Current data:\n" + jdao.getById(jobId_beforeUpdate));
            System.out.print("New Min Salary: ");
            double minSalary_Update = scan.nextDouble();
            scan.nextLine();
            System.out.print("New Max Salary: ");
            double maxSalary_Update = scan.nextDouble();
            scan.nextLine();

            Job updateJob = new Job(jobId_beforeUpdate, jdao.getById(jobId_beforeUpdate).getJobTitle(),
                    minSalary_Update, maxSalary_Update);
            jdao.update(jobId_beforeUpdate, updateJob);

        } else {
            System.out.println("Data do not exists in the database");
        }
    }

    @Override
    public void delete() {
        System.out.print("Select Job ID: ");
        String jobId_Delete = scan.nextLine();
        System.out.println("Target data to delete:\n" + jdao.getById(jobId_Delete));
        System.out.print("Type Job Title to delete: ");
        String jobTitle_Delete = scan.nextLine();
       
        ListOfJobs();
        boolean validasiDelete = jobLists.stream().anyMatch(jobTitle_Delete::contains);
       
        if (validasiDelete == true) {
            jdao.delete(jobId_Delete);
            System.out.println("the data successfully deleted");
        } else {
            System.out.println("the data is not exist in the database");
        }
    }   
   
}
