//********************************************************
//Zachary Mosley                                         *
//Login ID: mosl8748                                     *
//CS102, Winter 2017                                     *
//Programming Assignment 5                               *
//Station: An object class to be used by Database.java   *
//********************************************************

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
         JOptionPane.showMessageDialog(null, "Failure Creating a Station", 
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
         throw new ArrayStoreException();
      }
      if(callsign=="" || frequency=="" ||
         home=="" || format=="")
      {
         JOptionPane.showMessageDialog(null, "Failure Creating a Station", 
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
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
         JOptionPane.showMessageDialog(null, "Failure Creating a Station", 
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
         throw new ArrayStoreException();
      }
      if(callsign=="" || frequency=="" ||
         home=="" || format=="")
      {
         JOptionPane.showMessageDialog(null, "Failure Creating a Station", 
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
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
   public String getFreqBand()
   {
      return freqBand;
   }
   public String getFreqValue()
   {
      if(getFreqBand().equals("AM"))
         return String.valueOf(freqValueI / 10);
      else if(getFreqBand().equals("FM"))
         return String.valueOf(freqValueD * 10);
      else
         return "ERROR";
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
   public String export()
   {
      return getCallsign() + "/" +
             getFreqBand() + "/" +
             getFreqValue() + "/" +
             getHome() + "/" +
             getFormat() + "\n";
   }
}