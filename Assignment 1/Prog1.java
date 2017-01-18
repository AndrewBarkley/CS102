//***********************************************
//Zachary Mosley                                *
//CS102, Winter 2017                            *
//Programming Assignment 1                      *
//Prog1: Main method and UI                     *
//***********************************************

import java.util.*;
import java.io.*;

public class Prog1
{
   public static void main(String [] args)
   {
      File inFile = new File(args[0]);
      boolean quit = false;
      Scanner input = new Scanner("");
      try
      {
         input = new Scanner(inFile);
      }
      catch (FileNotFoundException e)
      {
         System.out.print("ERROR 404: File not found \nThe program will now terminate");
         quit =  true;
      }
      
      String echo = "";
      while(input.hasNext())
      {
         echo += input.nextLine() + "\n";
      }
      if(!quit)
         echo = echo.substring(0,(echo.length())-1);
      Database.initialize(echo);
      Scanner in = new Scanner(System.in);
      
      while(quit == false)
      {
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
               {
                  System.out.println();
                  System.out.print("Enter your Call Sign: ");
                  System.out.println();
                  System.out.println(Database.searchCall(in.next()));
                  break;
               }
            case "2":
               {
                  System.out.println();
                  System.out.print("Enter your Frequency Band (AM or FM): ");
                  String in1 = in.next();
                  System.out.print("Enter your Frequency Value: ");
                  String in2 = in.next();
                  System.out.println();
                  System.out.println(Database.searchFreq(in1, in2));
                  break;
               }
            case "3":
               {
                  System.out.println();
                  System.out.print("Enter your Home: ");
                  System.out.println();
                  System.out.println(Database.searchHome(in.next()));
                  break;
               }
            case "4":
               {
                  System.out.println();
                  System.out.print("Enter your Format: ");
                  System.out.println();
                  System.out.println(Database.searchFormat(in.next()));
                  break;
               }
            case "5":
               {
                  Database.print();
                  break;
               }
            case "0":
               {
                  System.out.println();
                  quit = true;
                  System.out.print("Goodbye");
                  break;
               }
            default:
               {
                  //Initial error handeling to force calling on predefined methods
                  System.out.println();
                  System.out.println("Error 503: Command not recognised");
                  System.out.println();
               }
         }
      }
      
      
   }
}