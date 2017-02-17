//********************************************************
//Zachary Mosley                                         *
//Login ID: mosl8748                                     *
//CS102, Winter 2017                                     *
//Programming Assignment 3                               *
//Station: An object class to be used by Database.java   *
//********************************************************

import java.util.*;
import java.io.*;

public class Station
{
   private String callsign = "";//contains Station call sign
   private String freqBand = "";//contains frequency band AM/FM
   private double freqValueD = 0.0;//contains AM frequency channel
   private int freqValueI = 0;//contains FM frequency channel
   private String frequency = "";//contains Station frequency
   private String home = "";//contains Station home
   private String format = "";//contains Station format
   
//***********************************************************
//Method: Constructor                                       *
//Purpose: To manage the creation of Station Objects        *
//                                                          *
//Paramaters:                                               *
// Scanner in           reads input file for assigning data *
//Returns: Station:     Data from requested variable        *
//***********************************************************
   public Station(Scanner input)
   {
      try
      {
         callsign = input.next();
         freqBand = input.next();
         if(freqBand.contains("AM"))//finds frequency for AM Stations
         {
            freqValueI = Integer.parseInt(input.next()) * 10;
            frequency = freqValueI +" "+ freqBand;
         }
         else if (freqBand.contains("FM"))//finds frequency for FM Stations
         {
            freqValueD = Double.parseDouble(input.next()) / 10.0;
            frequency = freqValueD +" "+ freqBand;
         }
         home = input.next();
         format = input.next();
      }
      //The catch() and if() ensure every variable has a value or the program closes
      catch(NullPointerException handeled)
      {
         System.out.println("ERROR 307: Invalid Station object input.\n"+
            "\nProgram will now terminate");
         throw new ArrayStoreException();
      }
      if(callsign=="" || frequency=="" ||
         home=="" || format=="")
      {
         System.out.println("ERROR 307: Invalid Station object input.\n"+
            "\nProgram will now terminate");
         throw new ArrayStoreException();
      }
   }
//***********************************************************
//Method: Constructor                                       *
//Purpose: To manage the creation of Station Objects        *
//                                                          *
//Paramaters:                                               *
// String in            contains input data                 *
//Returns: Station:     Data from requested variable        *
//***********************************************************   
   public Station(String in)
   {
      Scanner input = new Scanner(in).useDelimiter("/");
      try
      {
         freqBand = input.next();
         callsign = input.next();
         if(freqBand.contains("AM"))//finds frequency for AM Stations
         {
            freqValueI = Integer.parseInt(input.next());
            frequency = freqValueI +" "+ freqBand;
         }
         else if (freqBand.contains("FM"))//finds frequency for FM Stations
         {
            freqValueD = Double.parseDouble(input.next());
            frequency = freqValueD +" "+ freqBand;
         }
         home = input.next();
         format = input.next();
      }
      //The catch() and if() ensure every variable has a value or the program closes
      catch(NullPointerException handeled)
      {
         System.out.println("ERROR 307: Invalid Station object input.\n"+
            "\nAdd canceled");
         throw new ArrayStoreException();
      }
      if(callsign=="" || frequency=="" ||
         home=="" || format=="")
      {
         System.out.println("ERROR 307: Invalid Station object input.\n"+
            "\nAdd canceled");
         throw new ArrayStoreException();
      }
   }
  
//****************************************************
//Method: Accessors                                  *
//Purpose: To securely obtain object data            *
//                                                   *
//Paramaters:        N/A                             *
//Returns: String:   Data from requested variable    *
//****************************************************
   public String getCallsign()
   {
      return callsign;
   }
   
   public String getFrequency()
   {
      return frequency;
   }
   
   public String getHome()
   {
      return home;
   }
   
   public String getFormat()
   {
      return format;
   }
   
//*********************************************************
//Method: toString                                        *
//Purpose: To return a string representing the Object     *
//                                                        *
//Paramaters:           N/A                               *
//Returns: String:      Represents the Object as a String *
//*********************************************************
   public String toString()
   {
      return "   " +
             getCallsign() + ", " + 
             getFrequency() + ", " +
             getHome() + ": " +
             getFormat() +"\n";
   }
}