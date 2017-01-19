//***********************************************
//Zachary Mosley                                *
//Login ID: mosl8748                            *
//CS102, Winter 2017                            *
//Programming Assignment 1                      *
//Prog1: Main method and UI                     *
//***********************************************

import java.util.*;
import java.io.*;

public class Prog1
{
//****************************************************
//Method: Main                                       *
//Purpose: Main method / UI that calls on methods    *
//                                                   *
//Paramaters:                                        *
// callsign             Object data                  *
//Returns:        void                               *
//****************************************************
   public static void main(String [] args)
   {
      File inFile = new File(args[0]);
      boolean quit = false;
      Scanner input = new Scanner("");
      try
      {
         input = new Scanner(inFile).useDelimiter("/|\n");
      }
      catch (FileNotFoundException e)
      {
         System.out.print("ERROR 404: File not found \n" +
                           "The program will now terminate");
         quit =  true;
      }
      try
      {
         Database.initialize(input);
      }
      catch(ArrayStoreException e)
      {
         quit = true;
      }
      
      //Start User Interface
      Database.interpret(quit);
      
   }
}