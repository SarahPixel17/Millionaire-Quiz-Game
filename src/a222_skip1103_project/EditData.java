
package a222_skip1103_project;
import java.util.*;
public class EditData {
    private int foundIndex;
    private String name;
    private String searchedName;
    
    Scanner sc = new Scanner(System.in);


    public void displayData(int numOfPerson, String[] searchedName, String[] name){ 
        //To track down number of people
        System.out.println("The number of person(s) = " + numOfPerson);
        if (numOfPerson == 0) 
        {
            System.out.println("There is no person yet in the array");
            System.out.println("");
        } 
        else 
        {
            // display section

            System.out.println("");
            System.out.println("==============================================");
            System.out.println("             Player information               ");
            System.out.println("==============================================");
            System.out.printf("%-20s %10s \n", "Name","score");
            System.out.printf("%-20s %10s \n", "====","=====");
            
            int i=0;
                if (name[i] != null) 
                {
                    System.out.printf("%-20s %6s  \n", name[i], searchedName[i]);
                    System.out.println("");
                }

            
        }
    } // displayData()
    
    public int searchData(String searchedName, String[] name){
         //if the data does not exist
        foundIndex = -1;// -1 refers that the data is not found
        int i=0;
        
            if (name[i] != null) 
            {
                if (name[i].equals(searchedName)) 
                {
                    foundIndex = i;
                   
                }
            }
            
        return foundIndex;
    }// searchData()
    
        public void updateData(String[] name){
        if (foundIndex == -1) // -1 refers that the data is not found
        {
            System.out.println("Sorry, the data is not found");
            System.out.println("");
        } 
        else // if the data is found
        {
            System.out.print("Enter your Name              = ");
            name[foundIndex] = sc.next() + sc.nextLine();

            System.out.println("The data has been updated successfully");
            System.out.println("");

        }

    }//updateData()
        
    public void deletaData(int foundIndex, int numOfPerson, String[] searchedName, String[] name) {

        if (foundIndex == -1) // -1 refers that the data is not found
        {
            System.out.println("Sorry, the data is not found");
            System.out.println("");
        } 
        else // if the data is found
        {
            numOfPerson--;
            name[foundIndex]=null;
            searchedName[foundIndex] = null;
            System.out.println("The player data has removed successfully");
            System.out.println("");
        }

    }//deleteData()
    public String toString(){
        return "Name = ";
    }
    }


