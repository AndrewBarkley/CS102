//********************************************
//Zachary Mosley                             *
//Login ID: mosl8748                         *
//CS102, Winter 2017                         *
//Programming Assignment 1                   *
//Database: Stores all Stations in an array  *
//********************************************

import java.util.*;
import java.io.*;

public class Database
{
   public final static int DATABASE_ARRAY_SIZE = 50;
                         //^Arbitrary but reasonable array size
   private static Station[] archive = new Station[50];
                          //^Array to store all stations
   private static int size;
                    //^Int to track # of used array slots
   
//*******************************************************************
//Method: Initialize                                                *
//Purpose: Identify all stations that fit the query                 *
//                                                                  *
//Paramaters:                                                       *
// Scanner input          contains the format the user is searching *
//Returns:                void                                      *
//*******************************************************************
   public static void initialize(Scanner input)
   {
      size = 0;
      while(input.hasNextLine())
      {
         archive[size] = new Station(input);
         size++;
      }
   }

   
//********************************************************************
//Method: Search                                                     *
//Purpose: Identify all stations that fit the query                  *
//                                                                   *
//Paramaters:                                                        *
// String in           contains the call sign the user is searching  *
//Returns: String:     a list of all stations that fit the query     *
//********************************************************************
   public static String searchCall(String in)
   {
      String temp = "";//string to return after search
      for(int count = 0; count < size;count++)
      {
         if(archive[count].getCallsign().equalsIgnoreCase(in))
         {
            temp += archive[count] + "\n";
         }
      }
      if(temp == "")
      {
         temp = "Sorry, query empty\n";
      }
      return temp;
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
   public static String searchFreq(String in1, String in2)
   {
      String temp = "";//string to return after search
      for(int count = 0; count < size;count++)
      {
         if(archive[count].getFrequency().equalsIgnoreCase(in2 +" "+ in1))
         {
            temp += archive[count] + "\n";
         }
      }
      if(temp == "")
      {
         temp = "Sorry, query empty\n";
      }
      return temp;
   }
   
//****************************************************************
//Method: Search                                                 *
//Purpose: Identify all stations that fit the query              *
//                                                               *
//Paramaters:                                                    *
// String in           contains the home the user is searching   *
//Returns: String:     a list of all stations that fit the query *
//****************************************************************
   public static String searchHome(String in)
   {
      String temp = "";//string to return after search
      for(int count = 0;count < size;count++)
      {
         if(archive[count].getHome().equalsIgnoreCase(in))
         {
            temp += archive[count] + "\n";
         }
      }
      if(temp == "")
      {
         temp = "Sorry, query empty\n";
      }
      return temp;
   }
   
//****************************************************************
//Method: Search                                                 *
//Purpose: Identify all stations that fit the query              *
//                                                               *
//Paramaters:                                                    *
// String in           contains the format the user is searching *
//Returns: String:     a list of all stations that fit the query *
//****************************************************************
   public static String searchFormat(String in)
   {
      String temp = "";//string to return after search
      for(int count = 0; count < size;count++)
      {
         if(archive[count].getFormat().contains(in))
         {
            temp += archive[count] + "\n";
         }
      }
      if(temp == "")
      {
         temp = "Sorry, query empty\n";
      }
      return temp;
   }

   
//***********************************************
//Method: Print                                 *
//Purpose: Print a list of all Stations stored  *
//                                              *
//Paramaters:          N/A                      *
//Returns:             void                     *
//***********************************************
   public static void print()
   {
      System.out.println();
      int count;//keeps track of times it printed
      for(count=0;count < size;count++)
      {
         System.out.print(archive[count]);
      }
      if(count == 0)
         System.out.print("ALERT: No stations in database!");
      System.out.println("\n");
   }
   
//**************************************************************
//Method: Run                                                  *
//Purpose: Runs a loop to keep the program running             *
//                                                             *
//Paramaters:                                                  *
// boolean quit        closes the loop (and program) when true *
//Returns:             void                                    *
//**************************************************************
   public static void interpret(boolean quit)
   {
      Scanner in = new Scanner(System.in);//gets user commands
      
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
            case "1":
               {  //search call sign
                  System.out.print("\nEnter your Call Sign: \n");
                  System.out.println(Database.searchCall(in.next()));
                  break;
               }
            case "2":
               {  //search frequency
                  System.out.print("\nEnter your Frequency Band (AM or FM): ");
                  String in1 = in.next();//contains the band AM/FM
                  System.out.print("Enter your Frequency Value: ");
                  String in2 = in.next();//contains the channel
                  System.out.println();
                  System.out.println(Database.searchFreq(in1, in2));
                  break;
               }
            case "3":
               {  //search home
                  System.out.print("\nEnter your Home: \n");
                  System.out.println(Database.searchHome(in.next()));
                  break;
               }
            case "4":
               {  //search format
                  System.out.print("\nEnter your Format: \n");
                  System.out.println(Database.searchFormat(in.next()));
                  break;
               }
            case "5":
               {  //print all
                  Database.print();
                  break;
               }
            case "0":
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