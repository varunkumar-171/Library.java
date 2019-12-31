
import java.io.*;
import java.util.*;
public class BorrowedBook
{
    private Book book;
    private User user;
    public BorrowedBook(Book book,User user)
    {
       this.book = book;
       this.user = user;
    }
    public void printBorrowedBook()
    {
        System.out.println( " * \t" + book.getBookName() + "\t\t" + book.getAuthor() + "\t\t" +  book.getISBN() + "\t\t" +  book.getBorrowDate()
                                         + "\t" + book.getDueDate() + "\t" + user.getUserName() + "\t\t" + user.getUserID());
    }
    public String getBookName()
    {
        return book.getBookName();
    }
    public void storeBorrowedBook(PrintWriter pw) 
    {
        try
            {
                   pw.print(book.getBookName()+":");
                   pw.print(book.getAuthor()+":"); 
                   pw.print(book.getISBN()+":"); 
                   pw.print(book.getDueDate()+":");
                   pw.print(book.getBorrowDate()+":");
                   
                   pw.print(user.getUserName()+":"); 
                   pw.print(user.getPhoneNumber()+":"); 
                   pw.print(user.getUserID()+":");
                   
                   
                   pw.println("");
                   pw.flush();
              }
               
           
           catch(Exception e)
           {
               System.out.println("Exception: " + e);
               return;
           }
    }
}
