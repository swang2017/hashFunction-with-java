import java.io.*;

class hashTable
{
  
  public DataItem[] hashArray;    // array holds hash table
  public int arraySize;
  public DataItem nonItem;        // for deleted items
  
  // -------------------------------------------------------------
  public hashTable(int size)       // constructor
  {
    arraySize = size;
    hashArray = new DataItem[arraySize];
    nonItem = new DataItem(-1);   // deleted item key is -1
  }
  //--------------------------------------
  public static int getDigitCount(int n)                   // this part counts the number of digis of the input numbers
  {
    int numDigits = 1;
    while (n > 9) {
      n /= 10;
      numDigits++;
    }
    return numDigits;
  }
  
// -------------------------------------------------------------
  public void displayTable()                                    //display table 
  {
    System.out.print("Hash table: "+"\n\n");
    System.out.print("Index "+"\t"+"Hash Value"+"\t"+"\t"+"Keys"+"\n");
    for(int j=0; j<arraySize; j++)
    {
      
      if(hashArray[j] != null)
        
        System.out.println(j+"\t"+j+"\t"+"\t"+hashArray[j].getKey());
      else
        System.out.println(j+"\t"+"**"+"\t"+"\t"+"**");
    
    }
  }
    
 //--------------------------------------------------------------------------------
  public void insert(DataItem item)                           // insert a DataItem
                                                              // (assumes table not full)
    {
      int key = item.getKey();                                // extract key
      int hashVal = hashFunc(key);                            // hash the key
                                                              // if empty cell or -1, do the below
      while(hashArray[hashVal] != null &&
            hashArray[hashVal].getKey() != -1)
      {
        ++hashVal;                                            // lineaar probing, go to next cell
        hashVal %= arraySize;                                 // 
      }
      hashArray[hashVal] = item;                              // insert item
    }                                                         // end insert()
    
    
//-------------------------------------------------------------
    
    public  int hashFunc(int key)                        // this is the part that does the digit folding 
    {
      
      int keyDigitCount = getDigitCount(key);
      int groupSize = getDigitCount(arraySize);
      int groupSum = 0;
      String keyString = Integer.toString(key);
      int i;
      for (i = 0; i < keyString.length(); i += groupSize)   // this part determines the the length of the digits 
                                                          // to be used for the folding based on arraysize digit number
      {
        if (i + groupSize <= keyString.length())                
        {
          String group = keyString.substring(i, i + groupSize);    //use number of digits of arraysizze for 
                                                                  // slicing the key digits for digit folding
          groupSum += Integer.parseInt(group);
        }
      }
                                                     // There is no remaining part if count is divisible by groupsize.
      if (keyDigitCount % groupSize != 0)                           
      {
        String remainingPart =                 
          keyString.substring(i - groupSize, keyString.length());      
        groupSum += Integer.parseInt(remainingPart);
      }
      return groupSum % arraySize;                   
    }
    
    
    
  }  // end class HashTableApp
  