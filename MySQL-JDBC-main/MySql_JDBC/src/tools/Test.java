package tools;

import daos.RegionDAO;
import daos.CountryDAO;
import daos.LocationDAO;
import daos.DepartmentDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import models.Region;
import models.Country;
import models.Location;
import models.Department;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
    
       
        DbConnection connection = new DbConnection();
        System.out.println(connection.getConncetion());
        Scanner scan = new Scanner(System.in);
               
//        // Region
//        RegionDAO rdao = new RegionDAO(connection.getConncetion());
                
        
//        // 1. Show(Get All)        
//        for (Region region : rdao.getAll()) {
//            System.out.print(region.getRegionId() + " -- ");
//            System.out.println(region.getRegionName());
//        }
                
        // 2. Insert
//        System.out.print("Insert new ID: ");
//        int id_Insert = scan.nextInt();
//        scan.nextLine();
//        System.out.print("Insert region name: ");
//        String regionName_Insert = scan.nextLine();
//        
//        List<String> regionsInsert = new ArrayList<>();
//        for (Region region : rdao.getAll()){
//            regionsInsert.add(region.getRegionName());
//        }
//
//        boolean validasi = regionsInsert.stream().anyMatch(regionName_Insert::contains);
//        
//        if (validasi == false){
//            Region regionInsert = new Region(id_Insert, regionName_Insert);
//            rdao.insert(regionInsert);
//            System.out.println(regionName_Insert + " successfully inserted");   
//        } else {
//            System.out.println(regionName_Insert + " already exists");
//        }
               
        
        // 3. Update
//        System.out.print("Select id: ");
//        int id_Update = scan.nextInt();
//        System.out.println("previous name: " + rdao.getById(id_Update).getRegionName());
//        System.out.print("Update region name: ");
//        String regionName_Update = scan.nextLine();
//               
//         List<String> regionsUpdate = new ArrayList<>();
//        for (Region region : rdao.getAll()){
//            regionsUpdate.add(region.getRegionName());
//        }
//        
//        boolean validasi = regionsUpdate.stream().anyMatch(regionName_Update::contains);
//        
//        if (validasi == false || regionName_Update.equals(rdao.getById(id_Update).getRegionName())){
//            Region updateRegion = new Region(id_Update, regionName_Update);
//            rdao.update(id_Update, updateRegion);
//            System.out.println(regionName_Update + " successfully updated");   
//        } else {
//            System.out.println(regionName_Update + " already exists");
//        }                       

        
        // 4. Delete
//        System.out.print("Select id: ");
//        int id_Delete = scan.nextInt();
//        scan.nextLine();
//        System.out.print("Delete region name: ");
//        String regionName_Delete = scan.nextLine();
//               
//         List<String> regionsDelete = new ArrayList<>();
//        for (Region region : rdao.getAll()){
//            regionsDelete.add(region.getRegionName());
//        }
//        
//        boolean validasi = regionsDelete.stream().anyMatch(regionName_Delete::contains);
//                
//        if ((validasi == true)){ 
//            if (regionName_Delete.equals(regionsDelete.get(id_Delete - 1))){
//                rdao.delete(id_Delete);
//                System.out.println(regionName_Delete + " successfully deleted");  
//            } else {
//                System.out.println("region name and id did not match");
//            }              
//        } else if ((validasi == false)){
//            System.out.println(regionName_Delete + " is not exist in the database");
//        }

// =========================================================-------------------//
        // Country                
//        CountryDAO cdao = new CountryDAO(connection.getConncetion());
        
        // 1. Show(Get All)       
//        for (Country country : cdao.getAll()) {
//            System.out.print(country.getCountryId() + " -- ");
//            System.out.print(country.getCountryName() + " -- ");
//            System.out.println(country.getRegionId());
//        }
        
        // 2. Insert
//        System.out.print("Insert new country ID: ");
//        String CountryId_Insert = scan.nextLine();
//        System.out.print("Insert country name: ");
//        String countryName_Insert = scan.nextLine();
//        System.out.print("Insert region name: ");
//        int regionId_Insert = scan.nextInt();
//        scan.nextLine();
//        
//        List<String> countriesInsert = new ArrayList<>();
//        for (Country country : cdao.getAll()){
//            countriesInsert.add(country.getCountryId());
//            countriesInsert.add(country.getCountryName());
//        }
//
//        boolean validasiId = countriesInsert.stream().anyMatch(CountryId_Insert::contains);
//        boolean validasiName = countriesInsert.stream().anyMatch(countryName_Insert::contains);
//        
//        if (validasiName == false && validasiId == false){
//            Country countryInsert = new Country(CountryId_Insert, countryName_Insert, regionId_Insert);
//            cdao.insert(countryInsert);
//            System.out.println("new data successfully inserted");   
//        } else if (validasiName == true && validasiId == false) {
//            System.out.println(countryName_Insert + " already exists in the data base. Insert data is fail");
//        } else if (validasiName == false && validasiId == true) {
//            System.out.println(CountryId_Insert + " already exists in the data base. Insert data is fail");
//        } else if (validasiName == true && validasiId == true) {
//            System.out.println("Both " + CountryId_Insert + " and " + countryName_Insert + " already exists in the data base. Insert data is fail");
//        }
        
          // 3. Update
//        System.out.print("Select country id: ");
//        String countryId_Update = scan.nextLine();
//        System.out.println("previous country: " + cdao.getById(countryId_Update).getCountryName());
//        System.out.println("previous regional id: " + cdao.getById(countryId_Update).getRegionId());
//        System.out.print("Update country name: ");
//        String countryName_Update = scan.nextLine();
//               
//         List<String> countriesUpdate = new ArrayList<>();
//        for (Country country : cdao.getAll()){
//            countriesUpdate.add(country.getCountryName());
//        }
//        
//        boolean validasi = countriesUpdate.stream().anyMatch(countryName_Update::contains);
//        
//        if (validasi == false){
//            Country updateCountry = new Country(countryId_Update, countryName_Update, cdao.getById(countryId_Update).getRegionId());
//            cdao.update(countryId_Update, updateCountry);
//            System.out.println(countryName_Update + " successfully updated");   
//        } else {
//            System.out.println(countryName_Update + " already exists");
//        }
        
        
            // 4. Delete
//        System.out.print("Select country id: ");
//        String countryId_Delete = scan.nextLine();
//        System.out.print("Delete country name: ");
//        String countryName_Delete = scan.nextLine();
//               
//         List<String> countriesDelete = new ArrayList<>();
//        for (Country country : cdao.getAll()){
//            countriesDelete.add(country.getCountryName());
//        }
//        
//        boolean validasi = countriesDelete.stream().anyMatch(countryName_Delete::contains);
//                
//        if ((validasi == true)){
//            if (countryName_Delete.equals(cdao.getById(countryId_Delete).getCountryName())){
//                cdao.delete(countryId_Delete);
//                System.out.println(countryName_Delete + " successfully deleted");  
//            } else {
//                System.out.println("region name and id did not match");
//            }              
//        } else if ((validasi == false)){
//            System.out.println(countryName_Delete + " is not exist in the database");
//        }


// =========================================================-------------------//
        // Location
//        LocationDAO ldao = new LocationDAO(connection.getConncetion());                
        
//        // 1. Show(Get All)
//        System.out.println("id -- street address -- postal code -- city -- state province -- country id");
//        for (Location location : ldao.getAll()) {
//            System.out.print(location.getLocationId() + " -- ");
//            System.out.print(location.getStreetAddress() + " -- ");
//            System.out.print(location.getPostalCode() + " -- ");
//            System.out.print(location.getCity() + " -- ");
//            System.out.print(location.getStateProvince() + " -- ");
//            System.out.println(location.getCountryId());
//        }
                
        // 2. Insert
//        System.out.print("Insert new ID: ");
//        int locationId_Insert = scan.nextInt();
//        scan.nextLine();       
//        System.out.print("Insert new Street Address: ");
//        String streetAddress_Insert = scan.nextLine();               
//        System.out.print("Insert new Postal Code: ");
//        String postalCode_Insert = scan.nextLine();               
//        System.out.print("Insert new City: ");
//        String city_Insert = scan.nextLine();               
//        System.out.print("Insert new State Province: ");
//        String stateProvince_Insert = scan.nextLine();              
//        System.out.print("insert new Country ID: ");
//        String countryId_Insert = scan.nextLine();
//        
//        
//        List<String> locationsInsertSACid = new ArrayList<>();
//        for (Location location : ldao.getAll()){
//            locationsInsertSACid.add(location.getCountryId());
//            locationsInsertSACid.add(location.getStreetAddress());
//        }
//        
//        List<Integer> locationsInsertID = new ArrayList<>();
//        for (Location location : ldao.getAll()){
//            locationsInsertID.add(location.getLocationId());
//        }
//
//        boolean validasiInsert_Cid = locationsInsertSACid.stream().anyMatch(countryId_Insert::contains);
//        boolean validasiInsert_SA = locationsInsertSACid.stream().anyMatch(streetAddress_Insert::contains);
//        boolean validasiInsert_ID = locationsInsertID.stream().anyMatch(n -> (n == locationId_Insert));
//        
//        if (validasiInsert_Cid == false){
//            System.out.println("country with country ID of " + countryId_Insert + " do not exists in the database");
//        } else {
//            if (validasiInsert_SA == false && validasiInsert_ID == false){
//            Location locationInsert = new Location(locationId_Insert, streetAddress_Insert, postalCode_Insert, 
//            city_Insert, stateProvince_Insert, countryId_Insert);
//            ldao.insert(locationInsert);
//            System.out.println("a new location successfully inserted");   
//            } else if (validasiInsert_SA == true && validasiInsert_ID == false) {
//                System.out.println("street address already exists in the data base. Insert data is fail");
//            } else if (validasiInsert_SA == false && validasiInsert_ID == true) {
//                System.out.println("location ID already exists in the data base. Insert data is fail");
//            } else if (validasiInsert_SA == true && validasiInsert_ID == true) {
//                System.out.println("Both street address and location ID already exists in the data base. Insert data is fail");
//            }
//        }
        
       
        // 3. Update
//        System.out.print("Insert ID: ");
//        int locationId_Update = scan.nextInt();
//        scan.nextLine();
//        System.out.println("Current data:\n" + ldao.getById(locationId_Update));
//        System.out.print("new Street Address: ");
//        String streetAddress_Update = scan.nextLine();               
//        System.out.print("new Postal Code: ");
//        String postalCode_Update = scan.nextLine();               
//        System.out.print("new City: ");
//        String city_Update = scan.nextLine();               
//        System.out.print("new State Province: ");
//        String stateProvince_Update = scan.nextLine();              
//        System.out.print("new Country ID: ");
//        String countryId_Update = scan.nextLine();
//        
//        List<String> locationsUpdateSACid = new ArrayList<>();
//        for (Location location : ldao.getAll()){
//            locationsUpdateSACid.add(location.getCountryId());
//            locationsUpdateSACid.add(location.getStreetAddress());
//        }
//
//        boolean validasiUpdate_Cid = locationsUpdateSACid.stream().anyMatch(countryId_Update::contains);
//        boolean validasiUpdate_SA = locationsUpdateSACid.stream().anyMatch(streetAddress_Update::contains);
//        
//        if (validasiUpdate_Cid == false){
//            System.out.println("Country ID do not exists in the database");
//        } else {
//            if (validasiUpdate_SA == false || streetAddress_Update.equals(ldao.getById(locationId_Update).getStreetAddress())){
//                Location updateLocation = new Location(locationId_Update, streetAddress_Update, 
//                postalCode_Update, city_Update, stateProvince_Update, countryId_Update);
//                ldao.update(locationId_Update, updateLocation);
//                System.out.println("the data successfully updated");
//            } else {
//                System.out.println("Street address already exists in the database");
//            }
//        }
                                           
        
        // 4. Delete
//        System.out.print("Select location ID: ");
//        int locationId_Delete = scan.nextInt();
//        scan.nextLine();
//        System.out.println("Target data to delete:\n" + ldao.getById(locationId_Delete));
//        
//        List<Integer> locationsDeleteID = new ArrayList<>();
//        for (Location location : ldao.getAll()){
//            locationsDeleteID.add(location.getLocationId());
//        }
//
//        boolean validasiDelete_ID = locationsDeleteID.stream().anyMatch(n -> (n == locationId_Delete));
//        
//        if (validasiDelete_ID == true){
//            ldao.delete(locationId_Delete);
//            System.out.println("the data successfully deleted");
//        } else {
//            System.out.println("the data is not exist in the database");
//        }
    
    // =========================================================-------------------//
    
    // Department
        DepartmentDAO ddao = new DepartmentDAO(connection.getConncetion());                
        
//        // 1. Show(Get All)
//        System.out.println("Department ID -- Department Name -- manager ID -- location ID");
//        for (Department department : ddao.getAll()) {
//            System.out.print(department.getDepartmenId() + " -- ");
//            System.out.print(department.getDepartmentName() + " -- ");
//            System.out.print(department.getManagerId() + " -- ");
//            System.out.println(department.getLocationId());
//        }
                
        // 2. Insert
//        System.out.print("Insert new ID: ");
//        int departmentId_Insert = scan.nextInt();
//        scan.nextLine();       
//        System.out.print("Insert new Department Name: ");
//        String departmentname_Insert = scan.nextLine();               
//        System.out.print("Insert new Manager ID: ");
//        int managerId_Insert = scan.nextInt();
//        scan.nextLine();      
//        System.out.print("Insert new Location ID: ");
//        int locationId_Insert = scan.nextInt();
//        scan.nextLine();
//        
//        
//        List<String> departmentsInsertN = new ArrayList<>();
//        for (Department department : ddao.getAll()){
//            departmentsInsertN.add(department.getDepartmentName());
//        }
//        
//        List<Integer> departmentsInsertDid = new ArrayList<>();
//        for (Department department : ddao.getAll()){
//            departmentsInsertDid.add(department.getDepartmenId());
//        }
//
//        boolean validasiInsert_DN = departmentsInsertN.stream().anyMatch(departmentname_Insert::contains);
//        boolean validasiInsert_Did = departmentsInsertDid.stream().anyMatch(n -> (n == departmentId_Insert));
//        
//        if (validasiInsert_Did == false){
//            if (validasiInsert_DN == false && validasiInsert_Did == false){
//            Department departmentInsert = new Department(departmentId_Insert, departmentname_Insert, 
//            managerId_Insert, locationId_Insert);
//            ddao.insert(departmentInsert);
//            System.out.println("a new location successfully inserted");   
//            } else if (validasiInsert_DN == true && validasiInsert_Did == false) {
//                System.out.println("Department Name already exists in the data base. Insert data is fail");
//            } else if (validasiInsert_DN == false && validasiInsert_Did == true) {
//                System.out.println("Department ID already exists in the data base. Insert data is fail");
//            } else if (validasiInsert_DN == true && validasiInsert_Did == true) {
//                System.out.println("Both Department Name and Department ID already exists in the data base. Insert data is fail");
//            }
//        } else {
//            System.out.println("Department with ID of " + departmentId_Insert + " already exists in the database. Insert data is fail.");
//        }
        
       
        // 3. Update
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
        
        List<String> departmentsUpdateN = new ArrayList<>();
        for (Department department : ddao.getAll()){
            departmentsUpdateN.add(department.getDepartmentName());
        }

        boolean validasiUpdate_DN = departmentsUpdateN.stream().anyMatch(departmentName_Update::contains);
        
        if (validasiUpdate_DN == false || departmentName_Update.equals(ddao.getById(departmentId_Update).getDepartmentName())){
            Department updateDepartment = new Department(departmentId_Update, departmentName_Update, 
            managerId_Update, locationId_Update);
            ddao.update(departmentId_Update, updateDepartment);           
        } else {
            System.out.println("Department name already exists in the database");
        }
        
        
            // 4. Delete
//        System.out.print("Select location ID: ");
//        int locationId_Delete = scan.nextInt();
//        scan.nextLine();
//        System.out.println("Target data to delete:\n" + ldao.getById(locationId_Delete));
//        
//        List<Integer> locationsDeleteID = new ArrayList<>();
//        for (Location location : ldao.getAll()){
//            locationsDeleteID.add(location.getLocationId());
//        }
//
//        boolean validasiDelete_ID = locationsDeleteID.stream().anyMatch(n -> (n == locationId_Delete));
//        
//        if (validasiDelete_ID == true){
//            ldao.delete(locationId_Delete);
//            System.out.println("the data successfully deleted");
//        } else {
//            System.out.println("the data is not exist in the database");
//        }
        









        }

  
    
}
    