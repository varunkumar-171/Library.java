import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class BookList
{
    private Book[] allBooks = new Book[100];
    private BorrowedBook[] borrowedBooks = new BorrowedBook[100];
    int noOfBooks = 0;
    int noOfBorrowedBooks = 0;
    public BookList()   //Empty constructor
    {
    }
      /*
     * Adds books to array allBooks[]
     */
    public boolean addBook(Book b)
    {
        allBooks[noOfBooks] = b;
        noOfBooks++;
        return true;
    }   
    /*
     * Adds books to the borrowed Book array 
     */ 
    public boolean addBorrowedBook(BorrowedBook bb)
    {
       borrowedBooks[noOfBorrowedBooks] = bb;
       noOfBorrowedBooks++;
       return true;
    } 
      /*
     * Adds books to the borrowed Book array after borrowing
     */ 
    public boolean borrowBook(BorrowedBook bb)   
    {
           borrowedBooks[noOfBorrowedBooks] = bb;
           noOfBorrowedBooks++;
           return true;
    }
      /*
     * Sets the availability to true or false, before or after borrowing the book respectively
     */   
    public void setAvailability(int num,boolean availability)
    {
        Book b = allBooks[num];
        b.setAvailability(availability);
        allBooks[num] = b;
    }
    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
    public String getDueDate()
    {
        Book b = new Book();
        return b.getDueDate();
    }
    public Date getReturnDate()
    {
        Date d = new Date();
        return d;
    }
    public String getBorrowDate()
    {
      Book b = new Book();
      return b.getBorrowDate();
    }
         /*
     * Makes the Borrowed book at the particular index as null 
     */   
    public void returnBook(int num)
    { 
         borrowedBooks[num] = null;
         System.out.println("Book Returned Succesfully");
    } 
       /*
     * Finds the index of the borrowed book using Book name
     */
     public int findBorrowedBook(String bookName)
    {
        for(int i = 0;i<borrowedBooks.length;i++)
        {
            BorrowedBook bb = borrowedBooks[i];
            if(bb != null)
            {
                   if(bookName.equalsIgnoreCase(bb.getBookName()))
                  {
                      return i;
                  }
            }
        }
        System.out.println("You have not borrowed this Book");
        return -1;
    } 
      /*
     * Finds the index of the book using Book name
     */
        public int findBook1(String bookName)
    {
        for(int i = 0;i<allBooks.length;i++)
        {
            Book b = allBooks[i];
            if(b != null)
            {
                   if(bookName.equalsIgnoreCase(b.getBookName()))
                  {
                      System.out.println("Book Found");
                     // b.printBook1();
                      return i;
                  }
            }
        }
        System.out.println("Book not found");
        return -1;
    } 
      /*
     * Prints the Books from the array allBooks[]
     */
    public void printAllBooks()
    {
        for(int i = 0;i<noOfBooks;i++)
        {
            Book b = allBooks[i];
             if(b != null)
            {
                 b.printBook(); 
            }
        }
    }
        /*
     * Prints the name of Book and author
     */
    public void printAllBooksName()
    {
        for(int i = 0;i<noOfBooks;i++)
        {
            Book b = allBooks[i];
             if(b != null)
            {
                 b.printBookName(); 
            }
        }
    }
       /*
     * Prints the Borrowed Books from the array borrowedBooks[]
     */
     public void printAllBorowedBooks()
    {
        System.out.println("\t Book Name \t\t Author \t\t ISBN \t\t Borrow Date \t Due Date \t UserName \t UserID");
        for(int i = 0;i<noOfBorrowedBooks;i++)
        {
            BorrowedBook bb = borrowedBooks[i];
             if(bb != null)
            {
                 bb.printBorrowedBook(); 
            }
        }
    }
      /*
     * Stores the books in the array allBooks[]
     */
    public void storeAllBooks(PrintWriter pw) 
    {
        for(int i = 0;i<noOfBooks;i++)
        {
            Book b = allBooks[i];
             if(b != null)
            {
                 b.storeBook(pw); 
            }
        }
    }
    /*
     * Stores the Borrowed Books in the array borrowedBooks[]
     */
    public void storeAllBorrowedBooks(PrintWriter pw) {
        for(int i = 0;i<noOfBorrowedBooks;i++)
        {
            BorrowedBook bb = borrowedBooks[i];
             if(bb != null)
            {
                 bb.storeBorrowedBook(pw); 
            }
        }
        
    } 
     /*
     * Returns the book at the particular index
     */
    public Book getBook(int num)
    {
        Book b = allBooks[num];
        return b;
    }
    //Test method
    public static void main(String[]args)
    {
        BookList bl = new BookList();
        Book book1 = new Book("Alex Rider","Anthony Horowitz",454622);
       // book1.setBorrowDate(new Date());
       // book1.setDueDate(new Date());
        bl.addBook(book1);
        Book book2 = new Book("Percy Jackson","Rick Riordan",250022);
        bl.addBook(book2);
        Book book3 = new Book("Book3","Author3",454562);
        bl.addBook(book3);
        bl.printAllBooks();
        System.out.println("----------------------------------");
        bl.printAllBooks();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        //bl.borrowBook(454622);
        //bl.printAllBorrowedBooks();
    }
}
