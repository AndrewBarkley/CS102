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
                          "0 --> Quit");
         switch(in.next())
         {
            case "1":
               {
                  System.out.print(Database.searchCall(in.next()));
                  break;
               }
            case "2":
               {
                  System.out.print(Database.searchFreq(in.next()));
                  break;
               }
            case "3":
               {
                  System.out.print(Database.searchHome(in.next()));
                  break;
               }
            case "4":
               {
                  System.out.print(Database.searchFormat(in.next()));
                  break;
               }
            case "0":
               {
                  quit = true;
                  System.out.print("Goodbye");
                  break;
               }
            default:
               {
               //Initial error handeling to force calling on predefined methods
                  System.out.print("Error 503: Command not recognised");
               }
         }
      }
      
      
   }
}