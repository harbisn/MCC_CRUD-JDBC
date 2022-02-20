package tools;

import daos.CountryDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Country;

public class CountryCRUD implements CRUD {
        
    DbConnection connection = new DbConnection();
    CountryDAO cdao = new CountryDAO(connection.getConncetion());
    Scanner scan = new Scanner(System.in);

    @Override
    public void show() {
        for (Country country : cdao.getAll()) {
            System.out.print(country.getCountryId() + " -- ");
            System.out.print(country.getCountryName() + " -- ");
            System.out.println(country.getRegionId());
        }
    }

    @Override
    public void insert() {
        System.out.print("Insert new country ID: ");
        String CountryId_Insert = scan.nextLine();
        System.out.print("Insert country name: ");
        String countryName_Insert = scan.nextLine();
        System.out.print("Insert region name: ");
        int regionId_Insert = scan.nextInt();
        scan.nextLine();
        
        List<String> countriesInsert = new ArrayList<>();
        for (Country country : cdao.getAll()){
            countriesInsert.add(country.getCountryId());
            countriesInsert.add(country.getCountryName());
        }

        boolean validasiId = countriesInsert.stream().anyMatch(CountryId_Insert::contains);
        boolean validasiName = countriesInsert.stream().anyMatch(countryName_Insert::contains);
        
        if (validasiName == false && validasiId == false){
            Country countryInsert = new Country(CountryId_Insert, countryName_Insert, regionId_Insert);
            cdao.insert(countryInsert);
            System.out.println("new data successfully inserted");   
        } else if (validasiName == true && validasiId == false) {
            System.out.println(countryName_Insert + " already exists in the data base. Insert data is fail");
        } else if (validasiName == false && validasiId == true) {
            System.out.println(CountryId_Insert + " already exists in the data base. Insert data is fail");
        } else if (validasiName == true && validasiId == true) {
            System.out.println("Both " + CountryId_Insert + " and " + countryName_Insert + " already exists in the data base. Insert data is fail");
        }
    }

    @Override
    public void update() {
        System.out.print("Select country id: ");
        String countryId_Update = scan.nextLine();
        System.out.println("previous country: " + cdao.getById(countryId_Update).getCountryName());
        System.out.println("previous regional id: " + cdao.getById(countryId_Update).getRegionId());
        System.out.print("Update country name: ");
        String countryName_Update = scan.nextLine();
               
         List<String> countriesUpdate = new ArrayList<>();
        for (Country country : cdao.getAll()){
            countriesUpdate.add(country.getCountryName());
        }
        
        boolean validasi = countriesUpdate.stream().anyMatch(countryName_Update::contains);
        
        if (validasi == false){
            Country updateCountry = new Country(countryId_Update, countryName_Update, cdao.getById(countryId_Update).getRegionId());
            cdao.update(countryId_Update, updateCountry);
            System.out.println(countryName_Update + " successfully updated");   
        } else {
            System.out.println(countryName_Update + " already exists");
        }
    }

    @Override
    public void delete() {
        System.out.print("Select country id: ");
        String countryId_Delete = scan.nextLine();
        System.out.print("Delete country name: ");
        String countryName_Delete = scan.nextLine();
               
         List<String> countriesDelete = new ArrayList<>();
        for (Country country : cdao.getAll()){
            countriesDelete.add(country.getCountryName());
        }
        
        boolean validasi = countriesDelete.stream().anyMatch(countryName_Delete::contains);
                
        if ((validasi == true)){
            if (countryName_Delete.equals(cdao.getById(countryId_Delete).getCountryName())){
                cdao.delete(countryId_Delete);
                System.out.println(countryName_Delete + " successfully deleted");  
            } else {
                System.out.println("region name and id did not match");
            }              
        } else if ((validasi == false)){
            System.out.println(countryName_Delete + " is not exist in the database");
        }
    }
    
}

