import java.io.*;
import java.util.*;
import java.lang.*;
public class User
{
    private String userName;
    private String emailID;
    private long phoneNumber;
    private int userID;
    private String address;
    boolean newUser;
    public User() //Epty User Constructor
    {   
    }
      /*
     * User Constructor Overloading
     */
    public User(String user,int ID)   
    {
        userName = user;
        userID = ID;
    }
    public User(String user,long phone,int ID)
    {
        userName = user;
        phoneNumber = phone;
        userID = ID;
    }
      public User(String user,long phone,int ID,boolean newUser)
    {
        userName = user;
        phoneNumber = phone;
        userID = ID;
        this.newUser = newUser;
    }
     /*
     * Setter and Getter Methods for the user attributes
     */
    public void setAddress(String address)
    {
       this.address = address;
    }
    public void setEmailID(String emailID)
    {
       this.emailID = emailID;
    }
     public String getUserName()
    {
        return userName;
    } 
     public String getEmailID()
    {
        return emailID;
    } 
     public long getPhoneNumber()
    {
        return phoneNumber;
    } 
     public String getAddress()
    {
        return address;
    } 
    public int getUserID()
    {
        return userID;
    } 
      /*
     * Prints the detais of the User
     */
    public void printUser()
    {
        System.out.println("User-Name : " + userName);
        System.out.println("Email-id is : " + emailID); 
        System.out.println("Phone number : " + phoneNumber);
        System.out.println("User ID : " + userID);
        System.out.println("Address : " + address);
        System.out.println("--------------------------------");
    }
       public void printName(int num)
    {
         System.out.println("User-Name : " + userName);
    }
     /*
     * This Method writes the details of user to the file Userdata.txt. 
     */
    public void storeUser(PrintWriter pw)
    {
        if(newUser == true)
        {
        try
            {
                pw.print(userName+":"); 
                pw.print(emailID+":"); 
                pw.print(phoneNumber+":"); 
                pw.print(userID+":");
                pw.print(address+":");
                    pw.println("");
                    pw.flush();
           }
           catch(Exception e)
           {
               System.out.println("Exception: " + e);
               return;
           }
        }
        else
        {
            System.out.println("This user is already registered");
        }
    }
    public static void main(String[]args)
    {
        User varun = new User("Varun Kumar",9895035683L,334423);
        varun.printUser();
    }
}
