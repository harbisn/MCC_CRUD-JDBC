package tools;

import daos.RegionDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Region;

public class RegionCRUD implements CRUD {
    
    DbConnection connection = new DbConnection();
    RegionDAO rdao = new RegionDAO(connection.getConncetion());
    Scanner scan = new Scanner(System.in);

    @Override
    public void show() {
        for (Region region : rdao.getAll()) {
            System.out.print(region.getRegionId() + " -- ");
            System.out.println(region.getRegionName());
        }
    }

    @Override
    public void insert() {
        System.out.print("Insert new ID: ");
        int id_Insert = scan.nextInt();
        scan.nextLine();
        System.out.print("Insert region name: ");
        String regionName_Insert = scan.nextLine();
        
        List<String> regionsInsert = new ArrayList<>();
        for (Region region : rdao.getAll()){
            regionsInsert.add(region.getRegionName());
        }

        boolean validasi = regionsInsert.stream().anyMatch(regionName_Insert::contains);
        
        if (validasi == false){
            Region regionInsert = new Region(id_Insert, regionName_Insert);
            rdao.insert(regionInsert);
            System.out.println(regionName_Insert + " successfully inserted");   
        } else {
            System.out.println(regionName_Insert + " already exists");
        }
    }

    @Override
    public void update() {
        System.out.print("Select id: ");
        int id_Update = scan.nextInt();
        System.out.println("previous name: " + rdao.getById(id_Update).getRegionName());
        System.out.print("Update region name: ");
        String regionName_Update = scan.nextLine();
               
        List<String> regionsUpdate = new ArrayList<>();
        for (Region region : rdao.getAll()){
            regionsUpdate.add(region.getRegionName());
        }
        
        boolean validasi = regionsUpdate.stream().anyMatch(regionName_Update::contains);
        
        if (validasi == false || regionName_Update.equals(rdao.getById(id_Update).getRegionName())){
            Region updateRegion = new Region(id_Update, regionName_Update);
            rdao.update(id_Update, updateRegion);
            System.out.println(regionName_Update + " successfully updated");   
        } else {
            System.out.println(regionName_Update + " already exists");
        }
    }

    @Override
    public void delete() {
        System.out.print("Select id: ");
        int id_Delete = scan.nextInt();
        scan.nextLine();
        System.out.print("Delete region name: ");
        String regionName_Delete = scan.nextLine();
               
        List<String> regionsDelete = new ArrayList<>();
        for (Region region : rdao.getAll()){
            regionsDelete.add(region.getRegionName());
        }
        
        boolean validasi = regionsDelete.stream().anyMatch(regionName_Delete::contains);
                
        if ((validasi == true)){ 
            if (regionName_Delete.equals(regionsDelete.get(id_Delete - 1))){
                rdao.delete(id_Delete);
                System.out.println(regionName_Delete + " successfully deleted");  
            } else {
                System.out.println("region name and id did not match");
            }              
        } else if ((validasi == false)){
            System.out.println(regionName_Delete + " is not exist in the database");
        }
    }
    
    
 
    
    

    
}
