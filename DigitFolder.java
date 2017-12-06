import java.io.*;
import java.util.*;
                                                                    // Main program to do the digit folding
public class DigitFolder 
{
  public static void main(String[] args) 
  {
    DataItem aDataItem;
    int aKey, size;
  
    System.out.print("Enter size of hash table: ");
    Scanner scanner = new Scanner(System.in);                      // construct a scanner
    
 
    size = scanner.nextInt();                                     // get an integer as hash table size
    
    hashTable thehashTable = new hashTable(size);                 //  generate a blank table. 
    thehashTable.displayTable();
    
    System.out.println("please enter keys for the initial list " );
//---------------------------------------------------------
    List<String> list = new ArrayList<String>();                 // user input numbers
    Scanner stdin = new Scanner(System.in);
    
    do 
    {
      System.out.println("Current key list is " + list);
      System.out.println("Add more? (y/n)");
      if (stdin.next().startsWith("y")) 
      {
        System.out.println("Enter : ");
        list.add(stdin.next());
      } else {
        break;
      }
    } while (true);
    
    System.out.println("Key Array is " + list);
    String[] arr = list.toArray(new String[0]);           // the numbers are generated in string form
    int[] numList = new int[arr.length];                     
    
    //--------------------------------------------------------
    for (int i=0; i<arr.length;i++)
      
    {
      
      
      numList [i]=Integer.parseInt(arr[i]);                // /strings is transformed to integers
      
      aDataItem = new DataItem(numList[i]);
      thehashTable.insert(aDataItem);                      // insert the input numbers into the table
           
    }
    
    while(true)                                            // interact with user
         {
         System.out.print("Enter first letter of ");
         System.out.print("show or insert: ");
         
           
    char choice = scanner.next().charAt(0);
      
         switch(choice)
            {
            case 's':
               thehashTable.displayTable();                // show the table
               break;
            case 'i':
            System.out.print("Enter key value to insert: ");   // insert more numbers
               aKey = scanner.nextInt();
               aDataItem = new DataItem(aKey);
               thehashTable.insert(aDataItem);
               break;
            default:
               System.out.print("Invalid entry\n");
            }  // end switch
         }  // end while
     
  }
}
  
    
 

