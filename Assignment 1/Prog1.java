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
      File inFile = new File((String)(args[0]));
      Scanner input = new Scanner(inFile);
      String echo = "";
      while(input.hasNext())
      {
         echo += input.nextLine() + "\n";
      }
      Database.initialize(echo);
      Scanner in = new Scanner(System.in);
      quit = false;
      while(quit == false)
      {
         System.out.print("Available Commands:\n"+
                          "1 --> Search for a call signs\n"+
                          "2 --> Search for a frequency\n"+
                          "3 --> Search for a home\n"+
                          "4 --> Search for a format\n"+
                          "9 --> Quit");
         switch(in)
         {
            case 1:
               {
                  System.out.print(Database.searchCall(in));
                  break;
               }
            case 2:
               {
                  System.out.print(Database.searchFreq(echo));
                  break;
               }
            case 3:
               {
                  System.out.print(Database.searchHome(echo));
                  break;
               }
            case 4:
               {
                  System.out.print(Database.searchFormat(echo));
                  break;
               }
            case 0:
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