//***********************************************
//Zachary Mosley                                *
//CS102, Winter 2017                            *
//Programming Assignment 1                      *
//Database: Stores all Stations in an array     *
//***********************************************

import java.util.*;
import java.io.*;

public class Database
{
   public static int DATABASE_ARRAY_SIZE = 50;
   private static Station[] archive = new Station[50];
   
   public static void initialize(String echo)
   {
      Scanner in = new Scanner(echo).useDelimiter("/|\n");
      int count = 0;
      while(in.hasNextLine())
      {
         archive[count] = new Station(in);
         count++;
      }
   }
   
   ///Each search method will notify the user if the query returns empty
   public static String searchCall(String in)
   {
      String temp = "";
      for(int count = 0; count < archive.length;count++)
      {
         if(archive[count].getCallsign() == in)
         {
            temp += archive[count] + "\n";
         }
      }
      if(temp == "")
      {
         temp = "Sorry, query empty";
      }
      return temp;
   }
   public static String searchFreq(String in)
   {
      String temp = "";
      for(int count = 0; count < archive.length;count++)
      {
         if(archive[count].getFrequency() == in)
         {
            temp += archive[count] + "\n";
         }
      }
      if(temp == "")
      {
         temp = "Sorry, query empty";
      }
      return temp;
   }
   public static String searchHome(String in)
   {
      String temp = "";
      for(int count = 0; count < archive.length;count++)
      {
         if(archive[count].getHome() == in)
         {
            temp += archive[count] + "\n";
         }
      }
      if(temp == "")
      {
         temp = "Sorry, query empty";
      }
      return temp;
   }
   public static String searchFormat(String in)
   {
      String temp = "";
      for(int count = 0; count < archive.length;count++)
      {
         if(archive[count].getFormat().contains(in))
         {
            temp += archive[count] + "\n";
         }
      }
      if(temp == "")
      {
         temp = "Sorry, query empty";
      }
      return temp;
   }
   
}