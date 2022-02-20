package tools;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);        
        CRUD[] crud = {new RegionCRUD(), new CountryCRUD(), new LocationCRUD(), new DepartmentCRUD(), new JobCRUD(), new EmployeeCRUD()};
        int selection = -1;
        String str1 = "Welcome to the db_hr database CRUD application\nType \"0\" to see the list of table you can access and type \"07\" to quit the apps.";
        System.out.println(str1);
        
        while (selection != 07){
            selection = scan.nextInt();
            scan.nextLine();
            switch(selection){
                    case 0:
                        System.out.print("Table lists:\n1. Region\n2. Country\n3. Location\n4. Department\n5. Job\n6. Employee"
                                + "\n\"Type the numbering of each concent to access\"\n");
                        break;
                    case 1:
                        System.out.print("Region Table\n11. Show\n12. Insert\n13. Update\n14. Delete"
                                + "\n\"Type the numbering of each concent to access and type \"1\" to see Region table menu \"\n");
                        System.out.print("Type \"0\" to get you back into table list menu\n");
                        break;
                    case 2:
                        System.out.print("Country Table\n21. Show\n22. Insert\n23. Update\n24. Delete"
                                + "\n\"Type the numbering of each concent to access and type \"2\" to see Country table menu \"\n");
                        System.out.print("Type \"0\" to get you back into table list menu\n");
                        break;
                    case 3:
                        System.out.print("Location Table\n31. Show\n32. Insert\n33. Update\n34. Delete"
                                + "\n\"Type the numbering of each concent to access and type \"3\" to see Location table menu \"\n");
                        System.out.print("Type \"0\" to get you back into table list menu\n");
                        break;
                    case 4:
                        System.out.print("Department Table\n41. Show\n42. Insert\n43. Update\n44. Delete"
                                + "\n\"Type the numbering of each concent to access and type \"2\" to see Department table menu \"\n");
                        System.out.print("Type \"0\" to get you back into table list menu\n");
                        break;
                    case 5:
                        System.out.print("Job Table\n51. Show\n52. Insert\n53. Update\n54. Delete"
                                + "\n\"Type the numbering of each concent to access and type \"5\" to see Job table menu \"\n");
                        System.out.print("Type \"0\" to get you back into table list menu\n");
                        break;
                    case 6:
                        System.out.print("Employee Table\n61. Show\n62. Insert\n63. Update\n64. Delete"
                                + "\n\"Type the numbering of each concent to access and type \"6\" to see Employee table menu \"\n");
                        System.out.print("Type \"0\" to get you back into table list menu\n");
                        break;
                    case 07:
                        System.out.print("Thank you for using this apps!\n");
                        break;
                        
                     // region table    
                    case 11:
                        crud[0].show();
                        break;
                    case 12:
                        crud[0].insert();
                        break;
                    case 13:
                        crud[0].update();
                        break;
                    case 14:
                        crud[0].delete();
                        break;
                     // country table    
                    case 21:
                        crud[1].show();
                        break;
                    case 22:
                        crud[1].insert();
                        break;
                    case 23:
                        crud[1].update();
                        break;
                    case 24:
                        crud[1].delete();
                        break;
                     // location table
                    case 31:
                        crud[2].show();
                        break;
                    case 32:
                        crud[2].insert();
                        break;
                    case 33:
                        crud[2].update();
                        break;
                    case 34:
                        crud[2].delete();
                        break;
                     // department table
                    case 41:
                        crud[3].show();
                        break;
                    case 42:
                        crud[3].insert();
                        break;
                    case 43:
                        crud[3].update();
                        break;
                    case 44:
                        crud[3].delete();
                        break;
                     // job table
                    case 51:
                        crud[4].show();
                        break;
                    case 52:
                        crud[4].insert();
                        break;
                    case 53:
                        crud[4].update();
                        break;
                    case 54:
                        crud[4].delete();
                        break;
                     // employee table
                    case 61:
                        crud[5].show();
                        break;
                    case 62:
                        crud[5].insert();
                        break;
                    case 63:
                        crud[5].update();
                        break;
                    case 64:
                        crud[5].delete();
                        break;
                        
                    default:
                        System.out.print("There is no such selection exists, you will get back to the front menu\n"
                                + "Welcome to the db_hr database CRUD application\nType \"0\" to see the list of table you can access.");
                }                   
        }  
    }   
}
    
