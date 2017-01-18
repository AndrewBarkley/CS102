//********************************************************
//Zachary Mosley                                         *
//Login ID: mosl8748                                     *
//CS102, Winter 2017                                     *
//Programming Assignment 1                               *
//Station: An object class to be used by Database.java   *
//********************************************************

import java.util.*;
import java.io.*;

//*****************************************************
//Class: Object                                       *
//Purpose: To manage the creation of Station Objects  *
//                                                    *
//Paramaters:                                         *
// String callsign      contains Station call sign    *
// String freqBand      contains frequency band AM/FM *
// int freqValueI       contains AM frequency channel *
// double freqVaueD     contains FM frequency channel *
// String frequency     contains Station frequency    *
// String home          contains Station home         *
// String format        contains Station format       *
//Returns: String:      Data from requested variable  *
//*****************************************************
public class Station
{
   private String callsign = "";
   private String freqBand = "";
   private double freqValueD = 0.0;
   private int freqValueI = 0;
   private String frequency = "";
   private String home = "";
   private String format = "";
   
//***********************************************************
//Method: Consttructor                                      *
//Purpose: To manage the creation of Station Objects        *
//                                                          *
//Paramaters:                                               *
// Scanner in           reads input file for assigning data *
// String callsign      contains Station call sign          *
// String freqBand      contains frequency band AM/FM       *
// int freqValueI       contains AM frequency channel       *
// double freqVaueD     contains FM frequency channel       *
// String frequency     contains Station frequency          *
// String home          contains Station home               *
// String format        contains Station format             *
//Returns: Station:     Data from requested variable        *
//***********************************************************
   public Station(Scanner in)
   {
      try
      {
         callsign = in.next();
         freqBand = in.next();
         if(freqBand.contains("AM"))
         {
            freqValueI = Integer.parseInt(in.next()) * 10;
            frequency = freqValueI +" "+ freqBand;
         }
         else if (freqBand.contains("FM"))
         {
            freqValueD = Double.parseDouble(in.next()) / 10.0;
            frequency = freqValueD +" "+ freqBand;
         }
         home = in.next();
         format = in.next();
      }
      catch(NullPointerException e)
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
  
//****************************************************
//Method: Accessors                                  *
//Purpose: To securely obtain object data            *
//                                                   *
//Paramaters:                                        *
// callsign             Object data                  *
// frequency            Object data                  *
// home                 Object data                  *
// format               Object data                  *
//Returns: String:      Data from requested variable *
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
   
//*****************************************************
//Method: toString                                    *
//Purpose: To return a string representing the Object *
//                                                    *
//Paramaters:                                         *
// callsign             Object data                   *
// frequency            Object data                   *
// home                 Object data                   *
// format               Object data                   *
//Returns: String:      Represents the Object         *
//*****************************************************
   public String toString()
   {
      return getCallsign() + ", " + 
             getFrequency() + ", " +
             getHome() + ": " +
             getFormat();
   }
}