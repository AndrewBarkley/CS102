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
   public static int DATABASE_ARRAY_SIZE = 50;
   private static Station[] archive = new Station[50];
   private static int size;
   
   public static void initialize(String echo)
   {
      Scanner in = new Scanner(echo).useDelimiter("/|\n");
      size = 0;
      while(in.hasNextLine())
      {
         archive[size] = new Station(in);
         size++;
      }
   }
   
   ///Each search method will notify the user if the query returns empty
   public static String searchCall(String in)
   {
      String temp = "";
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
   public static String searchFreq(String in1, String in2)
   {
      String temp = "";
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
   public static String searchHome(String in)
   {
      String temp = "";
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
   public static String searchFormat(String in)
   {
      String temp = "";
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
   public static void print()
   {
      System.out.println();
      for(int count=0;count < size;count++)
      {
         System.out.println(archive[count]);
      }
      System.out.println();
   }
   
}