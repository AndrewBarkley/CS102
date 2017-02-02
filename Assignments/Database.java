//**********************************************
//Zachary Mosley                               *
//Login ID: mosl8748                           *
//CS102, Winter 2017                           *
//Programming Assignment 2                     *
//Database: Stores all Nodes in an linkedList  *
//**********************************************

import java.util.*;
import java.io.*;

public class Database implements DatabaseInterface
{
   LinkedList am = new LinkedList();//for all AM stations
   LinkedList fm = new LinkedList();//for all FM stations
   
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
      am.sort();//Sort both after filling them
      fm.sort();
   }

   
//********************************************************************
//Method: searchCall                                                 *
//Purpose: Identify all stations that fit the query                  *
//                                                                   *
//Paramaters:                                                        *
// String in           contains the call sign the user is searching  *
//Returns: String:     a list of all stations that fit the query     *
//********************************************************************
   public String searchCall(String in)
   {
      String list = "AM Stations:\n";//Stores the query results
      int count = 0;//counts through each list
      while(count >= 0 && count < am.size())
      {
         if(am.get(count).getCallsign().contains(in))
         {
            list = list + am.get(count) + "\n";
         }
         count++;
      }
      list = list + "\nFM Stations:\n";
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
   }
   
//*******************************************************************
//Method: searchFrequency                                           *
//Purpose: Identify all stations that fit the query                 *
//                                                                  *
//Paramaters:                                                       *
// String in           contains the frequency the user is searching *
//Returns: String:     a list of all stations that fit the query    *
//*******************************************************************
   public String searchFreq(String in)
   {
      String list = "AM Stations:\n";//Stores the query results
      int count = 0;
      while(count >= 0 && count < am.size())
      {
         if(am.get(count).getFrequency().contains(in))
         {
            list = list + am.get(count) + "\n";
         }
         count++;
      }
      list = list + "\nFM Stations:\n";
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
   }
   
//****************************************************************
//Method: searchHome                                             *
//Purpose: Identify all stations that fit the query              *
//                                                               *
//Paramaters:                                                    *
// String in           contains the home the user is searching   *
//Returns: String:     a list of all stations that fit the query *
//****************************************************************
   public String searchHome(String in)
   {
      String list = "AM Stations:\n";//Stores the query results
      int count = 0;
      while(count >= 0 && count < am.size())
      {
         if(am.get(count).getHome().contains(in))
         {
            list = list + am.get(count) + "\n";
         }
         count++;
      }
      list = list + "\nFM Stations:\n";
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
   }
   
//****************************************************************
//Method: searchFormat                                           *
//Purpose: Identify all stations that fit the query              *
//                                                               *
//Paramaters:                                                    *
// String in           contains the format the user is searching *
//Returns: String:     a list of all stations that fit the query *
//****************************************************************
   public String searchFormat(String in)
   {
      String list = "AM Stations:\n";//Stores the query results
      int count = 0;
      while(count >= 0 && count < am.size())
      {
         if(am.get(count).getFormat().contains(in))
         {
            list = list + am.get(count) + "\n";
         }
         count++;
      }
      list = list + "\nFM Stations:\n";
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
      //List of constants used as cases
      final String SEARCH_CALLSIGN = "1";
      final String SEARCH_FREQUENCY = "2";
      final String SEARCH_HOME = "3";
      final String SEARCH_FORMAT = "4";
      final String ADD_NODE = "5";
      final String PRINT = "6";
      final String QUIT = "0";
      
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
                  System.out.println(searchCall(in.next()));
                  break;
               }
            case SEARCH_FREQUENCY:
               {  //search frequency
                  System.out.print("Enter your Frequency Value: ");
                  System.out.println();
                  System.out.println(searchFreq(in.next()));
                  break;
               }
            case SEARCH_HOME:
               {  //search home
                  System.out.print("\nEnter your Home: \n");
                  System.out.println(searchHome(in.next()));
                  break;
               }
            case SEARCH_FORMAT:
               {  //search format
                  System.out.print("\nEnter your Format: \n");
                  System.out.println(searchFormat(in.next()));
                  break;
               }
            case ADD_NODE://Sorry for the mess
               {
                  boolean isAM = false;//Used to know which list to add it to
                  String temp = "";//holds the data to creae the station
                  System.out.print("\nEnter AM or FM: ");
                  //if,else if used to check if it's AM or FM
                  if(in.next().equalsIgnoreCase("am"))
                  {
                     isAM = true;
                     temp = "AM/";
                  }
                  else if(in.next().equalsIgnoreCase("fm"))
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
                  temp = temp + in.nextLine();
                  try
                  {
                     Station adding = new Station(temp);
                     
                     if(isAM)
                     {
                        if(searchCall(adding.getCallsign()).contains(adding.getCallsign()) &&
                           searchCall(adding.getCallsign()).contains("AM"))
                        {
                           System.out.println("Sorry but that call sign is already taken");
                           break;
                        }
                        am.add(adding);
                        am.sort();
                     }
                     else
                     {
                        if(searchCall(adding.getCallsign()).contains(adding.getCallsign()) &&
                           searchCall(adding.getCallsign()).contains("FM"))
                        {
                           System.out.println("Sorry but that call sign is already taken");
                           break;
                        }
                        fm.add(adding);
                        fm.sort();
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