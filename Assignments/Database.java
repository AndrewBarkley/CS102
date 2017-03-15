//******************************************************
//Zachary Mosley                                       *
//Login ID: mosl8748                                   *
//CS102, Winter 2017                                   *
//Programming Assignment 3                             *
//Database: Stores/Manages all Nodes in an linkedList  *
//******************************************************

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Database
{
   BinaryTree am = new BinaryTree();//for all AM stations
   BinaryTree fm = new BinaryTree();//for all FM stations
   //List of constants used as cases
   final String SEARCH_CALLSIGN = "1";
   final String SEARCH_FREQUENCY = "2";
   final String SEARCH_HOME = "3";
   final String SEARCH_FORMAT = "4";
   final String ADD_NODE = "5";
   final String REMOVE = "6";
   final String PRINT = "7";
   final String EXPORT = "8";
   final String IMPORT = "9";
   final String QUIT = "0";
      
//*******************************************************************
//Method: initialize                                                *
//Purpose: creates and places stations in ther lists                *
//                                                                  *
//Paramaters:                                                       *
// String fileName        what file to grab from the current folder *
//Returns:                void                                      *
//*******************************************************************
   public void initialize(String fileName)
   {
      File inFile = new File("");//initiate as empty file
      try {inFile = new File(fileName);}//try load data file
      catch (ArrayIndexOutOfBoundsException handeled){}
      Scanner in = new Scanner("");//reads data file
      String storage = "";//in stores info here
      Scanner input = new Scanner("");//used for station creation
      try
      {
         in = new Scanner(inFile).useDelimiter("/|\n");
         while(in.hasNextLine())
            storage = storage + in.nextLine() + "\n";
         input = new Scanner(storage).useDelimiter("/|\n");
      }
      catch (FileNotFoundException handeled)
      {
         JOptionPane.showMessageDialog(null, "File Not Found", 
                                    "ERROR", JOptionPane.ERROR_MESSAGE);;
      }
      try
      {
         am = new BinaryTree();
         fm = new BinaryTree();
         while(input.hasNext())
         {
         //Station to be stored as a node in one list 
            Station temp = new Station(input);
         
            if(temp.getFrequency().contains("AM"))
            {
               am.add(temp);
            }
            else
            {
               fm.add(temp);
            }
         }
      }
      catch(ArrayStoreException handeled)
      {//ArrayStore is set to be thrown if 
       //    the initialize can't store the data
         
         //throw error
      }
      
   }
   
   public String search(String target,String type,String list)
   {
      if(list.equalsIgnoreCase("am"))
         return "<html>AM Stations<br><br>" + am.search(target, type);
      else
         return "<html>FM Stations<br><br>" + fm.search(target, type);
   }
   
//******************************************
//Method: add                              *
//Purpose: gathers data for new station    *
//                                         *
//Paramaters:                              *
// Scanner in     gathers data for Station *
//Returns:             void                *
//******************************************
   public void add(String input)
   {
      Scanner in = new Scanner(input).useDelimiter("/|\n");
      boolean isAM = false;//Used to know which list to add it to
      String band = in.next();//if it's AM/FM
      if(band.equalsIgnoreCase("am"))
         isAM = true;
      
      try
      {
         Station adding = new Station(input);
                     
         if(isAM)
            am.add(adding);
         else
            fm.add(adding);
      }
      catch(ArrayStoreException handeled){}//user already notified just exit
      catch(NumberFormatException handeled)
      {
         JOptionPane.showMessageDialog(null, "Invalid Frequency", 
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
      }
   }

//************************************************
//Method: remove                                 *
//Purpose: ensures user removes correct Station  *
//                                               *
//Paramaters:                                    *
// Scanner in     gathers data and confirmation  *
//Returns:             void                      *
//************************************************
   public void remove(String input)
   {
      Scanner in = new Scanner(input).useDelimiter("/");
      String band = in.next();
      String callsign = in.next();
      
      if(band.equalsIgnoreCase("AM"))
         am.remove(callsign);
      else if(band.equalsIgnoreCase("FM"))
         fm.remove(callsign);
      else
         throw new IndexOutOfBoundsException();
   }
   
   public String print(String list)// change for individual print
   {
      if(list == "am")
         return "<html>AM Stations<br><br>" + am.print();
      else 
         return "<html>FM Stations<br><br>" + fm.print();
   }
   
   public void export(String fileName)
   {
      FileWriter fw = null;
      BufferedWriter bw = null;
      String data = am.export();
      data += fm.export();
      try
      {
         fw = new FileWriter(fileName + ".txt");
         bw = new BufferedWriter(fw);
         bw.write(data);
      }
      catch (IOException handeled)
      {
         JOptionPane.showMessageDialog(null, "File Creation Error", 
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
      }
      try
      {
         if(bw != null)
            bw.close();
         if(fw != null)
            fw.close();
      }
      catch (IOException handeled)
      {
         JOptionPane.showMessageDialog(null, "File Close Error", 
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
      }
   }
}