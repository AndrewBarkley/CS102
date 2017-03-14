//***********************************************
//Zachary Mosley                                *
//Login ID: mosl8748                            *
//CS102, Winter 2017                            *
//Programming Assignment 4                      *
//Prog4: Main method and UI                     *
//***********************************************

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Prog4
{
   final static String SEARCH_CALLSIGN = "1";
   final static String SEARCH_FREQUENCY = "2";
   final static String SEARCH_HOME = "3";
   final static String SEARCH_FORMAT = "4";
   final static String ADD_NODE = "5";
   final static String REMOVE = "6";
   final static String PRINT = "7";
   final static String EXPORT = "8";
   final static String IMPORT = "9";
   final static String QUIT = "0";
   static  Database database = new Database();//initiate Database
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
      database.initialize(args[0]);
      
      //Run GUI
      Display gui = new Display(database);
      gui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }
}