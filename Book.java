import java.util.*;
import java.lang.Object;
import java.io.*;
import java.text.SimpleDateFormat;
public class Book
{
    private String bookName;
    private String author;
    private int isbn;
    private boolean availability;
    private boolean newBook;
    private String returnDate;
    private String dueDate ;
    private String borrowDate;
      /*
     * Non-Parameterized constructor
     */
    public Book()
    {
        
    }
      /*
     * Parameterized constructor 1
     */
    public Book(String BookName,String Author,int ISBN)
    {
        bookName = BookName;
        author = Author;
        isbn = ISBN;
        this.availability = true;
        this.newBook = false;
    }
      /*
     * Parameterized constructor 2
     */
    public Book(String BookName,String Author,int ISBN,boolean availability, boolean newBook)
    {
        bookName = BookName;
        author = Author;
        isbn = ISBN;
        this.availability = availability;
        this.newBook = newBook;
    }
        /*
     * Parameterized constructor 3
     */
    public Book(String BookName,String Author,int ISBN,String borrowDate,String returnDate)
    {
        bookName = BookName;
        author = Author;
        isbn = ISBN;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date d = new Date();
        String s = "";
        Date dueDate = addDays(d,7);
        try 
        {
           formatter = new SimpleDateFormat("dd-MM-yyyy");
           s = formatter.format(dueDate);
        }
        catch(Exception e)
        {
        }
        return s;
    }
    public Date getReturnDate()
    {
        Date d = new Date();
        return d;
    }
      public String getBorrowDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date d = new Date();
        String s = "";
        try 
        {
           formatter = new SimpleDateFormat("dd-MM-yyyy");
           s = formatter.format(d);
        }
        catch(Exception e)
        {
        }
        return s;
    }
    public void setAvailability(Boolean availability)
    {
        this.availability = availability;
    }
      public String getBookName()
    {
        return bookName;
    }
      public String getAuthor()
    {
        return author;
    }
      public int getISBN()
    {
        return isbn;
    }
      public boolean getAvailability()
    {
        return availability;
    }
      /*
     * Prints the details of the book
     */
    public void printBook()
    { 
                System.out.println("Book Name : " + bookName); 
                System.out.println("Author : " + author); 
                System.out.println(" ISBN : " + isbn); 
                System.out.println("availability : " + getAvailability());
                System.out.println("--------------------------------");
    }
        /*
     * Prints the name of the Book and author
     */
    public void printBookName()
    {
         System.out.println("Book Name : " + bookName); 
         System.out.println("Author : " + author);
         System.out.println("");
    }
   
    /*
     * This Method writes the details of book to the file Bookdata.txt. 
     */
    public void storeBook(PrintWriter pw) {
        try
            {
                if(newBook == true)
                {
                    pw.print(bookName+":"); 
                    pw.print(author+":"); 
                    pw.print(isbn+":"); 
                    pw.print(availability+":");    
                    pw.println("");
                    pw.flush(); // Flushes the stream.
                }
                else
                {
                    System.out.println("This book is already loaded");
                }
           }
           catch(Exception e)
           {
               System.out.println("Exception: " + e);
               return;
           }
    }
      /*
     * Test Harness 
     */
    public static void main(String[]args)
    {
        try
        {   
            Book book1 = new Book("Alex Rider","Anthony Horowitz",454622);
   

            Book book2 = new Book("Percy Jackson","Rick Riordan",250022);
            Book book3 = new Book("Book3","Author3",454562);
            book1.printBook();
            
            book2.printBook();
           book3.printBook();
      }
       catch(Exception e)
       {
            System.out.println("Exception: " + e);
            return;
      }
    }
}
