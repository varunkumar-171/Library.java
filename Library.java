import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.SimpleDateFormat;
public class Library
{
  private UserList ul;
  private BookList bl;
  private int userId = 1;
  private int isbn = 1;
  public Library() 
  {
    ul = new UserList(); //creates user object u1
    bl = new BookList(); // creates book object b1
  }
   /*
   * Returns the index at the index at the Particular Index
   */
  public int getUserID()
  {
        Scanner a = new Scanner(System.in);
        System.out.println("Enter userId");
        int choice = a.nextInt();
        int num = ul.findUser(choice);
        while(num == -1)
        {
            System.out.println("Do you want to enter again");
            String choice1 = a.next();
            if(choice1.equalsIgnoreCase("Yes"))
            {
               System.out.println("Enter userId"); 
               int choice2 = a.nextInt();
               num = ul.findUser(choice2); // Calls the findUser method in UserLIst
               if(num == -1)
               {
                       continue;
               }
               else
               {
                   break;
               }
            }
            else
            {
                return 10;
            }
        }
        return num;
  }
   /*
   * This Method reads the details of user from the file Userdata.txt. 
   */
  public void loadUsersFromFile()
  {
    
       int count = 0;
       try
       {
           Scanner a = new Scanner(new File("Userdata.txt"));
           a.useDelimiter("\n");
           while(a.hasNext()) {
              String n1 = a.next();
              
              if(n1 == null || n1.equals("") || n1.equals("\n") || n1.equals("\r")) //Checks if the line is empty or not to read tokens
              {
                   System.out.println("Empty Line");
                   break;
              }
              System.out.println("<" + n1 + "> " + n1.length());
              count++;
              Scanner c = new Scanner(n1);
              c.useDelimiter(":");//Reads the token until a semicolon is encountered
              String userName = c.next();
              String emailID = c.next();
              System.out.println(emailID);
              long phoneNumber = c.nextLong(); 
              int userID = c.nextInt();
              String address = c.next();
              User u1 = new User(userName,phoneNumber,userID,true);
              u1.setAddress(address);
              u1.setEmailID(emailID);
              u1.printUser();
              ul.addUser(u1);
              c.close();
           }
           System.out.println("loaded "+ count + " users");
           userId = ++count;
           a.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
   
  }
    /*
   * This Method reads the details of book from the file Bookdata.txt. 
   */
    public void loadBooksFromFile()
    {
    int count = 0;
       try
       {
       Scanner a = new Scanner(new File("Bookdata.txt"));
       a.useDelimiter("\n");
       while(a.hasNext()) {
           String n1 = a.next();
           if(n1 == null || n1.equals("") || n1.equals("\n") || n1.equals("\r")) {
               System.out.println("Empty Line");
               break;
           }
               
           System.out.println("<" + n1 + "> " + n1.length());
           count++;
           
          Scanner c = new Scanner(n1);
          c.useDelimiter(":");
          String bookName = c.next();
          String author = c.next();
          int isbn = c.nextInt();
          boolean avail = c.nextBoolean();
          Book b1 = new Book(bookName,author,isbn,true,false);
          b1.printBook();
          bl.addBook(b1);
          c.close();
       }
       System.out.println("loaded "+count + " books");
       isbn = ++count;
       a.close();
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
  }
    /*
   * This Method reads the details of Borrrowedbook from the file BorrowedBookdata.txt. 
   */
   public void loadBorrowedBooksFromFile()
    {
    int count = 0;
       try
       {
       Scanner a = new Scanner(new File("BorrowedBookdata.txt"));
       a.useDelimiter("\n");
       while(a.hasNext()) 
       {
           String n1 = a.next();
           if(n1 == null || n1.equals("") || n1.equals("\n") || n1.equals("\r")) 
           {
               System.out.println("Empty Line");
               break;
          }    
          System.out.println("<" + n1 + "> " + n1.length());
          count++;
          Scanner c = new Scanner(n1);
          c.useDelimiter(":");
          String bookName = c.next();
          String author = c.next();
          int isbn = c.nextInt();
          String bd = c.next();  // Borrow Date
          String dd = c.next();  // Due Date
          Book b1 = new Book(bookName,author,isbn,bd,dd);
          b1.printBook();
          
          String userName = c.next();
          long phoneNumber = c.nextLong();
          int userID = c.nextInt();
          User u1 = new User(userName,phoneNumber,userID);
          u1.printUser();
          
          BorrowedBook bb1 = new BorrowedBook(b1,u1);      
          // bb1.printBorrowedBook();
          bl.addBorrowedBook(bb1);
          c.close();
       }
       System.out.println("loaded "+ count + " Borrowed books");
       count++;
       a.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
        System.out.println(e.getMessage());
    }
  }
    public static void main(String[] args)
    {
        try
        {
            /*
            * Creates the respective Files
              */
            FileWriter bfw = new FileWriter("Bookdata.txt", true);
            BufferedWriter bbw = new BufferedWriter(bfw);
            PrintWriter bw = new PrintWriter(bbw);
            
            FileWriter ufw = new FileWriter("Userdata.txt", true);
            BufferedWriter ubw = new BufferedWriter(ufw);
            PrintWriter uw = new PrintWriter(ubw);
            
            FileWriter bbfw = new FileWriter("BorrowedBookdata.txt", true);
            BufferedWriter bbbw = new BufferedWriter(bbfw);
            PrintWriter bpw = new PrintWriter(bbbw);
            
            int option;
            String name,address,emailId,bookName,author,publication;
            long phoneNum;
            String word = "yes";
            Library l = new Library(); //creates library object
            l.loadBooksFromFile();
            l.loadUsersFromFile();
            l.loadBorrowedBooksFromFile();
            Scanner a = new Scanner(System.in);
          
            a.useDelimiter("\n");
            boolean quitFlag = false;
            while(word.equalsIgnoreCase("yes"))
            {
                   System.out.print('\u000C');
                                                                                               //Main menu display
                   System.out.println("\t\tWelcome to Library Management System");
                   System.out.println("\t\t====================================");
                   System.out.println("\t\t\tCreate User(Enter 1)");
                   System.out.println("\t\t\tCreate Book(Enter 2)");
                   System.out.println("\t\t\tPrint Userlist(Enter 3)");
                   System.out.println("\t\t\tPrint Booklist(Enter 4)");
                   System.out.println("\t\t\tBorrow Book(Enter 5)");
                   System.out.println("\t\t\tPrint Borrowed BookList(Enter 6)");
                   System.out.println("\t\t\tReturn Book(Enter 7)");
                   System.out.println("\t\t\tExit Library(Enter 8)");
                   System.out.println("\t\t====================================");
                   System.out.print("\t\t\tChoose your option: ");
                   option = a.nextInt();
                   switch(option)
                   {
                       case 1:
                       System.out.println("Enter your name");
                       name = a.next(); 
                       while(true)
                       {
                       try{
                           System.out.println("Enter your phone number");
                           phoneNum = a.nextLong();
                           break;
                       } catch(InputMismatchException ime)
                       {
                           System.out.println("Invalid number");
                           a.next();
                       }
                       }
                       System.out.println("Enter your Address");
                       address = a.next();
                       System.out.println("Enter your email-id");
                       emailId = a.next();
                       User u1 = new User(name,phoneNum,l.userId,true);
                       u1.setAddress(address);
                       u1.setEmailID(emailId);
                       System.out.println("Hi! " + name + " your user Id is " + l.userId);
                       l.userId++;
                       l.ul.addUser(u1);
                       l.ul.storeAllUsers(uw);
                       break;
                       
                       case 2:
                       System.out.println("Enter name of Book");
                       bookName = a.next();
                       System.out.println("Enter book's author");
                       author = a.next();
                       System.out.println("Enter book's publication");
                       publication = a.next();
                       Book b1 = new Book( bookName,author,l.isbn,true,true);
                       l.isbn++;
                       l.bl.addBook(b1);
                       l.bl.storeAllBooks(bw);
                       break;
                       
                       case 3:
                       System.out.println("Printing all Users");
                       l.ul.printAllUsers();
                       break;
                       
                       case 4:
                       System.out.println("Printing all Books");
                       l.bl.printAllBooksName();
                       break;
                         
                       case 5:
                       int num1 = l.getUserID(); // Gets the correct userId and then allows borrowing  
                       if(num1 != 10)
                       {         
                           User u = l.ul.getUser(num1); 
                           l.ul.printName(num1);
                           System.out.println("");
                           System.out.println("       LIST OF AVAILABLE BOOKS");
                           System.out.println("-------------------------------------------");
                           l.bl.printAllBooks();
                           System.out.println("-------------------------------------------");
                           System.out.println("Enter book's name");
                           String choice1 = a.next();
                           int num = l.bl.findBook1(choice1); 
                           while(num != -1)
                           {                           
                                   Book b = l.bl.getBook(num);
                                   if(b.getAvailability() == true) // Checks for the Book's Availability then allows to borrow the book
                                   {
                                        BorrowedBook bb = new BorrowedBook(b,u);
                                       System.out.println("Do you want to Borrow the Book");
                                       String choice2 = a.next();
                                       if(choice2.equalsIgnoreCase("yes"))
                                       {
                                           l.bl.borrowBook(bb);
                                           System.out.println("Book borrowed Succesfully");
                                           l.bl.setAvailability(num, false);
                                           l.bl.getBorrowDate();
                                           l.bl.getDueDate();
                                           l.bl.storeAllBorrowedBooks(bpw);
                                           break;     
                                       }
                                       else
                                       {
                                            System.out.println("Book not Borrowed");
                                            break;
                                       }
                                    }
                                   else
                                   {
                                       System.out.println("Book is not available at the moment");
                                       break;
                                    }
                              }      
                        }
                        else
                        {
                            break;
                        }
                       break;
                       
                       case 6:
                       System.out.println("Printing all Borrowed Books");
                       l.bl.printAllBorowedBooks();
                       break;
                       
                       case 7:
                       l.getUserID();
                       System.out.println("Enter name of the Book you want to return");
                       String bName = a.next();

                       int num  = l.bl.findBorrowedBook(bName);
                       num1 = l.bl.findBook1(bName); 
                       if(num != -1)
                       {
                           if(l.bl.getReturnDate().equals(l.bl.getDueDate()))
                           {
                               System.out.println("Your due date has been crossed");
                               System.out.println("Fine of ₹20 will be charged ");
                            }
                           l.bl.returnBook(num);
                           l.bl.setAvailability(num1, true);
                        }
                        else
                        {
                            break;
                        }
                       break;
                       
                       case 8:
                       quitFlag = true;
                       break; 
                       
                       default:
                       System.out.println("Invalid choice");
                       break;
                    
                   }
                    if(quitFlag)
                    {
                        break;
                    }
                    System.out.println("Do you want to continue(Enter yes or no)");
                    word = a.next();
            }
            System.out.println("Thank you for using the Library System");
            System.exit(0);
    }
    catch(Exception e)
    {
       
        System.out.println("Exception: " + e);
        return;
    }
  }
}

