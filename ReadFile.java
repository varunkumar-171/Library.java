import java.io.*;
import java.lang.*;
import java.util.*;
public class ReadFile
{
   public static void main(String[] args)
   {
       int count = 0;
       try
       {
       Scanner a = new Scanner(new File("../Library/Bookdata.txt"));
       a.useDelimiter("\n");
       while(a.hasNext()) {
           String n1 = a.next();
           System.out.println(n1);
           count++;
           
           Scanner c = new Scanner(n1);
           c.useDelimiter(":");
              String bookName = c.next();
              String author = c.next();
              int isbn = c.nextInt();
              boolean avail = c.nextBoolean();
              String borrowDate = c.next();
              String returnDate = c.next();
              String dueDate = c.next();
              Book b1 = new Book(bookName,author,isbn);
              b1.printBook();
           c.close();
       }
       System.out.println(count);
       a.close();
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
    }
    public ReadFile()
    {
    }
}
