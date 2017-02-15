//**********************************************
//Zachary Mosley                               *
//Login ID: mosl8748                           *
//CS102, Winter 2017                           *
//Programming Assignment 2                     *
//Database: Stores all Nodes in an linkedList  *
//**********************************************

import java.util.*;
import java.io.*;

public class Database //implements DatabaseInterface
{
   LinkedList<Station> am = new LinkedList();//for all AM stations
   LinkedList<Station> fm = new LinkedList();//for all FM stations
   //List of constants used as cases
   final String SEARCH_CALLSIGN = "1";
   final String SEARCH_FREQUENCY = "2";
   final String SEARCH_HOME = "3";
   final String SEARCH_FORMAT = "4";
   final String ADD_NODE = "5";
   final String PRINT = "6";
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
      
      sort(am);//Sort both after filling them
      sort(fm);
   }

   
//********************************************************************
//Method: searchCall                                                 *
//Purpose: Identify all stations that fit the query                  *
//                                                                   *
//Paramaters:                                                        *
// String in           contains the call sign the user is searching  *
//Returns: String:     a list of all stations that fit the query     *
//********************************************************************
   public String search(String in,String type)
   {
      String list = "\nam Stations:\n";//Stores the query results
      int count = 0;//counts through each list
      switch (type)
      {
         case SEARCH_CALLSIGN:
            while(count >= 0 && count < am.size())
            {
               if(am.get(count).getCallsign().contains(in))
               {
                  list = list + am.get(count) + "\n";
               }
               count++;
            }
            list = list + "\nfm Stations:\n";
            count = 0;//reset for FM
            while(count >= 0 && count < fm.size())
            {
               if(fm.get(count).getCallsign().contains(in))
               {
                  list = list + fm.get(count) + "\n";
               }
               count++;
            }
            list = list + "\n";
            return list;
            
         case SEARCH_FREQUENCY:
            while(count >= 0 && count < am.size())
            {
               if(am.get(count).getFrequency().contains(in))
               {
                  list = list + am.get(count) + "\n";
               }
               count++;
            }
            list = list + "\nfm Stations:\n";
            count = 0;//reset for FM
            while(count >= 0 && count < fm.size())
            {
               if(fm.get(count).getFrequency().contains(in))
               {
                  list = list + fm.get(count) + "\n";
               }
               count++;
            }
            list = list + "\n";
            return list;
            
         case SEARCH_HOME:
            while(count >= 0 && count < am.size())
            {
               if(am.get(count).getHome().contains(in))
               {
                  list = list + am.get(count) + "\n";
               }
               count++;
            }
            list = list + "\nfm Stations:\n";
            count = 0;//reset for FM
            while(count >= 0 && count < fm.size())
            {
               if(fm.get(count).getHome().contains(in))
               {
                  list = list + fm.get(count) + "\n";
               }
               count++;
            }
            list = list + "\n";
            return list;
            
         case SEARCH_FORMAT:
            while(count >= 0 && count < am.size())
            {
               if(am.get(count).getFormat().contains(in))
               {
                  list = list + am.get(count) + "\n";
               }
               count++;
            }
            list = list + "\nfm Stations:\n";
            count = 0;//reset for FM
            while(count >= 0 && count < fm.size())
            {
               if(fm.get(count).getFormat().contains(in))
               {
                  list = list + fm.get(count) + "\n";
               }
               count++;
            }
            list = list + "\n";
            return list;
         default:
            System.out.println("ERROR: This line shouldnt be accessed");
            return "";
      }
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
      System.out.println("\n\nfm Stations:");
      count = 0;//reset for FM
      while(count >= 0 && count < fm.size())
      {
         System.out.print(fm.get(count));
         count++;
      }
      System.out.println();
   }
   
   public boolean isSorted(LinkedList<Station> list)
   {
      int count = 0;
      while(count < list.size()-1)
      {
         String current = list.get(count).getCallsign();
         String next = list.get(count + 1).getCallsign();
         
         if(current.compareTo(next) > 0)
         {
            return false;
         }
         count++;
      }
      return true;
   }
 
   private void sort(LinkedList<Station> list)
   {
      int last = list.size()-1;
      int place = 0;
      while(!isSorted(list))
      {
         //find 'largest' E
         Station big = list.get(last);
         for(int index = last-1;index >= 0;index--)
         {
            Station next = list.get(index);
            if(big.getCallsign().compareTo(next.getCallsign()) < 0)
            {
               big = next;
               place = index;
            }
         }
         //switch with last E
         if(place != last)
         {
            Station temp = list.remove(last);
            list.add(last,list.get(place));
            list.set(place, temp);
         }
         //find largest E minus last one
         last--;
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
                          "6 --> Print entire database\n"+
                          "0 --> Quit\n>>");
         switch(in.nextLine())
         {
            case SEARCH_CALLSIGN:
               {  //search call sign
                  System.out.print("\nEnter your Call Sign: \n");
                  System.out.println(search(in.nextLine(),SEARCH_CALLSIGN));
                  break;
               }
            
            case SEARCH_FREQUENCY:
               {  //search frequency
                  System.out.print("\nEnter your Frequency Value: \n");
                  System.out.println(search(in.nextLine(),SEARCH_FREQUENCY));
                  break;
               }
            case SEARCH_HOME:
               {  //search home
                  System.out.print("\nEnter your Home: \n");
                  System.out.println(search(in.nextLine(),SEARCH_HOME));
                  break;
               }
            case SEARCH_FORMAT:
               {  //search format
                  System.out.print("\nEnter your Format: \n");
                  System.out.println(search(in.nextLine(),SEARCH_FORMAT));
                  break;
               }
            case ADD_NODE://Sorry for the mess
               {
                  boolean isAM = false;//Used to know which list to add it to
                  String temp = "";//holds the data to creae the station
                  System.out.print("\nEnter AM or FM: ");
                  //if,else if used to check if it's AM or FM
                  String channel = in.next();//if it's AM/FM
                  if(channel.equalsIgnoreCase("am"))
                  {
                     isAM = true;
                     temp = "AM/";
                  }
                  else if(channel.equalsIgnoreCase("fm"))
                     temp = "FM/";
                  else
                  {
                     System.out.println("Incorrect band, canceling addition");
                     break;
                  }
                  System.out.print("\nEnter your Call Sign: ");
                  temp = temp + in.next() +"/";
                  System.out.print("\nEnter your Frequency: ");
                  temp = temp + in.next() +"/";
                  System.out.print("\nEnter your Home: ");
                  in.nextLine();//skips empty line
                  temp = temp + in.nextLine() +"/";
                  System.out.print("\nEnter your Format: ");
                  temp = temp + in.nextLine() + "\n";
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
                           break;
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
                           break;
                        }
                        fm.add(adding);
                        sort(fm);
                     }
                  }
                  catch(ArrayStoreException handeled){}//user already notified just exit
                  catch(NumberFormatException handeled)
                  {System.out.print("\nInvalidFrequency\n");}
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