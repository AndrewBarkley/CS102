//********************************************
//Zachary Mosley                             *
//Login ID: mosl8748                         *
//CS102, Winter 2017                         *
//Programming Assignment 1                   *
//Database: Stores all Stations in an array  *
//********************************************

import java.util.*;
import java.io.*;

public class Database implements DatabaseInterface
{
   
//*******************************************************************
//Method: Initialize                                                *
//Purpose: Identify all stations that fit the query                 *
//                                                                  *
//Paramaters:                                                       *
// Scanner input          contains the format the user is searching *
//Returns:                void                                      *
//*******************************************************************
   public void initialize(Scanner input)
   {
   
   }

   
//********************************************************************
//Method: Search                                                     *
//Purpose: Identify all stations that fit the query                  *
//                                                                   *
//Paramaters:                                                        *
// String in           contains the call sign the user is searching  *
//Returns: String:     a list of all stations that fit the query     *
//********************************************************************
   public String searchCall(String in)
   {
   
   }
   
//******************************************************************
//Method: Search                                                   *
//Purpose: Identify all stations that fit the query                *
//                                                                 *
//Paramaters:                                                      *
// String in1          contains the band the user is searching     *
// String in2          contains the channel the user is searching  *
//Returns: String:     a list of all stations that fit the query   *
//******************************************************************
   public String searchFreq(String in1, String in2)
   {
   
   }
   
//****************************************************************
//Method: Search                                                 *
//Purpose: Identify all stations that fit the query              *
//                                                               *
//Paramaters:                                                    *
// String in           contains the home the user is searching   *
//Returns: String:     a list of all stations that fit the query *
//****************************************************************
   public String searchHome(String in)
   {
   
   }
   
//****************************************************************
//Method: Search                                                 *
//Purpose: Identify all stations that fit the query              *
//                                                               *
//Paramaters:                                                    *
// String in           contains the format the user is searching *
//Returns: String:     a list of all stations that fit the query *
//****************************************************************
   public String searchFormat(String in)
   {
   
   }

   
//***********************************************
//Method: Print                                 *
//Purpose: Print a list of all Stations stored  *
//                                              *
//Paramaters:          N/A                      *
//Returns:             void                     *
//***********************************************
   public void print()
   {
   
   }
   
//**************************************************************
//Method: Run                                                  *
//Purpose: Runs a loop to keep the program running             *
//                                                             *
//Paramaters:                                                  *
// boolean quit        closes the loop (and program) when true *
//Returns:             void                                    *
//**************************************************************
   public void interpret(boolean quit)
   {
      Scanner in = new Scanner(System.in);//gets user commands
      final String SEARCH_CALLSIGN = "1";
      final String SEARCH_FREQUENCY = "2";
      final String SEARCH_HOME = "3";
      final String SEARCH_FORMAT = "4";
      final String PRINT = "5";
      final String QUIT = "0";
      
      while(quit == false)
      {  //repeating interface of the program
         System.out.print("Available Commands:\n"+
                          "1 --> Search for a call signs\n"+
                          "2 --> Search for a frequency\n"+
                          "3 --> Search for a home\n"+
                          "4 --> Search for a format\n"+
                          "5 --> Print entire database\n"+
                          "0 --> Quit\n>>");
         switch(in.next())
         {
            case SEARCH_CALLSIGN:
               {  //search call sign
                  System.out.print("\nEnter your Call Sign: \n");
                  System.out.println(searchCall(in.next()));
                  break;
               }
            case SEARCH_FREQUENCY:
               {  //search frequency
                  System.out.print("\nEnter your Frequency Band (AM or FM): ");
                  String in1 = in.next();//contains the band AM/FM
                  System.out.print("Enter your Frequency Value: ");
                  String in2 = in.next();//contains the channel
                  System.out.println();
                  System.out.println(searchFreq(in1, in2));
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