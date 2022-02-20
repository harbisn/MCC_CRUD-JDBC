package tools;

import daos.LocationDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Location;

public class LocationCRUD implements CRUD {
    
    DbConnection connection = new DbConnection();
    LocationDAO ldao = new LocationDAO(connection.getConncetion());
    Scanner scan = new Scanner(System.in);
    List<String> locationListsStr = new ArrayList<>();
    List<Integer> locationListsInt = new ArrayList<>();
    
     public void ListOfLocations(){
        ldao.getAll().forEach((i) -> locationListsStr.add(i.getCountryId() + i.getStreetAddress()));
        ldao.getAll().forEach((i) -> locationListsInt.add(i.getLocationId()));
     }
    
    @Override
    public void show() {
        System.out.println("id -- street address -- postal code -- city -- state province -- country id");
        for (Location location : ldao.getAll()) {
            System.out.println(location.getLocationId() + " -- " + location.getStreetAddress() + " -- " 
                    + location.getPostalCode() + " -- " + location.getCity() + " -- " + location.getStateProvince() + " -- " 
                    + location.getCountryId());
        }
    }

    @Override
    public void insert() {
        System.out.print("Insert new ID: ");
        int locationId_Insert = scan.nextInt();
        scan.nextLine();       
        System.out.print("Insert new Street Address: ");
        String streetAddress_Insert = scan.nextLine();               
        System.out.print("Insert new Postal Code: ");
        String postalCode_Insert = scan.nextLine();               
        System.out.print("Insert new City: ");
        String city_Insert = scan.nextLine();               
        System.out.print("Insert new State Province: ");
        String stateProvince_Insert = scan.nextLine();              
        System.out.print("insert new Country ID: ");
        String countryId_Insert = scan.nextLine();
        ListOfLocations();

        boolean validasiInsert_Cid = locationListsStr.stream().anyMatch(countryId_Insert::contains);
        boolean validasiInsert_SA = locationListsStr.stream().anyMatch(streetAddress_Insert::contains);
        boolean validasiInsert_ID = locationListsInt.stream().anyMatch(n -> (n == locationId_Insert));
       
        if (validasiInsert_Cid == false){
           System.out.println("country with country ID of " + countryId_Insert + " do not exists in the database");
        } else {
           if (validasiInsert_SA == false && validasiInsert_ID == false){
           Location locationInsert = new Location(locationId_Insert, streetAddress_Insert, postalCode_Insert, 
           city_Insert, stateProvince_Insert, countryId_Insert);
           ldao.insert(locationInsert);
           System.out.println("a new location successfully inserted");   
           } else if (validasiInsert_SA == true && validasiInsert_ID == false) {
               System.out.println("street address already exists in the data base. Insert data is fail");
           } else if (validasiInsert_SA == false && validasiInsert_ID == true) {
               System.out.println("location ID already exists in the data base. Insert data is fail");
           } else if (validasiInsert_SA == true && validasiInsert_ID == true) {
               System.out.println("Both street address and location ID already exists in the data base. Insert data is fail");
           }
       }
    }

    @Override
    public void update() {
        System.out.print("Insert ID: ");
        int locationId_Update = scan.nextInt();
        scan.nextLine();
        System.out.println("Current data:\n" + ldao.getById(locationId_Update));
        System.out.print("new Street Address: ");
        String streetAddress_Update = scan.nextLine();               
        System.out.print("new Postal Code: ");
        String postalCode_Update = scan.nextLine();               
        System.out.print("new City: ");
        String city_Update = scan.nextLine();               
        System.out.print("new State Province: ");
        String stateProvince_Update = scan.nextLine();              
        System.out.print("new Country ID: ");
        String countryId_Update = scan.nextLine();
        
        ListOfLocations();
        boolean validasiUpdate_Cid = locationListsStr.stream().anyMatch(countryId_Update::contains);
        boolean validasiUpdate_SA = locationListsStr.stream().anyMatch(streetAddress_Update::contains);
       
       if (validasiUpdate_Cid == false){
           System.out.println("Country ID do not exists in the database");
       } else {
           if (validasiUpdate_SA == false || streetAddress_Update.equals(ldao.getById(locationId_Update).getStreetAddress())){
               Location updateLocation = new Location(locationId_Update, streetAddress_Update, 
               postalCode_Update, city_Update, stateProvince_Update, countryId_Update);
               ldao.update(locationId_Update, updateLocation);
               System.out.println("the data successfully updated");
           } else {
               System.out.println("Street address already exists in the database");
           }
       }
    }

    @Override
    public void delete() {
        System.out.print("Select location ID: ");
        int locationId_Delete = scan.nextInt();
        scan.nextLine();
        System.out.println("Target data to delete:\n" + ldao.getById(locationId_Delete));
        System.out.print("Retype location ID to delete: ");
        int confirmDeletion = scan.nextInt();
        scan.nextLine();
        
        ListOfLocations();
        boolean validasiDelete_ID = locationListsInt.stream().anyMatch(n -> (n == locationId_Delete));

        if (validasiDelete_ID == true){
           ldao.delete(confirmDeletion);
           System.out.println("the data successfully deleted");
        } else {
           System.out.println("the data is not exist in the database");
        }
    }           
}


