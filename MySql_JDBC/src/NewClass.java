/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import java.util.ArrayList;
import java.util.Scanner;

public class NewClass {
    public static void main(String[] args) {

        System.out.println("========== TO DO LIST ==========");
        Scanner scan = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int choice = 0;

        while (choice != 5) {
            System.out.print("\n1.Add list\n2.Shows list\n3.Change list\n4.Delete list\n5.Exit App\nSelect: ");
            choice = scan.nextInt();
            System.out.println(" ");

            if (choice == 1) {
                System.out.println("Type \"enter\" to add new list and \"stop\" to finish (back to main menu).");
                String userInput;
                for (int i = 0; i < 15; i++) {
                    userInput = scan.nextLine();
                    if (!userInput.isEmpty()) {
                        list.add(userInput);
                        if (userInput.equals("stop")) {
                            break;
                        }
                    } else {
                        i--; // don't increase index for an empty item.
                    }
                }
            }

            else if (choice == 2) {
                for (int j = 0; j < list.size(); j++) {
                    list.remove("stop");
                    System.out.println(j + 1 + ". " + list.get(j));
                }
            }

            else if (choice == 3) {
                System.out.println("type \"enter\" to finish and get back to main menu");
                System.out.println("syntax = [number of the list  that will be replaced] + [space] + [new list]");
                int num = scan.nextInt();
                String newAct = scan.next();
                String newAct2 = newAct.replaceAll("\\s",""); // delete space before new act
                int index = num - 1 ;
                list.set(index, newAct2);
            }

            else if (choice == 4) {
                String editUserInput;
                System.out.println("type \"stop\" to finish and get back to main menu");
                System.out.println("Type list that you want to delete: ");
                for (int l = 0; l <= 15; l++) {
                    editUserInput = scan.nextLine();
                    list.remove(editUserInput);
                    if (editUserInput.equals("stop")) {
                        break;
                    }
                }
            }

            else {
                scan.close();
                System.out.println("========== CLOSED ==========");
            }
        }
    }
}
