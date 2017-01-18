//********************************************************
//Zachary Mosley                                         *
//Login ID: mosl8748                                     *
//CS102, Winter 2017                                     *
//Programming Assignment 1                               *
//Station: An object class to be used by Database.java   *
//********************************************************

import java.util.*;
import java.io.*;

public class Station
{
   private String callsign = "";
   private String freqBand = "";
   private double freqValueD = 0.0;
   private int freqValueI = 0;
   private String frequency = "";
   private String home = "";
   private String format = "";
   
   public Station(Scanner in)
   {
      
      callsign = in.next();
      freqBand = in.next();
      if(freqBand.contains("AM"))
      {
         freqValueI = Integer.parseInt(in.next()) * 10;
         frequency = freqValueI +" "+ freqBand;
      }
      else if(freqBand.contains("FM"))
      {
         freqValueD = Double.parseDouble(in.next()) / 10.0;
         frequency = freqValueD +" "+ freqBand;
      }
      else
      {
         System.out.println("ERROR 307: Invalid Stationn object input.\n Program will now terminate");
         throw new ArrayStoreException();
      }
      home = in.next();
      format = in.next();
   }
   
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
   
   public String toString()
   {
      return getCallsign() + ", " + 
             getFrequency() + ", " +
             getHome() + ": " +
             getFormat();
   }
}