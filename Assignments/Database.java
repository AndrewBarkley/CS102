//******************************************************
//Zachary Mosley                                       *
//Login ID: mosl8748                                   *
//CS102, Winter 2017                                   *
//Programming Assignment 3                             *
//Database: Stores/Manages all Nodes in an linkedList  *
//******************************************************

import java.util.*;
import java.io.*;

public class Database
{
   BinaryTree am = new BinaryTree();//for all AM stations
   BinaryTree fm = new BinaryTree();//for all FM stations
   //List of constants used as cases
   final String SEARCH_CALLSIGN = "1";
   final String SEARCH_FREQUENCY = "2";
   final String SEARCH_HOME = "3";
   final String SEARCH_FORMAT = "4";
   final String ADD_NODE = "5";
   final String REMOVE = "6";
   final String PRINT = "7";
   final String EXPORT = "8";
   final String IMPORT = "9";
   final String QUIT = "0";
      
//*******************************************************************
//Method: initialize                                                *
//Purpose: creates and places stations in ther lists                *
//                                                                  *
//Paramaters:                                                       *
// Scanner input          contains the format the user is searching *
//Returns:                void                                      *
//*******************************************************************
   public void initialize(Scanner input)
   {
      am = new BinaryTree();
      fm = new BinaryTree();
      while(input.hasNext())
      {
       //Station to be stored as a node in one list 
         Station temp = new Station(input);
         
         if(temp.getFrequency().contains("AM"))
         {
            am.add(temp);
         }
         else
         {
            fm.add(temp);
         }
      }
   }
   
   public String search(String target,String type)
   {
      String list = "\nam Stations:\n";//Stores the query results
      list = list + am.search(target, type);
      list = list + "\nfm Stations:\n";
      list = list + fm.search(target, type);
      
      return list;
   }
   
//******************************************
//Method: add                              *
//Purpose: gathers data for new station    *
//                                         *
//Paramaters:                              *
// Scanner in     gathers data for Station *
//Returns:             void                *
//******************************************
   public void add(Scanner in)
   {
      boolean isAM = false;//Used to know which list to add it to
      String temp = "";//holds the data to creae the station
      System.out.print("\nEnter AM or FM: ");
                  //if,else if used to check if it's AM or FM
      String band = in.next();//if it's AM/FM
      if(band.equalsIgnoreCase("am"))
      {
         isAM = true;
         temp = "AM/";
      }
      else if(band.equalsIgnoreCase("fm"))
         temp = "FM/";
      else
      {
         System.out.println("Incorrect band, canceling addition");
         throw new IllegalArgumentException();
      }
      System.out.print("\nEnter your Call Sign: ");
      temp = temp + in.next() +"/";
      System.out.print("\nEnter your Frequency: ");
      temp = temp + in.next() +"/";
      System.out.print("\nEnter your Home: ");
      in.nextLine();//skips empty line
      temp = temp + in.nextLine() +"/";
      System.out.print("\nEnter your Format: ");
      temp = temp + in.nextLine();
      try
      {
         System.out.println();
         Station adding = new Station(temp);
                     
         if(isAM)
            am.add(adding);
         else
            fm.add(adding);
      }
      catch(ArrayStoreException handeled){}//user already notified just exit
      catch(NumberFormatException handeled)
      {System.out.print("\nInvalidFrequency\n");}
   }

//************************************************
//Method: remove                                 *
//Purpose: ensures user removes correct Station  *
//                                               *
//Paramaters:                                    *
// Scanner in     gathers data and confirmation  *
//Returns:             void                      *
//************************************************
   public void remove(Scanner in)
   {
      System.out.print("AM or FM: ");
      String band = in.nextLine();
      System.out.print("Enter the callsign: ");
      String callsign = in.nextLine();
      
      System.out.print("Delete this Station? Y/N\n");//            MINOR INCONVENIENCE
      if(band.equalsIgnoreCase("AM"))
      {
         System.out.print(am.search(callsign,SEARCH_CALLSIGN));
         if(in.nextLine().equalsIgnoreCase("y"))
         {
            am.remove(callsign);
            System.out.print("Station Deleted\n\n");
         }
         else
            System.out.print("Delete canceled. Returning to menu\n\n");
      }
      else if(band.equalsIgnoreCase("FM"))
      {
         System.out.print(fm.search(callsign,SEARCH_CALLSIGN));
         if(in.nextLine().equalsIgnoreCase("y"))
         {
            fm.remove(callsign);
            System.out.print("Station Deleted\n\n");
         }
         else
            System.out.print("Delete canceled. Returning to menu\n\n");
      }
      else
      {
         System.out.println("Band not recognised\n");
         throw new IndexOutOfBoundsException();
      } 
   }
   
   public void print()
   {
      System.out.println("\nAM Stations:");
      am.print();
      System.out.println("\nFM Stations:");
      fm.print();
   }
   
   public void export()
   {
      FileWriter fw = null;
      BufferedWriter bw = null;
      String data = am.export();
      data += fm.export();
      try
      {
         fw = new FileWriter("Exported_Data.txt");
         bw = new BufferedWriter(fw);
         bw.write(data);
      }
      catch (IOException handeled)
      {
         System.out.println("File creation error");
      }
      try
      {
         if(bw != null)
            bw.close();
         if(fw != null)
            fw.close();
      }
      catch (IOException handeled)
      {
         System.out.println("File close error");
      }
   }
}