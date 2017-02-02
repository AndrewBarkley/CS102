//***********************************************
//Zachary Mosley                                *
//Login ID: mosl8748                            *
//CS102, Winter 2017                            *
//Programming Assignment 2                      *
//Prog2: Main method and UI                     *
//***********************************************

import java.util.*;
import java.io.*;

public class Prog2
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
      //initiate Database
      Database database = new Database();
      File inFile = new File("");//initiate as empty file
      try
      {
         inFile = new File(args[0]);//try load data file
      }
      catch (ArrayIndexOutOfBoundsException handeled){}
      boolean quit = false;//the program will end when true
      Scanner input = new Scanner("");//reads data file
      try
      {
         input = new Scanner(inFile).useDelimiter("/|\n");
      }
      catch (FileNotFoundException handeled)
      {
         System.out.print("ERROR 404: File not found \n" +
                           "The program will now terminate");
         quit =  true;
      }
      
      try
      {
         database.initialize(input);
      }
      catch(ArrayStoreException handeled)
      {//ArrayStore is set to be thrown if 
       //    the initialize can't store the data
         quit = true;
      }
      
      //Start User Interface
      database.interpret(quit);
   }
}