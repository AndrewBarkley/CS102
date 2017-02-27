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
   LinkedList<Station> am = new LinkedList();//for all AM stations
   LinkedList<Station> fm = new LinkedList();//for all FM stations
   //List of constants used as cases
   final String SEARCH_CALLSIGN = "1";
   final String SEARCH_FREQUENCY = "2";
   final String SEARCH_HOME = "3";
   final String SEARCH_FORMAT = "4";
   final String ADD_NODE = "5";
   final String REMOVE = "6";
   final String REMOVE_ALL = "7";
   final String PRINT = "8";
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

   
//********************************************************************
//Method: search                                                     *
//Purpose: Identify all stations that fit the query                  *
//                                                                   *
//Paramaters:                                                        *
// String in           contains the call sign the user is searching  *
// String type         decides what is being searched                *
//Returns: String:     a list of all stations that fit the query     *
//********************************************************************
   private String search(String in,String type)
   {
      String list = "\nam Stations:\n";//Stores the query results
      int count = 0;//counts through each list
      String getAM = "";//cycles through different searchs
      String getFM = "";//cycles through different searchs
      while(count >= 0 && count < am.size())
      {
         switch (type)
         {
            case SEARCH_CALLSIGN:
               getAM = am.get(count).getCallsign();
               break;
            case SEARCH_FREQUENCY:
               getAM = am.get(count).getFrequency();
               break;
            case SEARCH_HOME:
               getAM = am.get(count).getHome();
               break;
            case SEARCH_FORMAT:
               getAM = am.get(count).getFormat();
               break;
            default:
               {
                  System.out.print("You should never have come here");
                  throw new IllegalArgumentException();
               }
         }
         if(getAM.contains(in))
         {
            list = list + am.get(count);
         }
         count++;
      }
      list = list + "\nfm Stations:\n";
      count = 0;//reset for FM
      while(count >= 0 && count < fm.size())
      {
         switch (type)
         {
            case SEARCH_CALLSIGN:
               getFM = fm.get(count).getCallsign();
               break;
            case SEARCH_FREQUENCY:
               getFM = fm.get(count).getFrequency();
               break;
            case SEARCH_HOME:
               getFM = fm.get(count).getHome();
               break;
            case SEARCH_FORMAT:
               getFM = fm.get(count).getFormat();
               break;
            default:
               {
                  System.out.print("You should never have come here");
                  throw new IllegalArgumentException();
               }
         }
         if(getFM.contains(in))
         {
            list = list + fm.get(count);
         }
         count++;
      }
      list = list + "\n";
      return list;
   }
   
//********************************************************************
//Method: search                                                     *
//Purpose: Identify the index of the station that fits the query     *
//                                                                   *
//Paramaters:                                                        *
// LinkedList list     Which list to look in                         *
// String in           contains the call sign the user is searching  *
//Returns: int:        the index of station that fits the query      *
//********************************************************************
   private int search(LinkedList<Station> list, String in)
   {
      int count = 0;//counts through each list
      while(count >= 0 && count < list.size())
      {
         if(list.get(count).getCallsign().contains(in))
         {
            return count;
         }
         count++;
      }
      return -1;
   }
   
//***********************************************
//Method: print                                 *
//Purpose: Print a list of all Stations stored  *
//                                              *
//Paramaters:          N/A                      *
//Returns:             void                     *
//***********************************************
   public void print()
   {//exactly like all of the searches but instead prints
      System.out.println("am Stations:");
      int count = 0;
      while(count >= 0 && count < am.size())
      {
         System.out.print(am.get(count));
         count++;
      }
      System.out.println("\nfm Stations:");
      count = 0;//reset for FM
      while(count >= 0 && count < fm.size())
      {
         System.out.print(fm.get(count));
         count++;
      }
      System.out.println();
   }
   

 

//******************************************
//Method: add                              *
//Purpose: gathers data for new station    *
//                                         *
//Paramaters:                              *
// Scanner in     gathers data for Station *
//Returns:             void                *
//******************************************
   private void add(Scanner in)
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
         {
            if(search(adding.getCallsign(),SEARCH_CALLSIGN).contains(adding.getCallsign()) &&
                           search(adding.getCallsign(),SEARCH_CALLSIGN).contains("AM"))
            {
               System.out.println("Sorry but that call sign is already taken\n");
               throw new InterruptedException();
            }
            am.addFirst(adding);
            sort(am);
         }
         else
         {
            if(search(adding.getCallsign(),SEARCH_CALLSIGN).contains(adding.getCallsign()) &&
                           search(adding.getCallsign(),SEARCH_CALLSIGN).contains("FM"))
            {
               System.out.println("Sorry but that call sign is already taken\n");
               throw new InterruptedException();
            }
            fm.add(adding);
            sort(fm);
         }
      }
      catch(ArrayStoreException handeled){}//user already notified just exit
      catch(NumberFormatException handeled)
      {System.out.print("\nInvalidFrequency\n");}
      catch(InterruptedException handeled){}
   }

//************************************************
//Method: remove                                 *
//Purpose: ensures user removes correct Station  *
//                                               *
//Paramaters:                                    *
// Scanner in     gathers data and confirmation  *
//Returns:             void                      *
//************************************************
   private void remove(Scanner in)
   {
      System.out.print("AM or FM: ");
      String band = in.nextLine();
      int index = -1;
      System.out.print("Enter the callsign: ");
      String callsign = in.nextLine();
               
      if(band.equalsIgnoreCase("AM"))
      {
         index = search(am,callsign);
         if(index == -1)
         {
            System.out.print("Station not found. Returning to menu...\n\n");
            throw new IndexOutOfBoundsException();
         }
         System.out.print("Delete this Station? Y/N\n");
         System.out.print(am.get(index));
         if(in.nextLine().equalsIgnoreCase("y"))
         {
            am.remove(index);
            System.out.print("Station Deleted\n\n");
         }
         else
            System.out.print("Delete canceled. Returning to menu\n\n");
      }
      else if(band.equalsIgnoreCase("FM"))
      {
         index = search(fm,callsign);
         if(index == -1)
         {
            System.out.print("Station not found. Returning to menu...\n\n");
            throw new IndexOutOfBoundsException();
         }
         System.out.print("Delete this Station? Y/N\n");
         System.out.print(fm.get(index));
         if(in.nextLine().equalsIgnoreCase("y"))
         {
            fm.remove(index);
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

//**************************************************************
//Method: interpret                                            *
//Purpose: Runs a loop to keep the program running             *
//                                                             *
//Paramaters:                                                  *
// boolean quit        closes the loop (and program) when true *
//Returns:             void                                    *
//**************************************************************
   public void interpret(boolean quit)
   {
      Scanner in = new Scanner(System.in);//gets user commands
      
      while(quit == false)
      {  //repeating interface of the program
         System.out.print("Available Commands:\n"+
                          "1 --> Search for a call signs\n"+
                          "2 --> Search for a frequency\n"+
                          "3 --> Search for a home\n"+
                          "4 --> Search for a format\n"+
                          "5 --> Add a Station\n"+
                          "6 --> Remove a Station\n"+
                          "7 --> Remove all Stations\n"+
                          "8 --> Print entire database\n"+
                          "0 --> Quit\n>>");
         switch(in.nextLine())
         {
            case SEARCH_CALLSIGN:
               {  //search call sign
                  System.out.print("\nEnter your Call Sign: ");
                  try
                  {
                     System.out.println(search(in.nextLine(),SEARCH_CALLSIGN));
                  }
                  catch(IllegalArgumentException handeled)
                  {
                     System.out.println("Unexpected Runtime Error");
                  }
                  break;
               }
            
            case SEARCH_FREQUENCY:
               {  //search frequency
                  System.out.print("\nEnter your Frequency Value: ");
                  try
                  {
                     System.out.println(search(in.nextLine(),SEARCH_FREQUENCY));
                  }
                  catch(IllegalArgumentException handeled)
                  {
                     System.out.println("Unexpected Runtime Error");
                  }
                  break;
               }
            case SEARCH_HOME:
               {  //search home
                  System.out.print("\nEnter your Home: ");
                  try
                  {
                     System.out.println(search(in.nextLine(),SEARCH_HOME));
                  }
                  catch(IllegalArgumentException handeled)
                  {
                     System.out.println("Unexpected Runtime Error");
                  }
                  break;
               }
            case SEARCH_FORMAT:
               {  //search format
                  System.out.print("\nEnter your Format: ");
                  try
                  {
                     System.out.println(search(in.nextLine(),SEARCH_FORMAT));
                  }
                  catch(IllegalArgumentException handeled)
                  {
                     System.out.println("Unexpected Runtime Error");
                  }
                  break;
               }
            case ADD_NODE:
               {
                  try
                  {
                     add(in);
                  }
                  catch(IllegalArgumentException handeled){}
                  break;
               }
            case REMOVE:
               try
               {
                  remove(in);
               }
               catch(IndexOutOfBoundsException handeled){}
               break;
            case REMOVE_ALL:
               {
                  System.out.println("Delete all Stations? Y/N");
                  if(in.nextLine().equalsIgnoreCase("y"))
                  {
                     am.clear();
                     fm.clear();
                     System.out.print("All Stations Deleted\n\n");
                  }
                  else
                     System.out.print("Delete canceled. Returning to menu\n\n");
                  break;
               }
            case PRINT:
               {  //print all
                  print();
                  break;
               }
            case QUIT:
               {  //close
                  System.out.println();
                  quit = true;
                  System.out.print("Goodbye");
                  break;
               }
            
            default:
               {  //Error handeling to force calling on predefined methods
                  System.out.println();
                  System.out.println("Error 503: Command not recognised");
                  System.out.println();
               }
         }
      }
   }
}