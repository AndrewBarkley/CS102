//***********************************************
//Zachary Mosley                                *
//Login ID: mosl8748                            *
//CS102, Winter 2017                            *
//Programming Assignment 4                      *
//Prog3: Main method and UI                     *
//***********************************************

import java.util.*;
import java.io.*;

public class Prog4
{
   final static String SEARCH_CALLSIGN = "1";
   final static String SEARCH_FREQUENCY = "2";
   final static String SEARCH_HOME = "3";
   final static String SEARCH_FORMAT = "4";
   final static String ADD_NODE = "5";
   final static String REMOVE = "6";
   final static String PRINT = "7";
   final static String EXPORT = "8";
   final static String IMPORT = "9";
   final static String QUIT = "0";
//****************************************************
//Method: Main                                       *
//Purpose: Main method / UI that calls on methods    *
//                                                   *
//Paramaters:                                        *
// String[] args     Grabs file the user enters      *
//Returns:           void                            *
//****************************************************
   public static void main(String [] args)
   {
      //initiate Database
      Database database = new Database();
      File inFile = new File("");//initiate as empty file
      try {inFile = new File(args[0]);}//try load data file
      catch (ArrayIndexOutOfBoundsException handeled){}
      boolean quit = false;//the program will end when true
      Scanner in = new Scanner("");//reads data file
      String storage = "";//in stores info here
      Scanner input = new Scanner("");//used for station creation
      try
      {
         in = new Scanner(inFile).useDelimiter("/|\n");
         while(in.hasNextLine())
            storage = storage + in.nextLine() + "\n";
         input = new Scanner(storage).useDelimiter("/|\n");
      }
      catch (FileNotFoundException handeled)
      {
         System.out.print("ERROR 404: File not found \n" +
                           "The program will now terminate");
         quit =  true;
      }
      
      try
      {
         database.initialize(input);
      }
      catch(ArrayStoreException handeled)
      {//ArrayStore is set to be thrown if 
       //    the initialize can't store the data
         quit = true;
      }
      
      //Start User Interface
      
      Scanner keyboard = new Scanner(System.in);//gets user commands
      
      while(quit == false)
      {  //repeating interface of the program
         System.out.print("\nAvailable Commands:\n"+
                          "1 --> Search for a call signs\n"+
                          "2 --> Search for a frequency\n"+
                          "3 --> Search for a home\n"+
                          "4 --> Search for a format\n"+
                          "5 --> Add a Station\n"+
                          "6 --> Remove a Station\n" +
                          "7 --> Print entire database\n"+
                          "9 --> Export entire database\n"+
                          "0 --> Quit\n>>");
         switch(keyboard.nextLine())
         {
            case SEARCH_CALLSIGN:
               {  //search call sign
                  System.out.print("\nEnter your Call Sign: ");
                  try
                  {
                     System.out.println(database.search(keyboard.nextLine(),SEARCH_CALLSIGN));
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
                     System.out.println(database.search(keyboard.nextLine(),SEARCH_FREQUENCY));
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
                     System.out.println(database.search(keyboard.nextLine(),SEARCH_HOME));
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
                     System.out.println(database.search(keyboard.nextLine(),SEARCH_FORMAT));
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
                     database.add(keyboard);
                  }
                  catch(IllegalArgumentException handeled){}
                  break;
               }
            case REMOVE:
               try
               {
                  database.remove(keyboard);
               }
               catch(IndexOutOfBoundsException handeled){}
               break;
            case PRINT:
               {  //print all
                  database.print();
                  break;
               }
            case QUIT:
               {  //close
                  System.out.println();
                  quit = true;
                  System.out.print("Goodbye");
                  break;
               }
            
            case IMPORT:
               {
                  input = new Scanner("");//used for station creation
                  try
                  {
                     in = new Scanner(inFile).useDelimiter("/|\n");
                     while(in.hasNextLine())
                        storage = storage + in.nextLine() + "\n";
                     input = new Scanner(storage).useDelimiter("/|\n");
                  }
                  catch (FileNotFoundException handeled)
                  {System.out.print("ERROR 404: File not found \n");}
                  try
                  {
                     database.initialize(input);
                  }
                  catch(ArrayStoreException handeled)
                  {//ArrayStore is set to be thrown if 
                  //    the initialize can't store the data
                     quit = true;
                  }
               }
            case EXPORT:
               {
                  database.export();
                  System.out.println("done");
                  break;
               }
            default:
               {  //Error handeling to force calling on predefined methods
                  System.out.println("\nError 503: Command not recognised\n");
               }
         }
      }
   
   }
}