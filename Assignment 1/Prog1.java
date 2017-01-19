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
// String[] args     Grabs file the user enters      *
//Returns:           void                            *
//****************************************************
   public static void main(String [] args)
   {
      File inFile = new File(args[0]);//load data file
      boolean quit = false;//the program will end when true
      Scanner input = new Scanner("");//reads data file
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
      {//ArrayStore is set to be thrown if 
       //    the initialize can't store the data
         quit = true;
      }
      
      //Start User Interface
      Database.interpret(quit);
   }
}