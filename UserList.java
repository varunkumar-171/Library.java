import java.io.*;
import java.util.*;
import java.lang.*;
public class UserList
{
     private User[] allUsers = new User[100]; 
     int noOfUsers = 0;
      public UserList() // Empty Contructor
     {  
     }
     public  boolean addUser(User u)
     {
         allUsers[noOfUsers] = u;
         noOfUsers ++;
         return true;
     }
    /*
     * Finds and returns the index of the particular user 
     */
     public int findUser(int userID)
     {
         for(int i = 0;i<allUsers.length;i++)
         {
             User u = allUsers[i];
             if(u != null)
             {
                 if(userID == u.getUserID())  
                 {
                     System.out.println("User found");
                     //u.printUser();
                     return i;
                    }
            }
        }
        System.out.println("User not found");
         return -1;
     }
       /*
     * Deletes the User at the particular index and makes that index as null 
     */
     
       public boolean deleteUser(User u)
     {
        int UserIndex = findUser(u.getUserID());  
        if(UserIndex == -1)
        {
            System.out.println("User not found");
            return false;
        }
        else
        {
            allUsers[UserIndex] = null;
            return true;
        }
     }
      /*
     * This Method prints the list of users int he array allUsersp[]
     */
      public void printAllUsers()
    {
        for(int i = 0;i<noOfUsers;i++)
        {
            User u = allUsers[i];
             if(u != null)
            {
                 u.printUser(); 
            }
        }
    } 
    public void printName(int num)
    {
           User u = allUsers[num];
    }
     /*
     * Stores the all the users in the allUsers[] array 
     */
    public void storeAllUsers(PrintWriter pw)
    {
        for(int i = 0;i<noOfUsers;i++)
        {
            User u = allUsers[i];
             if(u != null)
            {
                 u.storeUser(pw); 
            }
        }
    } 
     /*
     * Returns the User at the particular index 
     */
    public User getUser(int num)
    {
        User u = allUsers[num]; 
        return u;
    }
      /*
     * Test Harness
     */
    public static void main(String[]args) 
    {
        UserList u1 = new UserList();
        User user1 = new User("Varun Kumar",9895035683L,334423);
        u1.addUser(user1);
        User user2 = new User("Abhishek",3746198273L,485876);
        u1.addUser(user2);
        User user3 = new User("Uma",2837465910L,238745);
        u1.addUser(user3);
            u1.printAllUsers();
            System.out.println("-----------------------------------");
        u1.deleteUser(user2);
             System.out.println("_________________________________________1");
        u1.deleteUser(user1);
             System.out.println("_________________________________________2");
         u1.deleteUser(user3);
         System.out.println("_________________________________________3");
             u1.printAllUsers();  
    }
    }
